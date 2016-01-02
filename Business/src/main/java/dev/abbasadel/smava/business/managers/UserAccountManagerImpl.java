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
import dev.abbasadel.smava.core.managers.SessionManager;

/**
 *
 * @author abbasadel
 */
public class UserAccountManagerImpl implements UserAccountManager{
    
    @Autowired
    UserAccountService userAccountService;
    
    @Autowired
    SessionManager sessionManager;
    
    @Autowired
    BankAccountManager bankAccountManager;
    

    @Override
    public UserAccount getOrCreateUserAccountBySessionId(String sessionID) {
        UserAccount userAccount; 
        
        if(sessionManager.isUserAccountExsist(sessionID)){
            userAccount = sessionManager.getUserAccountFromSession(sessionID);
        }else{
            userAccount = new UserAccount();
            userAccount =  userAccountService.save(userAccount);
            userAccount.setBankAccounts(bankAccountManager.generate());
            
            sessionManager.addUserAccountToSession(sessionID, userAccount);
        }
        
        
        return userAccount;
    }
    
}
