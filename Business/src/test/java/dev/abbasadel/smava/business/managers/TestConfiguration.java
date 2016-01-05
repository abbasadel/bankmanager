
package dev.abbasadel.smava.business.managers;

import dev.abbasadel.smava.core.services.BankAccountService;
import dev.abbasadel.smava.core.services.LoggerService;
import dev.abbasadel.smava.core.services.UserAccountService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author abbasadel
 */
@Configuration
public class TestConfiguration {

    // this bean will be injected into the OrderServiceTest class
    @Bean
    public UserAccountManager userAccountManager() {
        UserAccountManager userAccountManager = new UserAccountManager();
        return userAccountManager;
    }

    @Bean
    public BankAccountManager bankAccountManager() {
        BankAccountManager bankAccountManager = new BankAccountManager();
        return bankAccountManager;
    }

    @Bean
    public UserAccountService userAccountService() {
        return Mockito.mock(UserAccountService.class);
    }

    @Bean
    public BankAccountService bankAccountService() {
        return Mockito.mock(BankAccountService.class);
    }

    @Bean
    public LoggerService loggerService() {
        return Mockito.mock(LoggerService.class);
    }
}
