/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.core.services;

import dev.abbasadel.smava.core.RESTService;
import dev.abbasadel.smava.core.models.BankAccount;
import java.util.List;

/**
 *
 * @author abbasadel
 */
public interface BankAccountService extends RESTService<BankAccount>{
    List<BankAccount> getDefaut();
}
