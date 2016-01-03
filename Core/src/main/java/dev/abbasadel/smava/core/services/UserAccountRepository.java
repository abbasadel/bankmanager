/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.core.services;

import dev.abbasadel.smava.core.models.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abbasadel
 */

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{
    
//    UserAccount get(long userAccountId);
//    
//    UserAccount save(UserAccount userAccount);
    
//    void addBankAccount(long userAccountId, BankAccount bankAccount);
//    
//    void deleteBankAccount(long userAccountId, long bankAccountId);
//    
//    void updateBankAccount(long userAccountId, BankAccount bankAccount);
    
    
}
