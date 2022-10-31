package com.group.syllabus.repository;

import com.group.syllabus.model.SyllabusUnitChapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SyllabusUnitChapterRepository extends JpaRepository<SyllabusUnitChapter, UUID> {
}
