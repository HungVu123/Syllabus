package com.group.syllabus.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.group.syllabus.meta.SyllabusStatus;
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

    @OneToOne(mappedBy = "syllabus")
    private AssessmentScheme assessmentScheme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private SyllabusLevel syllabusLevel;

    @OneToMany(mappedBy = "syllabus")
    List<SyllabusDay> syllabusDays;

    @OneToOne(mappedBy = "syllabus")
    private DeliveryPrinciple deliveryPrinciple;

    @OneToMany(mappedBy = "syllabus")
    private List<SyllabusUnit> syllabusUnits;

    //Training Syllabus
//	@OneToMany(mappedBy = "syllabus")
//	private List<ProgramSyllabus> programSyllabusAssociation; // relationship association
}

