package com.mckesson.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mckesson.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
    public Task findByTaskSummaryAndTaskDescriptionAndCreatedByAndUpdatedBy(String taskSummary, String taskDescription, String createdBy, String updatedBy);


}