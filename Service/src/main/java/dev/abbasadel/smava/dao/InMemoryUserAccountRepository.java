/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.dao;

import dev.abbasadel.smava.core.dao.UserAccountRepository;
import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.models.UserAccount;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author abbasadel
 */
public class InMemoryUserAccountRepository implements UserAccountRepository {

    Map<Long, UserAccount> memory = new HashMap<>();
    AtomicLong incrementer = new AtomicLong(1);

    @Override
    public UserAccount get(long userAccountId) {
        return memory.get(userAccountId);
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        userAccount.setId(incrementer.get());
        memory.put(userAccount.getId(), userAccount);

        return userAccount;
    }

    @Override
    public void addBankAccount(long userAccountId, BankAccount bankAccount) {
        UserAccount userAccount = get(userAccountId);
        if(userAccount  == null){
            //throw exception
        }
        userAccount.getBankAccounts().add(bankAccount);
    }

    @Override
    public void deleteBankAccount(long userAccountId, long bankAccountId) {
        UserAccount userAccount = get(userAccountId);
        if(userAccount  == null){
            //throw exception
        }
        
        for(BankAccount bankAccount : userAccount.getBankAccounts()){
            if(bankAccountId == bankAccount.getId()){
             userAccount.getBankAccounts().remove(bankAccount); //performance issue here
            }
        }
    }

    @Override
    public void updateBankAccount(long userAccountId, BankAccount updatedBankAccount) {
        deleteBankAccount(userAccountId, updatedBankAccount.getId());
        addBankAccount(userAccountId, updatedBankAccount);
    }

}
