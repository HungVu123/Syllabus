package com.group.syllabus.repository;

import com.group.syllabus.model.OutputStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputStandardRepo  extends JpaRepository<OutputStandard,Long> {
}
