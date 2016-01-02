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
import org.apache.commons.lang3.RandomStringUtils;

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
        list.add(new BankAccount(generateIban(), generateBic()));
        list.add(new BankAccount(generateIban(), generateBic()));
        list.add(new BankAccount(generateIban(), generateBic()));
        
        return list;
    }

    @Override
    public List<BankAccount> getByUserAccountId(long id) {
        return generate();
    }
    
    private String generateIban(){
        return "DE" + RandomStringUtils.randomNumeric(20);
    }
    
    private String generateBic(){
        return RandomStringUtils.randomAlphabetic(8) + "XXX";
    }
    
    
}
