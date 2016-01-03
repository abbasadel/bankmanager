/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.managers.BankAccountManager;
import dev.abbasadel.smava.core.managers.UserAccountManager;
import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.models.UserAccount;
import dev.abbasadel.smava.core.services.UserAccountRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author abbasadel
 */
public class UserAccountManagerImpl implements UserAccountManager {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    BankAccountManager bankAccountManager;

    @Override
    public UserAccount create() {
        UserAccount userAccount = new UserAccount();
        userAccount = userAccountRepository.save(userAccount);
        userAccount.setBankAccounts(new ArrayList<>(3));
        
        for(int i=0; i<3; i++){
            BankAccount bankAccount = bankAccountManager.generate();
            bankAccount.setUserAccount(userAccount);
            bankAccount = bankAccountManager.save(bankAccount);
            userAccount.getBankAccounts().add(bankAccount);
        }

        return userAccount;
    }

    @Override
    public UserAccount get(Long id) {
        return userAccountRepository.findOne(id);
    }

}
