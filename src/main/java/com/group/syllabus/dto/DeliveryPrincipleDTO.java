package com.group.syllabus.dto;


import java.util.UUID;

public class DeliveryPrincipleDTO {
    private UUID id;
    private String content;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
