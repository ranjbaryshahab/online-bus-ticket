package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Ticket;

import java.util.List;

public interface MyTicketListByUserUseCase {
    List<Ticket> myList();
}
