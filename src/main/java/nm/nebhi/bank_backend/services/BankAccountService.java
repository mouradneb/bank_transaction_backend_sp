package nm.nebhi.bank_backend.services;

import nm.nebhi.bank_backend.constants.BankAccountType;
import nm.nebhi.bank_backend.entities.BankAccount;

import java.math.BigDecimal;

public interface BankAccountService {

    BankAccount getByBankAccountNumber(String accountNumber);

    BankAccount create(String customerId, BigDecimal initialCredit);

    // It's not required in assessment just proposal
    // U can also added bank or any other propeties to create one account
    // BankAccount create(Bank bank, String customerId, BigDecimal initialCredit, BankAccountType accountType);
    // But entity bank is not created in this project
    BankAccount create(String customerId, BigDecimal initialCredit, BankAccountType accountType);
}
