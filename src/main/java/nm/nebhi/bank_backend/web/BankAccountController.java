package nm.nebhi.bank_backend.web;

import com.sun.istack.NotNull;
import nm.nebhi.bank_backend.constants.BankAccountType;
import nm.nebhi.bank_backend.entities.BankAccount;
import nm.nebhi.bank_backend.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RequestMapping(value = "/assessmentBankAccountCreation")
public class BankAccountController {



    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping(value="/{accountNumber}",produces = { "application/hal+json" })
    public ResponseEntity<BankAccount> getByBankAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return ResponseEntity.ok().body(bankAccountService.getByBankAccountNumber(accountNumber));
    }


    @PostMapping
    public BankAccount create(@RequestBody AccountDataDTO accountDataDTO) {

        BankAccount bankAccount;

        if (accountDataDTO.accountType == null)
            //Assessment CASE
            bankAccount=bankAccountService.create(accountDataDTO.customerId, accountDataDTO.initialCredit);

        else
            //One proposal
            bankAccount=bankAccountService.create(accountDataDTO.customerId, accountDataDTO.initialCredit,accountDataDTO.accountType);

        return bankAccount;
    }

}

class AccountDataDTO {
    @NotNull
    String customerId;

    BigDecimal initialCredit;

    BankAccountType accountType;
}
