package com.healthmonitor.monitor.domain.query;

import com.healthmonitor.monitor.domain.projection.HealthMonitorSummary;

public class HealthMonitorSummaryResult {

	private HealthMonitorSummary healthMonitorSummary;
	
	public HealthMonitorSummaryResult(HealthMonitorSummary healthMonitorSummary) {
		super();
		this.healthMonitorSummary = healthMonitorSummary;
	}

	public HealthMonitorSummary getHealthMonitorSummary() {
		return healthMonitorSummary;
	}

	public void setHealthMonitorSummary(HealthMonitorSummary healthMonitorSummary) {
		this.healthMonitorSummary = healthMonitorSummary;
	}

}
