package br.edu.ufabc.ufabcrunner_ws;

import br.edu.ufabc.ufabcrunner_ws.controllers.UsersController;
import br.edu.ufabc.ufabcrunner_ws.data.UsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UsersController.class, UsersRepository.class})
@AutoConfigureMockMvc
public class ApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void failure_noUser() throws Exception {
        when(usersRepository.findById("0")).thenReturn(null);

        this.mockMvc.perform(get("/users/0")).andExpect(status().isNotFound());
    }
}