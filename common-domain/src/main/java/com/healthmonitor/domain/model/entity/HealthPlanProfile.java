package com.healthmonitor.domain.model.entity;

import java.util.List;

/**
 * 健康计划
 */
public class HealthPlanProfile {

	private String planId;
	private String account;
	private String doctor;
	private String description;
	private List<HealthTaskProfile> tasks;

	public HealthPlanProfile() {
	}
	
	public HealthPlanProfile(String planId, String account, String doctor, String description, List<HealthTaskProfile> tasks) {
		super();
		this.planId = planId;
		this.account = account;
		this.doctor = doctor;
		this.description = description;
		this.tasks = tasks;
	}

	public String getPlanId() {
		return planId;
	}

	public String getAccount() {
		return account;
	}

	public String getDoctor() {
		return doctor;
	}

	public String getDescription() {
		return description;
	}

	public List<HealthTaskProfile> getTasks() {
		return tasks;
	}
	
	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTasks(List<HealthTaskProfile> tasks) {
		this.tasks = tasks;
	}
}
