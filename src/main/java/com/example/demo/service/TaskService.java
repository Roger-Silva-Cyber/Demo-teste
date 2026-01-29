package com.example.demo.service;

import com.example.demo.dto.TaskCreateRequest;
import com.example.demo.dto.TaskResponse;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public TaskResponse create(TaskCreateRequest req) {
        Task task = new Task();
        task.setTitle(req.getTitle());
        task.setDescription(req.getDescription());
        Task saved = repo.save(task);

        return toResponse(saved);
    }

    public List<TaskResponse> list() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    private TaskResponse toResponse(Task t) {
        return new TaskResponse(t.getId(), t.getTitle(), t.getDescription(), t.getStatus(), t.getCreatedAt(), t.getPrioridade());
    }
}
