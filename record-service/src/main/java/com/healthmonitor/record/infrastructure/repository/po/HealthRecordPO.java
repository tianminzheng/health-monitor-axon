package com.healthmonitor.record.infrastructure.repository.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.domain.AbstractAggregateRoot;

import com.healthmonitor.record.domain.event.HealthInfoRecordedEvent;
import com.healthmonitor.record.domain.model.valueobject.RecordType;

@Entity
@Table(name = "health_record")
public class HealthRecordPO extends AbstractAggregateRoot<HealthRecordPO>{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "record_id")
	private String recordId;
	
	private String account;
	@Enumerated(EnumType.STRING)
	private RecordType recordType;
	private String recordValue;
	private int healthScore;	
	
	public HealthRecordPO() {
		super();
	}

	public HealthRecordPO(String recordId, String account, RecordType recordType, String recordValue,
			int healthScore) {
		super();
		this.recordId = recordId;
		this.account = account;
		this.recordType = recordType;
		this.recordValue = recordValue;
		this.healthScore = healthScore;

		//发布HealthInfoRecordedEvent事件，供其他限界上下文进行订阅和消费
		HealthInfoRecordedEvent healthInfoRecordedEvent = new HealthInfoRecordedEvent(account, recordId);
		this.registerEvent(healthInfoRecordedEvent);
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
