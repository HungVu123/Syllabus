package com.group.syllabus.repository;

import com.group.syllabus.model.SyllabusLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusLevelRepo extends JpaRepository<SyllabusLevel,Long> {
}
