package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskCreateRequest {

    @NotBlank(message = "title é obrigatório")
    @Size(max = 120, message = "title deve ter no máximo 120 caracteres")
    private String title;

    @Size(max = 1000, message = "description deve ter no máximo 1000 caracteres")
    private String description;

    public TaskCreateRequest() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
