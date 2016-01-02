package dev.abbasadel.smava.web;

import dev.abbasadel.smava.business.managers.BankAccountManagerImpl;
import dev.abbasadel.smava.business.managers.UserAccountManagerImpl;
import dev.abbasadel.smava.core.dao.UserAccountRepository;
import dev.abbasadel.smava.core.managers.BankAccountManager;
import dev.abbasadel.smava.core.managers.SessionManager;
import dev.abbasadel.smava.core.managers.UserAccountManager;
import dev.abbasadel.smava.core.services.BankAccountService;
import dev.abbasadel.smava.core.services.UserAccountService;
import dev.abbasadel.smava.dao.InMemoryUserAccountRepository;
import dev.abbasadel.smava.service.BankAccountServiceImpl;
import dev.abbasadel.smava.service.UserAccountServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }
    
    /***** SERVICES *****/
    
    @Bean
    BankAccountService getBankAccountService(){
        return new BankAccountServiceImpl();
    }
    
    @Bean
    UserAccountService getUserAccountService(){
        return new UserAccountServiceImpl();
    }

    /***** MANAGERS *****/
    
    
    @Bean
    public UserAccountManager getUserAccountManager() {
        return new UserAccountManagerImpl();
    }
    
    
    @Bean
    public BankAccountManager getAccountManager(){
        return new BankAccountManagerImpl();
    }
    
    /******* REPOSITORY ******/
    
    @Bean
    public UserAccountRepository getUserAccountRepository(){
        return new InMemoryUserAccountRepository();
    }
    
    
    
    

}
