/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.core.services;

import dev.abbasadel.smava.core.models.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abbasadel
 */
@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long>{
    
}
