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
public class DeliveryType {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(
            mappedBy = "deliverytype",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SyllabusUnitChapter> syllabusunitchapter = new ArrayList<>();

    private String name;
    private String description;
}
