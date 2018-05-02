package view;

import javax.swing.JFrame;

public class PassLevelFrame extends JFrame {
	//过关,胜利,失败窗口
	MyFrame myFrame;

	public PassLevelFrame(MyFrame myFrame) {
		this.myFrame = myFrame;
		this.setTitle("统计分数");
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setSize(300, 400);
		this.add(myFrame.getPassLevelPanel());

		this.setLocationRelativeTo(null);
	}

}
