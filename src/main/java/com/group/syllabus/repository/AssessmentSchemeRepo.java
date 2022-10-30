package com.group.syllabus.repository;

import com.group.syllabus.model.AssessmentScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentSchemeRepo  extends JpaRepository<AssessmentScheme,Long> {
}
