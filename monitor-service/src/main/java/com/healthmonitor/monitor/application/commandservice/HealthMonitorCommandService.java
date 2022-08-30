package com.healthmonitor.monitor.application.commandservice;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.healthmonitor.monitor.domain.command.ApplyMonitorCommand;
import com.healthmonitor.monitor.domain.command.GeneratePlanCommand;
import com.healthmonitor.monitor.domain.command.PerformTaskCommand;
import com.healthmonitor.monitor.domain.model.aggregate.HealthMonitor;
import com.healthmonitor.monitor.domain.model.entity.HealthTestOrder;
import com.healthmonitor.domain.model.entity.HealthPlanProfile;
import com.healthmonitor.domain.model.entity.HealthTaskProfile;
import com.healthmonitor.monitor.integration.acl.AclHealthPlanService;
import com.healthmonitor.monitor.integration.acl.AclHealthTaskService;

@Service
public class HealthMonitorCommandService {

	private CommandGateway commandGateway;
	private AclHealthPlanService aclHealthPlanService;
	private AclHealthTaskService aclHealthTaskService;

	public HealthMonitorCommandService(CommandGateway commandGateway,
			AclHealthPlanService aclHealthPlanService, AclHealthTaskService aclHealthTaskService) {
		this.commandGateway = commandGateway;
		this.aclHealthPlanService = aclHealthPlanService;
		this.aclHealthTaskService = aclHealthTaskService;
	}

	public void handleHealthMonitorApplication(ApplyMonitorCommand applyMonitorCommand) {
		// 生成MonitorId
		String monitorId = "Monitor" + UUID.randomUUID().toString().toUpperCase();
		applyMonitorCommand.setMonitorId(monitorId);
		
		commandGateway.send(applyMonitorCommand);
	}

	public void handleHealthPlanGeneration(GeneratePlanCommand generatePlanCommand) {
		
		// 根据healthMonitor调用Plan界限上下文获取HealthPlan并填充CreatePlanCommand
		HealthPlanProfile healthPlanProfile = aclHealthPlanService.fetchHealthPlan(generatePlanCommand.getOrder());
		generatePlanCommand.setHealthPlanProfile(healthPlanProfile);
		
		commandGateway.send(generatePlanCommand);
	}
	
	public void handleHealthTaskPerforming(PerformTaskCommand performTaskCommand) {
		
		// 根据healthMonitor调用Task界限上下文获取HealthTask并填充PerformTaskCommand	
		HealthTaskProfile healthTaskProfile = aclHealthTaskService.fetchHealthTask(performTaskCommand.getTaskId());
		performTaskCommand.setHealthTaskProfile(healthTaskProfile);
		
		commandGateway.send(performTaskCommand);
	}
}
