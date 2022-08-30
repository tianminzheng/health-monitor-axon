package com.healthmonitor.monitor.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AclConfig {

	@Value("${plan.service.url}")
    private String planUrl;
	
	@Value("${task.service.url}")
    private String taskUrl;

	public String getPlanUrl() {
		return planUrl;
	}

	public String getTaskUrl() {
		return taskUrl;
	}
}
