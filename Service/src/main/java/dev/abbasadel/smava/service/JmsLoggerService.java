/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.service;

import dev.abbasadel.smava.core.services.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasadel
 */
@Service
public class JmsLoggerService implements LoggerService{
    
    private static final String SIMPLE_QUEUE = "logger.queue";

    @Autowired
     JmsTemplate jmsTemplate;

    @Override
    public void log(String message) {
        jmsTemplate.convertAndSend(SIMPLE_QUEUE, message);
    }
    
}
