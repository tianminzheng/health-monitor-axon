package com.healthmonitor.monitor.application.commandservice;

import org.springframework.stereotype.Service;

import com.healthmonitor.monitor.domain.projection.HealthMonitorSummary;
import com.healthmonitor.monitor.infrastructure.repository.mapper.HealthMonitorSummaryMapper;

@Service
public class HealthMonitorProjectionService {

	private HealthMonitorSummaryMapper healthMonitorSummaryMapper;

	public HealthMonitorProjectionService(HealthMonitorSummaryMapper healthMonitorSummaryMapper) {
		this.healthMonitorSummaryMapper = healthMonitorSummaryMapper;
	}

	public void saveHealthMonitorSummary(HealthMonitorSummary healthMonitorSummary) {
		healthMonitorSummaryMapper.save(healthMonitorSummary);
	}
}
