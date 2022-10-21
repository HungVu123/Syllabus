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
public class OutputStandard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(
            mappedBy = "outputStandard",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SyllabusUnitChapter> syllabusUnitChapter = new ArrayList<>();

    private String code;
    private String name;
    private String description;
}
