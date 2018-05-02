package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tool.Util;

public class PassLevelPanel extends JPanel {
	//����,ʤ��,ʧ�����
	//��ǩ
	private JLabel UserName = new JLabel("�û���");
	private JLabel levelTitle = new JLabel("��ǰ�ؿ���"+0+"��");
	private JLabel killEasyEnemy = new JLabel("0");
	private JLabel killNormalEnemy = new JLabel("0");
	private JLabel killHardEnemy = new JLabel("0");
	private JLabel EasyEnemyScore = new JLabel("0");
	private JLabel NormalEnemylScore = new JLabel("0");
	private JLabel HardEnemyScore = new JLabel("0");
	private JLabel currentKillEnemy = new JLabel("��ǰ��ɱ��"+0);
	private JLabel totalKillEnemy = new JLabel("�ܹ���ɱ��"+0);
	private JLabel currentScore = new JLabel("��ǰ�÷֣�"+0);
	private JLabel totalScore = new JLabel("�ܹ��÷֣�"+0);
	//��ť
	private JButton passLevelButton = new JButton("��һ��");
	private JButton restartButton = new JButton("���¿�ʼ");
	private JButton returnButton = new JButton("�������");
	private JButton gameOverButton = new JButton("������Ϸ");
	
	MyFrame myFrame;

	public PassLevelPanel(MyFrame myFrame) {
		
		this.myFrame = myFrame;
		this.setPreferredSize(new Dimension(300, 400));
		this.setLayout(null);
		//��ǩ
		UserName.setBounds(10, 10, 70, 30);
		levelTitle.setBounds(105, 10, 100, 30);
		killEasyEnemy.setBounds(122, 63, 30, 30);
		killNormalEnemy.setBounds(122, 115, 30, 30);
		killHardEnemy.setBounds(122, 165, 30, 30);
		EasyEnemyScore.setBounds(250, 63, 40, 30);
		NormalEnemylScore.setBounds(250, 115, 40, 30);
		HardEnemyScore.setBounds(250, 165, 40, 30);
		currentKillEnemy.setBounds(50, 250, 120, 30);
		totalKillEnemy.setBounds(175, 250, 120, 30);
		currentScore.setBounds(50, 280, 120, 30);
		totalScore.setBounds(175, 280, 120, 30);
		//��ť
		passLevelButton.setBounds(45, 330, 90, 30);
		restartButton.setBounds(170, 330, 90, 30);
		returnButton.setBounds(45, 330, 90, 30);
		gameOverButton.setBounds(170, 330, 90, 30);
		this.add(UserName);
		this.add(killEasyEnemy);
		this.add(killNormalEnemy);
		this.add(killHardEnemy);
		this.add(EasyEnemyScore);
		this.add(NormalEnemylScore);
		this.add(HardEnemyScore);
		this.add(currentKillEnemy);
		this.add(totalKillEnemy);
		this.add(currentScore);
		this.add(totalScore);
		this.add(passLevelButton);
		this.add(restartButton);
		this.add(levelTitle);
		passLevelButton.setActionCommand("PASSLEVEL");
		restartButton.setActionCommand("RESTART");
		returnButton.setActionCommand("RETURN");
		gameOverButton.setActionCommand("GAMEOVER");
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawImage(Util.IMG_PASSLEVEL, 0, 0, 300, 400, 0, 0, Util.IMG_PASSLEVEL.getWidth(null), Util.IMG_PASSLEVEL.getHeight(null), null);
		
	}


//----------------------------------------------	
	public JLabel getKillEasyEnemy() {
		return killEasyEnemy;
	}

	public void setKillEasyEnemy(JLabel killEasyEnemy) {
		this.killEasyEnemy = killEasyEnemy;
	}

	public JLabel getKillNormalEnemy() {
		return killNormalEnemy;
	}

	public void setKillNormalEnemy(JLabel killNormalEnemy) {
		this.killNormalEnemy = killNormalEnemy;
	}

	public JLabel getKillHardEnemy() {
		return killHardEnemy;
	}

	public void setKillHardEnemy(JLabel killHardEnemy) {
		this.killHardEnemy = killHardEnemy;
	}

	public JLabel getCurrentKillEnemy() {
		return currentKillEnemy;
	}

	public void setCurrentKillEnemy(JLabel currentKillEnemy) {
		this.currentKillEnemy = currentKillEnemy;
	}

	public JLabel getTotalKillEnemy() {
		return totalKillEnemy;
	}

	public void setTotalKillEnemy(JLabel totalKillEnemy) {
		this.totalKillEnemy = totalKillEnemy;
	}

	public JLabel getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(JLabel currentScore) {
		this.currentScore = currentScore;
	}

	public JLabel getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(JLabel totalScore) {
		this.totalScore = totalScore;
	}

	public JLabel getLevelTitle() {
		return levelTitle;
	}

	public void setLevelTitle(JLabel levelTitle) {
		this.levelTitle = levelTitle;
	}

	public JLabel getEasyEnemyScore() {
		return EasyEnemyScore;
	}

	public void setEasyEnemyScore(JLabel easyEnemyScore) {
		EasyEnemyScore = easyEnemyScore;
	}


	public JButton getPassLevelButton() {
		return passLevelButton;
	}

	public void setPassLevelButton(JButton passLevelButton) {
		this.passLevelButton = passLevelButton;
	}

	public JButton getRestartButton() {
		return restartButton;
	}

	public void setRestartButton(JButton restartButton) {
		this.restartButton = restartButton;
	}

	public JLabel getNormalEnemylScore() {
		return NormalEnemylScore;
	}

	public void setNormalEnemylScore(JLabel normalEnemylScore) {
		NormalEnemylScore = normalEnemylScore;
	}

	public JLabel getHardEnemyScore() {
		return HardEnemyScore;
	}

	public void setHardEnemyScore(JLabel hardEnemyScore) {
		HardEnemyScore = hardEnemyScore;
	}

	public JLabel getUserName() {
		return UserName;
	}

	public void setUserName(JLabel userName) {
		UserName = userName;
	}

	public JButton getGameOverButton() {
		return gameOverButton;
	}

	public void setGameOverButton(JButton gameOverButton) {
		this.gameOverButton = gameOverButton;
	}

	public JButton getReturnButton() {
		return returnButton;
	}

	public void setReturnButton(JButton returnButton) {
		this.returnButton = returnButton;
	}
	
	
	
}
