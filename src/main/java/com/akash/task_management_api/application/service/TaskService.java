package com.akash.task_management_api.application.service;

import com.akash.task_management_api.domain.model.TaskStatus;
import com.akash.task_management_api.presentation.dto.CreateTaskRequest;
import com.akash.task_management_api.presentation.dto.TaskResponse;
import com.akash.task_management_api.presentation.dto.UpdateTaskRequest;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(CreateTaskRequest request);

    TaskResponse getTaskById(String id);

    List<TaskResponse> getAllTasks();

    TaskResponse updateTask(String id, UpdateTaskRequest request);

    void deleteTask(String id);

    List<TaskResponse> getTasksByStatus(TaskStatus status);
}
