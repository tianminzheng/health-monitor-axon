package com.healthmonitor.plan.infrastructure.repository.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "health_task")
public class HealthTaskPO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(targetEntity = HealthPlanPO.class)
	@JoinColumn(name = "plan_id")
	private HealthPlanPO plan;

	private String taskId;
	private String taskName;
	private String description;
	private int taskScore;
	
	public HealthPlanPO getPlan() {
		return plan;
	}
	public void setPlan(HealthPlanPO plan) {
		this.plan = plan;
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
