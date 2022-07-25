package nm.nebhi.bank_backend.services;

import nm.nebhi.bank_backend.constants.BankAccountType;
import nm.nebhi.bank_backend.dao.BankAccountRepository;
import nm.nebhi.bank_backend.dao.CustomerRepository;
import nm.nebhi.bank_backend.entities.BankAccount;
import nm.nebhi.bank_backend.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankAccountServiceI implements  BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public BankAccount getByBankAccountNumber(String bankAccountNumber) {
        return bankAccountRepository.findBankAccountByAccountNumber(bankAccountNumber);
    }

    @Override
    public BankAccount create(String customerId, BigDecimal initialCredit) {

        Customer customer=customerRepository.findCustomerByCustomerId(customerId);

        if (customer == null) {
            return null;
        }

        BankAccount newAccount=new BankAccount();
        // U can define strategy to define auto generation for account number,4
        // exp: for abbreviation Bank_TYPEACCOUNT_DATE_TIME_SEQUENTIEL_NUMBER
        newAccount.setAccountNumber("123146789");

        // set account is not used because the default type is CREDIT for assessment
        //newAccount.setAccountType(BankAccountType.CREDIT);

        newAccount.setCustomer(customer);
        newAccount.setCredit(initialCredit);

        return bankAccountRepository.save(newAccount);
    }

    @Override
    public BankAccount create(String customerId, BigDecimal initialCredit, BankAccountType accountType) {

        Customer customer=customerRepository.findCustomerByCustomerId(customerId);

        if (customer == null) {
            return null;
        }

        BankAccount newAccount=new BankAccount();
        // U can define strategy to define auto generation for account number,4
        // exp: for abbreviation Bank_TYPEACCOUNT_DATE_TIME_SEQUENTIEL_NUMBER
        newAccount.setAccountNumber("123146789");

        newAccount.setCustomer(customer);
        newAccount.setAccountType(accountType);
        newAccount.setCredit(initialCredit);

        return bankAccountRepository.save(newAccount);
    }
}
