package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import tool.Util;

public class EasyEnemy extends Enemy {
	//简单敌人
	public EasyEnemy() {
		super();
		this.setValue(100);//分值
		this.setType(0);//类型
		this.setRow(new Random().nextInt(Util.gameWidth/Util.tankSize)*Util.tankSize);//随机位置
		this.setHp(2);//血量
	}

	@Override
	public void drawEnemy(Graphics g) {
		switch (this.getDirect()) {
		//画不同方向
		case 1:
			g.drawImage(Util.IMG_ENEMYEASYU, this.getRow(), this.getCol(), this.getRow()+Util.tankSize, 
					this.getCol()+Util.tankSize, 0, 0, Util.IMG_ENEMYEASYU.getWidth(null), Util.IMG_ENEMYEASYU.getHeight(null), null);
			break;
		case 2:
			g.drawImage(Util.IMG_ENEMYEASYD, this.getRow(), this.getCol(), this.getRow()+Util.tankSize, 
					this.getCol()+Util.tankSize, 0, 0, Util.IMG_ENEMYEASYD.getWidth(null), Util.IMG_ENEMYEASYD.getHeight(null), null);
			break;
		case 3:
			g.drawImage(Util.IMG_ENEMYEASYL, this.getRow(), this.getCol(), this.getRow()+Util.tankSize, 
					this.getCol()+Util.tankSize, 0, 0, Util.IMG_ENEMYEASYL.getWidth(null), Util.IMG_ENEMYEASYL.getHeight(null), null);
			break;
		case 4:
			g.drawImage(Util.IMG_ENEMYEASYR, this.getRow(), this.getCol(), this.getRow()+Util.tankSize, 
					this.getCol()+Util.tankSize, 0, 0, Util.IMG_ENEMYEASYR.getWidth(null), Util.IMG_ENEMYEASYR.getHeight(null), null);
			break;

		default:
			break;
		}

	}
	@Override
	public void drawHp(Graphics g) {
		//画血条
		g.setColor(Color.RED);
		g.fillRect(this.getRow()-1, this.getCol() - 15, 42, 10);
		g.setColor(Color.GREEN);
		g.fillRect(this.getRow()-1, this.getCol() - 15, this.getHp()*21, 10);
	}

	@Override
	public void moveUp() {
		if( this.getCol() > 0 ) {	
			this.setCol(this.getCol()-Util.easyStept);
		}
	}

	@Override
	public void moveDowm() {
		if(this.getCol() + Util.tankSize < Util.gameHeight) {
			this.setCol(this.getCol()+Util.easyStept);
		}
	}

	@Override
	public void moveLeft() {
		if(this.getRow() > 0) {
			this.setRow(this.getRow()-Util.easyStept);
		}
	}

	@Override
	public void moveRight() {
		if(this.getRow() + Util.tankSize < Util.gameWidth) {
			this.setRow(this.getRow()+Util.easyStept);
		}
	}

}
