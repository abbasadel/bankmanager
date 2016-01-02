package dev.abbasadel.smava.web.controllers;

import dev.abbasadel.smava.core.managers.UserAccountManager;
import dev.abbasadel.smava.core.models.UserAccount;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author abbasadel
 */

@Controller
public class HomeController {

    Logger logger = Logger.getLogger(HomeController.class);
    
    @Autowired
    UserAccountManager userAccountManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Map<String, Object> model, HttpSession session) {
        String sessionId = session.getId();
        
        UserAccount userAccount = userAccountManager.getOrCreateUserAccountBySessionId(sessionId);        
        model.put("userAccount", userAccount);
        model.put("sessionId", sessionId);
                
        return "home";
    }
    
    
    @RequestMapping(value = "/abbas", method = RequestMethod.GET)
    public String abbas() {
        return "hi my name is abbas";
    }

}
