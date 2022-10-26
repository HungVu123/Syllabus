package com.group.syllabus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeliveryPrincipleDTO {

    private Long id;
//    private String content;
    private String trainees;
    private String trainer;
    private String training;
    private String re_test;
    private String marking;
    private String waivercriteria;
    private String others;
}
