package com.group.syllabus.Controller;


import com.group.syllabus.Repository.SyllabusLevelRepo;
import com.group.syllabus.Repository.SyllabusRepository;

import com.group.syllabus.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class SyllabusController {
    @Autowired
    private SyllabusRepository syllabusRepository;
    @Autowired
    private SyllabusLevelRepo syllabusLevelRepo;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping ("/create")

    public Syllabus createNew(@RequestBody SyllabusDTO syllabus) {
       SyllabusLevelDTO syllabusLevel = new SyllabusLevelDTO();
        syllabusLevel.setLevelName(syllabus.getSyllabusLevel().getLevelName());
       syllabus.setSyllabusLevel(syllabusLevel);
        modelMapper.map(syllabus,Syllabus.class);
        return syllabusRepository.saveAndFlush(modelMapper.map(syllabus,Syllabus.class));

    }
}
