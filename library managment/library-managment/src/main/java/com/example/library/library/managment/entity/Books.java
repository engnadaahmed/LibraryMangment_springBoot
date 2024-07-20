package com.example.library.library.managment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.Set;

@Entity
@Data
@Table(name = "Books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private  String title;
    @Column(nullable = false)
    private  String author;
    @Column(nullable = false)
    private String ISBN;
    @Column(nullable = false)
    private  Integer publication_year;
    @OneToMany(mappedBy="book",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Borrowing_Record> record;


}
