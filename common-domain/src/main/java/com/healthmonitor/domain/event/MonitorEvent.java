package com.healthmonitor.domain.event;

public abstract class MonitorEvent extends DomainEvent {

	private String monitorId;
	private String account;
	private int score;

	public MonitorEvent(String monitorId, String account, int score) {
		super();
		this.monitorId = monitorId;
		this.account = account;
		this.score = score;
	}

	public String getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	
}
