package com.example.library.library.managment.Reposaitory;

import com.example.library.library.managment.entity.Patrons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartonRepo extends JpaRepository<Patrons,Long> {
}
