package com.group.syllabus.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
public class Syllabus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private double version;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    private SyllabusLevel syllabusLevel;

    @OneToMany(
            mappedBy = "syllabusSession",
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<SyllabusSession> syllabusSession = new ArrayList<>();

    // private attendeeNo;
    private String techReq;
    private String courseObj;

    @OneToMany(
            mappedBy = "syllabusDeliveryPrinciple",
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<DeliveryPrinciple> deliveryPrinciple = new ArrayList<>();

    private int days;
    private int hours;
    private int status;
    // private isTemplate;
    // private createdBy;
    @CreationTimestamp
    private Timestamp createdDate;
    // private updatedBy;
    @CreationTimestamp
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

    public SyllabusLevel getSyllabusLevel() {
        return syllabusLevel;
    }

    public void setSyllabusLevel(SyllabusLevel syllabusLevel) {
        this.syllabusLevel = syllabusLevel;
    }

    public List<SyllabusSession> getSyllabusSession() {
        return syllabusSession;
    }

    public void setSyllabusSession(List<SyllabusSession> syllabusSession) {
        this.syllabusSession = syllabusSession;
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

    public List<DeliveryPrinciple> getDeliveryPrinciple() {
        return deliveryPrinciple;
    }

    public void setDeliveryPrinciple(List<DeliveryPrinciple> deliveryPrinciple) {
        this.deliveryPrinciple = deliveryPrinciple;
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
