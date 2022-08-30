package com.healthmonitor.monitor.domain.query;

public class HealthMonitorSummaryAccountQuery {

	private String account;
	
	public HealthMonitorSummaryAccountQuery(String account) {
		super();
		this.account = account;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}
