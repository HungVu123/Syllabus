package com.group.syllabus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Syllabus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private double version;

    @ManyToOne(fetch = FetchType.LAZY)
    private SyllabusLevel syllevel;

    @OneToMany(
            mappedBy = "syllabussession",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SyllabusSession> syllabusssession = new ArrayList<>();

    // private attendeeNo;
    private String techReq;
    private String courseObj;

    @OneToMany(
            mappedBy = "syllabusdeliveryprinciple",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DeliveryPrinciple> deliveryprinciple = new ArrayList<>();

    private int days;
    private int hours;
    private int status;
    // private isTemplate;
    // private createdBy;
    private Timestamp createdDate;
    // private updatedBy;
    private Timestamp updatedDate;
}
