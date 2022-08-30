package com.healthmonitor.monitor.domain.query;

import java.util.List;

import com.healthmonitor.monitor.domain.projection.HealthMonitorSummary;


public class HealthMonitorSummaryListResult {

	private List<HealthMonitorSummary> healthMonitorSummaries;
	
	public HealthMonitorSummaryListResult(List<HealthMonitorSummary> healthMonitorSummaries) {
		super();
		this.healthMonitorSummaries = healthMonitorSummaries;
	}

	public List<HealthMonitorSummary> getHealthMonitorSummaries() {
		return healthMonitorSummaries;
	}

	public void setHealthMonitorSummaries(List<HealthMonitorSummary> healthMonitorSummaries) {
		this.healthMonitorSummaries = healthMonitorSummaries;
	}
}
