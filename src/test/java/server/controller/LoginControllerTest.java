package server.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import server.model.Member;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MockHttpSession session;

    @Test
    void testToUserLogin() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void testLogin() throws Exception {
        // admin login
        mockMvc.perform(post("/login")
                .param("account", "1001")
                .param("password", "123456")
                .param("loginType", "admin"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/adminMain"))
                .andExpect(flash().attributeExists("admin"));
        // member login
        mockMvc.perform(post("/login")
                .param("account", "202183406")
                .param("password", "123456")
                .param("loginType", "member"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/userMain"))
                .andExpect(flash().attributeExists("member"));
        // employee login
        mockMvc.perform(post("/login")
                .param("account", "kingfitness")
                .param("password", "123456")
                .param("loginType", "employee"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/staff"))
                .andExpect(flash().attributeExists("employee"));
    }

    @Test
    void testToUserRegistration() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/userRegistration"));
    }

    @Test
    void testToAdminMain() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("memberTotal", 10);
        session.setAttribute("employeeTotal", 5);
        session.setAttribute("humanTotal", 20);
        session.setAttribute("equipmentTotal", 15);

        mockMvc.perform(get("/toAdminMain")
                .session(session))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("memberTotal"))
                .andExpect(model().attributeExists("employeeTotal"))
                .andExpect(model().attributeExists("humanTotal"))
                .andExpect(model().attributeExists("equipmentTotal"))
                .andExpect(view().name("admin/adminMain"))
                .andReturn();
    }

    @Test
    void testToUserMain() throws Exception {
        MockHttpSession session = new MockHttpSession();
        Member mockMember = new Member();
        session.setAttribute("user", mockMember);

        mockMvc.perform(get("/toUserMain")
                .session(session))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("member"))
                .andExpect(view().name("user/userMain"))
                .andReturn();
    }

    @Test
    void testLogout() throws Exception {
        MockHttpSession session = new MockHttpSession();

        mockMvc.perform(get("/logout").session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
                .andReturn();
    }
}
