package com.healthmonitor.task.domain.command;

public class CreateTaskCommand {

	private String taskId;
	private String taskName;
	private String description;
	private int taskScore;
	
	public CreateTaskCommand(String taskName, String description, int taskScore) {
		super();
		this.taskName = taskName;
		this.description = description;
		this.taskScore = taskScore;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

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
