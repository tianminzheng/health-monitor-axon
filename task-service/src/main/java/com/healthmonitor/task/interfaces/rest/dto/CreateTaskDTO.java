package com.healthmonitor.task.interfaces.rest.dto;

public class CreateTaskDTO {

	private String taskName;
	private String description;
	private int taskScore;
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTaskScore() {
		return taskScore;
	}
	public void setTaskScore(int taskScore) {
		this.taskScore = taskScore;
	}
}
