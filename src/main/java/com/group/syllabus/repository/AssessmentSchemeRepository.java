package com.group.syllabus.repository;

import com.group.syllabus.model.AssessmentScheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssessmentSchemeRepository extends JpaRepository<AssessmentScheme, UUID> {
}
