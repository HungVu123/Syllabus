package com.group.syllabus.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private int duration;
    private boolean isOnline;

    @OneToMany(mappedBy = "unitChapter")
    private List<Material> materials;

    // unit_id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private SyllabusUnit syllabusUnit;

    // output_standard_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "output_standard_id")
    private OutputStandard outputStandard;

    // delivery_type_id
    @ManyToOne
    @JoinColumn(name = "delivery_type_id")
    private DeliveryType deliveryType;

}

