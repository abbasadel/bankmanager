package dev.abbasadel.smava.jms.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author abbasadel
 */
@Component
public class JmsLoggerReceiver {
    //Logger logger = Logger.getLogger(JmsLoggerReceiver.class );
    
    @JmsListener(destination = "logger.queue")
    public void receiveOrder(String message) {
        //logger.debug(message);
        System.out.println(message);
    }
}
