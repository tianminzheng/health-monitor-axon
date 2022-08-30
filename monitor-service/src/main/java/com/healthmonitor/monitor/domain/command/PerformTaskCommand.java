package com.healthmonitor.monitor.domain.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.healthmonitor.domain.model.entity.HealthTaskProfile;

public class PerformTaskCommand {

	@TargetAggregateIdentifier
	private String monitorId;	
	private String taskId;
	private HealthTaskProfile healthTaskProfile;
	
	public PerformTaskCommand(String monitorId, String taskId) {
		super();
		this.monitorId = monitorId;
		this.taskId = taskId;
	}

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

	public HealthTaskProfile getHealthTaskProfile() {
		return healthTaskProfile;
	}

	public void setHealthTaskProfile(HealthTaskProfile healthTaskProfile) {
		this.healthTaskProfile = healthTaskProfile;
	}	
}
