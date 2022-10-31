package com.group.syllabus.repository;

import com.group.syllabus.model.SyllabusDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SyllabusDayRepository extends JpaRepository<SyllabusDay, UUID> {
}
