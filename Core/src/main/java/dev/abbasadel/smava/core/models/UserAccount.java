/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.core.models;

import java.util.List;

/**
 *
 * @author abbasadel
 */
public class UserAccount {
    
    long id;
    List<BankAccount> bankAccouts;
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<BankAccount> getBankAccouts() {
        return bankAccouts;
    }

    public void setBankAccouts(List<BankAccount> bankAccouts) {
        this.bankAccouts = bankAccouts;
    }
    
    
}
