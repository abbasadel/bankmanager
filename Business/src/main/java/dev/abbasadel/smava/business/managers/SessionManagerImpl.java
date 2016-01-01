/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.managers.SessionManager;
import dev.abbasadel.smava.core.models.UserAccount;

/**
 *
 * @author abbasadel
 */
public class SessionManagerImpl implements SessionManager{

    @Override
    public boolean isUserAccountExsist(String sessionId) {
        return false;
    }

    @Override
    public UserAccount getUserAccountFromSession(String sessionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUserAccountToSession(String sessionId, UserAccount userAccount) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
