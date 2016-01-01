/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.core.models;

/**
 *
 * @author abbasadel
 */
public class BankAccount {
    long id;
    String bic;
    String iban;

    public BankAccount() {
    }
    
    

    public BankAccount(String bic, String iban) {
        this.bic = bic;
        this.iban = iban;
    }

    public BankAccount(long id, String bic, String iban) {
        this.id = id;
        this.bic = bic;
        this.iban = iban;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
    
    
}
