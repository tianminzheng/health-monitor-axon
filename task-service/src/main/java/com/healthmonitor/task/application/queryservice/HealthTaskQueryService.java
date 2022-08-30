package com.healthmonitor.task.application.queryservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthmonitor.task.domain.model.aggregate.HealthTask;
import com.healthmonitor.task.domain.respository.HealthTaskRepository;

@Service
public class HealthTaskQueryService {

	private HealthTaskRepository healthTaskRepository;
	
	public HealthTaskQueryService(HealthTaskRepository healthTaskRepository) {

		this.healthTaskRepository = healthTaskRepository;
	}

	public HealthTask findByTaskId(String taskId) {
		return healthTaskRepository.findByTaskId(taskId);
	}

	public List<HealthTask> findAll() {
		return healthTaskRepository.findAll();
	}
}
