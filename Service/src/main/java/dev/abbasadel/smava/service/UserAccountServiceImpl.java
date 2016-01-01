/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.service;

import dev.abbasadel.smava.core.models.UserAccount;
import dev.abbasadel.smava.core.services.UserAccountService;

/**
 *
 * @author abbasadel
 */
public class UserAccountServiceImpl implements UserAccountService{

    @Override
    public UserAccount save(UserAccount userAccount) {
        userAccount.setId(1);
        return userAccount;
    }

    @Override
    public UserAccount get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
