package com.healthmonitor.plan.domain.model.aggregate;

/**
 * HealthPlan聚合的聚合标识符
 */
public class PlanId {

	private String planId;
	
	public PlanId(String planId) {
		super();
		this.planId = planId;
	}

	public String getPlanId() {
		return planId;
	}		
}
