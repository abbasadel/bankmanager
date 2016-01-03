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

    BankAccount get(Long id);

    BankAccount save(BankAccount bankAccount);

    BankAccount update(BankAccount bankAccount);

    /**
     * Deletes bank account
     *
     * @param bankAccount
     * @return success of fail
     */
    void delete(BankAccount bankAccount);

    /**
     * Deletes bank account by IBAN
     *
     * @param iban
     * @return success of fail
     */
    void delete(Long id);

    /**
     * generates dummy bank account
     *
     * @return
     */
    BankAccount generate();

    boolean exists(BankAccount bankAccount);

    }
