package view;

import javax.swing.JFrame;

public class CustomFrame extends JFrame {
	//�Զ������ô���
	MyFrame myFrame;

	public CustomFrame(MyFrame myFrame) {

		this.myFrame = myFrame;
		this.setTitle("����");
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.add(myFrame.getCustomPanel());
		this.pack();
		this.setLocationRelativeTo(null);

	}

}
