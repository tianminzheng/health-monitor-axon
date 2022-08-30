package com.healthmonitor.monitor.interfaces.rest.dto;

public class PerformTaskDTO {

	private String monitorId;	
	private String taskId;

	public String getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}	
}
