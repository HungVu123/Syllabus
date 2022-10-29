package com.group.syllabus.service.Syllabus;

import com.group.syllabus.Dto.SyllabusDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISyllabusService {

    SyllabusDto save(SyllabusDto syllabusDto);
    void delete(long[] ids);
    List<SyllabusDto> findAll(Pageable pageable);
    int totalItem();
}
