package com.group.syllabus.DTO;

import com.group.syllabus.model.SyllabusSession;
import com.group.syllabus.model.SyllabusUnitChapter;

import java.util.ArrayList;
import java.util.List;

public class SyllabusUnitDTO {
    private Long id;
    private int unitNo;
    private String name;
    private int duration;
    private SyllabusSession syllabusUnitSession;
    private List<SyllabusUnitChapterDTO> syllabusUnitChapter = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public SyllabusSession getSyllabusUnitSession() {
        return syllabusUnitSession;
    }

    public void setSyllabusUnitSession(SyllabusSession syllabusUnitSession) {
        this.syllabusUnitSession = syllabusUnitSession;
    }


    public List<SyllabusUnitChapterDTO> getSyllabusUnitChapter() {
        return syllabusUnitChapter;
    }

    public void setSyllabusUnitChapter(List<SyllabusUnitChapterDTO> syllabusUnitChapter) {
        this.syllabusUnitChapter = syllabusUnitChapter;
    }
}
