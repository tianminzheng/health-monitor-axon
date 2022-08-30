package com.healthmonitor.domain.model.valueobject;

/**
 * 既往病史
 */
public class Anamnesis {
	
	private String allergy; //过敏史
	private String injection; //预防注射史
	private String surgery; //外科手术史
	
	public Anamnesis(String allergy, String injection, String surgery) {
		super();
		this.allergy = allergy;
		this.injection = injection;
		this.surgery = surgery;
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
}
