package com.example.library.library.managment.services;

import com.example.library.library.managment.Reposaitory.BorrowRecord_Repo;
import com.example.library.library.managment.entity.Books;
import com.example.library.library.managment.entity.Borrowing_Record;
import com.example.library.library.managment.entity.Patrons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;


@Service
@AllArgsConstructor
public class BorrowService {
  @Autowired
private  BorrowRecord_Repo  borrowRecord_Repo;
  @Autowired
private  BookService bookService;
  @Autowired
private  PatronService patronService;



    private final EntityManager entityManager;
    @Autowired
    public BorrowService(EntityManager entityManager) {
        this.entityManager = entityManager;

    }
    public BorrowService() {
        this.entityManager = null;
        this.borrowRecord_Repo = null;
        this.bookService = null;
        this.patronService = null;
    }

    public Borrowing_Record issueBook(long bookId,long partonId,Borrowing_Record request){
        Books book=bookService.getById(bookId);
        Patrons patron=patronService.getById(partonId);

        Borrowing_Record obj=new Borrowing_Record();
        obj.setBorrow_date(new Date());

        obj.setReturn_date(request.getReturn_date());
        obj.setParton(patron);
        obj.setBook(book);
      return   borrowRecord_Repo.save(obj);

    }
    @Transactional
    public int updateIssue(long bookId,long partonId,Borrowing_Record Borrowing_newRecord){
        Books book=bookService.getById(bookId);
        Patrons patron=patronService.getById(partonId);

        String sql ="UPDATE Borrowing_Record SET return_date = :newReturnDate " +
                "WHERE parton_id = :borrowId AND borrow_date = (" +
                "SELECT MAX(borrow_date) FROM Borrowing_Record WHERE parton_id = :borrowId AND book_id = :bookId)" ;


        // Create and set parameters for the query
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("newReturnDate", Borrowing_newRecord.getReturn_date());
        query.setParameter("borrowId", partonId);
        query.setParameter("bookId",bookId );

        // Execute the update query and return the number of affected rows
        return query.executeUpdate();

    }
}
