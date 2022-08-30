package com.healthmonitor.monitor.domain.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.healthmonitor.domain.model.entity.HealthPlanProfile;
import com.healthmonitor.monitor.domain.model.entity.HealthTestOrder;

public class GeneratePlanCommand {

	@TargetAggregateIdentifier
	private String monitorId;
	private HealthTestOrder order;
	private HealthPlanProfile healthPlanProfile;
		
	public GeneratePlanCommand(String monitorId, HealthTestOrder order) {
		this.monitorId = monitorId;
		this.order = order;
	}

	public String getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	public HealthTestOrder getOrder() {
		return order;
	}

	public void setOrder(HealthTestOrder order) {
		this.order = order;
	}

	public HealthPlanProfile getHealthPlanProfile() {
		return healthPlanProfile;
	}

	public void setHealthPlanProfile(HealthPlanProfile healthPlanProfile) {
		this.healthPlanProfile = healthPlanProfile;
	}		
}



//public class CreatePlanCommand {
//
//	private String monitorId;//健康监控编号	
//
//	private String planId;
//	private String account;
//	private String doctor;
//	private String description;
//	private List<String> tasks;
//	
//	public CreatePlanCommand(String monitorId, String planId, String account, String doctor, String description,
//			List<String> tasks) {
//		super();
//		this.monitorId = monitorId;
//		this.planId = planId;
//		this.account = account;
//		this.doctor = doctor;
//		this.description = description;
//		this.tasks = tasks;
//	}
//
//	public String getMonitorId() {
//		return monitorId;
//	}
//
//	public String getPlanId() {
//		return planId;
//	}
//
//	public String getAccount() {
//		return account;
//	}
//
//	public String getDoctor() {
//		return doctor;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public List<String> getTasks() {
//		return tasks;
//	}
//}
