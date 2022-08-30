package com.healthmonitor.task.domain.respository;

import java.util.List;

import com.healthmonitor.task.domain.model.aggregate.HealthTask;

public interface HealthTaskRepository {
	
	void save(HealthTask healthTask);
	
	HealthTask findByTaskId(String taskId);
	
	List<HealthTask> findAll();
}
