package com.group.syllabus.repository;

import com.group.syllabus.model.SyllabusUnitChapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusUnitChapterRepo  extends JpaRepository<SyllabusUnitChapter,Long> {
}
