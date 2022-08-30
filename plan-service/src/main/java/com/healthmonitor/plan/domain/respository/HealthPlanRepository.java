package com.healthmonitor.plan.domain.respository;

import java.util.List;

import com.healthmonitor.plan.domain.model.aggregate.HealthPlan;

public interface HealthPlanRepository {

	void save(HealthPlan healthPlan);
	
	HealthPlan findByPlanId(String planId);
	
	List<HealthPlan> findAll();
}
