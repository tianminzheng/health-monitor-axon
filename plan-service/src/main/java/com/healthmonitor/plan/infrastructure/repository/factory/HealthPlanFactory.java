package com.healthmonitor.plan.infrastructure.repository.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.healthmonitor.domain.model.entity.HealthTaskProfile;
import com.healthmonitor.plan.domain.model.aggregate.HealthPlan;
import com.healthmonitor.plan.domain.model.aggregate.PlanId;
import com.healthmonitor.plan.infrastructure.repository.po.HealthPlanPO;
import com.healthmonitor.plan.infrastructure.repository.po.HealthTaskPO;

@Service
public class HealthPlanFactory {

	 public HealthPlanPO creatHealthPlanPO(HealthPlan healthPlan){
		 HealthPlanPO healthPlanPO = new HealthPlanPO();
		 healthPlanPO.setPlanId(healthPlan.getPlanId().getPlanId());
		 healthPlanPO.setAccount(healthPlan.getAccount());
		 healthPlanPO.setDoctor(healthPlan.getDoctor());
		 healthPlanPO.setDescription(healthPlan.getDescription());
		 
		 List<HealthTaskPO> healthTaskPOs = new ArrayList<HealthTaskPO>();
		 for(HealthTaskProfile healthTaskProfile : healthPlan.getTasks()) {
			 HealthTaskPO healthTaskPO = createHealthTaskPO(healthTaskProfile);
			 healthTaskPO.setPlan(healthPlanPO);
			 healthTaskPOs.add(healthTaskPO);
		 }		
		 healthPlanPO.setTasks(healthTaskPOs);
		 
		 return healthPlanPO;
	 }
	 
	 public HealthPlan creatHealthPlan(HealthPlanPO healthPlanPO){
		 HealthPlan healthPlan = new HealthPlan();
		 healthPlan.setAccount(healthPlanPO.getAccount());
		 healthPlan.setDescription(healthPlanPO.getDescription());
		 healthPlan.setDoctor(healthPlanPO.getDoctor());
		 healthPlan.setPlanId(new PlanId(healthPlanPO.getPlanId()));
		 
		 List<HealthTaskProfile> healthTaskProfiles = new ArrayList<HealthTaskProfile>();
		 for(HealthTaskPO healthTaskPO : healthPlanPO.getTasks()) {
			 HealthTaskProfile healthTaskProfile = createHealthTaskProfile(healthTaskPO);
			 healthTaskProfiles.add(healthTaskProfile);
		 }	
		 healthPlan.setTasks(healthTaskProfiles);
		 
		 return healthPlan;
	 }
	 
	 private HealthTaskPO createHealthTaskPO(HealthTaskProfile healthTaskProfile){
		 HealthTaskPO healthTaskPO = new HealthTaskPO();
		 healthTaskPO.setTaskId(healthTaskProfile.getTaskId());
		 healthTaskPO.setTaskName(healthTaskProfile.getTaskName());
		 healthTaskPO.setDescription(healthTaskProfile.getDescription());
		 healthTaskPO.setTaskScore(healthTaskProfile.getTaskScore());
		 
		 return healthTaskPO;
	 }
	 
	 private HealthTaskProfile createHealthTaskProfile(HealthTaskPO healthTaskPO){
		 HealthTaskProfile healthTaskProfile = new HealthTaskProfile();
		 healthTaskProfile.setTaskId(healthTaskPO.getTaskId());
		 healthTaskProfile.setTaskName(healthTaskPO.getTaskName());
		 healthTaskProfile.setDescription(healthTaskPO.getDescription());
		 healthTaskProfile.setTaskScore(healthTaskPO.getTaskScore());
		 
		 return healthTaskProfile;
	 }
}
