package com.healthmonitor.plan.application.queryservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthmonitor.plan.domain.model.aggregate.HealthPlan;
import com.healthmonitor.plan.domain.respository.HealthPlanRepository;

@Service
public class HealthPlanQueryService {

	private HealthPlanRepository healthPlanRepository;
	
	public HealthPlanQueryService(HealthPlanRepository healthPlanRepository) {
		this.healthPlanRepository = healthPlanRepository;
	}

	public HealthPlan findByPlanId(String PlanId) {
		return healthPlanRepository.findByPlanId(PlanId);
	}

	public List<HealthPlan> findAll() {
		return healthPlanRepository.findAll();
	}
}
