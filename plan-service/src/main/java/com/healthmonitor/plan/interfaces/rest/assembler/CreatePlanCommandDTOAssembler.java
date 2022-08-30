package com.healthmonitor.plan.interfaces.rest.assembler;

import com.healthmonitor.plan.domain.command.CreatePlanCommand;
import com.healthmonitor.plan.interfaces.rest.dto.CreatePlanDTO;

public class CreatePlanCommandDTOAssembler {

	public static CreatePlanCommand toCommandFromDTO(CreatePlanDTO createPlanDTO) {
		
		CreatePlanCommand createPlanCommand = new CreatePlanCommand();
		createPlanCommand.setAccount(createPlanDTO.getAccount());
		createPlanCommand.setDescription(createPlanDTO.getDescription());
		createPlanCommand.setDoctor(createPlanDTO.getDoctor());
		createPlanCommand.setTasks(createPlanDTO.getTasks());
		
		return createPlanCommand;
	}
}
