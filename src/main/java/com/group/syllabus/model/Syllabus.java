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

    @ManyToOne(fetch = FetchType.LAZY)
    private SyllabusLevel syllabusLevel;

    @OneToMany(
            mappedBy = "syllabus",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SyllabusSession> syllabusSession = new ArrayList<>();

    // private attendeeNo;
    private String techReq;
    private String courseObj;

    @OneToMany(
            mappedBy = "syllabus",
            cascade = CascadeType.ALL,
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
}
