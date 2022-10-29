package com.group.syllabus.Repository;

import com.group.syllabus.model.SyllabusUnitChapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SyllabusUnitChapterRepo extends JpaRepository<SyllabusUnitChapter,Long> {
    List<SyllabusUnitChapter> findAllBySyllabusUnitId(long syllabusUnitId);
}
