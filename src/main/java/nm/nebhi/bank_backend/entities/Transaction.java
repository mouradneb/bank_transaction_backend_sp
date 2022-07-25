package nm.nebhi.bank_backend.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nm.nebhi.bank_backend.constants.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Transaction extends BaseEntity{

    @ManyToOne(optional = true)
    private BankAccount creditAccount;

    @ManyToOne(optional = true)
    private BankAccount debitAccount;

    @Column(columnDefinition = "Decimal(15,2) default '0.00'")
    private BigDecimal amount;


    @NotNull
    @Column(length = 8, columnDefinition = "varchar(8) default 'CREDIT'")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @NotNull
    private LocalDateTime date;

    @NotNull
    @Column(unique = true)
    private String transactionNumber;


}
