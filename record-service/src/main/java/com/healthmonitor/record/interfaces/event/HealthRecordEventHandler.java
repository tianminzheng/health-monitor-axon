package com.healthmonitor.record.interfaces.event;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import com.healthmonitor.domain.event.MonitorInitializedEvent;
import com.healthmonitor.domain.event.PlanGeneratedEvent;
import com.healthmonitor.domain.event.TaskPerformedEvent;
import com.healthmonitor.record.application.commandservice.HealthRecordCommandService;
import com.healthmonitor.record.domain.command.SaveRecordCommand;
import com.healthmonitor.record.infrastructure.messaging.HealthRecordSink;
import com.healthmonitor.record.interfaces.event.assembler.SaveRecordCommandDTOAssembler;

@Service
@EnableBinding(HealthRecordSink.class)
public class HealthRecordEventHandler {

	private HealthRecordCommandService healthRecordCommandService;
	
	public HealthRecordEventHandler(HealthRecordCommandService healthRecordCommandService) {
		this.healthRecordCommandService = healthRecordCommandService;
	}	
	
	@StreamListener("monitorApplicationInput")
	public void handleMonitorInitializedEvent(MonitorInitializedEvent monitorInitializedEvent) {  
		//添加针对MonitorInitializedEvent的处理逻辑
		SaveRecordCommand saveRecordCommand = SaveRecordCommandDTOAssembler.toCommandFromDTO(monitorInitializedEvent);
		healthRecordCommandService.handleHealthRecordCreation(saveRecordCommand);
	}
	
	@StreamListener("planGenerationInput")
	public void handlePlanGeneratedEvent(PlanGeneratedEvent planGeneratedEvent) {  
		//添加针对PlanGeneratedEvent的处理逻辑
		SaveRecordCommand saveRecordCommand = SaveRecordCommandDTOAssembler.toCommandFromDTO(planGeneratedEvent);
		healthRecordCommandService.handleHealthRecordCreation(saveRecordCommand);
	}
	
	@StreamListener("taskPerformingInput")
	public void handleTaskPerformedEvent(TaskPerformedEvent taskPerformedEvent) {  
		//添加针对TaskPerformedEvent的处理逻辑
		SaveRecordCommand saveRecordCommand = SaveRecordCommandDTOAssembler.toCommandFromDTO(taskPerformedEvent);
		healthRecordCommandService.handleHealthRecordCreation(saveRecordCommand);
	}
}
