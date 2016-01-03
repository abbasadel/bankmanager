/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.managers.BankAccountManager;
import dev.abbasadel.smava.core.managers.UserAccountManager;
import dev.abbasadel.smava.core.models.UserAccount;
import dev.abbasadel.smava.core.services.UserAccountRepository;
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
        userAccount.setBankAccounts(bankAccountManager.generate());
        userAccount = userAccountRepository.save(userAccount);

        return userAccount;
    }

    @Override
    public UserAccount get(Long id) {
        return userAccountRepository.findOne(id);
    }

}
