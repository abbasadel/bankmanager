/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.service;

import dev.abbasadel.smava.core.dao.UserAccountRepository;
import dev.abbasadel.smava.core.models.UserAccount;
import dev.abbasadel.smava.core.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author abbasadel
 */
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public UserAccount save(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount get(long id) {
        return userAccountRepository.get(id);
    }

}
