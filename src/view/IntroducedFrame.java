package view;

import javax.swing.JFrame;

public class IntroducedFrame extends JFrame {
	//����˵������
	private IntroducePanel introducePanel = new IntroducePanel();
	public IntroducedFrame() {
		this.setTitle("����˵��");
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
