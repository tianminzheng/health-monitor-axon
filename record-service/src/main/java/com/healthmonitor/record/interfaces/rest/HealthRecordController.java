package com.healthmonitor.record.interfaces.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthmonitor.record.application.queryservice.HealthRecordQueryService;
import com.healthmonitor.record.domain.model.aggregate.HealthRecord;


@RestController
@RequestMapping(value = "records")
public class HealthRecordController {

	private HealthRecordQueryService healthRecordQueryService;

	public HealthRecordController(HealthRecordQueryService healthRecordQueryService) {
		this.healthRecordQueryService = healthRecordQueryService;
	}
	
	@GetMapping(value = "/list")
	public List<HealthRecord> getRecords() {
		 
		return healthRecordQueryService.findAll();
	}
}
