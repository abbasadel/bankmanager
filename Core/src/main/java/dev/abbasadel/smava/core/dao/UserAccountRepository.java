/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.core.dao;

import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.models.UserAccount;

/**
 *
 * @author abbasadel
 */
public interface UserAccountRepository {
    
    UserAccount get(long userAccountId);
    
    UserAccount save(UserAccount userAccount);
    
    void addBankAccount(long userAccountId, BankAccount bankAccount);
    
    void deleteBankAccount(long userAccountId, long bankAccountId);
    
    void updateBankAccount(long userAccountId, BankAccount bankAccount);
    
    
}
