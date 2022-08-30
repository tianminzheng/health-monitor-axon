package com.healthmonitor.record.infrastructure.repository.factory;

import org.springframework.stereotype.Service;

import com.healthmonitor.record.domain.model.aggregate.HealthRecord;
import com.healthmonitor.record.domain.model.aggregate.RecordId;
import com.healthmonitor.record.infrastructure.repository.po.HealthRecordPO;

@Service
public class HealthRecordFactory {

	 public HealthRecordPO creatHealthRecordPO(HealthRecord healthRecord){
		 HealthRecordPO healthRecordPO = new HealthRecordPO(
				 healthRecord.getRecordId().getRecordId(),
				 healthRecord.getAccount(),
				 healthRecord.getRecordType(),
				 healthRecord.getRecordValue(),
				 healthRecord.getHealthScore()
		 );
		 
		 return healthRecordPO;
	 }
	 
	 public HealthRecord creatHealthRecord(HealthRecordPO healthRecordPO){
		 HealthRecord healthRecord = new HealthRecord();
		 healthRecord.setRecordId(new RecordId(healthRecordPO.getRecordId()));
		 healthRecord.setAccount(healthRecordPO.getAccount());
		 healthRecord.setRecordType(healthRecordPO.getRecordType());
		 healthRecord.setRecordValue(healthRecordPO.getRecordValue());
		 healthRecord.setHealthScore(healthRecordPO.getHealthScore());
		 
		 return healthRecord;
	 }
}
