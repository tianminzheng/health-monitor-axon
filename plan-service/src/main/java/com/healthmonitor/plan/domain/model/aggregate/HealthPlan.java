package com.healthmonitor.plan.domain.model.aggregate;

import java.util.List;

import com.healthmonitor.domain.model.entity.HealthTaskProfile;
import com.healthmonitor.plan.domain.command.CreatePlanCommand;

public class HealthPlan {

	private PlanId planId;
	private String account;
	private String doctor;
	private String description;
	private List<HealthTaskProfile> tasks;

	public HealthPlan() {
		
	}
	
	public HealthPlan(CreatePlanCommand createPlanCommand) {
		this.planId = new PlanId(createPlanCommand.getPlanId());
		
		this.account = createPlanCommand.getAccount();
		this.description = createPlanCommand.getDescription();
		this.doctor = createPlanCommand.getDoctor();
		this.tasks = createPlanCommand.getTasks();		
	}

	public PlanId getPlanId() {
		return planId;
	}

	public void setPlanId(PlanId planId) {
		this.planId = planId;
	}

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
