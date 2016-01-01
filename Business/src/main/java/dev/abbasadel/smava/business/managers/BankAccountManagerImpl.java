/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.managers.BankAccountManager;
import dev.abbasadel.smava.core.models.BankAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abbasadel
 */
public class BankAccountManagerImpl implements BankAccountManager{

    @Override
    public BankAccount save(BankAccount bankAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(BankAccount bankAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String iban) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BankAccount> generate() {
        List<BankAccount> list = new ArrayList<>(3);
        list.add(new BankAccount("111", "XXX"));
        list.add(new BankAccount("222", "YYY"));
        list.add(new BankAccount("333", "ZZZ"));
        
        return list;
    }
    
}
