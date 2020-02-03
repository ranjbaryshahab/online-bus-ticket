package ir.maktab.java32.projects.servlet.onlinebusticket.features.accountmanagement.models;


import ir.maktab.java32.projects.servlet.onlinebusticket.features.shared.model.PersistenceEntity;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class User extends PersistenceEntity<Long> {

    @Column(name = "FIRST_NAME", length = 25)
    private String firstName;

    @Column(name = "LAST_NAME", length = 25)
    private String lastName;

    @Column(name = "USERNAME", nullable = false, length = 25, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 25)
    private String password;

}
