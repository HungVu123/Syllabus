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
public class SyllabusSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Syllabus syllabussession;

    private int sessionNo;
    private int status;

    @OneToMany(
            mappedBy = "syllabusunitsession",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SyllabusUnit> syllabusunit = new ArrayList<>();
}
