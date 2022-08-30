package com.healthmonitor.monitor.integration.acl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.healthmonitor.domain.model.entity.HealthTaskProfile;
import com.healthmonitor.monitor.infrastructure.config.AclConfig;

@Service
public class AclHealthTaskService {
	
	@Autowired
	private AclConfig aclConfig;

    @Autowired
    RestTemplate restTemplate;
    
	public HealthTaskProfile fetchHealthTask(String taskId) {
		ResponseEntity<HealthTaskProfile> result =
                restTemplate.exchange(aclConfig.getTaskUrl(), HttpMethod.GET, null,
                		HealthTaskProfile.class, taskId);

		return result.getBody();
	}	
}
