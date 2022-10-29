package com.group.syllabus.model;

import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryPrinciple {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    private String trainees;
    private String trainer;
    @Column(length = 1337)
    private String training;
    private String re_test;
    private String marking;
    private String waiverCriteria;
    private String others;
    // syllabus_id
    @OneToOne
    @JoinColumn(name = "syllabus_id", referencedColumnName = "id")
    private Syllabus syllabus;

}
