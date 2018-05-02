package view;

import javax.swing.JFrame;

public class IntroducedFrame extends JFrame {
	//操作说明窗口
	private IntroducePanel introducePanel = new IntroducePanel();
	public IntroducedFrame() {
		this.setTitle("操作说明");
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setSize(300, 400);
		this.add(introducePanel);
		this.setLocationRelativeTo(null);
	}
	public IntroducePanel getIntroducePanel() {
		return introducePanel;
	}
	public void setIntroducePanel(IntroducePanel introducePanel) {
		this.introducePanel = introducePanel;
	}
	
}
