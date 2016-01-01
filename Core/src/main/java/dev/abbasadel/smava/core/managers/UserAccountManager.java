/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.core.managers;

import dev.abbasadel.smava.core.models.UserAccount;

/**
 *
 * @author abbasadel
 */
public interface UserAccountManager {
    /**
     * returns UserAccount if found by Session ID or creates new one
     * @param sessionID
     * @return 
     */
    UserAccount getOrCreateUserAccountBySessionId(String sessionID);
}
