package view;

import javax.swing.JFrame;

public class PassLevelFrame extends JFrame {
	//����,ʤ��,ʧ�ܴ���
	MyFrame myFrame;

	public PassLevelFrame(MyFrame myFrame) {
		this.myFrame = myFrame;
		this.setTitle("ͳ�Ʒ���");
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setSize(300, 400);
		this.add(myFrame.getPassLevelPanel());

		this.setLocationRelativeTo(null);
	}

}
