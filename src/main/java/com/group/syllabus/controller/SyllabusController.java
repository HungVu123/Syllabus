package com.group.syllabus.controller;


import com.group.syllabus.dto.DeliveryPrincipleDTO;
import com.group.syllabus.dto.SyllabusDTO;
import com.group.syllabus.dto.SyllabusLevelDTO;
import com.group.syllabus.dto.SyllabusSessionDTO;
import com.group.syllabus.repository.*;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/")
public class SyllabusController {
    @Autowired
    private AssessmentSchemeRepo assessmentSchemeRepo;
    @Autowired
    private DeliveryPrincipleRepo deliveryPrincipleRepo;
    @Autowired
    private DeliveryTypeRepo deliveryTypeRepo;
    @Autowired
    private MaterialRepo materialRepo;
    @Autowired
    private OutputStandardRepo outputStandardRepo;
    @Autowired
    private SyllabusDayRepo syllabusDayRepo;
    @Autowired
    private SyllabusLevelRepo syllabusLevelRepo;
    @Autowired
    private SyllabusRepo syllabusRepo;
    @Autowired
    private SyllabusUnitChapterRepo syllabusUnitChapterRepo;
    @Autowired
    private SyllabusUnitRepo syllabusUnitRepo;
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
    public void mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile,@RequestParam("checkbox") List<String> checkbox,
                                     @RequestParam("radio") String radio) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
        XSSFSheet worksheet1 = workbook.getSheetAt(0);
        XSSFSheet worksheet2 = workbook.getSheetAt(1);

        Syllabus syllabus = new Syllabus();
        DeliveryPrinciple deliveryprinciple = new DeliveryPrinciple();
        AssessmentScheme assessmentScheme = new AssessmentScheme();
        SyllabusDay syllabusDay = new SyllabusDay();

        syllabus.setDays(Integer.parseInt(String.valueOf(worksheet1.getRow(13).getCell(6).getStringCellValue().charAt(0))));
        syllabus.setName(worksheet1.getRow(2).getCell(3).getStringCellValue());
        syllabus.setCode(worksheet1.getRow(3).getCell(3).getStringCellValue());
        syllabus.setVersion(worksheet1.getRow(4).getCell(3).getStringCellValue());
        syllabus.setCourseObjective(worksheet1.getRow(6).getCell(3).getStringCellValue()+
                "\n"+ worksheet1.getRow(11).getCell(3).getStringCellValue());
        syllabus.setTechnicalRequirement(worksheet1.getRow(22).getCell(4).getStringCellValue());
        syllabus.setHours((int) worksheet2.getRow(37).getCell(5).getNumericCellValue());
        syllabus.setAssessmentScheme(assessmentScheme);
        syllabus.setDeliveryPrinciple(deliveryprinciple);

        boolean dupe = true;
        if(checkbox.size() == 1 ){
            if(checkbox.get(0).equals("code")){
                //name
                if (syllabusRepo.findAllByCode(syllabus.getCode()).isEmpty()){
                    Syllabus savedSyllabus = syllabusRepo.save(syllabus);
                    assessmentScheme.setSyllabus(savedSyllabus);
                    deliveryprinciple.setSyllabus(savedSyllabus);
                    syllabusDay.setSyllabus(savedSyllabus);
                    dupe = false;
                }
            } else {
                if (syllabusRepo.findAllByName(syllabus.getName()).isEmpty()){
                    Syllabus savedSyllabus = syllabusRepo.save(syllabus);
                    assessmentScheme.setSyllabus(savedSyllabus);
                    deliveryprinciple.setSyllabus(savedSyllabus);
                    syllabusDay.setSyllabus(savedSyllabus);
                    dupe = false;
                }
            }
        } else {
            //ca 2
            if (syllabusRepo.findAllByName(syllabus.getName()).isEmpty()){
                if (syllabusRepo.findAllByCode(syllabus.getCode()).isEmpty()){
                    Syllabus savedSyllabus = syllabusRepo.save(syllabus);
                    assessmentScheme.setSyllabus(savedSyllabus);
                    deliveryprinciple.setSyllabus(savedSyllabus);
                    syllabusDay.setSyllabus(savedSyllabus);
                    dupe = false;
                }
            }
        }
        if (dupe) {
            if(radio.equals("allow")){
                Syllabus savedSyllabus = syllabusRepo.save(syllabus);
                assessmentScheme.setSyllabus(savedSyllabus);
                deliveryprinciple.setSyllabus(savedSyllabus);
                syllabusDay.setSyllabus(savedSyllabus);
            }else if(radio.equals("replace")){
                if(checkbox.size() == 1 ){
                    if(checkbox.get(0).equals("code")){

                        for ( Syllabus asylabus : syllabusRepo.findAllByCode(syllabus.getCode())){
                            syllabusRepo.deleteById(asylabus.getId());
                        }
                        Syllabus savedSyllabus = syllabusRepo.save(syllabus);
                        assessmentScheme.setSyllabus(savedSyllabus);
                        deliveryprinciple.setSyllabus(savedSyllabus);
                        syllabusDay.setSyllabus(savedSyllabus);
                    } else {
                        for (  Syllabus asylabus : syllabusRepo.findAllByName(syllabus.getName())){
                            syllabusRepo.deleteById(asylabus.getId());
                        }
                        Syllabus savedSyllabus = syllabusRepo.save(syllabus);
                        assessmentScheme.setSyllabus(savedSyllabus);
                        deliveryprinciple.setSyllabus(savedSyllabus);
                        syllabusDay.setSyllabus(savedSyllabus);
                    }
                } else {
                    //ca 2
                    for ( Syllabus asylabus : syllabusRepo.findAllByCode(syllabus.getCode())){
                        syllabusRepo.deleteById(asylabus.getId());
                    }
                    for ( Syllabus asylabus : syllabusRepo.findAllByName(syllabus.getName())){
                        syllabusRepo.deleteById(asylabus.getId());
                    }
                    Syllabus savedSyllabus = syllabusRepo.save(syllabus);
                    assessmentScheme.setSyllabus(savedSyllabus);
                    deliveryprinciple.setSyllabus(savedSyllabus);
                    syllabusDay.setSyllabus(savedSyllabus);
                }
            }
        }

