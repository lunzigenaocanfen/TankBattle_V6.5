package view;

import javax.swing.JFrame;

public class NameFrame extends JFrame {

	// ��ʾ�û�������������
	private NamePanel namePanel = new NamePanel();
	MyFrame myFrame;

	public NameFrame() {
		this.setTitle("��ӭ����̹�˴�ս");
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
