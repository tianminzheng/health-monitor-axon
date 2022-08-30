package com.healthmonitor.monitor.application.queryservice;

import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import com.healthmonitor.monitor.domain.projection.HealthMonitorSummary;
import com.healthmonitor.monitor.domain.query.HealthMonitorSummaryAccountQuery;
import com.healthmonitor.monitor.domain.query.HealthMonitorSummaryEmptyQuery;
import com.healthmonitor.monitor.domain.query.HealthMonitorSummaryListResult;
import com.healthmonitor.monitor.domain.query.HealthMonitorSummaryMonitorIdQuery;
import com.healthmonitor.monitor.domain.query.HealthMonitorSummaryResult;
import com.healthmonitor.monitor.infrastructure.repository.mapper.HealthMonitorSummaryMapper;

@Service
public class HealthMonitorQueryHandler {

	private HealthMonitorSummaryMapper healthMonitorSummaryMapper;

	public HealthMonitorQueryHandler(HealthMonitorSummaryMapper healthMonitorSummaryMapper) {
		this.healthMonitorSummaryMapper = healthMonitorSummaryMapper;
	}

	@QueryHandler
	public HealthMonitorSummaryResult handle(HealthMonitorSummaryMonitorIdQuery healthMonitorSummaryQuery) {
		
		HealthMonitorSummary healthMonitorSummary = healthMonitorSummaryMapper.findByMonitorId(healthMonitorSummaryQuery.getMonitorId());
		HealthMonitorSummaryResult healthMonitorSummaryResult = new HealthMonitorSummaryResult(healthMonitorSummary);
		return healthMonitorSummaryResult;
	}

	@QueryHandler
	public HealthMonitorSummaryListResult handle(HealthMonitorSummaryAccountQuery healthMonitorSummaryAccountQuery) {
		
		List<HealthMonitorSummary> healthMonitorSummaries = healthMonitorSummaryMapper.findByAccount(healthMonitorSummaryAccountQuery.getAccount());
		HealthMonitorSummaryListResult healthMonitorSummaryListResult = new HealthMonitorSummaryListResult(healthMonitorSummaries);
		return healthMonitorSummaryListResult;
	}
	
	@QueryHandler
	public HealthMonitorSummaryListResult handle(HealthMonitorSummaryEmptyQuery healthMonitorSummaryEmptyQuery) {
		
		List<HealthMonitorSummary> healthMonitorSummaries = healthMonitorSummaryMapper.findAll();
		HealthMonitorSummaryListResult healthMonitorSummaryListResult = new HealthMonitorSummaryListResult(healthMonitorSummaries);
		return healthMonitorSummaryListResult;
	}
}
