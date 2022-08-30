package com.healthmonitor.record.interfaces.event.assembler;

import com.healthmonitor.domain.event.DomainEvent;
import com.healthmonitor.domain.event.MonitorEvent;
import com.healthmonitor.domain.event.MonitorInitializedEvent;
import com.healthmonitor.domain.event.PlanGeneratedEvent;
import com.healthmonitor.domain.event.TaskPerformedEvent;
import com.healthmonitor.record.domain.command.SaveRecordCommand;
import com.healthmonitor.record.domain.model.valueobject.RecordType;

public class SaveRecordCommandDTOAssembler {

	public static SaveRecordCommand toCommandFromDTO(DomainEvent domainEvent) {
		
		MonitorEvent monitorEvent = (MonitorEvent)domainEvent;

		String account = monitorEvent.getAccount();
		int healthScore = monitorEvent.getScore();
		RecordType recordType = null;
		String recordValue = null;
		
		if(monitorEvent instanceof MonitorInitializedEvent) {			
			recordType = RecordType.MONITOR;
			recordValue = ((MonitorInitializedEvent)monitorEvent).getMonitorId();
		} else if(monitorEvent instanceof PlanGeneratedEvent) {
			recordType = RecordType.PLAN;
			recordValue = ((PlanGeneratedEvent)monitorEvent).getHealthPlanProfile().getPlanId();
		} else if(monitorEvent instanceof TaskPerformedEvent) {
			recordType = RecordType.TASK;
			recordValue = ((TaskPerformedEvent)monitorEvent).getTaskId();
		} 
		
		return new SaveRecordCommand(account, recordType, recordValue, healthScore);
	}
}
