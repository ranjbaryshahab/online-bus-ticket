package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services.impl;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.service.AuthenticationService;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Ticket;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.repositories.CustomerRepository;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services.MyTicketListByUserUseCase;

import java.util.List;
import java.util.stream.Collectors;

public class MyTicketListByUserUseCaseImpl implements MyTicketListByUserUseCase {
    @Override
    public List<Ticket> myList() {
        return CustomerRepository.getInstance()
                .findAll()
                .stream()
                .filter(customer -> customer.getUser().getUsername().equals(AuthenticationService.getInstance().getLoginUser().getUsername()))
                .flatMap(customer -> customer.getTicketList().stream())
                .collect(Collectors.toList())
                ;
    }
}
