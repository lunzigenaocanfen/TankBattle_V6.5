package model;



public class User {

	private String name ;//姓名
	private int presentHitEnemyCount;//当前击毁坦克统计
	private int totalHitEnemyCount;//总共击毁统计
	private int presentScore;//当前得分
	private int totalScore;//总得分

//-----------------------------------	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPresentHitEnemyCount() {
		return presentHitEnemyCount;
	}
	public void setPresentHitEnemyCount(int presentHitEnemyCount) {
		this.presentHitEnemyCount = presentHitEnemyCount;
	}
	public int getTotalHitEnemyCount() {
		return totalHitEnemyCount;
	}
	public void setTotalHitEnemyCount(int totalHitEnemyCount) {
		this.totalHitEnemyCount = totalHitEnemyCount;
	}
	public int getPresentScore() {
		return presentScore;
	}
	public void setPresentScore(int presentScore) {
		this.presentScore = presentScore;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	
	
}
