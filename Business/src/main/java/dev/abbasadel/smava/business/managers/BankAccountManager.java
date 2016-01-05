package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.exceptions.InvalidBankAccountException;
import dev.abbasadel.smava.core.models.BankAccount;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import dev.abbasadel.smava.core.services.BankAccountService;
import dev.abbasadel.smava.core.services.LoggerService;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasadel
 */
@Service
public class BankAccountManager {

    @Autowired
    BankAccountService bankAccountService;

    @Autowired
    LoggerService loggerService;

    public BankAccount save(BankAccount bankAccount) {
        if (!validate(bankAccount)) {
            throw new InvalidBankAccountException("IBAN/BIC are not valid");
        }
        loggerService.log("Creating: " + bankAccount);
        return bankAccountService.save(bankAccount);
    }

    public BankAccount update(BankAccount bankAccount) {
        if (!validate(bankAccount)) {
            throw new InvalidBankAccountException("IBAN/BIC are not valid");
        }
        loggerService.log("Updating: " + bankAccount);
        return bankAccountService.save(bankAccount);
    }

    public void delete(BankAccount bankAccount) {
        loggerService.log("Deleteing: " + bankAccount);
        bankAccountService.delete(bankAccount);
    }

    public void delete(Long id) {
        loggerService.log("Deleteing bank account ID: " + id);
        bankAccountService.delete(id);
    }

    public BankAccount generate() {
        return new BankAccount(randomIban(), randomBic());
    }

    private String randomIban() {
        return "DE" + RandomStringUtils.randomNumeric(20);
    }

    private String randomBic() {
        return RandomStringUtils.randomAlphabetic(8).toUpperCase() + "XXX";
    }

    public BankAccount get(Long id) {
        return bankAccountService.findOne(id);
    }

    public boolean exists(BankAccount bankAccount) {
        //worest implementation ever
        for (BankAccount ba : bankAccountService.findAll()) {
            if (ba.equals(bankAccount)) {
                return true;
            }
        }

        return false;
    }

    private boolean validate(BankAccount bankAccount) {
        if (bankAccount == null) {
            return false;
        }
        if (bankAccount.getIban().length() != 22) {
            return false;
        }
        if (bankAccount.getBic().length() != 11) {
            return false;
        }

        return true;
    }

}
