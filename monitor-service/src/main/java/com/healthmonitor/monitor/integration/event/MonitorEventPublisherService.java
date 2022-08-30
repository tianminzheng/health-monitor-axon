package com.healthmonitor.monitor.integration.event;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import com.healthmonitor.domain.event.MonitorInitializedEvent;
import com.healthmonitor.domain.event.PlanGeneratedEvent;
import com.healthmonitor.domain.event.TaskPerformedEvent;
import com.healthmonitor.monitor.application.commandservice.HealthMonitorProjectionService;
import com.healthmonitor.monitor.application.queryservice.HealthMonitorQueryService;
import com.healthmonitor.monitor.domain.model.valueobject.MonitorStatus;
import com.healthmonitor.monitor.domain.projection.HealthMonitorSummary;
import com.healthmonitor.monitor.infrastructure.messaging.HealthMonitorSource;

@Service
@EnableBinding(HealthMonitorSource.class)
public class MonitorEventPublisherService{


	private HealthMonitorProjectionService healthMonitorProjectionService;

	private HealthMonitorQueryService healthMonitorQueryService;
	
	private HealthMonitorSource healthMonitorSource;

    public MonitorEventPublisherService(HealthMonitorSource healthMonitorSource,
    		HealthMonitorProjectionService healthMonitorProjectionService,
    		HealthMonitorQueryService healthMonitorQueryService){
        this.healthMonitorSource = healthMonitorSource;
    	this.healthMonitorProjectionService = healthMonitorProjectionService;
    	this.healthMonitorQueryService = healthMonitorQueryService;
    }

	@EventHandler
    public void handleMonitorInitializedEvent(MonitorInitializedEvent monitorInitializedEvent){
    	
    	HealthMonitorSummary healthMonitorSummary = new HealthMonitorSummary();
    	healthMonitorSummary.setAccount(monitorInitializedEvent.getAccount());
    	healthMonitorSummary.setMonitorId(monitorInitializedEvent.getMonitorId());
    	healthMonitorSummary.setStatus(MonitorStatus.INITIALIZED.toString());
    	
    	healthMonitorProjectionService.saveHealthMonitorSummary(healthMonitorSummary);
    	
    	healthMonitorSource.monitorApplication().send(MessageBuilder.withPayload(monitorInitializedEvent).build());
    	
    }

	@EventHandler
    public void handlePlanGeneratedEvent(PlanGeneratedEvent planGeneratedEvent){
    	
    	HealthMonitorSummary healthMonitorSummary = healthMonitorQueryService.findByMonitorId(planGeneratedEvent.getMonitorId()).getHealthMonitorSummary();
    	
    	healthMonitorSummary.setPlanId(planGeneratedEvent.getHealthPlanProfile().getPlanId());
    	healthMonitorSummary.setDoctor(planGeneratedEvent.getHealthPlanProfile().getDoctor());
    	healthMonitorProjectionService.saveHealthMonitorSummary(healthMonitorSummary);
    	
    	healthMonitorSource.planGeneration().send(MessageBuilder.withPayload(planGeneratedEvent).build());
    }

	@EventHandler
    public void handleTaskPerformedEvent(TaskPerformedEvent taskPerformedEvent){
    	HealthMonitorSummary healthMonitorSummary = healthMonitorQueryService.findByMonitorId(taskPerformedEvent.getMonitorId()).getHealthMonitorSummary();
    	
    	int updatedScore = healthMonitorSummary.getScore() + taskPerformedEvent.getHealthScore();
    	healthMonitorSummary.setScore(updatedScore);
    	healthMonitorProjectionService.saveHealthMonitorSummary(healthMonitorSummary);
    	
    	healthMonitorSource.taskPerforming().send(MessageBuilder.withPayload(taskPerformedEvent).build());
    }
}
