package com.healthmonitor.monitor.domain.query;

public class HealthMonitorSummaryMonitorIdQuery {

	private String monitorId;
	
	public HealthMonitorSummaryMonitorIdQuery(String monitorId) {
		super();
		this.monitorId = monitorId;
	}

	public String getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

}
