package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services.impl;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.dto.TicketSearchDto;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Ticket;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.repositories.TicketRepository;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.services.TicketSearchByUserUseCase;

import java.util.List;
import java.util.function.Predicate;

public class TicketSearchByUserUseCaseImpl implements TicketSearchByUserUseCase {
    @Override
    public List<Ticket> getTicketList(TicketSearchDto ticketSearchDto) {
        return TicketRepository.getInstance().findAll((Predicate<Ticket>)
                ticket -> ticket.getOrigin().contains(ticketSearchDto.getOrigin()) &&
                        ticket.getDestination().contains(ticketSearchDto.getDestination()) &&
                        ticket.getDepartureDate().toString().equals(ticketSearchDto.getDepartureDate()));
    }
}
