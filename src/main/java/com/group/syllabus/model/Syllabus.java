package com.group.syllabus.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import com.group.syllabus.meta.SyllabusStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Syllabus {
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
    private String code;
    private String version;
    //	private String levelId; // fk
    private int attendeeNumber;
    private String technicalRequirement;
    private String courseObjective;
    //	private int deliveryPrincipleId;// fk
    private int days;
    private int hours;
    @Enumerated(EnumType.ORDINAL)
    private SyllabusStatus status;
    boolean isTemplate;
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID createdBy;
    private Date createdDate;
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID updatedBy;
    private Date updatedDate;
    @ToString.Exclude
    @OneToOne(mappedBy = "syllabus", cascade = CascadeType.ALL)
    private AssessmentScheme assessmentScheme;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "level_id")
    private SyllabusLevel syllabusLevel;

    @OneToMany(mappedBy = "syllabus", cascade = CascadeType.ALL)
    List<SyllabusDay> syllabusDays;

    @OneToOne(mappedBy = "syllabus", cascade = CascadeType.ALL)
    private DeliveryPrinciple deliveryPrinciple;

//    @OneToMany(mappedBy = "syllabus", cascade = CascadeType.ALL)
//    private List<SyllabusUnit> syllabusUnits;

    //Training Syllabus
//	@OneToMany(mappedBy = "syllabus")
//	private List<ProgramSyllabus> programSyllabusAssociation; // relationship association
}

