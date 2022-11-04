package com.group.syllabus.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

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
    @Column(length = 65555)
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
    @OneToMany(mappedBy = "material",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SyllabusUnitChapter> syllabusUnitChapter;
}

