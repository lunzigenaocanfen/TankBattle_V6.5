package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyBar extends JMenuBar {

	// �˵�
	private JMenu gameMenu = new JMenu("��Ϸ");
	private JMenu helpMenu = new JMenu("����");
	// �˵���
	private JMenuItem startItem = new JMenuItem("��ʼ��Ϸ");
	private JMenuItem newItem = new JMenuItem("���¿�ʼ");
	private JMenuItem continueItem = new JMenuItem("����");

	private JMenuItem customGameItem = new JMenuItem("�Զ�����Ϸ");
	private JMenuItem customMapItem = new JMenuItem("�Զ����ͼ");
	private JMenuItem quitItem = new JMenuItem("�˳���Ϸ");

	private JMenuItem aboutItem = new JMenuItem("����");
	private JMenuItem introduceItem = new JMenuItem("����");

	public MyBar() {
		// ��Ӳ˵������˵�����÷���ָ��
		gameMenu.add(startItem);
		gameMenu.add(newItem);
		gameMenu.add(continueItem);
		gameMenu.add(customGameItem);
		gameMenu.add(customMapItem);
		gameMenu.add(quitItem);
		helpMenu.add(aboutItem);
		helpMenu.add(introduceItem);

		this.add(gameMenu);
		this.add(helpMenu);

		startItem.setActionCommand("STARTGAME");
		newItem.setActionCommand("NEWGAME");
		customGameItem.setActionCommand("CUSTOMGAME");
		customMapItem.setActionCommand("CUSTOMMAP");
		quitItem.setActionCommand("QUIT");
		aboutItem.setActionCommand("ABOUT");
		introduceItem.setActionCommand("INTRODUCE");
		
	}

	// -------------------------
	public JMenu getGameMenu() {
		return gameMenu;
	}

	public void setGameMenu(JMenu gameMenu) {
		this.gameMenu = gameMenu;
	}

	public JMenu getHelpMenu() {
		return helpMenu;
	}

	public void setHelpMenu(JMenu helpMenu) {
		this.helpMenu = helpMenu;
	}

	public JMenuItem getStartItem() {
		return startItem;
	}

	public void setStartItem(JMenuItem startItem) {
		this.startItem = startItem;
	}

	public JMenuItem getNewItem() {
		return newItem;
	}

	public void setNewItem(JMenuItem newItem) {
		this.newItem = newItem;
	}

	public JMenuItem getCustomGameItem() {
		return customGameItem;
	}

	public void setCustomGameItem(JMenuItem customGameItem) {
		this.customGameItem = customGameItem;
	}

	public JMenuItem getCustomMapItem() {
		return customMapItem;
	}

	public void setCustomMapItem(JMenuItem customMapItem) {
		this.customMapItem = customMapItem;
	}

	public JMenuItem getQuitItem() {
		return quitItem;
	}

	public void setQuitItem(JMenuItem quitItem) {
		this.quitItem = quitItem;
	}

	public JMenuItem getContinueItem() {
		return continueItem;
	}

	public void setContinueItem(JMenuItem continueItem) {
		this.continueItem = continueItem;
	}

	public JMenuItem getAboutItem() {
		return aboutItem;
	}

	public void setAboutItem(JMenuItem aboutItem) {
		this.aboutItem = aboutItem;
	}

	public JMenuItem getIntroduceItem() {
		return introduceItem;
	}

	public void setIntroduceItem(JMenuItem introduceItem) {
		this.introduceItem = introduceItem;
	}


}
