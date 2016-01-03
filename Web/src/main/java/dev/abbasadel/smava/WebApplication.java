package dev.abbasadel.smava;

import dev.abbasadel.smava.business.managers.BankAccountManagerImpl;
import dev.abbasadel.smava.business.managers.UserAccountManagerImpl;
import dev.abbasadel.smava.core.managers.BankAccountManager;
import dev.abbasadel.smava.core.managers.UserAccountManager;
import jdk.nashorn.internal.runtime.UserAccessorProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"dev.abbasadel.smava.services"})
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
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
    
//    @Bean
//    public UserAccountRepository getUserAccountRepository(){
//        return new InMemoryUserAccountRepository();
//    }
//    
    
//     @Bean
//    public BankAccountRepository getBankAccountRepository(){
//        return new InMemoryUserAccountRepository();
//    }
    
    
    
    

}
