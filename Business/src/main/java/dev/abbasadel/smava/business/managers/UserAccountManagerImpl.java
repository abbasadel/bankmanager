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
import dev.abbasadel.smava.core.services.LoggerService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import dev.abbasadel.smava.core.services.UserAccountService;

/**
 *
 * @author abbasadel
 */
public class UserAccountManagerImpl implements UserAccountManager {

    @Autowired
    UserAccountService userAccountRepository;

    @Autowired
    BankAccountManager bankAccountManager;
    
    @Autowired
    LoggerService loggerService;

    @Override
    public UserAccount create() {
        UserAccount userAccount = new UserAccount();
        userAccount = userAccountRepository.save(userAccount);
        
        loggerService.log("New User created with id" + userAccount.getId());
        
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
