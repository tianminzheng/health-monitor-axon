package com.healthmonitor.monitor.infrastructure.repository.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthmonitor.monitor.domain.projection.HealthMonitorSummary;

@Repository
public interface HealthMonitorSummaryMapper extends JpaRepository<HealthMonitorSummary, Long>  {

	HealthMonitorSummary findByMonitorId(String monitor);
	
	List<HealthMonitorSummary> findByAccount(String account);
}
