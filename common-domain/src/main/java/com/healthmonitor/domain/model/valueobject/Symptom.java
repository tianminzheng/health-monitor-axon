package com.healthmonitor.domain.model.valueobject;

/**
 * 症状
 */
public class Symptom {

	private String symptomDescription;//症状描述
	private String bodyPart;//身体部位
	private String timeDuration;//持续时间	
	
	public Symptom(String symptomDescription, String bodyPart, String timeDuration) {
		super();
		this.symptomDescription = symptomDescription;
		this.bodyPart = bodyPart;
		this.timeDuration = timeDuration;
	}
	
	public String getSymptomDescription() {
		return symptomDescription;
	}
	public void setSymptomDescription(String symptomDescription) {
		this.symptomDescription = symptomDescription;
	}
	public String getBodyPart() {
		return bodyPart;
	}
	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}
	public String getTimeDuration() {
		return timeDuration;
	}
	public void setTimeDuration(String timeDuration) {
		this.timeDuration = timeDuration;
	}	
	
}
