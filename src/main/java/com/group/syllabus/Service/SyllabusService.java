package com.group.syllabus.Service;

import com.group.syllabus.dto.*;
import com.group.syllabus.model.*;
import com.group.syllabus.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyllabusService {
    @Autowired
    private SyllabusRepository syllabusRepository;
    @Autowired
    private com.group.syllabus.repository.SyllabusDayRepository syllabusDayRepository;
    @Autowired
    private DeliveryPrincipleRepository deliveryPrincipleRepository;
    @Autowired
    private SyllabusUnitRepository syllabusUnitRepository;
    @Autowired
    private SyllabusUnitChapterRepository syllabusUnitChapterRepository;
    @Autowired
    private AssessmentSchemeRepository assessmentSchemeRepository;
    @Autowired
    private ModelMapper modelMapper;

//    public SyllabusUnitDTO createSyllabusUnit(SyllabusDay syllabusDay, SyllabusUnit syllabusUnit){
//        SyllabusUnit syllabusUnitWithId;
//        SyllabusUnitDTO result;
//        syllabusUnit.setSyllabusDay(syllabusDay);
//        syllabusUnitWithId = syllabusUnitRepository.save(syllabusUnit);
//        result = modelMapper.map(syllabusUnitWithId, SyllabusUnitDTO.class);
//        return result;
//    }

//    public void createSyllabusUnit2(Syllabus syllabus, SyllabusUnit syllabusUnit){
//        SyllabusUnit syllabusUnitWithId;
//        SyllabusUnitDTO result;
//        for(int i = 0; i <= syllabus.getSyllabusDays().size() - 1; i++) {
//            syllabusUnit.setSyllabusDay(syllabus.getSyllabusDays().get(i));
//            syllabusUnitRepository.save(syllabusUnit);
//        }
////        syllabusUnitWithId = syllabusUnitRepository.save(syllabusUnit);
////        result = modelMapper.map(syllabusUnitWithId, SyllabusUnitDTO.class);
//    }

    public SyllabusUnitChapterDTO createSyllabusUnitChapter(SyllabusUnit syllabusUnit, SyllabusUnitChapter syllabusUnitChapter){
        SyllabusUnitChapter syllabusUnitChapterWithId;
        SyllabusUnitChapterDTO result;
        syllabusUnitChapter.setSyllabusUnit(syllabusUnit);
        syllabusUnitChapterWithId = syllabusUnitChapterRepository.save(syllabusUnitChapter);
        result = modelMapper.map(syllabusUnitChapterWithId, SyllabusUnitChapterDTO.class);
        return result;
    }

    public SyllabusUnitDTO createSyllabusUnit(SyllabusDay syllabusDay, SyllabusUnit syllabusUnit){
        SyllabusUnit syllabusUnitWithId;
        SyllabusUnitDTO result;
        // PROBLEM
        syllabusUnit.setSyllabusDay(syllabusDay);
        syllabusUnitWithId = syllabusUnitRepository.save(syllabusUnit);

        for (int i = 0; i <= syllabusUnitWithId.getSyllabusUnitChapters().size() - 1; i++) {
            createSyllabusUnitChapter(syllabusUnitWithId, syllabusUnitWithId.getSyllabusUnitChapters().get(i));
        }

        result = modelMapper.map(syllabusUnitWithId, SyllabusUnitDTO.class);
        return result;
    }

    public SyllabusDayDTO createSyllabusDay(Syllabus syllabus, SyllabusDay syllabusDay){
        SyllabusDay syllabusDayWithId;
        SyllabusDayDTO result;
        syllabusDay.setSyllabus(syllabus);
        syllabusDayWithId = syllabusDayRepository.save(syllabusDay);

//            || SET SYLLABUS DAY ID ||
        for (int i = 0; i <= syllabusDayWithId.getSyllabusUnits().size() - 1; i++) {
            createSyllabusUnit(syllabusDayWithId, syllabusDayWithId.getSyllabusUnits().get(i));
        }

        result = modelMapper.map(syllabusDayWithId, SyllabusDayDTO.class);
        return result;
    }

    public SyllabusDTO createSyllabus(SyllabusDTO syllabusDTO){
        Syllabus syllabus, syllabusWithId;
        SyllabusDTO result;
        syllabus = modelMapper.map(syllabusDTO, Syllabus.class);
        syllabusWithId = syllabusRepository.save(syllabus);

//            || SET SYLLABUS ID TO SYLLABUS DAY ||
        for (int i = 0; i <= syllabusWithId.getSyllabusDays().size() - 1; i++) {
            createSyllabusDay(syllabusWithId, syllabusWithId.getSyllabusDays().get(i));
        }

//            || SET SYLLABUS ID TO ASSESSMENT SCHEME ||
        createAssessmentScheme(syllabusWithId, syllabusWithId.getAssessmentScheme());

//            || SET SYLLABUS ID TO DELIVERY PRINCIPLE ||
        createDeliveryPrinciple(syllabusWithId, syllabusWithId.getDeliveryPrinciple());
        result = modelMapper.map(syllabusWithId, SyllabusDTO.class);
        return result;
    }


    public AssessmentSchemeDTO createAssessmentScheme(Syllabus syllabus, AssessmentScheme assessmentScheme){
        AssessmentScheme assessmentSchemeWithId;
        AssessmentSchemeDTO result;
        assessmentScheme.setSyllabus(syllabus);
        assessmentSchemeWithId = assessmentSchemeRepository.save(assessmentScheme);
        result = modelMapper.map(assessmentSchemeWithId, AssessmentSchemeDTO.class);
        return result;
    }

    public DeliveryPrincipleDTO createDeliveryPrinciple(Syllabus syllabus, DeliveryPrinciple deliveryPrinciple){
        DeliveryPrinciple deliveryPrincipleWithId;
        DeliveryPrincipleDTO result;
        deliveryPrinciple.setSyllabus(syllabus);
        deliveryPrincipleWithId = deliveryPrincipleRepository.save(deliveryPrinciple);
        result = modelMapper.map(deliveryPrincipleWithId, DeliveryPrincipleDTO.class);
        return result;
    }




//    public SyllabusDTO CreateSyllabus(Syllabus syllabus){
//        SyllabusDTO result;
//        Syllabus syllabus1;
//
//        syllabus1 = new Syllabus(
//                null, syllabus.getName(), syllabus.getCode(), syllabus.getVersion(), syllabus.getAttendeeNumber(),
//                syllabus.getTechnicalRequirement(), syllabus.getCourseObjective(), syllabus.getDays(), syllabus.getHours(), syllabus.getStatus(),
//                syllabus.isTemplate(), syllabus.getCreatedBy(), syllabus.getCreatedDate(), syllabus.getUpdatedBy(), syllabus.getUpdatedDate(),
//                syllabus.getAssessmentScheme(), syllabus.getSyllabusLevel(), syllabus.getSyllabusDays(), syllabus.getDeliveryPrinciple()
//        );
//
//        SyllabusDay syllabusDay = new SyllabusDay();
//        syllabusDay.setSyllabus(syllabus1);
//
////        SyllabusUnit syllabusUnit = new SyllabusUnit();
////        syllabusUnit.setSyllabus(syllabus1);
//
//
//        Syllabus syllabus2 = syllabusRepository.save(syllabus1);
////        CreateSyllabusDay(syllabus2, syllabus2.getSyllabusDays());
////        syllabusUnitRepository.saveAndFlush(syllabusUnit);
//
//        result = modelMapper.map(syllabus2, SyllabusDTO.class);
//        return result;
//    }
//
//    public AssessmentSchemeDTO CreateAssessmentScheme(AssessmentScheme assessmentScheme){
//        AssessmentSchemeDTO result;
//        AssessmentScheme assessmentScheme1;
//        assessmentScheme1 = new AssessmentScheme(null, assessmentScheme.getAssignment(), assessmentScheme.getQuiz(),
//                assessmentScheme.getExam(), assessmentScheme.getGpa(), assessmentScheme.getFinalPoint(),
//                assessmentScheme.getFinalTheory(), assessmentScheme.getFinalPractice(), assessmentScheme.getSyllabus()
//        );
//        assessmentSchemeRepository.saveAndFlush(assessmentScheme1);
//        result = modelMapper.map(assessmentScheme1, AssessmentSchemeDTO.class);
//        return result;
//    }
//
//    public SyllabusDayDTO CreateSyllabusDay(Syllabus syllabus, SyllabusDay syllabusDay){
//        SyllabusDayDTO result;
//        SyllabusDay syllabusDay1;
//
//        syllabusDay1 = new SyllabusDay(null, syllabusDay.getDayNo(), syllabusDay.getStatus(), syllabus, syllabusDay.getSyllabusUnits());
//
//        syllabusDayRepository.saveAndFlush(syllabusDay);
//
//        result = modelMapper.map(syllabusDay1, SyllabusDayDTO.class);
//        return result;
//    }

//    public Syllabus CreateSyllabus(Syllabus syllabus) {
//        try {
//
//
//            SyllabusDay syllabusDay = new SyllabusDay();
//            SyllabusUnit syllabusUnit = new SyllabusUnit();
//            SyllabusUnitChapter syllabusUnitChapter = new SyllabusUnitChapter();
//            OutputStandard outputStandard = new OutputStandard();
//
//            for (int i = 0; i < syllabus.getSyllabusDays().size(); i++) {
//                syllabusDay.setDayNo(syllabus.getSyllabusDays().get(i).getDayNo());
//                syllabusDay.setStatus(syllabus.getSyllabusDays().get(i).getStatus());
//                syllabusDayRepository.save(modelMapper.map(syllabusDay, SyllabusDay.class));
//
//                for (int j = 0; j < syllabus.getSyllabusDays().get(i).getSyllabusUnits().size(); i++) {
//                    syllabusUnit.setName(syllabus.getSyllabusUnits().get(j).getName());
//                    syllabusUnit.setUnitNo(syllabus.getSyllabusUnits().get(j).getUnitNo());
//                    syllabusUnit.setDuration(syllabus.getSyllabusUnits().get(j).getDuration());
//                    syllabusUnitRepository.save(modelMapper.map(syllabusUnit, SyllabusUnit.class));
//
//                    for (int k = 0; k < syllabus.getSyllabusDays().get(j).getSyllabusUnits().get(j).getSyllabusUnitChapters().size(); i++) {
//                        syllabusUnitChapter.setName(syllabusUnit.getSyllabusUnitChapters().get(k).getName());
//                        syllabusUnitChapter.setDuration(syllabusUnit.getSyllabusUnitChapters().get(k).getDuration());
//                        syllabusUnitChapter.setOnline(syllabusUnit.getSyllabusUnitChapters().get(k).isOnline());
//                        syllabusUnitChapterRepository.save(modelMapper.map(syllabusUnitChapter, SyllabusUnitChapter.class));
//
//                        /// "outputStandard":
//                        syllabusUnitChapter.setOutputStandard(outputStandard);
//
//                        ///"deliveryType":
//
//                        ///"material":
//
//                    }
//                }
//            }
//
//            DeliveryPrinciple deliveryPrinciple = new DeliveryPrinciple();
//            deliveryPrinciple.setTrainees(syllabus.getDeliveryPrinciple().getTrainees());
//            deliveryPrinciple.setTrainer(syllabus.getDeliveryPrinciple().getTrainer());
//            deliveryPrinciple.setTraining(syllabus.getDeliveryPrinciple().getTraining());
//            deliveryPrinciple.setRe_test(syllabus.getDeliveryPrinciple().getRe_test());
//            deliveryPrinciple.setMarking(syllabus.getDeliveryPrinciple().getMarking());
//            deliveryPrinciple.setWaiverCriteria(syllabus.getDeliveryPrinciple().getWaiverCriteria());
//            deliveryPrinciple.setOthers(syllabus.getDeliveryPrinciple().getOthers());
//            deliveryPrincipleRepository.save(modelMapper.map(deliveryPrinciple, DeliveryPrinciple.class));
//
//            SyllabusLevel syllabusLevel = new SyllabusLevel();
//            syllabusLevel.setName(syllabus.getSyllabusLevel().getName());
//            syllabus.setSyllabusLevel(syllabusLevel);
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return syllabusRepository.save(modelMapper.map(syllabus, Syllabus.class));
//    }

//    public Syllabus CreateSyllabus(SyllabusDTO syllabus) {
//        try {
//            SyllabusDayDTO syllabusDayDTOS = new SyllabusDayDTO();
//            SyllabusUnitDTO syllabusUnitDTO = new SyllabusUnitDTO();
//            SyllabusUnitChapterDTO syllabusUnitChapterDTO = new SyllabusUnitChapterDTO();
//            for (int i = 0; i < syllabus.getSyllabusDayDTO().size(); i++) {
//                syllabusDayDTOS.setDayNo(syllabus.getSyllabusDayDTO().get(i).getDayNo());
//                syllabusDayDTOS.setStatus(syllabus.getSyllabusDayDTO().get(i).getStatus());
//                syllabusDayRepository.save(modelMapper.map(syllabusDayDTOS, SyllabusDay.class));
//                for (int j = 0; j < syllabus.getSyllabusDayDTO().get(i).getSyllabusUnit().size(); i++) {
//                    syllabusDayDTOS.setDayNo(syllabus.getSyllabusDayDTO().get(j).getDayNo());
//                    syllabusDayDTOS.setStatus(syllabus.getSyllabusDayDTO().get(j).getStatus());
//                    syllabusDayRepository.save(modelMapper.map(syllabusDayDTOS, SyllabusDay.class));
//                    for (int k = 0; k < syllabus.getSyllabusDayDTO().get(j).getSyllabusUnit().get(j).getSyllabusUnitChapter().size(); i++) {
//                        syllabusDayDTOS.setDayNo(syllabus.getSyllabusDayDTO().get(k).getDayNo());
//                        syllabusDayDTOS.setStatus(syllabus.getSyllabusDayDTO().get(k).getStatus());
//                        syllabusDayRepository.save(modelMapper.map(syllabusDayDTOS, SyllabusDay.class));
//
//                        /// "outputStandard":
//
//                        ///"deliveryType":
//
//                        ///"material":
//
//                    }
//                }
//            }
//
//            DeliveryPrincipleDTO deliveryPrincipleDTOS = new DeliveryPrincipleDTO();
//            for (int i = 0; i < syllabus.getDeliveryPrincipleDTO().size(); i++) {
//                deliveryPrincipleDTOS.setContent(syllabus.getDeliveryPrincipleDTO().get(i).getContent());
//                deliveryPrincipleRepository.save(modelMapper.map(deliveryPrincipleDTOS, DeliveryPrinciple.class));
//            }
//            SyllabusLevelDTO syllabusLevel = new SyllabusLevelDTO();
//            syllabusLevel.setLevelName(syllabus.getSyllabusLevel().getLevelName());
//            syllabus.setSyllabusLevel(syllabusLevel);
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return syllabusRepository.save(modelMapper.map(syllabus, Syllabus.class));
//    }

}
