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
	//�Զ����������
	MyFrame myFrame;
	//��ѡ��
	private JRadioButton singlePlayerRaioButton = new JRadioButton("������Ϸ    ");
	private JRadioButton doublePlayerRaioButton = new JRadioButton("˫����Ϸ    ");
	private JRadioButton normalGameRaioButton = new JRadioButton("����ģʽ    ");
	private JRadioButton selectGameRaioButton = new JRadioButton("��ѡģʽ    ");
	private ButtonGroup customUserButtonGroup = new ButtonGroup();
	private ButtonGroup customEnemyButtonGroup = new ButtonGroup();
	//��ǩ
	private JLabel selectLevelLabel = new JLabel("ѡ��ǰ�ؿ���    ");
	private JLabel enemyTankSpeedLabel = new JLabel("�з�̹���ٶȣ�    ");
	private JLabel enemyBulletSpeedLabel = new JLabel("�з��ӵ��ٶȣ�    ");
	private JLabel enemyBulletPowerLabel = new JLabel("�з��Ĺ�������    ");
	private JLabel enemyNumberLabel = new JLabel("�з�̹������(10-50)��");
	//������
	private String[] arr = { "1", "2", "3" };
	private JComboBox<String> levelBox = new JComboBox<String>(arr);
	private JComboBox<String> enemyTankSpeedBox = new JComboBox<String>(arr);
	private JComboBox<String> enemyBulletSpeedBox = new JComboBox<String>(arr);
	private JComboBox<String> enemyBulletPowerBox = new JComboBox<String>(arr);
	//�ı���
	private JTextField enemyNumberTextField = new JTextField(5);
	//��ť
	private JButton customSureButton = new JButton("ȷ  ��");
	private JButton customCancelButton = new JButton("ȡ  ��");

	public CustomPanel(MyFrame myFrame) {
		this.myFrame = myFrame;
		this.setPreferredSize(new Dimension(200, 250));
		//��ť����ӵ�ѡ��ʹ�ñ��鵥ѡ��ֻ��ѡһ��
		customUserButtonGroup.add(singlePlayerRaioButton);
		customUserButtonGroup.add(doublePlayerRaioButton);
		customEnemyButtonGroup.add(normalGameRaioButton);
		customEnemyButtonGroup.add(selectGameRaioButton);
		this.add(singlePlayerRaioButton);
		this.add(doublePlayerRaioButton);
		this.add(normalGameRaioButton);
		this.add(selectGameRaioButton);
		//��ӱ�ǩ��������
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
		// ��ť
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
