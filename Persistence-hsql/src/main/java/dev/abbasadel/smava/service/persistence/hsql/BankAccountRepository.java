package dev.abbasadel.smava.service.persistence.hsql;

import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.services.BankAccountService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abbasadel
 */
@Repository
public interface BankAccountRepository 
        extends BankAccountService, CrudRepository<BankAccount, Long>{
    
}
