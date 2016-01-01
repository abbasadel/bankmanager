/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.service;

import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.services.BankAccountService;
import java.util.List;

/**
 *
 * @author abbasadel
 */
public class BankAccountServiceImpl implements BankAccountService{

    @Override
    public List<BankAccount> get(long userAccountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(BankAccount bankAccount, long userAccountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long bankAccountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
