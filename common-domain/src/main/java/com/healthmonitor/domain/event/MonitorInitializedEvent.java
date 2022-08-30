package com.healthmonitor.domain.event;

public class MonitorInitializedEvent extends MonitorEvent {

	private String account;

	private String allergy; 
	private String injection; 
	private String surgery; 

	private String symptomDescription;
	private String bodyPart;
	private String timeDuration;
	
	public MonitorInitializedEvent(String monitorId, String account, String allergy, String injection, String surgery,
			String symptomDescription, String bodyPart, String timeDuration, int score) {
		super(monitorId, account, score);
		this.account = account;
		this.allergy = allergy;
		this.injection = injection;
		this.surgery = surgery;
		this.symptomDescription = symptomDescription;
		this.bodyPart = bodyPart;
		this.timeDuration = timeDuration;
	}

	public String getAccount() {
		return account;
	}

	public String getAllergy() {
		return allergy;
	}

	public String getInjection() {
		return injection;
	}

	public String getSurgery() {
		return surgery;
	}

	public String getSymptomDescription() {
		return symptomDescription;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public String getTimeDuration() {
		return timeDuration;
	}
}
