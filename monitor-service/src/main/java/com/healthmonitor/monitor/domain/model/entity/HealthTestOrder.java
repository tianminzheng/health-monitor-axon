package com.healthmonitor.monitor.domain.model.entity;

import com.healthmonitor.domain.model.valueobject.Anamnesis;
import com.healthmonitor.domain.model.valueobject.Symptom;
import com.healthmonitor.monitor.domain.model.valueobject.OrderStatus;

/**
 * 健康检测单
 */
public class HealthTestOrder {

	private String orderNumber;//检测单编号
	private String account;//用户账户
	private Anamnesis anamnesis;//既往病史
	private Symptom symptom;//症状
	private OrderStatus orderStatus;//检测单状态	
	
	public HealthTestOrder(Anamnesis anamnesis, Symptom symptom) {
		super();
		this.anamnesis = anamnesis;
		this.symptom = symptom;
	}	
	
	public HealthTestOrder(String orderNumber, String account, Anamnesis anamnesis, Symptom symptom) {
		this(anamnesis, symptom);
		this.orderNumber = orderNumber;
		this.account = account;
		this.orderStatus = OrderStatus.CREATED;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public String getAccount() {
		return account;
	}

	public Anamnesis getAnamnesis() {
		return anamnesis;
	}

	public Symptom getSymptom() {
		return symptom;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public void setAccount(String account) {
		this.account = account;
	}

	public void setAnamnesis(Anamnesis anamnesis) {
		this.anamnesis = anamnesis;
	}

	public void setSymptom(Symptom symptom) {
		this.symptom = symptom;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

}
