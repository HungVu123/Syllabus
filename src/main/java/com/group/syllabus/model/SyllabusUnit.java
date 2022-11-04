package com.group.syllabus.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SyllabusUnit {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    private String name;
    private int unitNo;
    private int duration;

    @OneToMany(mappedBy = "syllabusUnit",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SyllabusUnitChapter> syllabusUnitChapters;

    // syllabus_id
//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "syllabus_id")
//    private Syllabus syllabus;

    // syllabus_day_id
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "syllabus_day_id")
    private SyllabusDay syllabusDay;

    // trainer_id
}
