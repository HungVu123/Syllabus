package com.group.syllabus.repository;

import com.group.syllabus.model.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusRepo extends JpaRepository<Syllabus,Long> {


}
