package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.controllers;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.enumeration.Gender;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.service.AuthenticationService;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Customer;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Ticket;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.repositories.TicketRepository;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services.impl.PurchaseTicketByUserUseCaseImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "purchaseTicket", urlPatterns = "/view/secured/buy-tickets/purchaseTicket")
public class PurchaseTicketByUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user_data") != null) {
            String customerName = req.getParameter("customerName");
            String gender = req.getParameter("gender");
            String ticketId = req.getParameter("ID");
            Customer customer = new Customer();
            String pre;
            if (gender.toLowerCase().equals("female")) {
                customer.setGender(Gender.Female);
                pre = "Ms. ";
            } else {
                customer.setGender(Gender.Male);
                pre = "Mr. ";
            }
            customer.setCustomerName(customerName);
            customer.setUser(AuthenticationService.getInstance().getLoginUser());
            Customer newCustomer = new PurchaseTicketByUserUseCaseImpl().purchase(customer);
            Ticket ticket = TicketRepository.getInstance().findById(Long.parseLong(ticketId));

            if (ticket.getCustomerSet().isEmpty())
                ticket.setCustomerSet(Set.of(newCustomer));
            else
                ticket.getCustomerSet().add(newCustomer);

            TicketRepository.getInstance().update(ticket);
            req.setAttribute("pre", pre);
            req.setAttribute("customerName", customerName);
            req.setAttribute("ticketId", ticketId);
            req.setAttribute("purchase", "purchase");
            req.getRequestDispatcher("/view/secured/buy-tickets/index.jsp").forward(req, resp);
        }
    }
}
