package com.example.library.library.managment.services;

import com.example.library.library.managment.Reposaitory.BookRepo;
import com.example.library.library.managment.entity.Books;
import com.example.library.library.managment.exception.NOT_FOUND_ID;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;

@Validated
@Service
@RequiredArgsConstructor
public class BookService {

   private final BookRepo bookRepo;

public List<Books> allbooks(){

    return bookRepo.findAll();
}

public Books addbook(@Valid Books book){
   return bookRepo.save(book);

}
public Books getById(Long id){

  return bookRepo.findById(id).orElseThrow(()-> new NOT_FOUND_ID("not found id of book:" + id));
}
@Transactional
public Books fullUpdate(Books book,long id) {


        book.setId(id);
    if (!bookRepo.existsById(id)) {
        throw new NOT_FOUND_ID("not found id of book:" + id);
    }



        return bookRepo.saveAndFlush(book);

}
@Transactional
 public void  deleteById(long id) {

     Books book = getById(id);
     if (book != null) {
         bookRepo.deleteById(id);
     }

 }

}
