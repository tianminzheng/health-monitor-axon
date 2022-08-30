package com.healthmonitor.monitor.domain.model.aggregate;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.healthmonitor.domain.model.valueobject.Anamnesis;
import com.healthmonitor.domain.model.valueobject.Symptom;
import com.healthmonitor.monitor.domain.command.ApplyMonitorCommand;
import com.healthmonitor.monitor.domain.command.GeneratePlanCommand;
import com.healthmonitor.monitor.domain.command.PerformTaskCommand;
import com.healthmonitor.domain.event.MonitorInitializedEvent;
import com.healthmonitor.domain.event.PlanGeneratedEvent;
import com.healthmonitor.domain.event.TaskPerformedEvent;
import com.healthmonitor.domain.model.entity.HealthPlanProfile;
import com.healthmonitor.monitor.domain.model.entity.HealthTestOrder;
import com.healthmonitor.monitor.domain.model.valueobject.HealthScore;
import com.healthmonitor.monitor.domain.model.valueobject.MonitorStatus;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;;

@Aggregate
public class HealthMonitor {

	@AggregateIdentifier
	private String monitorId;// 聚合标识符
	private HealthTestOrder order;
	private HealthPlanProfile plan;
	private HealthScore score;
	private MonitorStatus status;

	public HealthMonitor() {

	}

	@CommandHandler
	public HealthMonitor(ApplyMonitorCommand applyMonitorCommand) {

		// 执行业务验证规则
		if (applyMonitorCommand.getMonitorId().isEmpty()) {
			throw new IllegalArgumentException("MonitorId should not be empty.");
		}

		MonitorInitializedEvent monitorInitializedEvent = new MonitorInitializedEvent(
				applyMonitorCommand.getMonitorId(), applyMonitorCommand.getAccount(), applyMonitorCommand.getAllergy(),
				applyMonitorCommand.getInjection(), applyMonitorCommand.getSurgery(),
				applyMonitorCommand.getSymptomDescription(), applyMonitorCommand.getBodyPart(),
				applyMonitorCommand.getTimeDuration(), 0);
		apply(monitorInitializedEvent);
	}

	@EventSourcingHandler
	public void on(MonitorInitializedEvent monitorInitializedEvent) {

		this.monitorId = monitorInitializedEvent.getMonitorId();

		// 构建HealthTestOrder
		Anamnesis anamnesis = new Anamnesis(monitorInitializedEvent.getAllergy(),
				monitorInitializedEvent.getInjection(), monitorInitializedEvent.getSurgery());
		Symptom symptom = new Symptom(monitorInitializedEvent.getSymptomDescription(),
				monitorInitializedEvent.getBodyPart(), monitorInitializedEvent.getTimeDuration());
		String orderNumber = "Order" + UUID.randomUUID().toString().toUpperCase();
		HealthTestOrder order = new HealthTestOrder(orderNumber, monitorInitializedEvent.getAccount(), anamnesis,
				symptom);

		// 初始化聚合状态
		this.order = order;
		this.status = MonitorStatus.INITIALIZED;
		this.score = new HealthScore(0);
	}

	@CommandHandler
	public void generateHealthPlan(GeneratePlanCommand createPlanCommand) {

		// 验证monitorId是否对当前HealthMonitor对象是否有效
		String monitorId = createPlanCommand.getMonitorId();
		if (!monitorId.equals(this.monitorId)) {
			return;
		}

		PlanGeneratedEvent planGeneratedEvent = new PlanGeneratedEvent(this.monitorId,
				createPlanCommand.getHealthPlanProfile(), this.getScore().getScore());
		apply(planGeneratedEvent);
	}

	@EventSourcingHandler
	public void on(PlanGeneratedEvent planGeneratedEvent) {

		this.plan = planGeneratedEvent.getHealthPlanProfile();
	}

	@CommandHandler
	public void performHealthTask(PerformTaskCommand performTaskCommand) {

		// 验证monitorId是否对当前HealthMonitor对象是否有效
		String monitorId = performTaskCommand.getMonitorId();
		if (!monitorId.equals(this.monitorId)) {
			return;
		}

		TaskPerformedEvent taskPerformedEvent = new TaskPerformedEvent(this.monitorId, this.getOrder().getAccount(),
				performTaskCommand.getTaskId(), performTaskCommand.getHealthTaskProfile().getTaskScore());
		apply(taskPerformedEvent);
	}

	@EventSourcingHandler
	public void on(TaskPerformedEvent taskPerformedEvent) {

		this.score.plusScore(taskPerformedEvent.getHealthScore());
	}

	public String getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	public MonitorStatus getStatus() {
		return status;
	}

	public HealthTestOrder getOrder() {
		return order;
	}

	public void setOrder(HealthTestOrder order) {
		this.order = order;
	}

	public HealthPlanProfile getPlan() {
		return plan;
	}

	public void setPlan(HealthPlanProfile plan) {
		this.plan = plan;
	}

	public HealthScore getScore() {
		return score;
	}

	public void setScore(HealthScore score) {
		this.score = score;
	}

	public void setStatus(MonitorStatus status) {
		this.status = status;
	}
}
