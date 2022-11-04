package com.group.syllabus.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import com.group.syllabus.meta.SyllabusStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(length = 65555)
    private String technicalRequirement;
    @Column(length = 65555)
    private String courseObjective;
    //	private int deliveryPrincipleId;// fk
    private int days;
    private int hours;
    @Enumerated(EnumType.ORDINAL)
    private SyllabusStatus status;
    boolean isTemplate;
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID createdBy;
    @CreationTimestamp
    private Date createdDate;
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID updatedBy;
    @CreationTimestamp
    private Date updatedDate;

    @OneToOne(mappedBy = "syllabus",cascade = CascadeType.ALL, orphanRemoval = true)
    private AssessmentScheme assessmentScheme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private SyllabusLevel syllabusLevel;

    @OneToMany(mappedBy = "syllabus", orphanRemoval = true)
    List<SyllabusDay> syllabusDays;

    @OneToOne(mappedBy = "syllabus",cascade = CascadeType.ALL,orphanRemoval = true)
    private DeliveryPrinciple deliveryPrinciple;

//    @OneToMany(mappedBy = "syllabus")
//    private List<SyllabusUnit> syllabusUnits;

    //Training Syllabus
//	@OneToMany(mappedBy = "syllabus")
//	private List<ProgramSyllabus> programSyllabusAssociation; // relationship association
}

