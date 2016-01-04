package dev.abbasadel.smava.core.services;

import dev.abbasadel.smava.core.models.UserAccount;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author abbasadel
 */

public interface UserAccountService extends CrudRepository<UserAccount, Long>{

    
}
