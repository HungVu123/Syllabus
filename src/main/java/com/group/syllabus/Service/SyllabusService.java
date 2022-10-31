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

    public SyllabusDayDTO createSyllabusDay(Syllabus syllabus, SyllabusDay syllabusDay){
        SyllabusDay syllabusDayWithId;
        SyllabusDayDTO result;
        syllabusDay.setSyllabus(syllabus);

//            || SET SYLLABUS DAY ID AND SYLLABUS UNIT DATA ||
        for (int i = 0; i <= syllabusDay.getSyllabusUnits().size() - 1; i++) {
            SyllabusUnit syllabusUnit = syllabusDay.getSyllabusUnits().get(i);
            syllabusUnit.setSyllabusDay(syllabusDay);
            syllabusUnit.setUnitNo(syllabusDay.getSyllabusUnits().get(i).getUnitNo());
            syllabusUnit.setName(syllabusDay.getSyllabusUnits().get(i).getName());
            syllabusUnit.setDuration(syllabusDay.getSyllabusUnits().get(i).getDuration());
            syllabusUnit.setSyllabusUnitChapters(syllabusDay.getSyllabusUnits().get(i).getSyllabusUnitChapters());
            syllabusUnitRepository.save(syllabusUnit);

            for (int j = 0; j <= syllabusUnit.getSyllabusUnitChapters().size() - 1; j ++){
                SyllabusUnitChapter syllabusUnitChapter = syllabusUnit.getSyllabusUnitChapters().get(j);
                syllabusUnitChapter.setSyllabusUnit(syllabusUnit);
                syllabusUnitChapter.setName(syllabusUnit.getSyllabusUnitChapters().get(j).getName());
                syllabusUnitChapter.setDuration(syllabusUnit.getSyllabusUnitChapters().get(j).getDuration());
                syllabusUnitChapter.setMaterials(syllabusUnit.getSyllabusUnitChapters().get(j).getMaterials());
                syllabusUnitChapter.setSyllabusUnit(syllabusUnit.getSyllabusUnitChapters().get(j).getSyllabusUnit());
                syllabusUnitChapter.setOutputStandard(syllabusUnit.getSyllabusUnitChapters().get(j).getOutputStandard());
                syllabusUnitChapter.setDeliveryType(syllabusUnit.getSyllabusUnitChapters().get(j).getDeliveryType());
                syllabusUnitChapter.setOnline(syllabusUnit.getSyllabusUnitChapters().get(j).isOnline());
                syllabusUnitChapterRepository.save(syllabusUnitChapter);
            }
        }

        syllabusDayWithId = syllabusDayRepository.save(syllabusDay);

        result = modelMapper.map(syllabusDayWithId, SyllabusDayDTO.class);
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


    public SyllabusUnitChapterDTO createSyllabusUnitChapter(SyllabusUnit syllabusUnit, SyllabusUnitChapter syllabusUnitChapter){
        SyllabusUnitChapter syllabusUnitChapterWithId;
        SyllabusUnitChapterDTO result;
        syllabusUnitChapter.setSyllabusUnit(syllabusUnit);
        syllabusUnitChapterWithId = syllabusUnitChapterRepository.save(syllabusUnitChapter);
        result = modelMapper.map(syllabusUnitChapterWithId, SyllabusUnitChapterDTO.class);
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
}
