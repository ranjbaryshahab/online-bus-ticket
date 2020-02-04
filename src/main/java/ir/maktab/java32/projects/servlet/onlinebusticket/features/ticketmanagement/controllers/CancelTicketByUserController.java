package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.controllers;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.enumeration.Gender;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Customer;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services.impl.CancelTicketByUserUseCaseImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cancelTicket", urlPatterns = "/view/secured/my-ticket/cancelTicket")
public class CancelTicketByUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user_data") != null) {
            String ticketId = req.getParameter("ticketId");
            String customerId = req.getParameter("customerId");
            String customerName = req.getParameter("customerName");
            String gender = req.getParameter("gender");
            Customer customer = new Customer();
            String pre;
            if (gender.toLowerCase().equals("female")) {
                customer.setGender(Gender.Female);
                pre = "Ms. ";
            } else {
                customer.setGender(Gender.Male);
                pre = "Mr. ";
            }

            new CancelTicketByUserUseCaseImpl().cancel(Long.parseLong(customerId));
            req.setAttribute("pre", pre);
            req.setAttribute("customerName", customerName);
            req.setAttribute("ticketId", ticketId);
            req.setAttribute("cancel", "cancel");
            req.getRequestDispatcher("/view/secured/my-ticket/my-ticket.jsp").forward(req, resp);
        }
    }
}
