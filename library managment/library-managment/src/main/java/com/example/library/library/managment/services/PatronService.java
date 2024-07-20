package com.example.library.library.managment.services;


import com.example.library.library.managment.Reposaitory.PartonRepo;

import com.example.library.library.managment.entity.Patrons;
import com.example.library.library.managment.exception.NOT_FOUND_ID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Service
@RequiredArgsConstructor
public class PatronService {
    private final PartonRepo partonRepo;

    public List<Patrons> allPatrons(){
        return partonRepo.findAll();
    }

    public Patrons addPatron(@Valid Patrons patrons){
        return partonRepo.save(patrons);

    }
    public Patrons getById(Long id){

        return partonRepo.findById(id).orElseThrow(()-> new NOT_FOUND_ID("not found id of patron:" + id));
    }

    public Patrons fullUpdate(Patrons patrons, long id) {


        patrons.setId(id);
        if (!partonRepo.existsById(id)) {
            throw new NOT_FOUND_ID("not found id of patron:" + id);
        }
        return partonRepo.save(patrons);

    }

    public void  deleteById(long id) {

        Patrons patrons = getById(id);
        if (patrons != null) {
            partonRepo.deleteById(id);
        }

    }

}
