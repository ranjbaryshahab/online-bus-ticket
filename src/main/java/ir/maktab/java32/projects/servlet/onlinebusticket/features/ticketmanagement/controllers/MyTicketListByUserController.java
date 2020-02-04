package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.controllers;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Ticket;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services.impl.MyTicketListByUserUseCaseImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "myTicketList", urlPatterns = "/view/secured/my-ticket/myTicketList")
public class MyTicketListByUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user_data") != null) {
            List<Ticket> ticketList = new MyTicketListByUserUseCaseImpl().myList();

            if (ticketList != null) {
                req.setAttribute("myTicketList", ticketList);
                req.getRequestDispatcher("/view/secured/my-ticket/my-ticket.jsp").forward(req, resp);
            }
        }
    }
}
