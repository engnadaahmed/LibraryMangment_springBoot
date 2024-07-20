package com.example.library.library.managment.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String role;
    @ManyToMany(mappedBy = "roles")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Patrons> users;



}
