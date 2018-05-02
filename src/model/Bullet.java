package model;

import java.awt.Graphics;

import tool.Util;

public class Bullet {
	//子弹类
	private int x;//坦克的坐标
	private int y;
	private int direct = 1;//默认方向
	private int directX;//子弹的坐标
	private int directY;
//	private boolean fire = false;
	public Bullet(int x , int y, int direct) {

		this.x = x ;
		this.y = y ;
		this.direct = direct;
	}
	
	public void drawBullet(Graphics g) {

		if( direct == 1 ) {
			//子弹方向向上
			directX = x + (Util.tankSize - Util.myBulletSize) / 2;
			directY = y - (Util.tankSize - Util.myBulletSize) / 2;
		}else if( direct == 2 ) {
			//子弹方向向下
			directX = x + (Util.tankSize - Util.myBulletSize) / 2;
			directY = y + Util.tankSize;
		}else if( direct == 3 ) {
			//子弹方向向左
			directX = x - (Util.tankSize - Util.myBulletSize) / 2;
			directY = y + (Util.tankSize - Util.myBulletSize) / 2;
		}else if( direct == 4 ) {
			//子弹方向向右
			directX = x + Util.tankSize;
			directY = y + (Util.tankSize - Util.myBulletSize) / 2;
		}
		//画子弹
		g.drawImage(Util.IMG_MYBULLET, directX , directY, directX+Util.myBulletSize, directY+Util.myBulletSize,
				0, 0, Util.IMG_MYBULLET.getWidth(null), Util.IMG_MYBULLET.getWidth(null), null);
		
	}
	public void moveUp() {
		this.y -= 10;
	}
	public void moveDown() {
		this.y += 10;
	}
	public void moveLeft() {
		this.x -= 10;
	}
	public void moveRight() {
		this.x += 10;
	}
	
	
	
//----------------------------------	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getDirectX() {
		return directX;
	}

	public void setDirectX(int directX) {
		this.directX = directX;
	}

	public int getDirectY() {
		return directY;
	}

	public void setDirectY(int directY) {
		this.directY = directY;
	}


}
