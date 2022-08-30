package com.healthmonitor.record.domain.respository;

import java.util.List;

import com.healthmonitor.record.domain.model.aggregate.HealthRecord;

public interface HealthRecordRepository {

	void save(HealthRecord healthRecord);
	
	List<HealthRecord> findAll();
}
