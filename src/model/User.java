package model;



public class User {

	private String name ;//����
	private int presentHitEnemyCount;//��ǰ����̹��ͳ��
	private int totalHitEnemyCount;//�ܹ�����ͳ��
	private int presentScore;//��ǰ�÷�
	private int totalScore;//�ܵ÷�

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
