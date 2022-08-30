package com.healthmonitor.monitor.interfaces.rest.assembler;

import java.util.UUID;

import com.healthmonitor.domain.model.valueobject.Anamnesis;
import com.healthmonitor.domain.model.valueobject.Symptom;
import com.healthmonitor.monitor.domain.command.GeneratePlanCommand;
import com.healthmonitor.monitor.domain.model.entity.HealthTestOrder;
import com.healthmonitor.monitor.interfaces.rest.dto.GeneratePlanDTO;

public class GeneratePlanCommandDTOAssembler {

	public static GeneratePlanCommand toCommandFromDTO(GeneratePlanDTO generatePlanDTO) {
		
		//构建HealthTestOrder
		Anamnesis anamnesis = new Anamnesis(generatePlanDTO.getAllergy(),generatePlanDTO.getInjection(),generatePlanDTO.getSurgery());
		Symptom symptom = new Symptom(generatePlanDTO.getSymptomDescription(), generatePlanDTO.getBodyPart(), generatePlanDTO.getTimeDuration());
		String orderNumber =  "Order" + UUID.randomUUID().toString().toUpperCase();
		HealthTestOrder order = new HealthTestOrder(orderNumber, generatePlanDTO.getAccount(), anamnesis, symptom);
		
		GeneratePlanCommand generatePlanCommand = new GeneratePlanCommand(generatePlanDTO.getMonitorId(), order);
			
		return generatePlanCommand;
	}
}
