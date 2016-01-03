/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.web.controllers;

import dev.abbasadel.smava.core.exceptions.BusinessException;
import dev.abbasadel.smava.web.JsonResponse;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author abbasadel
 */
@ControllerAdvice
public class GlobalJsonExceptionHandler {

    Logger logger = Logger.getLogger(GlobalJsonExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public @ResponseBody
    JsonResponse handleBusinessException(Exception e) {
        logger.debug(e.getMessage());
        return JsonResponse.make(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }
    
    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody
    JsonResponse handleRuntimeException(Exception e) {
        logger.error(e.getMessage(), e);
        return JsonResponse.make("Error Happened, Please try again later.", HttpStatus.EXPECTATION_FAILED);
    }
}
