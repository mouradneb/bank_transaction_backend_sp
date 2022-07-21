package nm.nebhi.bank_backend.dao;

import nm.nebhi.bank_backend.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
