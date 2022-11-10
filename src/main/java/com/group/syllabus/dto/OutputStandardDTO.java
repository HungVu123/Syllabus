package com.group.syllabus.dto;

import com.group.syllabus.model.SyllabusUnitChapter;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

public class OutputStandardDTO {
    private UUID id;
    private String name;
    private String code;
    private String description;
    private List<SyllabusUnitChapter> syllabusUnitChapters;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SyllabusUnitChapter> getSyllabusUnitChapters() {
        return syllabusUnitChapters;
    }

    public void setSyllabusUnitChapters(List<SyllabusUnitChapter> syllabusUnitChapters) {
        this.syllabusUnitChapters = syllabusUnitChapters;
    }
}
