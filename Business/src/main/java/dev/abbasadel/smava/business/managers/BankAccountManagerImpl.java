/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.managers.BankAccountManager;
import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.services.BankAccountRepository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author abbasadel
 */
public class BankAccountManagerImpl implements BankAccountManager{
    
    @Autowired
    BankAccountRepository bankAccountRepository;

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
        int times = 3;
        List<BankAccount> list = new ArrayList<>(times);
        for(int i=0; i<times; i++){
            BankAccount dummyBankAccount = new BankAccount(generateIban(), generateBic());
            //dummyBankAccount = bankAccountRepository.save(dummyBankAccount);
            list.add(dummyBankAccount);
        }
        
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
