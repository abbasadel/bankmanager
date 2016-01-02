/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.web.controllers;

import dev.abbasadel.smava.core.managers.BankAccountManager;
import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.web.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abbasadel
 */
@RestController
@RequestMapping("/banks")
public class BankAccountController {

    @Autowired
    BankAccountManager bankAccountManager;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody JsonResponse add(BankAccount bankAccount) {
        return JsonResponse.make("Created Successfully", HttpStatus.OK, bankAccount);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody JsonResponse update(BankAccount bankAccount) {
        return JsonResponse.make("Updated Successfully", HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody JsonResponse delete(long bankAccountId) {
        return JsonResponse.make("Deleted Successfully", HttpStatus.OK);
    }

}
