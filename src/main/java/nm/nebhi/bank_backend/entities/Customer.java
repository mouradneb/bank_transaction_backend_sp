package nm.nebhi.bank_backend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name="ctxUniqueNameBirthDay",columnNames = {"firstName","lastName","dateBirth"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;
    private Gender gender;
    private Date dateBirth;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    List<BankAccount> bankAccounts;
}

enum Gender {
    MALE, FEMALE, OTHER;
}
