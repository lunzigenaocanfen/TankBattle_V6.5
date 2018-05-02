package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import tool.Util;
import view.MyFrame;

public class MyMouse extends MouseAdapter {
	//鼠标监听
	MyFrame myFrame;
	private int[][] map = new int[15][15];
	public MyMouse(MyFrame myFrame) {
		
		this.myFrame = myFrame;
		map[14][7] = 5;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

		//获取鼠标坐标
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		map = myFrame.getGameMap().getArr();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int mapX = j*Util.wallSize;
				int mapY = i*Util.wallSize;
				
				if(mouseX > mapX && mouseY > mapY && mouseX < mapX + Util.tankSize && 
						mouseY < mapY + Util.tankSize) {
					//按数组网格设置障碍物类型
					if(i != 14 || j != 7) {
						map[i][j] = Util.mapStyl;
					}
					
				}
				
			}
			
		}
		//自定义地图时，点击地图面板时设置可以获得焦点
		myFrame.getPlayGamePanel().setFocusable(true);
		myFrame.getPlayGamePanel().requestFocus();
		
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}
	
	
	
}
