package com.group.syllabus.repository;

import com.group.syllabus.model.SyllabusUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusUnitRepo  extends JpaRepository<SyllabusUnit,Long> {
}
