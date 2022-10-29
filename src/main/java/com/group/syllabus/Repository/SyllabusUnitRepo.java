package com.group.syllabus.Repository;

import com.group.syllabus.model.SyllabusUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SyllabusUnitRepo extends JpaRepository<SyllabusUnit,Long> {
    List<SyllabusUnit> findAllBySyllabusId(Long syllabusId);

}
