package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services.impl;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Customer;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.repositories.CustomerRepository;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services.PurchaseTicketByUserUseCase;

public class PurchaseTicketByUserUseCaseImpl implements PurchaseTicketByUserUseCase {
    @Override
    public Customer purchase(Customer customer) {
        return CustomerRepository.getInstance().save(customer);
    }
}
