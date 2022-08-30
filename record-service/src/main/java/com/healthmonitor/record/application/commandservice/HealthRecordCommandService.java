package com.healthmonitor.record.application.commandservice;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthmonitor.record.domain.command.SaveRecordCommand;
import com.healthmonitor.record.domain.model.aggregate.HealthRecord;
import com.healthmonitor.record.domain.model.aggregate.RecordId;
import com.healthmonitor.record.domain.respository.HealthRecordRepository;

@Service
public class HealthRecordCommandService {

	private HealthRecordRepository healthRecordRepository;
	
	public HealthRecordCommandService(HealthRecordRepository healthRecordRepository) {
		this.healthRecordRepository = healthRecordRepository;
	}
	
	public RecordId handleHealthRecordCreation(SaveRecordCommand saveRecordCommand) {
			
		String recordId = "Record" + UUID.randomUUID().toString().toUpperCase();
		saveRecordCommand.setRecordId(recordId);
		
		HealthRecord healthRecord = new HealthRecord(saveRecordCommand);
		healthRecordRepository.save(healthRecord);
		
		return healthRecord.getRecordId();
	}
}
