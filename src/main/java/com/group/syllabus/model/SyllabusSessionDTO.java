package com.group.syllabus.model;

public class SyllabusSessionDTO {
    private Long id;
    private int sessionNo;
    private int status;
    private SyllabusUnit syllabusUnit;

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

    public SyllabusUnit getSyllabusUnit() {
        return syllabusUnit;
    }

    public void setSyllabusUnit(SyllabusUnit syllabusUnit) {
        this.syllabusUnit = syllabusUnit;
    }
}
