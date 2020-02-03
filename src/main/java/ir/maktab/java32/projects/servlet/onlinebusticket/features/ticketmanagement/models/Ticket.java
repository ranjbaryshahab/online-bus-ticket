package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.models.User;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.enumeration.Gender;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.model.PersistenceEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Ticket extends PersistenceEntity<Long> {

    private String customerName;

    private Gender gender;

    private String origin;

    private String destination;

    private Date dateOfDeparture;

    private Date departureTime;

    private String travelId;

    @ManyToOne
    private User user;
}
