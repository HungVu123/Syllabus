package com.group.syllabus.dto;

import java.util.UUID;

public class SyllabusLevelDTO {
    private UUID id;
    private String levelName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
