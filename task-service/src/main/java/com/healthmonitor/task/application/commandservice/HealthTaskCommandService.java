package com.healthmonitor.task.application.commandservice;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthmonitor.task.domain.command.CreateTaskCommand;
import com.healthmonitor.task.domain.command.UpdateTaskCommand;
import com.healthmonitor.task.domain.model.aggregate.HealthTask;
import com.healthmonitor.task.domain.model.aggregate.TaskId;
import com.healthmonitor.task.domain.respository.HealthTaskRepository;

@Service
public class HealthTaskCommandService {

	private HealthTaskRepository healthTaskRepository;
	
	public HealthTaskCommandService(HealthTaskRepository healthTaskRepository) {
		this.healthTaskRepository = healthTaskRepository;
	}
	
	public TaskId handleHealthTaskCreation(CreateTaskCommand createTaskCommand) {
		
		String taskId = "Task" + UUID.randomUUID().toString().toUpperCase();
		createTaskCommand.setTaskId(taskId);
		
		HealthTask healthTask = new HealthTask(createTaskCommand);
		healthTaskRepository.save(healthTask);
		
		return healthTask.getTaskId();
	}
	
	public void handleHealthTaskUpdating(UpdateTaskCommand updateTaskCommand) {
		HealthTask healthTask = healthTaskRepository.findByTaskId(updateTaskCommand.getTaskId());
		
		healthTask.updateTask(updateTaskCommand);
		healthTaskRepository.save(healthTask);		
	}
}
