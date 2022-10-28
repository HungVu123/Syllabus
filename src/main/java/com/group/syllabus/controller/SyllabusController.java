package com.group.syllabus.controller;


import com.group.syllabus.dto.DeliveryPrincipleDTO;
import com.group.syllabus.dto.SyllabusDTO;
import com.group.syllabus.dto.SyllabusLevelDTO;
import com.group.syllabus.repository.SyllabusLevelRepo;
import com.group.syllabus.repository.SyllabusRepo;

import com.group.syllabus.model.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class SyllabusController {
    @Autowired
    private SyllabusRepo syllabusRepo;
    @Autowired
    private SyllabusLevelRepo syllabusLevelRepo;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping ("/create")
    public Syllabus createNew(@RequestBody SyllabusDTO syllabus) {
       SyllabusLevelDTO syllabusLevel = new SyllabusLevelDTO();
       syllabusLevel.setLevelName(syllabus.getSyllabusLevel().getLevelName());
       syllabus.setSyllabusLevel(syllabusLevel);
       return syllabusRepo.save(modelMapper.map(syllabus,Syllabus.class));
    }

    @PostMapping("/import")
    public void mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {

        List<Syllabus> syllabusList = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
        XSSFSheet worksheet1 = workbook.getSheetAt(0);
        XSSFSheet worksheet2 = workbook.getSheetAt(1);

        Syllabus syllabus = new Syllabus();
        DeliveryPrinciple deliveryprinciple = new DeliveryPrinciple();

//  1.Topic Name
        syllabus.setName(worksheet1.getRow(2).getCell(3).getStringCellValue());

//  2.Topic Code
        syllabus.setCode(worksheet1.getRow(3).getCell(3).getStringCellValue());

//  3.Version
        syllabus.setVersion(worksheet1.getRow(4).getCell(3).getNumericCellValue());

//  5.Objectives
        syllabus.setCourseObj(worksheet1.getRow(6).getCell(3).getStringCellValue()+
                "\n"+ worksheet1.getRow(11).getCell(3).getStringCellValue());

//  6.Topic Outline
//        syllabus.setCode(worksheet1.getRow(12).getCell(3).getStringCellValue());

//  8.Training Materials & Environments Technical requirements
        syllabus.setTechReq(worksheet1.getRow(22).getCell(4).getStringCellValue());

//  9.Assessment Scheme
//        for(int i=23;i<27;i++){
//            for(int j=3;j<7;j++){
//                System.out.println(worksheet1.getRow(i).getCell(j));
//            }
//        }

//  10.Training Delivery Principles
        deliveryprinciple.setTrainees(worksheet1.getRow(27).getCell(4).getStringCellValue());
        deliveryprinciple.setTrainer(worksheet1.getRow(28).getCell(4).getStringCellValue());
        deliveryprinciple.setTraining(worksheet1.getRow(29).getCell(4).getStringCellValue());
        deliveryprinciple.setRe_test(worksheet1.getRow(30).getCell(4).getStringCellValue());
        deliveryprinciple.setMarking(worksheet1.getRow(31).getCell(4).getStringCellValue());
        deliveryprinciple.setWaivercriteria(worksheet1.getRow(32).getCell(4).getStringCellValue());
        deliveryprinciple.setOthers(worksheet1.getRow(33).getCell(4).getStringCellValue());
        syllabus.setDeliveryPrinciple(deliveryprinciple);

        syllabusList.add(syllabus);
        syllabusRepo.saveAll(syllabusList);
    }

}