//  9.Assessment Scheme
        assessmentScheme.setQuiz(worksheet1.getRow(23).getCell(4).getNumericCellValue());
        assessmentScheme.setAssignment(worksheet1.getRow(24).getCell(4).getNumericCellValue());
        assessmentScheme.setFinal_theory(worksheet1.getRow(25).getCell(4).getNumericCellValue());
        assessmentScheme.setFinal_practice(worksheet1.getRow(26).getCell(4).getNumericCellValue());
        assessmentScheme.setGpa(worksheet1.getRow(27).getCell(4).getNumericCellValue());

//  10.Training Delivery Principles
        deliveryprinciple.setTrainees(worksheet1.getRow(28).getCell(4).getStringCellValue());
        deliveryprinciple.setTrainer(worksheet1.getRow(29).getCell(4).getStringCellValue());
        deliveryprinciple.setTraining(worksheet1.getRow(30).getCell(4).getStringCellValue());
        deliveryprinciple.setRe_test(worksheet1.getRow(31).getCell(4).getStringCellValue());
        deliveryprinciple.setMarking(worksheet1.getRow(32).getCell(4).getStringCellValue());
        deliveryprinciple.setWaiverCriteria(worksheet1.getRow(33).getCell(4).getStringCellValue());
        deliveryprinciple.setOthers(worksheet1.getRow(34).getCell(4).getStringCellValue());

        SyllabusDay savedSyllabusDay = syllabusDayRepo.save(syllabusDay);

//----------------------------------------------------------------------------------------------------------------------
//Sheet 2 :Schedule
        int numMerged = worksheet2.getNumMergedRegions() ;
            for(int n=0;n<numMerged;n++){

                SyllabusUnit syllabusUnit = new SyllabusUnit();

                int firstRow = worksheet2.getMergedRegion(n).getFirstRow();
                int lastRow = worksheet2.getMergedRegion(n).getLastRow();
                syllabusUnit.setName(worksheet2.getRow(firstRow).getCell(1).getStringCellValue());
                syllabusUnit.setUnitNo((int) worksheet2.getRow(firstRow).getCell(2).getNumericCellValue());
                syllabusUnit.setSyllabusDay(savedSyllabusDay);

                double sum = 0;
                for(int c=firstRow;c<=lastRow;c++){
                    sum = sum + worksheet2.getRow(c).getCell(5).getNumericCellValue();

                    SyllabusUnitChapter syllabusUnitChapter = new SyllabusUnitChapter();
                    DeliveryType deliveryType = new DeliveryType();
                    Material material = new Material();

                    syllabusUnitChapter.setName(worksheet2.getRow(c).getCell(3).getStringCellValue());
                    deliveryType.setName(worksheet2.getRow(c).getCell(4).getStringCellValue());
                    syllabusUnitChapter.setDuration(worksheet2.getRow(c).getCell(5).getNumericCellValue());
                    deliveryType.setDescription(worksheet2.getRow(c).getCell(6).getStringCellValue());
                    
                    syllabusUnitChapter.setDeliveryType(deliveryType);
                    syllabusUnitChapter.setSyllabusUnit(syllabusUnit);
                    syllabusUnitChapter.setMaterial(material);
                    syllabusUnitChapterRepo.save(syllabusUnitChapter);
                }
                syllabusUnit.setDuration((int) sum);
                syllabusUnitRepo.save(syllabusUnit);
            }
       }
    }
