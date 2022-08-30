package com.healthmonitor.plan.interfaces.rest.dto;

import java.util.List;

import com.healthmonitor.domain.model.entity.HealthTaskProfile;

public class CreatePlanDTO {

	private String account;
	private String doctor;
	private String description;
	private List<HealthTaskProfile> tasks;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<HealthTaskProfile> getTasks() {
		return tasks;
	}
	public void setTasks(List<HealthTaskProfile> tasks) {
		this.tasks = tasks;
	}	
}
