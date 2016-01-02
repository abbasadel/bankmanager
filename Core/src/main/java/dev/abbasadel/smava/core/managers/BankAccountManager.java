/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.core.managers;

import dev.abbasadel.smava.core.models.BankAccount;
import java.util.List;

/**
 *
 * @author abbasadel
 */
public interface BankAccountManager {
    BankAccount save(BankAccount bankAccount);
    
    
    BankAccount update(BankAccount bankAccount);
    
    /**
     * Deletes bank account
     * @param bankAccount
     * @return success of fail
     */
    boolean delete(BankAccount bankAccount);
    
    /**
     * Deletes bank account by IBAN
     * @param iban
     * @return success of fail
     */
    boolean delete(String iban);
    
    /**
     * generates default bank accounts
     * @return 
     */
    List<BankAccount> generate();

    public List<BankAccount> getByUserAccountId(long id);

    
    
}
