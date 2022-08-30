package com.healthmonitor.task.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthmonitor.task.domain.model.aggregate.HealthTask;
import com.healthmonitor.task.domain.respository.HealthTaskRepository;
import com.healthmonitor.task.infrastructure.repository.factory.HealthTaskFactory;
import com.healthmonitor.task.infrastructure.repository.mapper.HealthTaskMapper;
import com.healthmonitor.task.infrastructure.repository.po.HealthTaskPO;

@Repository
public class HealthTaskRepositoryImpl implements HealthTaskRepository {

	private HealthTaskMapper healthTaskMapper;
	private HealthTaskFactory healthTaskFactory;

	public HealthTaskRepositoryImpl(HealthTaskMapper healthTaskMapper,
			HealthTaskFactory healthTaskFactory) {
		this.healthTaskMapper = healthTaskMapper;
		this.healthTaskFactory = healthTaskFactory;
	}
	
	@Override
	public void save(HealthTask healthTask) {
		HealthTaskPO healthTaskPO = healthTaskFactory.createHealthTaskPO(healthTask);
		healthTaskMapper.save(healthTaskPO);
	}

	@Override
	public HealthTask findByTaskId(String taskId) {
		HealthTaskPO healthTaskPO = healthTaskMapper.findByTaskId(taskId);
		return healthTaskFactory.createHealthTask(healthTaskPO);
	}

	@Override
	public List<HealthTask> findAll() {
		List<HealthTaskPO> healthTaskPOs = healthTaskMapper.findAll();
		List<HealthTask> healthTasks = new ArrayList<HealthTask>();
		
		healthTaskPOs.forEach((po) -> {
			HealthTask healthTask = healthTaskFactory.createHealthTask(po);
			healthTasks.add(healthTask);
		});
		return healthTasks;
	}

}
