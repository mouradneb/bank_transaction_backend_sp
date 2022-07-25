package nm.nebhi.bank_backend;

import com.fasterxml.jackson.annotation.JsonFormat;
import nm.nebhi.bank_backend.constants.BankAccountType;
import nm.nebhi.bank_backend.constants.Gender;
import nm.nebhi.bank_backend.dao.BankAccountRepository;
import nm.nebhi.bank_backend.dao.CustomerRepository;
import nm.nebhi.bank_backend.entities.BankAccount;
import nm.nebhi.bank_backend.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class BankBackendApplication implements CommandLineRunner  {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Value("${test.customer.firstName:Mourad}")
    String firstName;

    @Value("${test.customer.lastName:Nebhi}")
    String lastName;


    @Value("${test.customer.dateBirth:30-10-1975}")
    @JsonFormat(pattern = "dd-MM-yyyy")
    String dateBirth;

    @Value("${test.customer.gender:MALE}")
    Gender gender;

    @Value("${test.bankAccount.accountNumber:123456789}")
    String bankAccountNumber;

    public static void main(String[] args) {
        SpringApplication.run(BankBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Optional<Customer> optionalNM=customerRepository
                                            .findCustomerByFirstNameAndLastNameAndGenderAndDateBirth
                                                        (this.firstName,this.lastName,this.gender,LocalDate.parse(this.dateBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        if (!optionalNM.isEmpty()) {
            String oldTestCustomerID=optionalNM.get().getCustomerId();
            customerRepository.delete(optionalNM.get());
           /* bankAccountRepository.findBankAccountByCustomer_CustomerID(oldTestCustomerID)
                    .stream().forEach(ba->bankAccountRepository.deleteById(ba.getId()));*/
        }
        createNewCustomerTest(this.firstName,this.lastName,this.gender,LocalDate.parse(this.dateBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }


    private void createNewCustomerTest(final String firstName,final String lastName,final Gender gender, final LocalDate dateBirth) {
        Customer customer= new Customer(UUID.randomUUID().toString(),
                                    firstName,
                                        lastName,
                                                gender,
                                                    dateBirth,
                                                        new ArrayList<BankAccount>());
        customer=customerRepository.save(customer);

        BankAccount bankAccount=new BankAccount();
        bankAccount.setCustomer(customer);
        bankAccount.setAccountNumber("123456");
        bankAccount.setCredit(new BigDecimal(1_000));
        bankAccount.setAccountType(BankAccountType.CREDIT);

        bankAccount=bankAccountRepository.save(bankAccount);

        customer.setBankAccounts(Arrays.asList(bankAccount));

        customer=customerRepository.save(customer);

        System.out.println("---------------------------------------------------"+customer.getBankAccounts().size());
        System.out.println("---------------------------------------------------"+customer.getCustomerId());
        System.out.println("---------------------------------------------------"+customer.getId());
        System.out.println();
        System.out.println("---------------------------------------------------"+bankAccount.getAccountNumber());

    }


}
