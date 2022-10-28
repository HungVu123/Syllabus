package com.group.syllabus.DTO;

import java.sql.Timestamp;
import java.util.List;

public class SyllabusDTO {

    private Long id;
    private String name;
    private String code;
    private double version;
    private SyllabusLevelDTO syllabusLevel;
    private String techReq;
    private String courseObj;
    private int days;
    private int hours;
    private int status;
    private List<SyllabusSessionDTO> syllabusSessionDTO;
    private List<DeliveryPrincipleDTO> deliveryPrincipleDTO;

    public List<SyllabusSessionDTO> getSyllabusSessionDTO() {
        return syllabusSessionDTO;
    }

    public void setSyllabusSessionDTO(List<SyllabusSessionDTO> syllabusSessionDTO) {
        this.syllabusSessionDTO = syllabusSessionDTO;
    }

    public List<DeliveryPrincipleDTO> getDeliveryPrincipleDTO() {
        return deliveryPrincipleDTO;
    }

    public void setDeliveryPrincipleDTO(List<DeliveryPrincipleDTO> deliveryPrincipleDTO) {
        this.deliveryPrincipleDTO = deliveryPrincipleDTO;
    }

    private Timestamp createdDate;
    // private updatedBy;

    private Timestamp updatedDate;

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

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public SyllabusLevelDTO getSyllabusLevel() {
        return syllabusLevel;
    }

    public void setSyllabusLevel(SyllabusLevelDTO syllabusLevel) {
        this.syllabusLevel = syllabusLevel;
    }

    public String getTechReq() {
        return techReq;
    }

    public void setTechReq(String techReq) {
        this.techReq = techReq;
    }

    public String getCourseObj() {
        return courseObj;
    }

    public void setCourseObj(String courseObj) {
        this.courseObj = courseObj;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }
}
