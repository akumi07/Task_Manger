package com.akash.task_management_api.domain.repository;

import com.akash.task_management_api.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);

    Optional<Task> findById(String id);

    List<Task> findAll();

    void deleteById(String id);

    boolean existsById(String id);
}
