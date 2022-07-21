package nm.nebhi.bank_backend.dao;

import nm.nebhi.bank_backend.entities.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
