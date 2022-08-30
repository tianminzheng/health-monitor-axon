package com.healthmonitor.record.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthmonitor.record.domain.model.aggregate.HealthRecord;
import com.healthmonitor.record.domain.respository.HealthRecordRepository;
import com.healthmonitor.record.infrastructure.repository.factory.HealthRecordFactory;
import com.healthmonitor.record.infrastructure.repository.mapper.HealthRecordMapper;
import com.healthmonitor.record.infrastructure.repository.po.HealthRecordPO;

@Repository
public class HealthRecordRepositoryImpl implements HealthRecordRepository {

	private HealthRecordMapper healthRecordMapper;
	private HealthRecordFactory healthRecordFactory;

	public HealthRecordRepositoryImpl(HealthRecordMapper healthRecordMapper,
			HealthRecordFactory healthRecordFactory) {
		this.healthRecordMapper = healthRecordMapper;
		this.healthRecordFactory = healthRecordFactory;
	}
	
	@Override
	public void save(HealthRecord healthRecord) {
		HealthRecordPO healthRecordPO = healthRecordFactory.creatHealthRecordPO(healthRecord);
		healthRecordMapper.save(healthRecordPO);
	}

	@Override
	public List<HealthRecord> findAll() {
		List<HealthRecordPO> healthRecordPOs = healthRecordMapper.findAll();
		List<HealthRecord> healthRecords = new ArrayList<HealthRecord>();
		
		healthRecordPOs.forEach((po) -> {
			HealthRecord healthRecord = healthRecordFactory.creatHealthRecord(po);
			healthRecords.add(healthRecord);
		});
		return healthRecords;
	}
}
