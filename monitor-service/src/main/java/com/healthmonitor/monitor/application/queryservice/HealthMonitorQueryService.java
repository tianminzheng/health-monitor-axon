package com.healthmonitor.monitor.application.queryservice;

import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import com.healthmonitor.monitor.domain.query.HealthMonitorSummaryAccountQuery;
import com.healthmonitor.monitor.domain.query.HealthMonitorSummaryEmptyQuery;
import com.healthmonitor.monitor.domain.query.HealthMonitorSummaryListResult;
import com.healthmonitor.monitor.domain.query.HealthMonitorSummaryMonitorIdQuery;
import com.healthmonitor.monitor.domain.query.HealthMonitorSummaryResult;

@Service
public class HealthMonitorQueryService {

	private QueryGateway queryGateway;

	public HealthMonitorQueryService(QueryGateway queryGateway) {
		this.queryGateway = queryGateway;
	}

	public HealthMonitorSummaryResult findByMonitorId(String monitorId) {

		HealthMonitorSummaryMonitorIdQuery healthMonitorSummaryMonitorIdQuery = new HealthMonitorSummaryMonitorIdQuery(monitorId);
		HealthMonitorSummaryResult healthMonitorSummaryResult = queryGateway.query(healthMonitorSummaryMonitorIdQuery,
				HealthMonitorSummaryResult.class).join();

	    return healthMonitorSummaryResult;	
	}
	
	public HealthMonitorSummaryListResult findByUserAccount(String account) {

		HealthMonitorSummaryAccountQuery healthMonitorSummaryAccountQuery = new HealthMonitorSummaryAccountQuery(account);
		HealthMonitorSummaryListResult healthMonitorSummaryResult = queryGateway.query(healthMonitorSummaryAccountQuery,
				HealthMonitorSummaryListResult.class).join();

	    return healthMonitorSummaryResult;	
	}
	
	public HealthMonitorSummaryListResult findAll() {

		HealthMonitorSummaryEmptyQuery healthMonitorSummaryEmptyQuery = new HealthMonitorSummaryEmptyQuery();
		HealthMonitorSummaryListResult healthMonitorSummaryResult = queryGateway.query(healthMonitorSummaryEmptyQuery,
				HealthMonitorSummaryListResult.class).join();

	    return healthMonitorSummaryResult;	
	}
}
