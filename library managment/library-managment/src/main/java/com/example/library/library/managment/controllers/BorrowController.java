package com.example.library.library.managment.controllers;

import com.example.library.library.managment.entity.Books;
import com.example.library.library.managment.entity.Borrowing_Record;
import com.example.library.library.managment.services.BorrowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
@Validated
@RequiredArgsConstructor
@RestController
public class BorrowController {
    private final BorrowService  borrowService;
    @PostMapping("/api/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<Borrowing_Record>  issueBook(@PathVariable("bookId") long bookId, @PathVariable("patronId") long patronId,@Validated @RequestBody Borrowing_Record request){
        return ResponseEntity.status(HttpStatus.CREATED).body( borrowService.issueBook(bookId,patronId,request)) ;



    }


    @PutMapping("/api/borrow/{bookId}/patron/{patronId}")

      public ResponseEntity<String>  updateIssue(@PathVariable("bookId") long bookId, @PathVariable("patronId") long patronId, @RequestBody @Valid Borrowing_Record  borrowing_Record){
        if (borrowing_Record.getReturn_date() == null) {
            return ResponseEntity.badRequest().body("Return date cannot be null");
        }

        int rowsUpdated = borrowService.updateIssue(bookId,patronId, borrowing_Record);

        if (rowsUpdated > 0) {
            return ResponseEntity.ok("Return date updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record found to update");
        }

        }


}
