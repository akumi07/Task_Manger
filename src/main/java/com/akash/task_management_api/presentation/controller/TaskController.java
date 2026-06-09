package com.akash.task_management_api.presentation.controller;

import com.akash.task_management_api.application.service.TaskService;
import com.akash.task_management_api.domain.model.TaskStatus;
import com.akash.task_management_api.presentation.dto.CreateTaskRequest;
import com.akash.task_management_api.presentation.dto.TaskResponse;
import com.akash.task_management_api.presentation.dto.UpdateTaskRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse createTask(
            @Valid @RequestBody CreateTaskRequest request) {

        return taskService.createTask(request);
    }

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable String id) {

        return taskService.getTaskById(id);
    }


//    @GetMapping
//    public List<TaskResponse> getAllTasks() {
//
//        return taskService.getAllTasks();
//    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(
            @PathVariable String id,
            @Valid @RequestBody UpdateTaskRequest request) {

        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable String id) {

        taskService.deleteTask(id);
    }

    //Bonus Feature

    @GetMapping
    public List<TaskResponse> getTasks(
            @RequestParam(required = false) TaskStatus status) {

        if (status != null) {
            return taskService.getTasksByStatus(status);
        }

        return taskService.getAllTasks();
    }
}