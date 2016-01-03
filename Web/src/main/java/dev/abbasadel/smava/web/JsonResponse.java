package dev.abbasadel.smava.web;

import java.io.Serializable;
import org.springframework.http.HttpStatus;

/**
 *
 * @author abbasadel
 */
public class JsonResponse implements Serializable {

    private static final long serialVersionUID = -6068183407884308855L;

    HttpStatus status = HttpStatus.OK;
    String message;
    Object data;

    public JsonResponse() {
        super();
    }

    public JsonResponse(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
    
    public JsonResponse(HttpStatus status, String message, Object data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public JsonResponse(String message) {
        super();
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
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
