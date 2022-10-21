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
public class SyllabusLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(
            mappedBy = "syllabusLevel",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Syllabus> syllabus = new ArrayList<>();

    private String levelName;
}
