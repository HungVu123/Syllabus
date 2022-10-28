package com.group.syllabus.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.group.syllabus.meta.MaterialStatus;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material {
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
    private String url;
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID createdBy;
    private Date createdDate;
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID updatedBy;
    private Date updatedDate;

    //
    private String type;
    @Lob
    private byte[] data;
    //
    @Enumerated(EnumType.ORDINAL)
    private MaterialStatus materialStatus;

    // unit_chapter_id
    @ManyToOne
    @JoinColumn(name = "unit_chapter_id")
    private SyllabusUnitChapter unitChapter;
}

