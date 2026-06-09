package com.akash.task_management_api.presentation.dto;

import com.akash.task_management_api.domain.model.TaskStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskRequest {
    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private TaskStatus status;

    @Future(message = "Due date must be in future")
    private LocalDate dueDate;
}
