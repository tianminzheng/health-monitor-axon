package com.healthmonitor.plan.infrastructure.repository.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.healthmonitor.plan.infrastructure.repository.po.HealthPlanPO;

@Repository
public interface HealthPlanMapper extends JpaRepository<HealthPlanPO, Long>  {
	
	HealthPlanPO findByPlanId(String planId);
}
