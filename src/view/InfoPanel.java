package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.EasyEnemy;
import model.Enemy;
import model.HardEnemy;
import model.NormalEnemy;
import tool.Util;

public class InfoPanel extends JPanel {

	MyFrame myFrame;

	private ArrayList<Enemy> infoEnemyList = new ArrayList<Enemy>();
	private JLabel easyLabel = new JLabel("0");// 统计剩余简单敌人
	private JLabel normalLabel = new JLabel("0");// 统计剩余一般敌人
	private JLabel hardLabel = new JLabel("0");// 统计剩余困难敌人
	private JLabel levelLabel = new JLabel("0");// 当前关卡
	private JLabel killEnemyLabel = new JLabel("0");// 当前击杀
	private JLabel currentScoreLabel = new JLabel("0");// 当前得分
	private JLabel totalScoreLabel = new JLabel("0");// 总得分
	private JLabel leftLiveLabel = new JLabel("P1:0    P2:0");// 血条

	// 右侧信息面板
	public InfoPanel(MyFrame myFrame) {
		this.myFrame = myFrame;
		this.setPreferredSize(new Dimension(Util.tipWidth, Util.tipHeight));
		this.setLayout(null);
		//设置位置
		easyLabel.setBounds(130, 54, 30, 30);
		normalLabel.setBounds(130, 101, 30, 30);
		hardLabel.setBounds(130, 149, 30, 30);

		levelLabel.setBounds(130, 432, 30, 30);
		killEnemyLabel.setBounds(130, 462, 30, 30);
		leftLiveLabel.setBounds(110, 491, 100, 30);
		currentScoreLabel.setBounds(130, 522, 60, 30);

		totalScoreLabel.setBounds(130, 552, 60, 30);

		this.add(easyLabel);
		this.add(normalLabel);
		this.add(hardLabel);
		this.add(levelLabel);
		this.add(killEnemyLabel);
		this.add(currentScoreLabel);
		this.add(totalScoreLabel);
		this.add(leftLiveLabel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		//画背景
		super.paintComponent(g);
		g.drawImage(Util.IMG_INFO, 0, 0, Util.tipWidth, Util.tipHeight, 0, 0, Util.IMG_INFO.getWidth(null),
				Util.IMG_INFO.getHeight(null), null);

	}

	public void addEnemy() {

		for (int i = 0; i < Util.enemyNumber; i++) {

			Enemy enemy = null;
			switch (new Random().nextInt(3)) {
			case 0:

				enemy = new EasyEnemy();
				infoEnemyList.add(enemy);

				break;
			case 1:

				enemy = new NormalEnemy();
				infoEnemyList.add(enemy);

				break;
			case 2:

				enemy = new HardEnemy();
				infoEnemyList.add(enemy);

				break;

			default:
				break;
			}
		}

	}

	// ------------------------------------
	public ArrayList<Enemy> getInfoEnemyList() {
		return infoEnemyList;
	}

	public void setInfoEnemyList(ArrayList<Enemy> infoEnemyList) {
		this.infoEnemyList = infoEnemyList;
	}

	public JLabel getEasyLabel() {
		return easyLabel;
	}

	public void setEasyLabel(JLabel easyLabel) {
		this.easyLabel = easyLabel;
	}

	public JLabel getNormalLabel() {
		return normalLabel;
	}

	public void setNormalLabel(JLabel normalLabel) {
		this.normalLabel = normalLabel;
	}

	public JLabel getHardLabel() {
		return hardLabel;
	}

	public void setHardLabel(JLabel hardLabel) {
		this.hardLabel = hardLabel;
	}

	public JLabel getLevelLabel() {
		return levelLabel;
	}

	public void setLevelLabel(JLabel levelLabel) {
		this.levelLabel = levelLabel;
	}

	public JLabel getKillEnemyLabel() {
		return killEnemyLabel;
	}

	public void setKillEnemyLabel(JLabel killEnemyLabel) {
		this.killEnemyLabel = killEnemyLabel;
	}

	public JLabel getCurrentScoreLabel() {
		return currentScoreLabel;
	}

	public void setCurrentScoreLabel(JLabel currentScoreLabel) {
		this.currentScoreLabel = currentScoreLabel;
	}

	public JLabel getTotalScoreLabel() {
		return totalScoreLabel;
	}

	public void setTotalScoreLabel(JLabel totalScoreLabel) {
		this.totalScoreLabel = totalScoreLabel;
	}

	public JLabel getLeftLiveLabel() {
		return leftLiveLabel;
	}

	public void setLeftLiveLabel(JLabel leftLiveLabel) {
		this.leftLiveLabel = leftLiveLabel;
	}

}
