/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.web.controllers;

import dev.abbasadel.smava.core.managers.BankAccountManager;
import dev.abbasadel.smava.core.managers.UserAccountManager;
import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.models.UserAccount;
import dev.abbasadel.smava.web.JsonResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abbasadel
 */
@RestController
@RequestMapping("/banks/accounts/")
public class BankAccountController {

    @Autowired
    BankAccountManager bankAccountManager;

    @Autowired
    UserAccountManager userAccountManager;

    @RequestMapping(method = RequestMethod.POST)
    public JsonResponse add(@RequestBody BankAccount bankAccount, HttpSession session) {

        Long currentUserAccountId = (Long) session.getAttribute("SESSION_USER_ACCOUNT_ID");

        if (currentUserAccountId != null) {
            UserAccount userAccount = userAccountManager.get(currentUserAccountId);
            bankAccount.setUserAccount(userAccount);
            bankAccount = bankAccountManager.save(bankAccount);
        }

        return JsonResponse.make("Created Successfully", HttpStatus.OK, bankAccount);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public JsonResponse update(@PathVariable Long id, @RequestBody BankAccount bankAccount) {
        BankAccount oldBankAccount = bankAccountManager.get(id);
        oldBankAccount.setBic(bankAccount.getBic());
        oldBankAccount.setIban(bankAccount.getIban());
        bankAccountManager.update(oldBankAccount);
        return JsonResponse.make("Updated Successfully", HttpStatus.OK, bankAccount);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public JsonResponse delete(@PathVariable Long id) {
        bankAccountManager.delete(id);
        return JsonResponse.make("Deleted Successfully", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public JsonResponse get(@PathVariable Long id) {
        return JsonResponse.make("Get Successfully", HttpStatus.OK, bankAccountManager.get(id));

    }

}
