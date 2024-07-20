package com.example.library.library.managment.patronController;

import com.example.library.library.managment.controllers.PatronController;
import com.example.library.library.managment.entity.Books;
import com.example.library.library.managment.entity.Patrons;
import com.example.library.library.managment.services.PatronService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;

@WebMvcTest(PatronController.class)
public class PatronControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatronService patronService;

    @Test
    void testGetAllPatrons() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/patrons"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    void testGetBookById() throws Exception {
        Patrons patron = new Patrons();
        patron.setId(1L);
        patron.setName("ahmed");
        patron.setAddress("maady");
        patron.setPhone_number("01097592050");

        when(patronService.getById(1L)).thenReturn(patron);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/patrons/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        "{\"id\":1,\"name\":\"ahmed\",\"address\":\"maady\",\"phone_number\":\"01097592050\"}"));

        verify(patronService, times(1)).getById(1L);
    }
}
