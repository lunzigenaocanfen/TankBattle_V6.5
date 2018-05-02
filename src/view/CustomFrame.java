package view;

import javax.swing.JFrame;

public class CustomFrame extends JFrame {
	//自定义设置窗口
	MyFrame myFrame;

	public CustomFrame(MyFrame myFrame) {

		this.myFrame = myFrame;
		this.setTitle("设置");
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.add(myFrame.getCustomPanel());
		this.pack();
		this.setLocationRelativeTo(null);

	}

}
