package com.healthmonitor.domain.event;

public class TaskPerformedEvent extends MonitorEvent {
	
	private String taskId;
	private int healthScore;
	
	public TaskPerformedEvent(String monitorId, String account, String taskId, int healthScore) {
		super(monitorId, account, healthScore);
		this.taskId = taskId;
		this.healthScore = healthScore;
	}

	public int getHealthScore() {
		return healthScore;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public void setHealthScore(int healthScore) {
		this.healthScore = healthScore;
	}
	
}
