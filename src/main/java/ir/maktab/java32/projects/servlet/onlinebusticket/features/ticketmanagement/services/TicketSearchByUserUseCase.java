package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.dto.TicketSearchDto;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Ticket;

import java.util.List;

public interface TicketSearchByUserUseCase {
    List<Ticket> getTicketList(TicketSearchDto ticketSearchDto);
}
