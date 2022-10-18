package com.group.syllabus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SyllabusUnitChapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private SyllabusSession syllabusunitchapter;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private OutputStandard outputstandard;

    @ManyToOne(fetch = FetchType.LAZY)
    private DeliveryType deliverytype;

    @OneToMany(
            mappedBy = "material",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Material> material = new ArrayList<>();

    private int duration;
    private int online; // status


    // private sort;
}
