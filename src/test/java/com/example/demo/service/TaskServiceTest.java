package com.example.demo.service;

import com.example.demo.dto.TaskCreateRequest;
import com.example.demo.dto.TaskResponse;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @SuppressWarnings("null")
    @Test
    void create_deveSalvarTaskERetornarResponse() {
        // Arrange
        TaskRepository repo = mock(TaskRepository.class);
        TaskService service = new TaskService(repo);

        TaskCreateRequest req = new TaskCreateRequest();
        req.setTitle("Estudar testes");
        req.setDescription("JUnit + Mockito");

        // Simula o retorno do repo.save(...)
        Task saved = new Task();
        saved.setTitle(req.getTitle());
        saved.setDescription(req.getDescription());

        when(repo.save(any(Task.class))).thenReturn(saved);

        // Act
        TaskResponse resp = service.create(req);

        // Assert: garante que chamou save com os dados certos
        ArgumentCaptor<Task> captor = ArgumentCaptor.forClass(Task.class);
        verify(repo, times(1)).save(captor.capture());

        Task enviado = captor.getValue();
        assertEquals("Estudar testes", enviado.getTitle());
        assertEquals("JUnit + Mockito", enviado.getDescription());

        // Assert: resposta
        assertNotNull(resp);
        assertEquals("Estudar testes", resp.getTitle());
        assertEquals("JUnit + Mockito", resp.getDescription());
    }

    @Test
    void list_deveRetornarListaDeResponses() {
        TaskRepository repo = mock(TaskRepository.class);
        TaskService service = new TaskService(repo);

        Task t1 = new Task();
        t1.setTitle("A");
        t1.setDescription("Desc A");

        Task t2 = new Task();
        t2.setTitle("B");
        t2.setDescription("Desc B");

        when(repo.findAll()).thenReturn(java.util.List.of(t1, t2));

        var result = service.list();

        assertEquals(2, result.size());
        assertEquals("A", result.get(0).getTitle());
        assertEquals("B", result.get(1).getTitle());
        verify(repo, times(1)).findAll();
    }

}
