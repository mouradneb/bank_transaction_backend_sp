package nm.nebhi.bank_backend.dao;

import nm.nebhi.bank_backend.constants.Gender;
import nm.nebhi.bank_backend.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author Mourad NEBHI
 * @version 1.0
 * @apiNote  CustomerRepository interface expose http://localhost:8080/customers API
 *           feel free to visit all built in default exposed APIs through http://localhost:8080
 */
@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer,Long> {

    Customer findCustomerByCustomerId (String cusotmerId);

    Optional<Customer> findCustomerByFirstNameAndLastNameAndGenderAndDateBirth(String firstName, String lastName, Gender gender, LocalDate dateBirth);

}
