package com.healthmonitor.task.domain.model.aggregate;

import com.healthmonitor.task.domain.command.CreateTaskCommand;
import com.healthmonitor.task.domain.command.UpdateTaskCommand;

public class HealthTask {

	//唯一标识
	private TaskId taskId;
	private String taskName;
	private String description;
	private int taskScore;
	
	public HealthTask() {
		
	}
	
	//实体对象的初始化
	public HealthTask(CreateTaskCommand createTaskCommand) {		

		this.taskId = new TaskId(createTaskCommand.getTaskId());
		
		this.taskName = createTaskCommand.getTaskName();
		this.description = createTaskCommand.getDescription();
		this.taskScore = createTaskCommand.getTaskScore();		
	}
	
	//实体对象的状态更新
	public void updateTask(UpdateTaskCommand updateTaskCommand) {
		
		this.description = updateTaskCommand.getDescription();
		this.taskScore = updateTaskCommand.getTaskScore();
	}

	public TaskId getTaskId() {
		return taskId;
	}

	public void setTaskId(TaskId taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTaskScore() {
		return taskScore;
	}

	public void setTaskScore(int taskScore) {
		this.taskScore = taskScore;
	}

}
