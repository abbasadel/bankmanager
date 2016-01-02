/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.managers.BankAccountManager;
import dev.abbasadel.smava.core.managers.UserAccountManager;
import dev.abbasadel.smava.core.models.UserAccount;
import dev.abbasadel.smava.core.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author abbasadel
 */
public class UserAccountManagerImpl implements UserAccountManager {

    @Autowired
    UserAccountService userAccountService;

    @Autowired
    BankAccountManager bankAccountManager;

    @Override
    public UserAccount create() {
        UserAccount userAccount = new UserAccount();
                userAccount.setBankAccounts(bankAccountManager.generate());
        userAccount = userAccountService.save(userAccount);

        return userAccount;
    }

    @Override
    public UserAccount get(long id) {
         UserAccount userAccount = userAccountService.get(id);
//         userAccount.setBankAccounts(bankAccountManager.getByUserAccountId(id));
         
         return userAccount;
    }

}
