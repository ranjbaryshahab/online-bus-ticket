package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Customer;

public interface PurchaseTicketByUserUseCase {
    Customer purchase(Customer customer);
}
