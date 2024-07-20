package com.example.library.library.managment.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Patrons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Size(min=11, max=11)
    private  String phone_number;

    @Column(nullable = false)
    private  String address;

    @OneToMany(mappedBy="parton",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Borrowing_Record> record;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Role> roles;


}
