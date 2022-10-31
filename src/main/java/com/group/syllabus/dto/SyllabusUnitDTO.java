package com.group.syllabus.dto;

import com.group.syllabus.model.SyllabusDay;
import com.group.syllabus.model.SyllabusUnitChapter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SyllabusUnitDTO {
    private UUID id;
    private int unitNo;
    private String name;
    private int duration;
    private SyllabusDay syllabusDay;
    private List<SyllabusUnitChapterDTO> syllabusUnitChapter = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(int unitNo) {
        this.unitNo = unitNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public SyllabusDay getSyllabusUnitDay() {
        return syllabusDay;
    }

    public void setSyllabusUnitDay(SyllabusDay syllabusUnitDay) {
        this.syllabusDay = syllabusUnitDay;
    }


    public List<SyllabusUnitChapterDTO> getSyllabusUnitChapter() {
        return syllabusUnitChapter;
    }

    public void setSyllabusUnitChapter(List<SyllabusUnitChapterDTO> syllabusUnitChapter) {
        this.syllabusUnitChapter = syllabusUnitChapter;
    }
}
