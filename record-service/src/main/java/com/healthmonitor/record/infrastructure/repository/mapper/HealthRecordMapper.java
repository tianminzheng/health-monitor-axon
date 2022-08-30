package com.healthmonitor.record.infrastructure.repository.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthmonitor.record.infrastructure.repository.po.HealthRecordPO;

@Repository
public interface HealthRecordMapper extends JpaRepository<HealthRecordPO, Long>  {
	
}
