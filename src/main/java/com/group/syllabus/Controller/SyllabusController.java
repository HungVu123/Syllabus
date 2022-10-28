package com.group.syllabus.Controller;


import com.group.syllabus.DTO.*;
import com.group.syllabus.Repository.DeliveryPrincipleRepository;

import com.group.syllabus.Repository.SyllabusLevelRepo;
import com.group.syllabus.Repository.SyllabusRepository;

import com.group.syllabus.Repository.SyllabusSessionRepository;
import com.group.syllabus.Service.ServiceSyllabus;
import com.group.syllabus.model.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    @Autowired
    private ServiceSyllabus serviceSyllabus;
    private static final Logger LOGGER = LoggerFactory.getLogger(SyllabusController.class);
    @GetMapping ("/create")

    public ResponseEntity<?> createNew(@RequestBody SyllabusDTO syllabus) {
        LOGGER.info("Start method save in Syllabus Controller");
        String message = "";
        try {
            Syllabus syllabus1 = serviceSyllabus.CreateSyllabus(syllabus);
            LOGGER.info(message);
            ResponseObject response = new ResponseObject("OK", message, null, syllabus1);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            message = "Couldn't Create Syllabus" ;
            ErrorResponse error = new ErrorResponse(new Date(), "ERROR", message);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(error);
        }
    }
}
