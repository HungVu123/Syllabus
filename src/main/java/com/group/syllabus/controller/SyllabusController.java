package com.group.syllabus.controller;


import com.group.syllabus.dto.*;
import com.group.syllabus.repository.DeliveryPrincipleRepository;

import com.group.syllabus.repository.*;
import com.group.syllabus.Service.SyllabusService;
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
    private SyllabusLevelRepository syllabusLevelRepo;

    @Autowired
    private SyllabusDayRepository syllabusSessionRepository;
    @Autowired
    private DeliveryPrincipleRepository deliveryPrincipleRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SyllabusService syllabusService;
    private static final Logger LOGGER = LoggerFactory.getLogger(SyllabusController.class);
    @PostMapping ("/create")

    public ResponseEntity<?> createNew(@RequestBody SyllabusDTO syllabusDTO) {
        LOGGER.info("Start method save in Syllabus Controller");
        String message = "";
        try {
            Syllabus syllabus = syllabusService.createSyllabus(syllabusDTO);
            LOGGER.info(message);
            ResponseObject response = new ResponseObject("OK", message, null, syllabus);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            message = "Couldn't Create Syllabus" ;
            ErrorResponse error = new ErrorResponse(new Date(), "ERROR", e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(error);
        }
    }
}