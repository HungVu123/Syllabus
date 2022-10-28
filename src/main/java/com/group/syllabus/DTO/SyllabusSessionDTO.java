package com.group.syllabus.DTO;

import com.group.syllabus.model.SyllabusUnit;

import java.util.ArrayList;
import java.util.List;

public class SyllabusSessionDTO {
    private Long id;
    private int sessionNo;
    private int status;
    private List<SyllabusUnitDTO> syllabusUnit = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSessionNo() {
        return sessionNo;
    }

    public void setSessionNo(int sessionNo) {
        this.sessionNo = sessionNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<SyllabusUnitDTO> getSyllabusUnit() {
        return syllabusUnit;
    }

    public void setSyllabusUnit(List<SyllabusUnitDTO> syllabusUnit) {
        this.syllabusUnit = syllabusUnit;
    }
}
