package com.healthmonitor.record.domain.event;

import com.healthmonitor.domain.event.DomainEvent;

public class HealthInfoRecordedEvent extends DomainEvent {

	private String recordId;
	private String account;
	
	public HealthInfoRecordedEvent(String account, String recordId) {
		super();
		this.recordId = recordId;
		this.account = account;
	}

	public String getRecordId() {
		return recordId;
	}

	public String getAccount() {
		return account;
	}
}
