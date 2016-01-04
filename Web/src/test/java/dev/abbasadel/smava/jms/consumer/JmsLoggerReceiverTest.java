
package dev.abbasadel.smava.jms.consumer;

import dev.abbasadel.smava.core.services.LoggerService;
import dev.abbasadel.smava.WebApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;

/**
 *
 * @author abbasadel
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebApplication.class)
public class JmsLoggerReceiverTest {
    
    @Autowired
    private LoggerService loggerService;
//    
//    @Autowired
//    private StoreService storeService;
//    
    @Test
    public void sendSimpleMessage() {
//        clientService.addOrder(new Order("order1"));
//        
//        Optional<Order> storedOrder = storeService.getReceivedOrder("order1");
//        Assert.assertTrue(storedOrder.isPresent());
//        Assert.assertEquals("order1", storedOrder.get().getId());
    }
}
