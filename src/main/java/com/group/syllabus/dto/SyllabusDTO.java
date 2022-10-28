package com.group.syllabus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SyllabusDTO {

    private Long id;
    private String name;
    private String code;
    private double version;
    private SyllabusSessionDTO syllabusSession;
    private SyllabusLevelDTO syllabusLevel;
    private DeliveryPrincipleDTO deliveryPrinciple;
    private String techReq;
    private String courseObj;
    private int days;
    private int hours;
    private int status;
    private Timestamp createdDate;
    // private updatedBy;

    private Timestamp updatedDate;
}
