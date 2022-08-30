package com.healthmonitor.monitor.integration.acl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.healthmonitor.domain.model.entity.HealthPlanProfile;
import com.healthmonitor.interfaces.rest.dto.HealthTestInfoDTO;
import com.healthmonitor.monitor.domain.model.entity.HealthTestOrder;
import com.healthmonitor.monitor.infrastructure.config.AclConfig;

@Service
public class AclHealthPlanService {	

	@Autowired
	private AclConfig aclConfig;

    @Autowired
    RestTemplate restTemplate;
    
	public HealthPlanProfile fetchHealthPlan(HealthTestOrder healthTestOrder) {
		
		HealthTestInfoDTO healthTestInfoDTO = new HealthTestInfoDTO(
				healthTestOrder.getAnamnesis().getAllergy(),
				healthTestOrder.getAnamnesis().getInjection(),
				healthTestOrder.getAnamnesis().getSurgery(),
				healthTestOrder.getSymptom().getSymptomDescription(),
				healthTestOrder.getSymptom().getBodyPart(),
				healthTestOrder.getSymptom().getTimeDuration()
		);
		
		HttpEntity<HealthTestInfoDTO> httpEntity = new HttpEntity<HealthTestInfoDTO>(healthTestInfoDTO);
		ResponseEntity<HealthPlanProfile> result =
                restTemplate.exchange(aclConfig.getPlanUrl(), HttpMethod.POST, httpEntity,
                		HealthPlanProfile.class);

		return result.getBody();
	}		
}
