package com.healthmonitor.monitor.domain.projection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="health_monitor_summary")
public class HealthMonitorSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String monitorId;
	private String account;//用户账户
	private String planId;//计划编号
	private String doctor;//医生
	private String status;//监控状态
	private int score;//健康分
	
	public HealthMonitorSummary() {
	}
	
	public HealthMonitorSummary(String monitorId, String account, String planId, String doctor,
			String status, int score) {
		super();
		this.monitorId = monitorId;
		this.account = account;
		this.planId = planId;
		this.doctor = doctor;
		this.status = status;
		this.score = score;
	}

	public String getMonitorId() {
		return monitorId;
	}
	public String getAccount() {
		return account;
	}
	public String getPlanId() {
		return planId;
	}
	public String getDoctor() {
		return doctor;
	}
	public String getStatus() {
		return status;
	}
	public int getScore() {
		return score;
	}
	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
