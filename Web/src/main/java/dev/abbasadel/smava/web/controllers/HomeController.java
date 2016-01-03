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

    private static final String SESSION_USER_ACCOUNT_ID = "SESSION_USER_ACCOUNT_ID";

    @Autowired
    UserAccountManager userAccountManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Map<String, Object> model, HttpSession session) {

        UserAccount userAccount;

        Long userAccountId = getUserAccountIdFromSession(session);
        if (userAccountId == null) {
            userAccount = userAccountManager.create();
            setUserAccountIdInSession(session, userAccount.getId());
        } else {
            userAccount = userAccountManager.get(userAccountId);
        }

        model.put("userAccount", userAccount);
        model.put("sessionid", session.getId());

        return "home";
    }

    private Long getUserAccountIdFromSession(HttpSession session) {
         return (Long) session.getAttribute(SESSION_USER_ACCOUNT_ID);
    }

    private void setUserAccountIdInSession(HttpSession session, long userAccountId) {
        session.setAttribute(SESSION_USER_ACCOUNT_ID, userAccountId);
    }

}
