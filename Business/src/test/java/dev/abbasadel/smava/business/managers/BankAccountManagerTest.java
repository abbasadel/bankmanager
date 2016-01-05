package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.services.BankAccountService;
import dev.abbasadel.smava.core.services.LoggerService;
import dev.abbasadel.smava.core.services.UserAccountService;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author abbasadel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class BankAccountManagerTest {

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

    /**
     * Test of save method, of class BankAccountManager.
     */
    @Test
    public void testSave() {
        BankAccount dummyAccount = new BankAccount();
        dummyAccount.setBic("12345678912");
        dummyAccount.setIban("1234567890123456789012");
        dummyAccount.setId(100L);

        Mockito.when(bankAccountService.save(dummyAccount)).thenReturn(dummyAccount);
        Mockito.doNothing().when(loggerService).log(Matchers.anyString());

        BankAccount ba = bankAccountManager.save(dummyAccount);
        assertNotNull(ba);
    }

    /**
     * Test of update method, of class BankAccountManager.
     */
    @Test
    public void testUpdate() {
        BankAccount dummyAccount = new BankAccount();
        dummyAccount.setBic("12345678912");
        dummyAccount.setIban("1234567890123456789012");
        dummyAccount.setId(100L);

        Mockito.when(bankAccountService.save(dummyAccount)).thenReturn(dummyAccount);
        Mockito.doNothing().when(loggerService).log(Matchers.anyString());

        BankAccount ba = bankAccountManager.update(dummyAccount);
        assertNotNull(ba);
    }

    /**
     * Test of delete method, of class BankAccountManager.
     */
    @Test
    public void testDelete() {

        Mockito.doNothing().when(bankAccountService).delete(100L);
        Mockito.doNothing().when(loggerService).log(Matchers.anyString());
        bankAccountManager.delete(100L);

    }

    @Test
    public void testGet() {
        BankAccount dummyAccount = new BankAccount();
        dummyAccount.setBic("12345678912");
        dummyAccount.setIban("1234567890123456789012");
        dummyAccount.setId(100L);

        Mockito.when(bankAccountService.findOne(100L)).thenReturn(dummyAccount);
        Mockito.doNothing().when(loggerService).log(Matchers.anyString());

        BankAccount ba = bankAccountManager.get(100L);
        assertEquals(ba, dummyAccount);
    }

//    /**
//     * Test of exists method, of class BankAccountManager.
//     */
//    @Test(expected=InvalidBankAccountException.class)
//    public void testExists() {
//        BankAccount dummyAccount = new BankAccount();
//        dummyAccount.setBic("12345678912");
//        dummyAccount.setIban("1234567890123456789012");
//        dummyAccount.setId(100L);
//
//        Mockito.when(bankAccountService.exists(100L)).thenReturn(true);
//        Mockito.doNothing().when(loggerService).log(Matchers.anyString());
//        
//        BankAccount ba = bankAccountManager.save(dummyAccount); //already exists
//        
//        
//    }

}
