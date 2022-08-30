package com.healthmonitor.task.interfaces.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthmonitor.domain.model.entity.HealthTaskProfile;
import com.healthmonitor.task.application.commandservice.HealthTaskCommandService;
import com.healthmonitor.task.application.queryservice.HealthTaskQueryService;
import com.healthmonitor.task.domain.command.CreateTaskCommand;
import com.healthmonitor.task.domain.command.UpdateTaskCommand;
import com.healthmonitor.task.domain.model.aggregate.HealthTask;
import com.healthmonitor.task.interfaces.rest.assembler.CreateTaskCommandDTOAssembler;
import com.healthmonitor.task.interfaces.rest.assembler.UpdateTaskCommandDTOAssembler;
import com.healthmonitor.task.interfaces.rest.dto.CreateTaskDTO;
import com.healthmonitor.task.interfaces.rest.dto.UpdateTaskDTO;

@RestController
@RequestMapping(value = "tasks")
public class HealthTaskController {

	private HealthTaskCommandService healthTaskCommandService;
	private HealthTaskQueryService healthTaskQueryService;

	public HealthTaskController(HealthTaskCommandService healthTaskCommandService,
			HealthTaskQueryService healthTaskQueryService) {
		this.healthTaskCommandService = healthTaskCommandService;
		this.healthTaskQueryService = healthTaskQueryService;
	}	
	
	@GetMapping(value = "/{taskId}")
	public HealthTaskProfile getTask(@PathVariable String taskId) {
		HealthTask healthTask = healthTaskQueryService.findByTaskId(taskId);
		
		return convertHealthTaskProfile(healthTask);
	}
	
	@PostMapping(value = "/")
	public void createTask(@RequestBody CreateTaskDTO createTaskDTO) {
		
		CreateTaskCommand createTaskCommand = CreateTaskCommandDTOAssembler.toCommandFromDTO(createTaskDTO);
		healthTaskCommandService.handleHealthTaskCreation(createTaskCommand);
	}
	
	@PutMapping(value = "/")
	public void updateTask(@RequestBody UpdateTaskDTO updateTaskDTO) {
		
		UpdateTaskCommand updateTaskCommand = UpdateTaskCommandDTOAssembler.toCommandFromDTO(updateTaskDTO);
		healthTaskCommandService.handleHealthTaskUpdating(updateTaskCommand);
	}
	
	public HealthTaskProfile convertHealthTaskProfile(HealthTask healthTask){
		HealthTaskProfile healthTaskProfile = new HealthTaskProfile();
		healthTaskProfile.setTaskId(healthTask.getTaskId().getTaskId());
		healthTaskProfile.setTaskName(healthTask.getTaskName());
		healthTaskProfile.setDescription(healthTask.getDescription());
		healthTaskProfile.setTaskScore(healthTask.getTaskScore());
		 
		return healthTaskProfile;
	}
}
