package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import tool.Util;
import view.MyFrame;

public class MyMouse extends MouseAdapter {
	//������
	MyFrame myFrame;
	private int[][] map = new int[15][15];
	public MyMouse(MyFrame myFrame) {
		
		this.myFrame = myFrame;
		map[14][7] = 5;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

		//��ȡ�������
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		map = myFrame.getGameMap().getArr();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int mapX = j*Util.wallSize;
				int mapY = i*Util.wallSize;
				
				if(mouseX > mapX && mouseY > mapY && mouseX < mapX + Util.tankSize && 
						mouseY < mapY + Util.tankSize) {
					//���������������ϰ�������
					if(i != 14 || j != 7) {
						map[i][j] = Util.mapStyl;
					}
					
				}
				
			}
			
		}
		//�Զ����ͼʱ�������ͼ���ʱ���ÿ��Ի�ý���
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
