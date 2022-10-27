package com.group.syllabus.Controller;


import com.group.syllabus.Repository.DeliveryPrincipleRepository;

import com.group.syllabus.Repository.SyllabusLevelRepo;
import com.group.syllabus.Repository.SyllabusRepository;

import com.group.syllabus.Repository.SyllabusSessionRepository;
import com.group.syllabus.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class SyllabusController {
    @Autowired
    private SyllabusRepository syllabusRepository;
    @Autowired
    private SyllabusLevelRepo syllabusLevelRepo;

    @Autowired
    private SyllabusSessionRepository syllabusSessionRepository;
    @Autowired
    private DeliveryPrincipleRepository deliveryPrincipleRepository;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping ("/create")

    public Syllabus createNew(@RequestBody SyllabusDTO syllabus) {
       SyllabusLevelDTO syllabusLevel = new SyllabusLevelDTO();
        SyllabusSessionDTO syllabusSessionDTOS = new SyllabusSessionDTO();
        for(int i =0 ;i<syllabus.getSyllabusSessionDTO().size();i++){
            syllabusSessionDTOS.setSessionNo(syllabus.getSyllabusSessionDTO().get(i).getSessionNo());
            syllabusSessionDTOS.setStatus(syllabus.getSyllabusSessionDTO().get(i).getStatus());
            syllabusSessionRepository.save(modelMapper.map(syllabusSessionDTOS,SyllabusSession.class));
        }
        DeliveryPrincipleDTO deliveryPrincipleDTOS = new DeliveryPrincipleDTO();
        for(int i =0 ;i<syllabus.getDeliveryPrincipleDTO().size();i++){
            deliveryPrincipleDTOS.setContent(syllabus.getDeliveryPrincipleDTO().get(i).getContent());
            deliveryPrincipleRepository.save(modelMapper.map(deliveryPrincipleDTOS,DeliveryPrinciple.class));
        }

        syllabusLevel.setLevelName(syllabus.getSyllabusLevel().getLevelName());
       syllabus.setSyllabusLevel(syllabusLevel);
        syllabusRepository.save(modelMapper.map(syllabus,Syllabus.class));
        return syllabusRepository.save(modelMapper.map(syllabus,Syllabus.class));

    }
}
