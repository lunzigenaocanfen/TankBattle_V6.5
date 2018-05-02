package model;

import java.awt.Graphics;

import tool.Util;

public class GameMap {
	
	//网格大小
	private int row;
	private int col;
	//地图数组
	private int[][] arr = null;
	
	public GameMap(int row, int col) {
		
		this.row = row;
		this.col = col;
		this.arr = new int[row][col];
		
//		drawLevelSecend();//直接画第一关地图
	}
	


	public void drawMap(Graphics g) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				switch ( arr[i][j] ) {
				case 1://画砖墙
					g.drawImage(Util.IMG_WALL, j*Util.wallSize, i*Util.wallSize, j*Util.wallSize+Util.wallSize, i*Util.wallSize+Util.wallSize, 0, 0, Util.wallSize, Util.wallSize, null);
					break;
				case 2://画铁墙
					g.drawImage(Util.IMG_STEEL, j*Util.wallSize, i*Util.wallSize, j*Util.wallSize+Util.wallSize, i*Util.wallSize+Util.wallSize, 0, 0, Util.wallSize, Util.wallSize, null);
					break;
				case 3://画草地
					g.drawImage(Util.IMG_GRASSES, j*Util.wallSize, i*Util.wallSize, j*Util.wallSize+Util.wallSize, i*Util.wallSize+Util.wallSize, 0, 0, Util.wallSize, Util.wallSize, null);
					break;
				case 4://画水地
					g.drawImage(Util.IMG_WATER, j*Util.wallSize, i*Util.wallSize, j*Util.wallSize+Util.wallSize, i*Util.wallSize+Util.wallSize, 0, 0, Util.wallSize, Util.wallSize, null);
					break;
				case 5://画老巢
					g.drawImage(Util.IMG_HOME, j*Util.wallSize, i*Util.wallSize, j*Util.wallSize+Util.wallSize, i*Util.wallSize+Util.wallSize, 0, 0, Util.wallSize, Util.wallSize, null);
					break;
					
				default:
					break;
				}
				
			}
		}
	
	}
	
	public void drawLevelFirst() {
		arr[1][1] = 1;
		arr[2][1] = 1;
		arr[3][1] = 1;
		arr[4][1] = 1;
		arr[5][1] = 1;
		arr[6][1] = 1;
		
		arr[8][1] = 1;
		arr[9][1] = 1;
		arr[10][1] = 1;
		arr[11][1] = 1;
		arr[12][1] = 1;
		arr[13][1] = 1;
		
		arr[2][3] = 1;
		arr[3][3] = 1;
		arr[4][3] = 1;
		arr[5][3] = 1;
		arr[6][3] = 1;
		
		arr[8][3] = 1;
		arr[9][3] = 1;
		arr[10][3] = 1;
		arr[11][3] = 1;
		arr[12][3] = 1;
		
		arr[2][5] = 1;
		arr[3][5] = 2;
		arr[4][5] = 3;
		arr[5][5] = 1;
		arr[6][5] = 1;
		
		arr[8][5] = 1;
		arr[9][5] = 1;
		arr[10][5] = 3;
		arr[11][5] = 2;
		arr[11][6] = 2;
		arr[7][6] = 4;
		
		arr[2][7] = 1;
		arr[3][7] = 1;
		arr[4][7] = 1;
		arr[5][7] = 1;
		arr[6][7] = 1;
		arr[7][7] = 4;
		arr[8][7] = 1;
		arr[9][7] = 1;
		arr[10][7] = 1;
		
		arr[7][8] = 4;
		
		//右半边
		arr[2][9] = 1;
		arr[3][9] = 2;
		arr[4][9] = 3;
		arr[5][9] = 1;
		arr[6][9] = 1;
		
		arr[8][9] = 1;
		arr[9][9] = 1;
		arr[10][9] = 3;
		arr[11][9] = 2;
		arr[11][8] = 2;
		
		arr[2][11] = 1;
		arr[3][11] = 1;
		arr[4][11] = 1;
		arr[5][11] = 1;
		arr[6][11] = 1;
		
		arr[8][11] = 1;
		arr[9][11] = 1;
		arr[10][11] = 1;
		arr[11][11] = 1;
		arr[12][11] = 1;
		
		arr[1][13] = 1;
		arr[2][13] = 1;
		arr[3][13] = 1;
		arr[4][13] = 1;
		arr[5][13] = 1;
		arr[6][13] = 1;
		
		arr[8][13] = 1;
		arr[9][13] = 1;
		arr[10][13] = 1;
		arr[11][13] = 1;
		arr[12][13] = 1;
		arr[13][13] = 1;
		
		
		//老巢外围
		arr[13][6] = 1;
		arr[13][7] = 1;
		arr[13][8] = 1;
		arr[14][8] = 1;
		arr[14][6] = 1;
		
		arr[14][7] = 5;//画老巢
		
		
		
	}
	public void drawLevelSecend() {
		
		arr[1][0] = 3;
		arr[1][1] = 3;
		arr[1][2] = 3;
		arr[1][3] = 3;
		arr[1][4] = 3;
		arr[1][5] = 3;
		arr[1][6] = 3;
		arr[1][7] = 3;
		arr[1][8] = 3;
		arr[1][9] = 3;
		arr[1][10] = 3;
		arr[1][11] = 3;
		arr[1][12] = 3;
		arr[1][13] = 3;
		arr[1][14] = 3;
		
		arr[2][0] = 1;
		arr[2][1] = 1;
		arr[2][2] = 1;
		arr[2][3] = 1;
		arr[2][4] = 1;
		arr[2][5] = 1;
		arr[2][6] = 1;
		arr[2][7] = 1;
		arr[2][8] = 1;
		arr[2][9] = 1;
		arr[2][10] = 1;
		arr[2][11] = 1;
		arr[2][12] = 1;
		arr[2][13] = 1;
		arr[2][14] = 1;
		
		arr[4][1] = 2;
		arr[4][2] = 2;
		arr[4][3] = 2;
		
		arr[4][6] = 2;
		arr[4][7] = 2;
		arr[4][8] = 2;

		arr[4][11] = 2;
		arr[4][12] = 2;
		arr[4][13] = 2;
		
		arr[6][1] = 3;
		arr[6][2] = 3;
		arr[6][3] = 3;
		arr[6][4] = 3;
		arr[6][5] = 3;
		arr[6][6] = 3;
		arr[6][7] = 3;
		arr[6][8] = 3;
		arr[6][9] = 3;
		arr[6][10] = 3;
		arr[6][11] = 3;
		arr[6][12] = 3;
		arr[6][13] = 3;
		
		arr[8][1] = 2;
		arr[8][2] = 2;
		arr[8][3] = 2;
		
		arr[8][6] = 2;
		arr[8][7] = 2;
		arr[8][8] = 2;

		arr[8][11] = 2;
		arr[8][12] = 2;
		arr[8][13] = 2;
		
		arr[10][0] = 1;
		arr[10][1] = 1;
		arr[10][2] = 1;
		arr[10][3] = 1;
		arr[10][4] = 1;
		arr[10][5] = 1;
		arr[10][6] = 1;
		arr[10][7] = 1;
		arr[10][8] = 1;
		arr[10][9] = 1;
		arr[10][10] = 1;
		arr[10][11] = 1;
		arr[10][12] = 1;
		arr[10][13] = 1;
		arr[10][14] = 1;
		
		arr[12][0] = 1;
		arr[12][1] = 1;
		arr[12][2] = 1;
		arr[13][0] = 1;
		arr[13][1] = 2;
		arr[13][2] = 1;
		arr[14][0] = 1;
		arr[14][1] = 1;
		arr[14][2] = 1;
		
		arr[12][12] = 1;
		arr[12][13] = 1;
		arr[12][14] = 1;
		arr[13][12] = 1;
		arr[13][13] = 2;
		arr[13][14] = 1;
		arr[14][12] = 1;
		arr[14][13] = 1;
		arr[14][14] = 1;


		
		//老巢外围
		arr[13][6] = 1;
		arr[13][7] = 1;
		arr[13][8] = 1;
		arr[14][8] = 1;
		arr[14][6] = 1;
				
		arr[14][7] = 5;//画老巢
	}
	public void drawLevelThird() {
		
		arr[1][1] = 1;
		arr[2][1] = 1;
		arr[3][1] = 1;
		arr[4][1] = 1;
		arr[5][1] = 1;
		arr[6][1] = 1;
		arr[7][1] = 1;
		arr[8][1] = 1;
		arr[9][1] = 1;
		arr[10][1] = 1;
		arr[11][1] = 1;
		arr[12][1] = 1;
		arr[13][1] = 1;
		
		arr[1][2] = 1;
		arr[1][3] = 1;
		arr[1][4] = 1;
		arr[1][5] = 1;
		arr[1][6] = 1;
		arr[1][7] = 1;
		arr[1][8] = 1;
		arr[1][9] = 1;
		arr[1][10] = 1;
		arr[1][11] = 1;
		arr[1][12] = 1;
		arr[1][13] = 1;
		
		arr[2][13] = 1;
		arr[3][13] = 1;
		arr[4][13] = 1;
		arr[5][13] = 1;
		arr[6][13] = 1;
		arr[7][13] = 1;
		arr[8][13] = 1;
		arr[9][13] = 1;
		arr[10][13] = 1;
		arr[11][13] = 1;
		arr[12][13] = 1;
		arr[13][13] = 1;
		
		arr[13][2] = 1;
		
		arr[7][3] = 1;
		arr[8][3] = 1;
		arr[9][3] = 1;
		arr[10][3] = 1;
		arr[11][3] = 1;
		arr[12][3] = 1;
		arr[13][3] = 1;

		arr[7][4] = 1;
		arr[7][5] = 1;
		arr[7][6] = 1;
		arr[7][7] = 1;
		arr[7][8] = 1;
		arr[7][9] = 1;
		arr[7][10] = 1;
		arr[7][11] = 1;

		arr[13][12] = 1;
		arr[7][11] = 1;
		arr[8][11] = 1;
		arr[9][11] = 1;
		arr[10][11] = 1;
		arr[11][11] = 1;
		arr[12][11] = 1;
		arr[13][11] = 1;
		
		arr[4][4] = 2;
		arr[4][5] = 2;
		arr[4][6] = 2;
		arr[4][7] = 2;
		arr[4][8] = 2;
		arr[4][9] = 2;
		arr[4][10] = 2;
		
		arr[3][4] = 3;
		arr[3][5] = 3;
		arr[3][6] = 3;
		arr[3][7] = 3;
		arr[3][8] = 3;
		arr[3][9] = 3;
		arr[3][10] = 3;
		
		arr[5][4] = 3;
		arr[5][5] = 3;
		arr[5][6] = 3;
		arr[5][7] = 3;
		arr[5][8] = 3;
		arr[5][9] = 3;
		arr[5][10] = 3;
		
		arr[10][4] = 2;
		arr[10][5] = 2;
		arr[10][6] = 2;
		arr[10][7] = 2;
		arr[10][8] = 2;
		arr[10][9] = 2;
		arr[10][10] = 2;
		
		arr[9][4] = 4;
		arr[9][5] = 4;
		arr[9][6] = 4;
		arr[9][7] = 4;
		arr[9][8] = 4;
		arr[9][9] = 4;
		arr[9][10] = 4;
		
		arr[11][4] = 4;
		arr[11][5] = 4;
		arr[11][6] = 4;
		arr[11][7] = 4;
		arr[11][8] = 4;
		arr[11][9] = 4;
		arr[11][10] = 4;

		
		//老巢外围
		arr[13][6] = 1;
		arr[13][7] = 1;
		arr[13][8] = 1;
		arr[14][8] = 1;
		arr[14][6] = 1;
				
		arr[14][7] = 5;//画老巢
		
	}
	
	
	
//---------------------------------------	

	public int[][] getArr() {
		return arr;
	}

	public void setArr(int[][] arr) {
		this.arr = arr;
	}
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	

}
