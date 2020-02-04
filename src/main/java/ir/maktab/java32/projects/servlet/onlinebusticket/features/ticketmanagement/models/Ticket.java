package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.model.PersistenceEntity;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Ticket extends PersistenceEntity<Long> {

    @Column(name = "ORIGIN")
    private String origin;

    @Column(name = "DESTINATION")
    private String destination;

    @Column(name = "DEPARTURE_DATE")
    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @Column(name = "DEPARTURE_TIME")
    @Temporal(TemporalType.TIME)
    private Date departureTime;

    @Column(name = "TRAVEL_ID")
    private String travelId;

    @ManyToMany
    private Set<Customer> customerSet = new HashSet<>();
}
