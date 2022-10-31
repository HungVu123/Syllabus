package com.group.syllabus.dto;

import com.group.syllabus.meta.SyllabusStatus;
import com.group.syllabus.model.AssessmentScheme;
import com.group.syllabus.model.DeliveryPrinciple;
import com.group.syllabus.model.SyllabusDay;
import com.group.syllabus.model.SyllabusLevel;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class SyllabusDTO {
    private UUID id;
    private String name;
    private String code;
    private String version;
    private int attendeeNumber;
    private String technicalRequirement;
    private String courseObjective;
    private int days;
    private int hours;
    private SyllabusStatus status;
    boolean isTemplate;
    private UUID createdBy;
    private Date createdDate;
    private UUID updatedBy;
    private Date updatedDate;
    private AssessmentScheme assessmentScheme;
    private SyllabusLevel syllabusLevel;
    List<SyllabusDay> syllabusDays;
    private DeliveryPrinciple deliveryPrinciple;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getAttendeeNumber() {
        return attendeeNumber;
    }

    public void setAttendeeNumber(int attendeeNumber) {
        this.attendeeNumber = attendeeNumber;
    }

    public String getTechnicalRequirement() {
        return technicalRequirement;
    }

    public void setTechnicalRequirement(String technicalRequirement) {
        this.technicalRequirement = technicalRequirement;
    }

    public String getCourseObjective() {
        return courseObjective;
    }

    public void setCourseObjective(String courseObjective) {
        this.courseObjective = courseObjective;
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

    public SyllabusStatus getStatus() {
        return status;
    }

    public void setStatus(SyllabusStatus status) {
        this.status = status;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public AssessmentScheme getAssessmentScheme() {
        return assessmentScheme;
    }

    public void setAssessmentScheme(AssessmentScheme assessmentScheme) {
        this.assessmentScheme = assessmentScheme;
    }

    public SyllabusLevel getSyllabusLevel() {
        return syllabusLevel;
    }

    public void setSyllabusLevel(SyllabusLevel syllabusLevel) {
        this.syllabusLevel = syllabusLevel;
    }

    public List<SyllabusDay> getSyllabusDays() {
        return syllabusDays;
    }

    public void setSyllabusDays(List<SyllabusDay> syllabusDays) {
        this.syllabusDays = syllabusDays;
    }

    public DeliveryPrinciple getDeliveryPrinciple() {
        return deliveryPrinciple;
    }

    public void setDeliveryPrinciple(DeliveryPrinciple deliveryPrinciple) {
        this.deliveryPrinciple = deliveryPrinciple;
    }
}
