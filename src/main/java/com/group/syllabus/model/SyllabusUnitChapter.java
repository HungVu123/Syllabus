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
public class SyllabusUnitChapter {
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
    private double duration;
    private boolean isOnline;

    //material_id
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id")
    private Material material;

    // unit_id
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_id")
    private SyllabusUnit syllabusUnit;

    // output_standard_id
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "output_standard_id")
    private OutputStandard outputStandard;

    // delivery_type_id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_type_id")
    private DeliveryType deliveryType;

}

