package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services.impl;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.repositories.CustomerRepository;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services.CancelTicketByUserUseCase;

public class CancelTicketByUserUseCaseImpl implements CancelTicketByUserUseCase {
    @Override
    public void cancel(Long id) {
        CustomerRepository.getInstance().removeById(id);
    }
}
