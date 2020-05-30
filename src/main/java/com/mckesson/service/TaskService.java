package com.mckesson.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mckesson.dto.TaskDTO;
import com.mckesson.entities.Task;
import com.mckesson.repositories.TaskRepository;
import com.mckesson.utils.ObjectMapperUtils;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	// Create
	public TaskDTO save(String taskSummary, String taskDescription, String createdBy, String updatedBy) {
		Task task = taskRepository.save(new Task(taskSummary, taskDescription, createdBy, LocalDate.now(), updatedBy, LocalDate.now(), "TODO"));
		return (task == null ? null : ObjectMapperUtils.map(task, TaskDTO.class));
	}

	public TaskDTO findById(Long Id) {
		Task task = taskRepository.findById(Id).get();
		return (task == null ? null : ObjectMapperUtils.map(task, TaskDTO.class));
	}

	public List<TaskDTO> findAll() {
		final List<Task> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(task -> tasks.add(task));
		return ObjectMapperUtils.mapAll(tasks, TaskDTO.class);
	}

	public TaskDTO save(TaskDTO taskDTO) {
		Optional<Task> optTask = taskRepository.findById(taskDTO.getId());
		Task task = optTask.get();
		if (task != null) {
			task.setTaskSummary(taskDTO.getTaskSummary());
			task.setTaskDescription(taskDTO.getTaskDescription());
			task.setTaskStatus(taskDTO.getTaskStatus());

			task = taskRepository.save(task);
		}
		return (task == null ? null : ObjectMapperUtils.map(task, TaskDTO.class));
	}

	public void delete(TaskDTO taskDTO) {
		taskRepository.deleteById(taskDTO.getId());
	}

	public void deleteById(Long Id) {
		taskRepository.deleteById(Id);
	}
	
	
	
    public TaskDTO findByTaskSummaryAndTaskDescriptionAndCreatedByAndUpdatedBy(String taskSummary, String taskDescription, String createdBy, String updatedBy){
        Task task = taskRepository.findByTaskSummaryAndTaskDescriptionAndCreatedByAndUpdatedBy(taskSummary, taskDescription, createdBy, updatedBy);
        return (task == null ? null : ObjectMapperUtils.map(task, TaskDTO.class));
    }
}