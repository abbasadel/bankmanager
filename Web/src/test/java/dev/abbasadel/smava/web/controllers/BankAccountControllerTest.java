package dev.abbasadel.smava.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.abbasadel.smava.business.managers.BankAccountManager;
import dev.abbasadel.smava.business.managers.UserAccountManager;
import dev.abbasadel.smava.core.models.BankAccount;
import dev.abbasadel.smava.core.models.UserAccount;
import dev.abbasadel.smava.web.JsonResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author abbasadel
 */
public class BankAccountControllerTest extends BaseControllerTest {

    @Mock
    private UserAccountManager userAccountManager;

    @Mock
    private BankAccountManager bankAccountManager;

    @InjectMocks
    private BankAccountController bankAccountController;

    @Before
    @Override
    public void setup() {
        super.setup();

        mockMvc = MockMvcBuilders.standaloneSetup(bankAccountController).build();

    }

    @Test
    public void createBankAccount() throws Exception {

        BankAccount dummBankAccount = new BankAccount("xxx", "yyy");
        Mockito.when(bankAccountManager.exists(dummBankAccount)).thenReturn(false);
        Mockito.when(userAccountManager.get(Matchers.anyLong())).thenReturn(new UserAccount());
        Mockito.when(bankAccountManager.save(dummBankAccount)).thenReturn(dummBankAccount);

        String jsonString = new ObjectMapper().writeValueAsString(dummBankAccount);
        String jsonResposne = new ObjectMapper().writeValueAsString(new JsonResponse(HttpStatus.OK, "Created Successfully", dummBankAccount));
        mockMvc.perform(post("/banks/accounts/")
                .sessionAttr(HomeController.SESSION_USER_ACCOUNT_ID, 101L)
                .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(MockMvcResultMatchers.content().string(jsonResposne));
    }

    @Test
    public void updateBankAccount() throws Exception {

        BankAccount dummBankAccount = new BankAccount(1L, "xxx", "yyy");
        Mockito.when(userAccountManager.get(Matchers.anyLong())).thenReturn(new UserAccount());
        Mockito.when(bankAccountManager.get(1L)).thenReturn(dummBankAccount);
        Mockito.when(bankAccountManager.update(dummBankAccount)).thenReturn(dummBankAccount);

        String jsonString = new ObjectMapper().writeValueAsString(dummBankAccount);
        String jsonResposne = new ObjectMapper().writeValueAsString(new JsonResponse(HttpStatus.OK, "Updated Successfully", dummBankAccount));
        mockMvc.perform(put("/banks/accounts/1")
                .sessionAttr(HomeController.SESSION_USER_ACCOUNT_ID, 101L)
                .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(MockMvcResultMatchers.content().string(jsonResposne));
    }

    @Test
    public void deleteBankAccount() throws Exception {

        Mockito.doNothing().when(bankAccountManager).delete(1L);

        String jsonResposne = new ObjectMapper().writeValueAsString(new JsonResponse(HttpStatus.OK, "Deleted Successfully"));
        mockMvc.perform(delete("/banks/accounts/1")
                .sessionAttr(HomeController.SESSION_USER_ACCOUNT_ID, 101L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string(jsonResposne));

    }
    
    
//    @Test
//    public void invalidBankAccount() throws Exception {
//
//        BankAccount dummBankAccount = new BankAccount("xxx", "yyy");
//        Mockito.when(bankAccountManager.exists(dummBankAccount)).thenReturn(false);
//        Mockito.when(userAccountManager.get(Matchers.anyLong())).thenReturn(new UserAccount());
//        Mockito.when(bankAccountManager.save(dummBankAccount)).thenThrow( new InvalidBankAccountException("IBAN/BIC are not valid"));
//
//        String jsonString = new ObjectMapper().writeValueAsString(dummBankAccount);
//        String jsonResposne = new ObjectMapper().writeValueAsString(JsonResponse.make("Error Happened, Please try again later.", HttpStatus.EXPECTATION_FAILED));
//        mockMvc.perform(post("/banks/accounts/")
//                .sessionAttr(HomeController.SESSION_USER_ACCOUNT_ID, 101L)
//                .contentType(MediaType.APPLICATION_JSON).content(jsonString))
//                .andExpect(MockMvcResultMatchers.content().string(jsonResposne));
//    }
}
