package com.healthmonitor.monitor.interfaces.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthmonitor.monitor.application.commandservice.HealthMonitorCommandService;
import com.healthmonitor.monitor.application.queryservice.HealthMonitorQueryService;
import com.healthmonitor.monitor.domain.command.ApplyMonitorCommand;
import com.healthmonitor.monitor.domain.command.GeneratePlanCommand;
import com.healthmonitor.monitor.domain.command.PerformTaskCommand;
import com.healthmonitor.monitor.domain.projection.HealthMonitorSummary;
import com.healthmonitor.monitor.interfaces.rest.assembler.ApplyMonitorCommandDTOAssembler;
import com.healthmonitor.monitor.interfaces.rest.assembler.GeneratePlanCommandDTOAssembler;
import com.healthmonitor.monitor.interfaces.rest.assembler.PerformTaskCommandDTOAssembler;
import com.healthmonitor.monitor.interfaces.rest.dto.ApplyMonitorDTO;
import com.healthmonitor.monitor.interfaces.rest.dto.GeneratePlanDTO;
import com.healthmonitor.monitor.interfaces.rest.dto.PerformTaskDTO;

@RestController
@RequestMapping(value = "monitors")
public class HealthMonitorController {

	private HealthMonitorCommandService healthMonitorCommandService;
	private HealthMonitorQueryService healthMonitorQueryService;

	public HealthMonitorController(HealthMonitorCommandService healthMonitorCommandService,
			HealthMonitorQueryService healthMonitorQueryService) {
		this.healthMonitorCommandService = healthMonitorCommandService;
		this.healthMonitorQueryService = healthMonitorQueryService;
	}

	@GetMapping(value = "/")
	public  List<HealthMonitorSummary> getAllHealthMonitor() {
		List<HealthMonitorSummary> healthMonitorSummaries = healthMonitorQueryService.findAll().getHealthMonitorSummaries();
		return healthMonitorSummaries;
	}
	
	@GetMapping(value = "/{monitorId}")
	public HealthMonitorSummary getHealthMonitorById(@PathVariable String monitorId) {
		HealthMonitorSummary healthMonitorSummary = healthMonitorQueryService.findByMonitorId(monitorId).getHealthMonitorSummary();
		return healthMonitorSummary;
	}
	
	@PostMapping(value = "/application")
	public void applyMonitor(@RequestBody ApplyMonitorDTO applyMonitorDTO) {
		ApplyMonitorCommand applyMonitorCommand = ApplyMonitorCommandDTOAssembler.toCommandFromDTO(applyMonitorDTO);
		healthMonitorCommandService.handleHealthMonitorApplication(applyMonitorCommand);
	}

	@PostMapping(value = "/plan")
	public void createPlan(@RequestBody GeneratePlanDTO createPlanDTO) {
		GeneratePlanCommand createPlanCommand = GeneratePlanCommandDTOAssembler.toCommandFromDTO(createPlanDTO);
		healthMonitorCommandService.handleHealthPlanGeneration(createPlanCommand);
	}
	
	@PostMapping(value = "/task")
	public void performPlan(@RequestBody PerformTaskDTO performTaskDTO) {
		PerformTaskCommand performTaskCommand = PerformTaskCommandDTOAssembler.toCommandFromDTO(performTaskDTO);
		healthMonitorCommandService.handleHealthTaskPerforming(performTaskCommand);
	}
}
