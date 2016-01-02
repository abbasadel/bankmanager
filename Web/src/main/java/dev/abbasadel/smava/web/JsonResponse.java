/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.web;

import java.io.Serializable;
import org.springframework.http.HttpStatus;

/**
 *
 * @author abbasadel
 */
public class JsonResponse implements Serializable {

    private static final long serialVersionUID = -6068183407884308855L;

    HttpStatus staus = HttpStatus.OK;
    String message;
    Object data;

    public JsonResponse() {
        super();
    }

    public JsonResponse(HttpStatus staus, String message) {
        super();
        this.staus = staus;
        this.message = message;
    }
    
    public JsonResponse(HttpStatus staus, String message, Object data) {
        super();
        this.staus = staus;
        this.message = message;
        this.data = data;
    }

    public JsonResponse(String message) {
        super();
        this.message = message;
    }

    public HttpStatus getStaus() {
        return staus;
    }

    public void setStaus(HttpStatus staus) {
        this.staus = staus;
    }

    public String getMessage() {
        return message;
    }
    

    public void setMessage(String message) {
        this.message = message;
    }

    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    public static JsonResponse make(String msg) {
        return new JsonResponse(msg);
    }

    public static JsonResponse make(String msg, HttpStatus status) {
        return new JsonResponse(status, msg);
    }
    
    public static JsonResponse make(String msg, HttpStatus status, Object data) {
        return new JsonResponse(status, msg, data);
    }


}
