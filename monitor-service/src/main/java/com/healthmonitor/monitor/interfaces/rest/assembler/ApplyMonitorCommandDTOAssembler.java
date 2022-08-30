package com.healthmonitor.monitor.interfaces.rest.assembler;

import com.healthmonitor.monitor.domain.command.ApplyMonitorCommand;
import com.healthmonitor.monitor.interfaces.rest.dto.ApplyMonitorDTO;

public class ApplyMonitorCommandDTOAssembler {

	public static ApplyMonitorCommand toCommandFromDTO(ApplyMonitorDTO applyMonitorDTO) {

		return new ApplyMonitorCommand(
				applyMonitorDTO.getAccount(), 
				applyMonitorDTO.getAllergy(),
				applyMonitorDTO.getInjection(), 
				applyMonitorDTO.getSurgery(), 
				applyMonitorDTO.getSymptomDescription(),
				applyMonitorDTO.getBodyPart(), 
				applyMonitorDTO.getTimeDuration());
	}
}
