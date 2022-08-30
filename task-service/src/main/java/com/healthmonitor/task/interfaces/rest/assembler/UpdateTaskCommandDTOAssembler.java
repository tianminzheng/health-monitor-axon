package com.healthmonitor.task.interfaces.rest.assembler;

import com.healthmonitor.task.domain.command.UpdateTaskCommand;
import com.healthmonitor.task.interfaces.rest.dto.UpdateTaskDTO;

public class UpdateTaskCommandDTOAssembler {

	public static UpdateTaskCommand toCommandFromDTO(UpdateTaskDTO updateTaskDTO) {

		return new UpdateTaskCommand(updateTaskDTO.getTaskId(), updateTaskDTO.getDescription(),
				updateTaskDTO.getTaskScore());
	}
}
