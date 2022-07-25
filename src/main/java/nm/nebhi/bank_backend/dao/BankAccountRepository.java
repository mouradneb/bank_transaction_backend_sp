package nm.nebhi.bank_backend.dao;

import nm.nebhi.bank_backend.entities.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author Mourad NEBHI
 * @version 1.0
 * @apiNote  BankAccountRepository interface expose http://localhost:8080/bankAccounts API
 *           feel free to visit all built in default exposed APIs through http://localhost:8080
 */
@RepositoryRestResource
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
    /*
    * It's very easy to get all informations that you need about entities with spring jpa.
    * Within interface CrudRepository or JpaRepository, just concatenate to 'findBy' method (function)
    * all fields that you need to ask for (even for nested objects properties).
    * You can combine these fields with AND, OR and much more logical Operators.
    * Spring is very smart and do work for you :o).
    * Thanks spring, i love it :o).

    * If you are fun for sql query or you don't trust automation, you can write your own request as shown here:

        @Query("select ba from BankAccount as ba where ba.customer.id=:id")
        List<BankAccount> findBankAccountsByCustomerId(@Param("id") Long id);
    */

    List<BankAccount> findBankAccountsByCustomer_CustomerId(final String customerId);

    //because we assume that one customer can have multiple account
    BankAccount findBankAccountByAccountNumber(final String accountNumber);
}
