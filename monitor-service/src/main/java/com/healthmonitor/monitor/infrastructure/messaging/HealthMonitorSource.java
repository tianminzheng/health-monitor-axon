package com.healthmonitor.monitor.infrastructure.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface HealthMonitorSource {

    @Output("monitorApplicationOutput")
    MessageChannel monitorApplication();
    
	@Output("planGenerationOutput")
    MessageChannel planGeneration();
	
	@Output("taskPerformingOutput")
    MessageChannel taskPerforming();
}
