package com.group.syllabus.DTO;

import com.group.syllabus.model.DeliveryType;
import com.group.syllabus.model.Material;
import com.group.syllabus.model.OutputStandard;
import com.group.syllabus.model.SyllabusUnit;

import java.util.ArrayList;
import java.util.List;

public class SyllabusUnitChapterDTO {
    private Long id;
    private SyllabusUnit syllabusUnit;
    private String name;
    private OutputStandard outputStandard;
    private DeliveryType deliveryType;
    private List<Material> material = new ArrayList<>();

    private int duration;
    private int online;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SyllabusUnit getSyllabusUnit() {
        return syllabusUnit;
    }

    public void setSyllabusUnit(SyllabusUnit syllabusUnit) {
        this.syllabusUnit = syllabusUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OutputStandard getOutputStandard() {
        return outputStandard;
    }

    public void setOutputStandard(OutputStandard outputStandard) {
        this.outputStandard = outputStandard;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public List<Material> getMaterial() {
        return material;
    }

    public void setMaterial(List<Material> material) {
        this.material = material;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }
}
