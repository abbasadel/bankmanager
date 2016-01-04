package dev.abbasadel.smava.jms.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author abbasadel
 */
@Component
public class JmsLoggerReceiver {
    Logger logger = LoggerFactory.getLogger(JmsLoggerReceiver.class );


    @JmsListener(destination = "audit.queue")
    public void receiveOrder(String message) {
        logger.info(message);
    }

}
