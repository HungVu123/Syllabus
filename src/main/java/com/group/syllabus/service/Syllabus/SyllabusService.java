package com.group.syllabus.service.Syllabus;

import com.group.syllabus.Dto.SyllabusDto;
import com.group.syllabus.Repository.OutputStandardRepository;
import com.group.syllabus.Repository.SyllabusRepository;
import com.group.syllabus.Repository.SyllabusUnitChapterRepo;
import com.group.syllabus.Repository.SyllabusUnitRepo;
import com.group.syllabus.model.*;
import com.group.syllabus.paging.outputSyllabus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SyllabusService {

    @Autowired
    private SyllabusRepository syllabusRepository;

    @Autowired
    private OutputStandardRepository outputStandardRepository;

    @Autowired
    private SyllabusUnitRepo syllabusUnitRepo;

    @Autowired
    private SyllabusUnitChapterRepo syllabusUnitChapterRepo;

//    public SyllabusDto save(SyllabusDto syllabusDto) {
//        NewEntity newEntity = new NewEntity();
//        if (newDTO.getId() != null) {
//            NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
//            newEntity = newConverter.toEntity(newDTO, oldNewEntity);
//        } else {
//            newEntity = newConverter.toEntity(newDTO);
//        }
//        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
//        newEntity.setCategory(categoryEntity);
//        newEntity = newRepository.save(newEntity);
//        return newConverter.toDTO(newEntity);
//    }

    public void delete(long[] ids) {
        for(long item: ids) {
            syllabusRepository.deleteById(item);
        }
    }
    public List<SyllabusDto> findAll(Pageable pageable) {
        List<SyllabusDto> results = new ArrayList<>();
        SyllabusDto dto = new SyllabusDto();
        User user = new User();
        List<String> outputStandards = new ArrayList<>();
        List<SyllabusUnit> syllabusUnits = new ArrayList<>();
        List<SyllabusUnitChapter> syllabusUnitChapters = new ArrayList<>();
        List<Syllabus> syllabus = syllabusRepository.findAll(pageable).getContent();
        for (Syllabus item: syllabus) {
            //NewDTO newDTO = newConverter.toDTO(item);
        dto.setId(item.getId());
        syllabusUnits = syllabusUnitRepo.findAllBySyllabusId(item.getId());
        for(SyllabusUnit itemunit: syllabusUnits) {
            syllabusUnitChapters = syllabusUnitChapterRepo.findAllBySyllabusUnitId(itemunit.getId());
            for(SyllabusUnitChapter itemChapter: syllabusUnitChapters){
                Optional<OutputStandard> optional = outputStandardRepository.findById(itemChapter.getOutputStandard().getId());
                if(optional.isPresent()) {
                    outputStandards.add(optional.get().getCode());
                }
            }
        }
        dto.setName(item.getName());
        dto.setCode(item.getCode());
        dto.setDays(item.getDays());
        dto.setCreatedDate(item.getCreatedDate());
        dto.setCreatedBy(user.getFullName());
        dto.setOutputStandards(outputStandards);
        results.add(dto);
        }
        return results;
    }

    public int totalItem() {
        return (int) syllabusRepository.count();
    }
}
