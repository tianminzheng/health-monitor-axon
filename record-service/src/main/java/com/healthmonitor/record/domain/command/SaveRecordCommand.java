package com.healthmonitor.record.domain.command;

import com.healthmonitor.record.domain.model.valueobject.RecordType;

public class SaveRecordCommand {

	private String recordId;
	private String account;
	private RecordType recordType;
	private String recordValue; //记录的编号，来自Monitor、Plan或Task
	private int healthScore;
	
	public SaveRecordCommand(String account, RecordType recordType, String recordValue,
			int healthScore) {
		super();
		this.account = account;
		this.recordType = recordType;
		this.recordValue = recordValue;
		this.healthScore = healthScore;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public RecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(RecordType recordType) {
		this.recordType = recordType;
	}

	public String getRecordValue() {
		return recordValue;
	}

	public void setRecordValue(String recordValue) {
		this.recordValue = recordValue;
	}

	public int getHealthScore() {
		return healthScore;
	}

	public void setHealthScore(int healthScore) {
		this.healthScore = healthScore;
	}	
}
