package ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models;

import ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.models.User;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.enumeration.Gender;
import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.model.PersistenceEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Customer extends PersistenceEntity<Long> {

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Ticket> ticketList = new ArrayList<>();
}
