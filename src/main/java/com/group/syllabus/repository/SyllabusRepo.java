package com.group.syllabus.repository;

import com.group.syllabus.model.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SyllabusRepo extends JpaRepository<Syllabus,UUID> {

    @Query(
            value = "SELECT * FROM syllabus.syllabus WHERE syllabus.code = code ",
            nativeQuery = true)
    List<Syllabus> findAllByCode(String code);

    @Query(
            value = "SELECT * FROM syllabus.syllabus WHERE syllabus.name = name ",
            nativeQuery = true)
    List<Syllabus> findAllByName(String name);

}
