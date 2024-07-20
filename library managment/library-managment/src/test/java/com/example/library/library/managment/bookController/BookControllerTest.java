package com.example.library.library.managment.bookController;
import static org.mockito.Mockito.*;

import com.example.library.library.managment.controllers.BooksController;
import com.example.library.library.managment.entity.Books;
import com.example.library.library.managment.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@WebMvcTest(BooksController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void testGetBookById() throws Exception {
        Books book = new Books();
        book.setId(1L);
        book.setTitle("science");
        book.setAuthor("ahmed");
        book.setPublication_year(2009);
        book.setISBN("1234");






       when(bookService.getById(1L)).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        "{\"id\":1,\"title\":\"science\",\"author\":\"ahmed\",\"publication_year\":2009,\"isbn\":\"1234\"}"));

        verify(bookService, times(1)).getById(1L);
    }

    @Test
    void testGetAllBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

}

