package com.group.syllabus.Dto;

import com.group.syllabus.model.OutputStandard;
import com.group.syllabus.model.SyllabusUnit;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SyllabusDto {
    private Long id;
    private String name;
    private String code;
    private Timestamp createdDate;
    private String createdBy;
    private int days;
    private List<String> outputStandards;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public List<String> getOutputStandards() {
        return outputStandards;
    }

    public void setOutputStandards(List<String> outputStandards) {
        this.outputStandards = outputStandards;
    }
}
