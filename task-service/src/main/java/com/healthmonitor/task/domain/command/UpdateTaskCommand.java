package com.healthmonitor.task.domain.command;

public class UpdateTaskCommand {
	
	private String taskId;
	private String description;
	private int taskScore;
	
	public UpdateTaskCommand(String taskId, String description, int taskScore) {
		super();
		this.taskId = taskId;
		this.description = description;
		this.taskScore = taskScore;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
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
