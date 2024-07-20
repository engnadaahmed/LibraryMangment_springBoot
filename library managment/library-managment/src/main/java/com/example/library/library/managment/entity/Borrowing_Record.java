package com.example.library.library.managment.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import java.util.Date;

@Entity
@Data
public class Borrowing_Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Date borrow_date;
    @Column(nullable = false)
    private Date return_date;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Books book;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patrons parton;
}
