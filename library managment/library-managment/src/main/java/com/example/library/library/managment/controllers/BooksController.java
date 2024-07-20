package com.example.library.library.managment.controllers;

import com.example.library.library.managment.entity.Books;
import com.example.library.library.managment.error_response.Error_Response;
import com.example.library.library.managment.exception.NOT_FOUND_ID;
import com.example.library.library.managment.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
//@Validated
@RequestMapping("/api/books")
public class BooksController {
    private  final BookService bookService;


@GetMapping
    public ResponseEntity<List<Books>> allBooks(){
        return ResponseEntity.ok(bookService.allbooks()) ;


    }

    @PostMapping("/add")
    public ResponseEntity<Books> addBook(@RequestBody @Valid Books book){
        return ResponseEntity.status(HttpStatus.CREATED).body( bookService.addbook(book)) ;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getById(@PathVariable("id") Long id ){

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(bookService.getById(id));


    }
    @PutMapping("/{id}")
    public ResponseEntity<Books>  fullyUpdate( @RequestBody @Valid Books book,@PathVariable("id") long id){
        return ResponseEntity.ok(bookService.fullUpdate(book, id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id ){
        bookService.deleteById(id);
        return ResponseEntity.ok().build();



    }


}
