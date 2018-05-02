package model;

import java.awt.Color;
import java.awt.Graphics;

import tool.Util;

public class MyTank {

	private int x ;//坐标
	private int y ;
	private int hp = 3;//三滴血
	private int live = 3;//有几条命
	private int direct = 1;//朝向
	private int stept = 10;//步伐
	private int hpReduce = 14; //打中时扣20血
	private int type;//判断坦克是用户几
	//移动判断
	private boolean moveUp = false;
	private boolean moveDown = false;
	private boolean moveLeft = false;
	private boolean moveRight = false;
	
	public MyTank(int x, int y,int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public void drawMy(Graphics g) {

		if(type==1) {
		switch (direct) {
		case 1://上
			g.drawImage(Util.IMG_MYTANKU, x, y, x+Util.tankSize, y+Util.tankSize,
					0, 0, Util.IMG_MYTANKU.getWidth(null), Util.IMG_MYTANKU.getHeight(null), null);
			break;
		case 2://下
			g.drawImage(Util.IMG_MYTANKD, x, y, x+Util.tankSize, y+Util.tankSize,
					0, 0, Util.IMG_MYTANKD.getWidth(null), Util.IMG_MYTANKD.getHeight(null), null);
			break;
		case 3://左
			g.drawImage(Util.IMG_MYTANKL, x, y, x+Util.tankSize, y+Util.tankSize,
					0, 0, Util.IMG_MYTANKL.getWidth(null), Util.IMG_MYTANKL.getHeight(null), null);
			break;
		case 4://右
			g.drawImage(Util.IMG_MYTANKR, x, y, x+Util.tankSize, y+Util.tankSize,
					0, 0, Util.IMG_MYTANKR.getWidth(null), Util.IMG_MYTANKR.getHeight(null), null);
			break;

		default:
			break;
		}
		}
		if(type==2) {
			switch (direct) {
			case 1://上
				g.drawImage(Util.IMG_SECONDTANKU, x, y, x+Util.tankSize, y+Util.tankSize,
						0, 0, Util.IMG_SECONDTANKU.getWidth(null), Util.IMG_SECONDTANKU.getHeight(null), null);
				break;
			case 2://下
				g.drawImage(Util.IMG_SECONDTANKD, x, y, x+Util.tankSize, y+Util.tankSize,
						0, 0, Util.IMG_SECONDTANKD.getWidth(null), Util.IMG_SECONDTANKD.getHeight(null), null);
				break;
			case 3://左
				g.drawImage(Util.IMG_SECONDTANKL, x, y, x+Util.tankSize, y+Util.tankSize,
						0, 0, Util.IMG_SECONDTANKL.getWidth(null), Util.IMG_SECONDTANKL.getHeight(null), null);
				break;
			case 4://右
				g.drawImage(Util.IMG_SECONDTANKR, x, y, x+Util.tankSize, y+Util.tankSize,
						0, 0, Util.IMG_SECONDTANKR.getWidth(null), Util.IMG_SECONDTANKR.getHeight(null), null);
				break;

			default:
				break;
			}
		}
		
	}
	public void drawHp(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(this.x-1, this.y - 15, 42, 10);
		g.setColor(Color.GREEN);
		g.fillRect(this.x-1, this.y - 15, 14*this.hp, 10);
	}
	
	//移动
	public void moveUp() {
		
		if( y > 0 ) {	
			y -= stept;
		}
	}
	public void moveDown() {
		if(y+Util.tankSize < Util.gameHeight) {
			y += stept;
		}
		
		
	}
	public void moveLeft() {
		if(x > 0) {
			x -= stept;
		}
		
	
	}
	public void moveRight() {
		if(x + Util.tankSize < Util.gameWidth) {
			x += stept;
		}
		
	
	}
	
	
	
	
	
	
//--------------------------------------------------------
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

	public int getStept() {
		return stept;
	}

	public void setStept(int stept) {
		this.stept = stept;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHpReduce() {
		return hpReduce;
	}

	public void setHpReduce(int hpReduce) {
		this.hpReduce = hpReduce;
	}

	public int getLive() {
		return live;
	}

	public void setLive(int live) {
		this.live = live;
	}

	public boolean isMoveUp() {
		return moveUp;
	}

	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}

	public boolean isMoveDown() {
		return moveDown;
	}

	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}

	public boolean isMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}
