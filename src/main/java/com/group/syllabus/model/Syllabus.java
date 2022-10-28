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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AssessmentScheme assessmentScheme;

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL )
    private SyllabusLevel syllabusLevel;

    @OneToMany(
            mappedBy = "syllabus",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SyllabusSession> syllabusSession = new ArrayList<>();

    private int attendeeNo;
    @Column(length = 1337)
    private String techReq;

    @Column(length = 1337)
    private String courseObj;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DeliveryPrinciple deliveryPrinciple;

    private int days;
    private int hours;
    private int status;
    private Long createdBy;
    @CreationTimestamp
    private Timestamp createdDate;
    private Long updatedBy;
    @CreationTimestamp
    private Timestamp updatedDate;
}
