/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.abbasadel.smava.web.controllers;

import dev.abbasadel.smava.business.managers.UserAccountManager;
import dev.abbasadel.smava.core.models.UserAccount;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author abbasadel
 */

public class HomeControllerTest extends BaseControllerTest{

    @Mock
    private UserAccountManager userAccountManager;


    @InjectMocks
    private HomeController homeController;

    @Before
    @Override
    public void setup() {
        super.setup();

        mockMvc = MockMvcBuilders.standaloneSetup(homeController)
                .setViewResolvers(viewResolver).build();
    }

    @Test
    public void testNewSession() throws Exception {

        UserAccount ua = new UserAccount();
        ua.setId(100L);
        Mockito.when(userAccountManager.create()).thenReturn(ua);

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.view().name("home"))
                .andExpect(MockMvcResultMatchers.model().attribute("userAccount", ua))
                .andExpect(MockMvcResultMatchers.request().sessionAttribute(HomeController.SESSION_USER_ACCOUNT_ID, 100L));
    }

    @Test
    public void testOldSession() throws Exception {

        UserAccount ua = new UserAccount();
        ua.setId(101L);
        Mockito.when(userAccountManager.get(101L)).thenReturn(ua);

        mockMvc.perform(MockMvcRequestBuilders.get("/")
                .sessionAttr(HomeController.SESSION_USER_ACCOUNT_ID, 101L))
                .andExpect(MockMvcResultMatchers.view().name("home"))
                .andExpect(MockMvcResultMatchers.model().attribute("userAccount", ua));

    }
}
