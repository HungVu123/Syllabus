package com.group.syllabus.repository;

import com.group.syllabus.model.SyllabusLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SyllabusLevelRepository extends JpaRepository<SyllabusLevel, UUID> {
}
