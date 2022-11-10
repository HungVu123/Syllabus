package com.group.syllabus.dto;

import com.group.syllabus.model.SyllabusUnitChapter;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

public class DeliveryTypeDTO {
    private UUID id;
    private String name;
    private String description;
    private List<SyllabusUnitChapter> syllabusUnitChapter;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SyllabusUnitChapter> getSyllabusUnitChapter() {
        return syllabusUnitChapter;
    }

    public void setSyllabusUnitChapter(List<SyllabusUnitChapter> syllabusUnitChapter) {
        this.syllabusUnitChapter = syllabusUnitChapter;
    }
}
