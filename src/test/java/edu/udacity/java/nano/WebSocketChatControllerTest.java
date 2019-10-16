package edu.udacity.java.nano;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class WebSocketChatControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void login() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("/login"));
    }

    @Test
    public void index() throws Exception {
        this.mockMvc.perform(get("/index?username=" + "stub-username"))
                .andExpect(status().isOk())
                .andExpect(view().name("/chat"));
    }
}
