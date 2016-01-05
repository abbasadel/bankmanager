/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.models.BankAccount;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import dev.abbasadel.smava.core.models.UserAccount;
import dev.abbasadel.smava.core.services.BankAccountService;
import dev.abbasadel.smava.core.services.LoggerService;
import dev.abbasadel.smava.core.services.UserAccountService;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author abbasadel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class UserAccountManagerTest {

    @Autowired
    UserAccountService userAccountRepository;

    @Autowired
    BankAccountService bankAccountService;

    @Autowired
    UserAccountManager userAccountManager;

    @Autowired
    BankAccountManager bankAccountManager;

    @Autowired
    LoggerService loggerService;

   

    @Test
    public void testCreate() {
        UserAccount dummyAccount = new UserAccount();
        dummyAccount.setId(100L);
        Mockito.when(userAccountRepository.save((UserAccount)Matchers.anyObject())).thenReturn(dummyAccount);
        Mockito.when(bankAccountService.save((BankAccount) Matchers.anyObject())).thenReturn(new BankAccount());
        Mockito.doNothing().when(loggerService).log(Matchers.anyString());
        UserAccount userAccount = userAccountManager.create();
        assertEquals(userAccount.getId(), dummyAccount.getId());
        assertTrue(userAccount.getBankAccounts().size() == 3);

    }

}
