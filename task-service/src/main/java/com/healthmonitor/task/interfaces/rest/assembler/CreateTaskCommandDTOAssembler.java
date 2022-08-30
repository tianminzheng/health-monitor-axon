package com.healthmonitor.task.interfaces.rest.assembler;

import com.healthmonitor.task.domain.command.CreateTaskCommand;
import com.healthmonitor.task.interfaces.rest.dto.CreateTaskDTO;

public class CreateTaskCommandDTOAssembler {

	public static CreateTaskCommand toCommandFromDTO(CreateTaskDTO createTaskDTO) {

		return new CreateTaskCommand(createTaskDTO.getTaskName(), createTaskDTO.getDescription(),
				createTaskDTO.getTaskScore());
	}
}
