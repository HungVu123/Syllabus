package com.group.syllabus.Service;

import com.group.syllabus.dto.*;
import com.group.syllabus.model.*;
import com.group.syllabus.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    @Autowired
    private DeliveryTypeRepository deliveryTypeRepository;

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


//            || SET SYLLABUS UNIT DATA ||
        for (int i = 0; i <= syllabusDay.getSyllabusUnits().size() - 1; i++) {
            SyllabusUnit syllabusUnit = syllabusDay.getSyllabusUnits().get(i);
            syllabusUnit.setSyllabusDay(syllabusDay);
            syllabusUnit.setUnitNo(syllabusDay.getSyllabusUnits().get(i).getUnitNo());
            syllabusUnit.setName(syllabusDay.getSyllabusUnits().get(i).getName());
            syllabusUnit.setDuration(syllabusDay.getSyllabusUnits().get(i).getDuration());
            syllabusUnit.setSyllabusUnitChapters(syllabusDay.getSyllabusUnits().get(i).getSyllabusUnitChapters());
            syllabusUnitRepository.save(syllabusUnit);

//            || SET SYLLABUS UNIT CHAPTER DATA ||
            for (int j = 0; j <= syllabusUnit.getSyllabusUnitChapters().size() - 1; j ++){
                SyllabusUnitChapter syllabusUnitChapter = syllabusUnit.getSyllabusUnitChapters().get(j);

                UUID id = syllabusUnit.getSyllabusUnitChapters().get(j).getDeliveryType().getId();
                DeliveryType deliveryType = getDeliveryTypeById(id);

                syllabusUnitChapter.setSyllabusUnit(syllabusUnit);
                syllabusUnitChapter.setDeliveryType(deliveryType);
//                syllabusUnitChapter.setOutputStandard();

                syllabusUnitChapter.setName(syllabusUnit.getSyllabusUnitChapters().get(j).getName());
                syllabusUnitChapter.setDuration(syllabusUnit.getSyllabusUnitChapters().get(j).getDuration());
                syllabusUnitChapter.setMaterials(syllabusUnit.getSyllabusUnitChapters().get(j).getMaterials());
                syllabusUnitChapter.setSyllabusUnit(syllabusUnit.getSyllabusUnitChapters().get(j).getSyllabusUnit());

                syllabusUnitChapter.setOnline(syllabusUnit.getSyllabusUnitChapters().get(j).isOnline());
                syllabusUnitChapterRepository.save(syllabusUnitChapter);
            }
        }

        syllabusDayWithId = syllabusDayRepository.save(syllabusDay);
        result = modelMapper.map(syllabusDayWithId, SyllabusDayDTO.class);
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

    public DeliveryType getDeliveryTypeById(UUID id){
        return deliveryTypeRepository.findById(id).get();
    }
}
