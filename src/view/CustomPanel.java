package view;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CustomPanel extends JPanel {
	//自定义设置面板
	MyFrame myFrame;
	//单选框
	private JRadioButton singlePlayerRaioButton = new JRadioButton("单人游戏    ");
	private JRadioButton doublePlayerRaioButton = new JRadioButton("双人游戏    ");
	private JRadioButton normalGameRaioButton = new JRadioButton("正常模式    ");
	private JRadioButton selectGameRaioButton = new JRadioButton("自选模式    ");
	private ButtonGroup customUserButtonGroup = new ButtonGroup();
	private ButtonGroup customEnemyButtonGroup = new ButtonGroup();
	//标签
	private JLabel selectLevelLabel = new JLabel("选择当前关卡：    ");
	private JLabel enemyTankSpeedLabel = new JLabel("敌方坦克速度：    ");
	private JLabel enemyBulletSpeedLabel = new JLabel("敌方子弹速度：    ");
	private JLabel enemyBulletPowerLabel = new JLabel("敌方的攻击力：    ");
	private JLabel enemyNumberLabel = new JLabel("敌方坦克数量(10-50)：");
	//下拉框
	private String[] arr = { "1", "2", "3" };
	private JComboBox<String> levelBox = new JComboBox<String>(arr);
	private JComboBox<String> enemyTankSpeedBox = new JComboBox<String>(arr);
	private JComboBox<String> enemyBulletSpeedBox = new JComboBox<String>(arr);
	private JComboBox<String> enemyBulletPowerBox = new JComboBox<String>(arr);
	//文本框
	private JTextField enemyNumberTextField = new JTextField(5);
	//按钮
	private JButton customSureButton = new JButton("确  定");
	private JButton customCancelButton = new JButton("取  消");

	public CustomPanel(MyFrame myFrame) {
		this.myFrame = myFrame;
		this.setPreferredSize(new Dimension(200, 250));
		//按钮组添加单选框，使得本组单选框只能选一个
		customUserButtonGroup.add(singlePlayerRaioButton);
		customUserButtonGroup.add(doublePlayerRaioButton);
		customEnemyButtonGroup.add(normalGameRaioButton);
		customEnemyButtonGroup.add(selectGameRaioButton);
		this.add(singlePlayerRaioButton);
		this.add(doublePlayerRaioButton);
		this.add(normalGameRaioButton);
		this.add(selectGameRaioButton);
		//添加标签与下拉框
		this.add(selectLevelLabel);
		this.add(levelBox);
		this.add(enemyTankSpeedLabel);
		this.add(enemyTankSpeedBox);
		this.add(enemyBulletSpeedLabel);
		this.add(enemyBulletSpeedBox);
		this.add(enemyBulletPowerLabel);
		this.add(enemyBulletPowerBox);

		this.add(enemyNumberLabel);
		this.add(enemyNumberTextField);
		// 按钮
		this.add(customSureButton);
		this.add(customCancelButton);
		customSureButton.setActionCommand("CUSTOMSURE");
		customCancelButton.setActionCommand("CUSTOMCANCEL");

	}
	
//----------------------------------------------------------
	public JRadioButton getSinglePlayerRaioButton() {
		return singlePlayerRaioButton;
	}

	public void setSinglePlayerRaioButton(JRadioButton singlePlayerRaioButton) {
		this.singlePlayerRaioButton = singlePlayerRaioButton;
	}

	public JRadioButton getDoublePlayerRaioButton() {
		return doublePlayerRaioButton;
	}

	public void setDoublePlayerRaioButton(JRadioButton doublePlayerRaioButton) {
		this.doublePlayerRaioButton = doublePlayerRaioButton;
	}

	public JRadioButton getNormalGameRaioButton() {
		return normalGameRaioButton;
	}

	public void setNormalGameRaioButton(JRadioButton normalGameRaioButton) {
		this.normalGameRaioButton = normalGameRaioButton;
	}

	public JRadioButton getSelectGameRaioButton() {
		return selectGameRaioButton;
	}

	public void setSelectGameRaioButton(JRadioButton selectGameRaioButton) {
		this.selectGameRaioButton = selectGameRaioButton;
	}

	public JLabel getSelectLevelLabel() {
		return selectLevelLabel;
	}

	public void setSelectLevelLabel(JLabel selectLevelLabel) {
		this.selectLevelLabel = selectLevelLabel;
	}

	public JLabel getEnemyTankSpeedLabel() {
		return enemyTankSpeedLabel;
	}

	public void setEnemyTankSpeedLabel(JLabel enemyTankSpeedLabel) {
		this.enemyTankSpeedLabel = enemyTankSpeedLabel;
	}

	public JLabel getEnemyBulletSpeedLabel() {
		return enemyBulletSpeedLabel;
	}

	public void setEnemyBulletSpeedLabel(JLabel enemyBulletSpeedLabel) {
		this.enemyBulletSpeedLabel = enemyBulletSpeedLabel;
	}

	public JLabel getEnemyNumberLabel() {
		return enemyNumberLabel;
	}

	public void setEnemyNumberLabel(JLabel enemyNumberLabel) {
		this.enemyNumberLabel = enemyNumberLabel;
	}

	public String[] getArr() {
		return arr;
	}

	public void setArr(String[] arr) {
		this.arr = arr;
	}

	public JComboBox<String> getLevelBox() {
		return levelBox;
	}

	public void setLevelBox(JComboBox<String> levelBox) {
		this.levelBox = levelBox;
	}

	public JComboBox<String> getEnemyTankSpeedBox() {
		return enemyTankSpeedBox;
	}

	public void setEnemyTankSpeedBox(JComboBox<String> enemyTankSpeedBox) {
		this.enemyTankSpeedBox = enemyTankSpeedBox;
	}

	public JComboBox<String> getEnemyBulletSpeedBox() {
		return enemyBulletSpeedBox;
	}

	public void setEnemyBulletSpeedBox(JComboBox<String> enemyBulletSpeedBox) {
		this.enemyBulletSpeedBox = enemyBulletSpeedBox;
	}

	public JTextField getEnemyNumberTextField() {
		return enemyNumberTextField;
	}

	public void setEnemyNumberTextField(JTextField enemyNumberTextField) {
		this.enemyNumberTextField = enemyNumberTextField;
	}

	public JButton getCustomSureButton() {
		return customSureButton;
	}

	public void setCustomSureButton(JButton customSureButton) {
		this.customSureButton = customSureButton;
	}

	public JButton getCustomCancelButton() {
		return customCancelButton;
	}

	public void setCustomCancelButton(JButton customCancelButton) {
		this.customCancelButton = customCancelButton;
	}

	public ButtonGroup getCustomUserButtonGroup() {
		return customUserButtonGroup;
	}

	public void setCustomUserButtonGroup(ButtonGroup customUserButtonGroup) {
		this.customUserButtonGroup = customUserButtonGroup;
	}

	public ButtonGroup getCustomEnemyButtonGroup() {
		return customEnemyButtonGroup;
	}

	public void setCustomEnemyButtonGroup(ButtonGroup customEnemyButtonGroup) {
		this.customEnemyButtonGroup = customEnemyButtonGroup;
	}

	public JLabel getEnemyBulletPowerLabel() {
		return enemyBulletPowerLabel;
	}

	public void setEnemyBulletPowerLabel(JLabel enemyBulletPowerLabel) {
		this.enemyBulletPowerLabel = enemyBulletPowerLabel;
	}

	public JComboBox<String> getEnemyBulletPowerBox() {
		return enemyBulletPowerBox;
	}

	public void setEnemyBulletPowerBox(JComboBox<String> enemyBulletPowerBox) {
		this.enemyBulletPowerBox = enemyBulletPowerBox;
	}

}
