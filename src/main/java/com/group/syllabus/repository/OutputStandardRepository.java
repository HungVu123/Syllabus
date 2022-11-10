package com.group.syllabus.repository;

import com.group.syllabus.model.OutputStandard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OutputStandardRepository extends JpaRepository<OutputStandard, UUID> {
}
