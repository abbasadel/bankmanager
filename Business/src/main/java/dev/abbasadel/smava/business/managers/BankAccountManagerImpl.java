/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.managers.BankAccountManager;
import dev.abbasadel.smava.core.models.BankAccount;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import dev.abbasadel.smava.core.services.BankAccountService;

/**
 *
 * @author abbasadel
 */
public class BankAccountManagerImpl implements BankAccountManager{
    
    @Autowired
    BankAccountService bankAccountService;

    @Override
    public BankAccount save(BankAccount bankAccount) {
        return bankAccountService.save(bankAccount);
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        return bankAccountService.save(bankAccount);
    }

    @Override
    public void delete(BankAccount bankAccount) {
        bankAccountService.delete(bankAccount);
    }

    @Override
    public void delete(Long id) {
        bankAccountService.delete(id);
    }

    @Override
    public BankAccount generate() {
            return new BankAccount(randomIban(), randomBic());
    }

   
    private String randomIban(){
        return "DE" + RandomStringUtils.randomNumeric(20);
    }
    
    private String randomBic(){
        return RandomStringUtils.randomAlphabetic(8).toUpperCase() + "XXX";
    }

    @Override
    public BankAccount get(Long id) {
        return bankAccountService.findOne(id);
    }
    
    
    @Override
    public boolean exists(BankAccount bankAccount){
        //worest implementation ever
        for(BankAccount ba : bankAccountService.findAll()){
            if(ba.equals(bankAccount)){
                return true;
            }
        }
        
        return false;
    }
    
    
}
