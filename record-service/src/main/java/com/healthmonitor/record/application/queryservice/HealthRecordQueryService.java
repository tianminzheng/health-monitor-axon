package com.healthmonitor.record.application.queryservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthmonitor.record.domain.model.aggregate.HealthRecord;
import com.healthmonitor.record.domain.respository.HealthRecordRepository;

@Service
public class HealthRecordQueryService {

	private HealthRecordRepository healthRecordRepository;
	
	public HealthRecordQueryService(HealthRecordRepository healthRecordRepository) {

		this.healthRecordRepository = healthRecordRepository;
	}

	public List<HealthRecord> findAll() {
		return healthRecordRepository.findAll();
	}
}
