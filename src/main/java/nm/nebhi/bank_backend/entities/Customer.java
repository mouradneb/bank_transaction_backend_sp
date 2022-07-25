package nm.nebhi.bank_backend.entities;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nm.nebhi.bank_backend.constants.Gender;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Mourad NEBHI
 * @version 1.0
 *
 * @apiNote Define Customer class,
 *          Entity has one Unique field inherited from Parent Class (annotated by @Id) to define primary key within in Table (Database)
 *          And second Unique field customerId to reach
 *
 *          Assuming :  One bank account is attached to one Customer only
 *                      One customer can have several bank account
 *                      One bank account can have multiple transactions (credit or debit transaction)
 */

@Entity
// Assuming unique customer by : firstName, lastName, gender and dateBirth.
@Table(uniqueConstraints = {
        @UniqueConstraint(name="ctxUniqueNameBirthDay",columnNames = {"firstName","lastName","gender","dateBirth"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {
    // extends BaseEntity to inherit @Id, primary key and generation of auto value

    @NotNull
    @Column(unique = true,nullable = false)
    private String customerId;

    @NotNull
    @Size(min = 2, max=64)
    @Column(length = 64)
    private String firstName;

    @NotNull
    @Column(length = 64)
    @Size(min = 2, max=64)
    private String lastName;

    @NotNull
    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    private LocalDate dateBirth;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<BankAccount> bankAccounts;
}

