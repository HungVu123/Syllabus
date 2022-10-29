package com.group.syllabus.dto;

import com.group.syllabus.model.Syllabus;
import com.group.syllabus.model.SyllabusUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SyllabusSessionDTO {
    private Long id;
    private Syllabus syllabus;
    private int sessionNo;
    private int status;
    private List<SyllabusUnit> syllabusUnit = new ArrayList<>();
}
