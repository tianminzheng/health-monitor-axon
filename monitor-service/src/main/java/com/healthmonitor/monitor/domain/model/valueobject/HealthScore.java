package com.healthmonitor.monitor.domain.model.valueobject;

/**
 * 健康分
 */
public class HealthScore {

	private int score;//健康分值
	
	public HealthScore(int score) {
		super();
		this.score = score;
	}
	
	public void plusScore(int taskScore) {
		this.score += taskScore;
	}

	public int getScore() {
		return score;
	}
}
