package com.group.syllabus.repository;

import com.group.syllabus.model.SyllabusDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusDayRepo  extends JpaRepository<SyllabusDay,Long> {
}
