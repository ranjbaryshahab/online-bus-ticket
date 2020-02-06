package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TicketSearchDto implements Serializable {
    private String origin;

    private String destination;

    private String departureDate;
}


