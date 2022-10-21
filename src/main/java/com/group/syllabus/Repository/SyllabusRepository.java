package com.group.syllabus.Repository;

import com.group.syllabus.model.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyllabusRepository extends JpaRepository<Syllabus,Long> {


}
