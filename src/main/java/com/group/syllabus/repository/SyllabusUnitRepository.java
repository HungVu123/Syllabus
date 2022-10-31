package com.group.syllabus.repository;

import com.group.syllabus.model.SyllabusUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SyllabusUnitRepository extends JpaRepository<SyllabusUnit, UUID> {
}
