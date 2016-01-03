/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.external.bankservice;

import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.services.BankAccountService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abbasadel
 */
@Repository
public interface ExternalBankAccountService 
        extends BankAccountService, CrudRepository<BankAccount, Long>{
    
}
