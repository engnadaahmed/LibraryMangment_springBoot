package com.example.library.library.managment.Reposaitory;

import com.example.library.library.managment.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Books,Long> {
}
