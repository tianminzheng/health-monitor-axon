package com.healthmonitor.record.domain.model.aggregate;

import com.healthmonitor.record.domain.command.SaveRecordCommand;
import com.healthmonitor.record.domain.model.valueobject.RecordType;

public class HealthRecord {

	private RecordId recordId;
	private String account;
	private RecordType recordType;
	private String recordValue; //记录的编号，来自Monitor、Plan或Task
	private int healthScore;
	
	public HealthRecord() {
		super();
	}

	public HealthRecord(SaveRecordCommand saveRecordCommand) {
		this.recordId = new RecordId(saveRecordCommand.getRecordId());
		
		this.account = saveRecordCommand.getAccount();
		this.recordType = saveRecordCommand.getRecordType();
		this.recordValue = saveRecordCommand.getRecordValue();
		this.healthScore = saveRecordCommand.getHealthScore();
	}

	public RecordId getRecordId() {
		return recordId;
	}

	public void setRecordId(RecordId recordId) {
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
