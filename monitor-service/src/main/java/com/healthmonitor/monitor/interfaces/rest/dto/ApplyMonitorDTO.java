package com.healthmonitor.monitor.interfaces.rest.dto;

public class ApplyMonitorDTO {

	private String account;//用户账号

	private String allergy; //过敏史
	private String injection; //预防注射史
	private String surgery; //外科手术史

	private String symptomDescription;//症状描述
	private String bodyPart;//身体部位
	private String timeDuration;//持续时间
	
	public ApplyMonitorDTO() {
		super();
	}
	

	public ApplyMonitorDTO(String account, String allergy, String injection, String surgery, String symptomDescription,
			String bodyPart, String timeDuration) {
		super();
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

	public void setAccount(String account) {
		this.account = account;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public void setInjection(String injection) {
		this.injection = injection;
	}

	public void setSurgery(String surgery) {
		this.surgery = surgery;
	}

	public void setSymptomDescription(String symptomDescription) {
		this.symptomDescription = symptomDescription;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	public void setTimeDuration(String timeDuration) {
		this.timeDuration = timeDuration;
	}	
}
