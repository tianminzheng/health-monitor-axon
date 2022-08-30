package com.healthmonitor.task.infrastructure.repository.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.healthmonitor.task.infrastructure.repository.po.HealthTaskPO;

@Repository
public interface HealthTaskMapper extends JpaRepository<HealthTaskPO, Long>  {
	
	HealthTaskPO findByTaskId(String taskId);
}
