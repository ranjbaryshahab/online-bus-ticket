package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.repositories;

import ir.maktab.java32.projects.servlet.onlinebusticket.config.database.HibernateUtil;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.repositories.CrudRepository;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Ticket;

public class TicketRepository extends CrudRepository<Ticket, Long> {
    private static TicketRepository ticketRepository;

    private TicketRepository() {
        setSession(HibernateUtil.getSession());
    }

    public static TicketRepository getInstance() {
        if (ticketRepository == null) {
            ticketRepository = new TicketRepository();
        }
        return ticketRepository;
    }

    @Override
    protected Class<Ticket> getEntityClass() {
        return Ticket.class;
    }
}
