package com.mckesson.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;


public class TaskDTO {

	// @JsonProperty("task_id")
	private Long id;
	@JsonProperty("task_summary")
	private String taskSummary;
	@JsonProperty("task_description")
	private String taskDescription;
	@JsonProperty("created_by") 
    private String createdBy;
	@JsonProperty("updated_by")
	private String updatedBy;
	@JsonProperty("task_status")
	private String taskStatus;
	@JsonProperty("created_date")
	private LocalDate createdDate;
    @JsonProperty("updated_date")
    private LocalDate updatedDate;
	
    public TaskDTO(){
        
    }

	public String getTaskSummary() {
		return taskSummary;
	}

	public void setTaskSummary(String taskSummary) {
		this.taskSummary = taskSummary;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
}