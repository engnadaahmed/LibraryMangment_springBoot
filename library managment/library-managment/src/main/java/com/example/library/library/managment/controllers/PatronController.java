package com.example.library.library.managment.controllers;


import com.example.library.library.managment.entity.Patrons;

import com.example.library.library.managment.services.PatronService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api/patrons")
public class PatronController {
    private  final PatronService patronService;


    @GetMapping
    public ResponseEntity<List<Patrons>> allPatrons(){
        return ResponseEntity.ok(patronService.allPatrons()) ;


    }

    @PostMapping("/add")
    public ResponseEntity<Patrons> addPatron(@Validated @RequestBody Patrons patrons){
        return ResponseEntity.status(HttpStatus.CREATED).body( patronService.addPatron(patrons)) ;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Patrons> getById(@PathVariable("id") Long id ){

        return ResponseEntity.ok(patronService.getById(id));


    }
    @PutMapping("/{id}")
    public ResponseEntity<Patrons>  fullyUpdate(@RequestBody Patrons patrons, @PathVariable("id") long id){
        return ResponseEntity.ok(patronService.fullUpdate(patrons, id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id ){
        patronService.deleteById(id);
        return ResponseEntity.ok().build();



    }


}
