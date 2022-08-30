package com.healthmonitor.task.domain.model.aggregate;

/**
 * Healthtask聚合的聚合标识符
 */
public class TaskId {

	private String taskId;
	
	public TaskId(String taskId) {
		super();
		this.taskId = taskId;
	}

	public String getTaskId() {
		return taskId;
	}		
}
