package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import tool.Util;

public class CustomMapPanel extends JPanel {
	// 自定义地图面板
	MyFrame myFrame;

	public CustomMapPanel(MyFrame myFrame) {

		this.myFrame = myFrame;
		this.setPreferredSize(new Dimension(600, 600));

	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		// 画背景
		g.drawImage(Util.IMG_BACKGROUND, 0, 0, Util.gameWidth, Util.gameHeight, 0, 0,
				Util.IMG_BACKGROUND.getWidth(null), Util.IMG_BACKGROUND.getHeight(null), null);
		// 画地图
		myFrame.getGameMap().drawMap(g);
	}

}
