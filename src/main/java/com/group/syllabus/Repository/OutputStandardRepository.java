package com.group.syllabus.Repository;

import com.group.syllabus.model.OutputStandard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputStandardRepository extends JpaRepository<OutputStandard,Long>{
   // OutputStandard (String code);
}
