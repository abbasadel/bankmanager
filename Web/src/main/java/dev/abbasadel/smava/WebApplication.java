package dev.abbasadel.smava;

import dev.abbasadel.smava.business.managers.BankAccountManagerImpl;
import dev.abbasadel.smava.business.managers.UserAccountManagerImpl;
import dev.abbasadel.smava.core.managers.BankAccountManager;
import dev.abbasadel.smava.core.managers.UserAccountManager;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.eclipse.jetty.server.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"dev.abbasadel.smava.services"})
public class WebApplication extends SpringBootServletInitializer {

    private static final String JMS_BROKER_URL = "vm://embedded?broker.persistent=false,useShutdownHook=false";
    
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
    
    /*** JMS ***/
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        return (ConnectionFactory) new ActiveMQConnectionFactory(JMS_BROKER_URL);
//    }

    
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
