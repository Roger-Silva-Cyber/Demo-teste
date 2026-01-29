package com.example.demo.dto;

import com.example.demo.model.TaskStatus;
import java.time.Instant;

public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Instant createdAt;
    private String prioridade = "BAIXA"; 


    public TaskResponse(Long id, String title, String description, TaskStatus status, Instant createdAt, String prioridade) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.prioridade = prioridade;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public TaskStatus getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }
    public String getPrioridade() { return prioridade; }
}
