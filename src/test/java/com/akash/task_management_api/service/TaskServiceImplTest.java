package com.akash.task_management_api.service;

import com.akash.task_management_api.application.service.TaskServiceImpl;
import com.akash.task_management_api.domain.model.Task;
import com.akash.task_management_api.domain.model.TaskStatus;
import com.akash.task_management_api.domain.repository.TaskRepository;
import com.akash.task_management_api.presentation.dto.CreateTaskRequest;
import com.akash.task_management_api.presentation.dto.TaskResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Test
    void shouldCreateTaskSuccessfully() {

        CreateTaskRequest request =
                new CreateTaskRequest(
                        "Learn Spring Boot",
                        "Testing Service Layer",
                        LocalDate.now().plusDays(5)
                );

        Task savedTask = new Task();

        savedTask.setId("1");
        savedTask.setTitle(request.getTitle());
        savedTask.setDescription(request.getDescription());
        savedTask.setDueDate(request.getDueDate());
        savedTask.setStatus(TaskStatus.PENDING);

        when(taskRepository.save(any(Task.class)))
                .thenReturn(savedTask);

        TaskResponse response =
                taskService.createTask(request);

        assertNotNull(response);
        assertEquals("Learn Spring Boot",
                response.getTitle());

        verify(taskRepository,
                times(1))
                .save(any(Task.class));
    }
}