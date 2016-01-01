/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.core.managers;

import dev.abbasadel.smava.core.models.BankAccount;

/**
 *
 * @author abbasadel
 */
public interface BankAccountManager {
    BankAccount create(BankAccount bankAccount);
    
    
    BankAccount edit(BankAccount bankAccount);
    
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
}
