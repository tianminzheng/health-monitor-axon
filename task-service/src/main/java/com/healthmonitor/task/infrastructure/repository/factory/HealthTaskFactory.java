package com.healthmonitor.task.infrastructure.repository.factory;

import org.springframework.stereotype.Service;

import com.healthmonitor.task.domain.model.aggregate.HealthTask;
import com.healthmonitor.task.domain.model.aggregate.TaskId;
import com.healthmonitor.task.infrastructure.repository.po.HealthTaskPO;

@Service
public class HealthTaskFactory {

	 public HealthTaskPO createHealthTaskPO(HealthTask healthTask){
		 HealthTaskPO healthTaskPO = new HealthTaskPO();
		 healthTaskPO.setTaskId(healthTask.getTaskId().getTaskId());
		 healthTaskPO.setTaskName(healthTask.getTaskName());
		 healthTaskPO.setDescription(healthTask.getDescription());
		 healthTaskPO.setTaskScore(healthTask.getTaskScore());
		 
		 return healthTaskPO;
	 }
	 
	 public HealthTask createHealthTask(HealthTaskPO healthTaskPO){
		 HealthTask healthTask = new HealthTask();
		 healthTask.setTaskId(new TaskId(healthTaskPO.getTaskId()));
		 healthTask.setTaskName(healthTaskPO.getTaskName());
		 healthTask.setDescription(healthTaskPO.getDescription());
		 healthTask.setTaskScore(healthTaskPO.getTaskScore());
		 
		 return healthTask;
	 }
}
