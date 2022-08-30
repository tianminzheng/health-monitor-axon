package com.healthmonitor.monitor.interfaces.rest.assembler;

import com.healthmonitor.monitor.domain.command.PerformTaskCommand;
import com.healthmonitor.monitor.interfaces.rest.dto.PerformTaskDTO;

public class PerformTaskCommandDTOAssembler {

	public static PerformTaskCommand toCommandFromDTO(PerformTaskDTO performTaskDTO) {
		
		return new PerformTaskCommand(performTaskDTO.getMonitorId(), performTaskDTO.getTaskId());
	}
}
