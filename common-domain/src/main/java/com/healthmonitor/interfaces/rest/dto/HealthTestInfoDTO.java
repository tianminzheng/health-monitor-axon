package com.healthmonitor.interfaces.rest.dto;

import java.io.Serializable;

public class HealthTestInfoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String allergy; //过敏史
	private String injection; //预防注射史
	private String surgery; //外科手术史

	private String symptomDescription;//症状描述
	private String bodyPart;//身体部位
	private String timeDuration;//持续时间		
		
	public HealthTestInfoDTO() {
		
	}
	
	public HealthTestInfoDTO(String allergy, String injection, String surgery, String symptomDescription,
			String bodyPart, String timeDuration) {
		super();
		this.allergy = allergy;
		this.injection = injection;
		this.surgery = surgery;
		this.symptomDescription = symptomDescription;
		this.bodyPart = bodyPart;
		this.timeDuration = timeDuration;
	}
	
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public String getInjection() {
		return injection;
	}
	public void setInjection(String injection) {
		this.injection = injection;
	}
	public String getSurgery() {
		return surgery;
	}
	public void setSurgery(String surgery) {
		this.surgery = surgery;
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
