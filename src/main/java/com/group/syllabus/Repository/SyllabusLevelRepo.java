package com.group.syllabus.Repository;

import com.group.syllabus.model.Syllabus;
import com.group.syllabus.model.SyllabusLevel;
import com.group.syllabus.model.SyllabusSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusLevelRepo extends JpaRepository<SyllabusLevel,Long> {
}
