package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.controllers;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.dto.TicketSearchDto;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Ticket;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services.impl.TicketSearchByUserUseCaseImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ticketSearch", urlPatterns = "/view/secured/buy-tickets/ticketSearch")
public class TicketSearchByUserController extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("user_data") != null) {
            String origin = req.getParameter("origin");
            String destination = req.getParameter("destination");
            String departureDate = req.getParameter("departure-date");

            TicketSearchDto ticketSearchDto = new TicketSearchDto(origin
                    , destination,
                    departureDate);

            List<Ticket> ticketList = new TicketSearchByUserUseCaseImpl().getTicketList(ticketSearchDto);
            ticketList.sort(Comparator.comparing(Ticket::getDepartureTime));
            req.setAttribute("ticketList", ticketList);
            req.getRequestDispatcher("/view/secured/buy-tickets/index.jsp").forward(req, resp);
        }
    }
}
