package com.healthmonitor.record.infrastructure.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface HealthRecordSink {

    @Input("monitorApplicationInput")
    MessageChannel monitorApplication();
    
    @Input("planGenerationInput")
    MessageChannel planGeneration();
	
    @Input("taskPerformingInput")
    MessageChannel taskPerforming();
}
