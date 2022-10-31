package com.group.syllabus.dto;

import com.group.syllabus.meta.SyllabusStatus;
import com.group.syllabus.model.Syllabus;
import com.group.syllabus.model.SyllabusUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SyllabusDayDTO {
    private UUID id;
    private int dayNo;
    private SyllabusStatus status;
    private SyllabusDTO syllabus;
    private List<SyllabusUnit> syllabusUnit = new ArrayList<>();

    public SyllabusDTO getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(SyllabusDTO syllabus) {
        this.syllabus = syllabus;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getDayNo() {
        return dayNo;
    }

    public void setDayNo(int dayNo) {
        this.dayNo = dayNo;
    }

    public SyllabusStatus getStatus() {
        return status;
    }

    public void setStatus(SyllabusStatus status) {
        this.status = status;
    }

    public List<SyllabusUnit> getSyllabusUnit() {
        return syllabusUnit;
    }

    public void setSyllabusUnit(List<SyllabusUnit> syllabusUnit) {
        this.syllabusUnit = syllabusUnit;
    }
}
