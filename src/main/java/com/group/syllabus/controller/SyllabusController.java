package com.group.syllabus.controller;


import com.group.syllabus.dto.DeliveryPrincipleDTO;
import com.group.syllabus.dto.SyllabusDTO;
import com.group.syllabus.dto.SyllabusLevelDTO;
import com.group.syllabus.dto.SyllabusSessionDTO;
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
       SyllabusSessionDTO syllabusSession = new SyllabusSessionDTO();
       syllabusSession.setSessionNo(syllabus.getSyllabusSession().getSessionNo());
       syllabusLevel.setLevelName(syllabus.getSyllabusLevel().getLevelName());
       syllabus.setSyllabusLevel(syllabusLevel);
       syllabus.setSyllabusSession(syllabusSession);
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
        SyllabusUnit syllabusUnit = new SyllabusUnit();
        SyllabusSession syllabusSession = new SyllabusSession();
        SyllabusUnitChapter syllabusUnitChapter = new SyllabusUnitChapter();
        DeliveryType deliveryType = new DeliveryType();
//Sheet 1: Syllabus

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
        deliveryprinciple.setWaiverCriteria(worksheet1.getRow(32).getCell(4).getStringCellValue());
        deliveryprinciple.setOthers(worksheet1.getRow(33).getCell(4).getStringCellValue());
        syllabus.setDeliveryPrinciple(deliveryprinciple);

//----------------------------------------------------------------------------------------------------------------------
//Sheet 2 :Schedule
        int rows = worksheet2.getLastRowNum();
        int numMerged = worksheet2.getNumMergedRegions();
//        for(int r=2;r<rows;r++){
            for(int n=0;n<numMerged;n++){
                int firstRow = worksheet2.getMergedRegion(n).getFirstRow();
                int lastRow = worksheet2.getMergedRegion(n).getLastRow();
                int numCell = worksheet2.getMergedRegion(n).getNumberOfCells();
                syllabusUnit.setName(worksheet2.getRow(firstRow).getCell(1).getStringCellValue());
                System.out.println(numCell + "/" + lastRow + "/" + firstRow);
                for(int c=firstRow;c<=lastRow;c++){
                    syllabusUnit.setUnitNo((int) worksheet2.getRow(c).getCell(2).getNumericCellValue());
                    syllabusUnitChapter.setName(worksheet2.getRow(c).getCell(3).getStringCellValue());
                    deliveryType.setName(worksheet2.getRow(c).getCell(4).getStringCellValue());
                    syllabusUnitChapter.setDuration((int) worksheet2.getRow(c).getCell(5).getNumericCellValue());
                }
            }
            syllabusUnit.setSyllabusUnitChapter((List<SyllabusUnitChapter>) syllabusUnitChapter);
            syllabusSession.setSyllabusUnit((List<SyllabusUnit>) syllabusUnit);
            syllabus.setSyllabusSession((List<SyllabusSession>) syllabusSession);

        syllabusList.add(syllabus);
        syllabusRepo.saveAll(syllabusList);

       }


    }