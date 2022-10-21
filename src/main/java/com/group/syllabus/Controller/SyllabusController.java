package com.group.syllabus.Controller;


import com.group.syllabus.Repository.SyllabusRepository;
import com.group.syllabus.model.Syllabus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

public class SyllabusController {
    @Autowired
    private SyllabusRepository syllabusRepository;
    @PostMapping("/create")

    public Syllabus createNew(  @RequestBody Syllabus syllabus ) {
        return syllabusRepository.save(syllabus) ;

    }
}
