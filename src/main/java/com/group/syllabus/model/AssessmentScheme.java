package com.group.syllabus.model;

import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssessmentScheme {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    private Double assignment;
    private Double quiz;
    private Double exam;
    private Double gpa;
    private Double finalPoint;
    private Double finalTheory;
    private Double finalPractice;
    // syllabus id
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "syllabus_id", referencedColumnName = "id")
    private Syllabus syllabus;

}
