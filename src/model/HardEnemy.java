package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import tool.Util;

public class HardEnemy extends Enemy {
	//困难敌人
	public HardEnemy() {
		super();
		this.setValue(300);//分值
		this.setType(2);//类型
		this.setRow(new Random().nextInt(Util.gameWidth/Util.tankSize)*Util.tankSize);//随机出现
		this.setHp(3);//血量
	}

	@Override
	public void drawEnemy(Graphics g) {
		switch (this.getDirect()) {
		//画四个方位
		case 1:
			g.drawImage(Util.IMG_ENEMYHARDU, this.getRow(), this.getCol(), this.getRow()+Util.tankSize, 
					this.getCol()+Util.tankSize, 0, 0, Util.IMG_ENEMYHARDU.getWidth(null), Util.IMG_ENEMYHARDU.getHeight(null), null);
			break;
		case 2:
			g.drawImage(Util.IMG_ENEMYHARDD, this.getRow(), this.getCol(), this.getRow()+Util.tankSize, 
					this.getCol()+Util.tankSize, 0, 0, Util.IMG_ENEMYHARDD.getWidth(null), Util.IMG_ENEMYHARDD.getHeight(null), null);
			break;
		case 3:
			g.drawImage(Util.IMG_ENEMYHARDL, this.getRow(), this.getCol(), this.getRow()+Util.tankSize, 
					this.getCol()+Util.tankSize, 0, 0, Util.IMG_ENEMYHARDL.getWidth(null), Util.IMG_ENEMYHARDL.getHeight(null), null);
			break;
		case 4:
			g.drawImage(Util.IMG_ENEMYHARDR, this.getRow(), this.getCol(), this.getRow()+Util.tankSize, 
					this.getCol()+Util.tankSize, 0, 0, Util.IMG_ENEMYHARDR.getWidth(null), Util.IMG_ENEMYHARDR.getHeight(null), null);
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
		g.fillRect(this.getRow()-1, this.getCol() - 15, this.getHp()*14, 10);
	}
	//移动
	@Override
	public void moveUp() {
		if( this.getCol() > 0 ) {	
			this.setCol(this.getCol()-Util.hardStept);
		}
		
	}

	@Override
	public void moveDowm() {
		if(this.getCol() + Util.tankSize < Util.gameHeight) {
			this.setCol(this.getCol()+Util.hardStept);
		}
		
	}

	@Override
	public void moveLeft() {
		if(this.getRow() > 0) {
			this.setRow(this.getRow()-Util.hardStept);
		}
		
	}

	@Override
	public void moveRight() {
		if(this.getRow() + Util.tankSize < Util.gameWidth) {
			this.setRow(this.getRow()+Util.hardStept);
		}
		
	}

}
