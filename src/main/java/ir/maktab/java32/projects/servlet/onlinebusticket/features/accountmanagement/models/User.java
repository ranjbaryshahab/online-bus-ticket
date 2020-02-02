package ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.models;


import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.model.PersistenceEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class User extends PersistenceEntity<Long> {

    @Column(name = "FIRST_NAME", nullable = false, length = 25)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 25)
    private String lastName;

    @Column(name = "BIOGRAPHY")
    private String biography;

    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name = "USERNAME", nullable = false, length = 25, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 25)
    private String password;



}
