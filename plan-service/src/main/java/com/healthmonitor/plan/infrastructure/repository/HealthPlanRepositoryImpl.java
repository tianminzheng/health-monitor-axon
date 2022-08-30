package com.healthmonitor.plan.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.healthmonitor.plan.domain.model.aggregate.HealthPlan;
import com.healthmonitor.plan.domain.respository.HealthPlanRepository;
import com.healthmonitor.plan.infrastructure.repository.factory.HealthPlanFactory;
import com.healthmonitor.plan.infrastructure.repository.mapper.HealthPlanMapper;
import com.healthmonitor.plan.infrastructure.repository.po.HealthPlanPO;

@Repository
public class HealthPlanRepositoryImpl implements HealthPlanRepository {

	private HealthPlanMapper healthPlanMapper;
	private HealthPlanFactory healthPlanFactory;

	public HealthPlanRepositoryImpl(HealthPlanMapper healthPlanMapper,
			HealthPlanFactory healthPlanFactory) {
		this.healthPlanMapper = healthPlanMapper;
		this.healthPlanFactory = healthPlanFactory;
	}
	
	@Override
	public void save(HealthPlan healthPlan) {
		HealthPlanPO healthPlanPO = healthPlanFactory.creatHealthPlanPO(healthPlan);
		healthPlanMapper.save(healthPlanPO);
	}

	@Override
	public HealthPlan findByPlanId(String planId) {
		HealthPlanPO healthPlanPO = healthPlanMapper.findByPlanId(planId);
		return healthPlanFactory.creatHealthPlan(healthPlanPO);
	}

	@Override
	public List<HealthPlan> findAll() {
		List<HealthPlanPO> healthPlanPOs = healthPlanMapper.findAll();
		List<HealthPlan> healthPlans = new ArrayList<HealthPlan>();
		
		healthPlanPOs.forEach((po) -> {
			HealthPlan healthPlan = healthPlanFactory.creatHealthPlan(po);
			healthPlans.add(healthPlan);
		});
		return healthPlans;
	}

}
