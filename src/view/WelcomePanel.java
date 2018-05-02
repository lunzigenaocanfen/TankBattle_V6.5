package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import tool.Util;

public class WelcomePanel extends JPanel {
	//һ��ʼ�Ļ�ӭ���
	//��ʼ���
	private JButton startBtn = new JButton("��  ʼ  ��  Ϸ");
	private JButton overBtn = new JButton("��  ��  ��  Ϸ");
	
	public WelcomePanel() {
		this.setPreferredSize(new Dimension(Util.welcomeWidth, Util.welcomeHeight));
		this.setLayout(null);
		startBtn.setBounds(315, 80, 120, 40);
		overBtn.setBounds(315, 130, 120, 40);
		this.add(startBtn);
		this.add(overBtn);
		startBtn.setActionCommand("START");
		overBtn.setActionCommand("QUIT");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(Util.IMG_WELCOME, 0, 0, Util.welcomeWidth, Util.welcomeHeight, 0, 0, 
				Util.IMG_WELCOME.getWidth(null), Util.IMG_WELCOME.getHeight(null), null);
		
		
		
	}
	
	
	
	
	
//-------------------------------------------
	public JButton getStartBtn() {
		return startBtn;
	}

	public void setStartBtn(JButton startBtn) {
		this.startBtn = startBtn;
	}

	public JButton getOverBtn() {
		return overBtn;
	}

	public void setOverBtn(JButton overBtn) {
		this.overBtn = overBtn;
	}
	
}
