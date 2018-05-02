package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import tool.Util;

public class CustomMapInfoPanel extends JPanel {
	//自定义地图右侧的预览区面板
	private JButton wallButton = new JButton("画     砖     墙");
	private JButton steelButton = new JButton("画     铁    墙");
	private JButton grassButton = new JButton("画     草     地");
	private JButton waterButton = new JButton("画     河     流");
	private JButton deleteButton = new JButton("删          除");

	private JButton sureButton = new JButton("确          定");
	private JButton cancelButton = new JButton("取          消");

	MyFrame myFrame;

	public CustomMapInfoPanel(MyFrame myFrame) {
		//按钮设置位置，和返回指令
		this.myFrame = myFrame;
		this.setPreferredSize(new Dimension(200, 600));
		this.setLayout(null);
		wallButton.setBounds(40, 50, 120, 30);
		steelButton.setBounds(40, 130, 120, 30);
		grassButton.setBounds(40, 210, 120, 30);
		waterButton.setBounds(40, 290, 120, 30);
		deleteButton.setBounds(40, 370, 120, 30);
		sureButton.setBounds(40, 450, 120, 30);
		cancelButton.setBounds(40, 530, 120, 30);

		this.add(wallButton);
		this.add(steelButton);
		this.add(grassButton);
		this.add(waterButton);
		this.add(deleteButton);

		this.add(sureButton);
		this.add(cancelButton);

		wallButton.setActionCommand("WALL");
		steelButton.setActionCommand("STEEL");
		grassButton.setActionCommand("GRASS");
		waterButton.setActionCommand("WATER");
		deleteButton.setActionCommand("DELETE");
		sureButton.setActionCommand("CUSTOMMAPSURE");
		cancelButton.setActionCommand("CUSTOMCANCEL");

	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(Util.IMG_CUSTOMINFO, 0, 0, Util.tipWidth, Util.tipHeight, 0, 0, Util.IMG_CUSTOMINFO.getWidth(null),
				Util.IMG_CUSTOMINFO.getHeight(null), null);
	}
	
	
	
//----------------------------------------------------
	public JButton getWallButton() {
		return wallButton;
	}

	public void setWallButton(JButton wallButton) {
		this.wallButton = wallButton;
	}

	public JButton getSteelButton() {
		return steelButton;
	}

	public void setSteelButton(JButton steelButton) {
		this.steelButton = steelButton;
	}

	public JButton getGrassButton() {
		return grassButton;
	}

	public void setGrassButton(JButton grassButton) {
		this.grassButton = grassButton;
	}

	public JButton getWaterButton() {
		return waterButton;
	}

	public void setWaterButton(JButton waterButton) {
		this.waterButton = waterButton;
	}

	public JButton getSureButton() {
		return sureButton;
	}

	public void setSureButton(JButton sureButton) {
		this.sureButton = sureButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

}
