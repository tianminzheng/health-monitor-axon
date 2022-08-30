package com.healthmonitor.plan.application.commandservice;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthmonitor.plan.domain.command.CreatePlanCommand;
import com.healthmonitor.plan.domain.model.aggregate.HealthPlan;
import com.healthmonitor.plan.domain.model.aggregate.PlanId;
import com.healthmonitor.plan.domain.respository.HealthPlanRepository;

@Service
public class HealthPlanCommandService {

	private HealthPlanRepository healthPlanRepository;
	
	public HealthPlanCommandService(HealthPlanRepository healthPlanRepository) {
		this.healthPlanRepository = healthPlanRepository;
	}
	
	public PlanId handleHealthPlanCreation(CreatePlanCommand createPlanCommand) {
		
		String planId = "Plan" + UUID.randomUUID().toString().toUpperCase();
		createPlanCommand.setPlanId(planId);
		
		HealthPlan healthPlan = new HealthPlan(createPlanCommand);
		healthPlanRepository.save(healthPlan);
		
		return healthPlan.getPlanId();
	}
}
