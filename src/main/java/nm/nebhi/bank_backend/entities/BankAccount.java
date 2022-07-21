package nm.nebhi.bank_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nm.nebhi.bank_backend.constants.AccountType;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class BankAccount extends BaseEntity {

    private String accountNumber;
    private BigDecimal credit;
    private BigDecimal debit;
    private AccountType accountType;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
}


