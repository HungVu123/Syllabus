package com.group.syllabus.repository;

import com.group.syllabus.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepo  extends JpaRepository<Material,Long> {
}
