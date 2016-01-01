/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.managers.UserAccountManager;
import dev.abbasadel.smava.core.models.UserAccount;

/**
 *
 * @author abbasadel
 */
public class UserAccountManagerImpl implements UserAccountManager{

    @Override
    public UserAccount getOrCreateUserAccountBySessionId(String sessionID) {
        return new UserAccount();
    }
    
}
