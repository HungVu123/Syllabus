package com.group.syllabus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPrinciple {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trainees;
    private String trainer;
    @Column(length = 1337)
    private String training;
    private String re_test;
    private String marking;
    private String waivercriteria;
    private String others;

    @OneToOne(
            mappedBy = "deliveryPrinciple",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private Syllabus syllabus;

}
