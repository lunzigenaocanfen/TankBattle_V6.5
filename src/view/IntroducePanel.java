package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import tool.Util;

public class IntroducePanel extends JPanel {
	//操作说明面板
	private JButton backButton = new JButton("返    回");
	public IntroducePanel() {
		this.setPreferredSize(new Dimension(300, 400));
		this.setLayout(null);
		backButton.setBounds(110, 330, 80, 30);
		this.add(backButton);
		backButton.setActionCommand("BACK");
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(Util.IMG_INTRODUCE, 0, 0, 300, 400, 0, 0, 300, 400, null);
	}
	public JButton getBackButton() {
		return backButton;
	}
	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}
	
}
