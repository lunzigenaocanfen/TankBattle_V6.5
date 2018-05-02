package view;

import javax.swing.JFrame;

public class NameFrame extends JFrame {

	// 提示用户输入姓名界面
	private NamePanel namePanel = new NamePanel();
	MyFrame myFrame;

	public NameFrame() {
		this.setTitle("欢迎来到坦克大战");
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		this.add(namePanel);
		this.pack();
		this.setLocationRelativeTo(null);

	}

	// ----------------------------------------------------
	public NamePanel getNamePanel() {
		return namePanel;
	}

	public void setNamePanel(NamePanel namePanel) {
		this.namePanel = namePanel;
	}

}
