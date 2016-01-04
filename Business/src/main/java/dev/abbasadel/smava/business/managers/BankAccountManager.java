package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.models.BankAccount;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import dev.abbasadel.smava.core.services.BankAccountService;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasadel
 */
@Service
public class BankAccountManager  {
    
    @Autowired
    BankAccountService bankAccountService;

    public BankAccount save(BankAccount bankAccount) {
        return bankAccountService.save(bankAccount);
    }

    public BankAccount update(BankAccount bankAccount) {
        return bankAccountService.save(bankAccount);
    }

    public void delete(BankAccount bankAccount) {
        bankAccountService.delete(bankAccount);
    }

    public void delete(Long id) {
        bankAccountService.delete(id);
    }

    
    public BankAccount generate() {
            return new BankAccount(randomIban(), randomBic());
    }

   
    private String randomIban(){
        return "DE" + RandomStringUtils.randomNumeric(20);
    }
    
    private String randomBic(){
        return RandomStringUtils.randomAlphabetic(8).toUpperCase() + "XXX";
    }

    
    public BankAccount get(Long id) {
        return bankAccountService.findOne(id);
    }
    
    
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
