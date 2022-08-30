package com.healthmonitor.domain.event;

import com.healthmonitor.domain.model.entity.HealthPlanProfile;

public class PlanGeneratedEvent extends MonitorEvent {

	private HealthPlanProfile healthPlanProfile;

	public PlanGeneratedEvent(String monitorId, HealthPlanProfile healthPlanProfile, int score) {
		super(monitorId, healthPlanProfile.getAccount(), score);
		this.healthPlanProfile = healthPlanProfile;
	}

	public HealthPlanProfile getHealthPlanProfile() {
		return healthPlanProfile;
	}
}
