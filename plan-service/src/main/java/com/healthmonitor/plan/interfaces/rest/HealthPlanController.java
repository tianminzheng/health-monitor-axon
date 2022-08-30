package com.healthmonitor.plan.interfaces.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthmonitor.domain.model.entity.HealthPlanProfile;
import com.healthmonitor.interfaces.rest.dto.HealthTestInfoDTO;
import com.healthmonitor.plan.application.commandservice.HealthPlanCommandService;
import com.healthmonitor.plan.application.queryservice.HealthPlanQueryService;
import com.healthmonitor.plan.domain.command.CreatePlanCommand;
import com.healthmonitor.plan.domain.model.aggregate.HealthPlan;
import com.healthmonitor.plan.domain.model.aggregate.PlanId;
import com.healthmonitor.plan.interfaces.rest.assembler.CreatePlanCommandDTOAssembler;
import com.healthmonitor.plan.interfaces.rest.dto.CreatePlanDTO;

@RestController
@RequestMapping(value = "plans")
public class HealthPlanController {

	private HealthPlanCommandService healthPlanCommandService;
	private HealthPlanQueryService healthPlanQueryService;

	public HealthPlanController(HealthPlanCommandService healthPlanCommandService,
			HealthPlanQueryService healthPlanQueryService) {
		this.healthPlanCommandService = healthPlanCommandService;
		this.healthPlanQueryService = healthPlanQueryService;
	}
	
	@PostMapping(value = "/optimal")
	public HealthPlanProfile getOptimalPlan(@RequestBody HealthTestInfoDTO healthTestInfoDTO) {
		 
		List<HealthPlan> healthPlans = healthPlanQueryService.findAll();
		
		//这里对专业的健康计划制定流程做简化处理，默认以HealthPlan列表的第一个作为最优健康计划
		HealthPlan optimalPlan = healthPlans.get(0);
		
		return convertHealthPlanProfile(optimalPlan);
	}
	
	@PostMapping(value = "/")
	public PlanId createPlan(@RequestBody CreatePlanDTO createPlanDTO) {
		
		CreatePlanCommand createPlanCommand = CreatePlanCommandDTOAssembler.toCommandFromDTO(createPlanDTO);
		return healthPlanCommandService.handleHealthPlanCreation(createPlanCommand);
	}
	
	@GetMapping(value = "/list")
	public List<HealthPlan> getPlans() {
		 
		return healthPlanQueryService.findAll();
	}
	
	private HealthPlanProfile convertHealthPlanProfile(HealthPlan optimalPlan) {		
		HealthPlanProfile healthPlanProfile = new HealthPlanProfile(
				optimalPlan.getPlanId().getPlanId(), 
				optimalPlan.getAccount(), 
				optimalPlan.getDoctor(), 
				optimalPlan.getDescription(),
				optimalPlan.getTasks());
		
		return healthPlanProfile;
	}
}
