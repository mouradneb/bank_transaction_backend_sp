package nm.nebhi.bank_backend.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nm.nebhi.bank_backend.constants.BankAccountType;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
/**
 * @author Mourad NEBHI
 * @version 1.0
 *
 * @apiNote Define Bank Account,
 *              Account must have unique accountNumber
 *              Default account type is CREDIT
 *
 *          Assuming :  One bank account is attached to one Customer only
 *                      One customer can have several bank account
 *                      One bank account can have multiple transactions (credit or debit transaction)
 */
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class BankAccount extends RepresentationModel<BankAccount> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    @Size(min = 4, max=64)
    @Column(length = 64,unique = true)
    private String accountNumber;

    @Column(columnDefinition = "Decimal(15,2) default '0.00'")
    private BigDecimal credit;

    @NotNull
    @Column(length = 8, columnDefinition = "varchar(8) default 'CREDIT'")
    @Enumerated(EnumType.STRING)
    private BankAccountType accountType;

    @NotNull
    private LocalDateTime creationDate;


    /*
    * You can join target entity with any other field in target entity,
    * or combine multiple foreign keys.
    * But I prefer make join between entities by primary key.
    * */
    /*@JoinColumn(name = "customerId")
    @JoinColumns({
            @JoinColumn(name="firstName"),
            @JoinColumn(name="lastName"),

    })*/
    @ManyToOne
    private Customer customer;

    @OneToMany()
    private List<Transaction> transactions;

}


