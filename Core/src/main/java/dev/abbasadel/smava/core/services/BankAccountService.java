/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.core.services;

import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.models.UserAccount;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author abbasadel
 */
public interface BankAccountService extends CrudRepository<BankAccount, Long> {
    Iterable<BankAccount> findforUserAccount(UserAccount userAccount);
}
