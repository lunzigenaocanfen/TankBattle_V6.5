package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import tool.Util;

public class NormalEnemy extends Enemy {
	//һ�����
	public NormalEnemy() {
		super();
		this.setValue(200);//��ֵ
		this.setType(1);//����
		this.setRow(new Random().nextInt(Util.gameWidth/Util.tankSize)*Util.tankSize);//�������
		this.setHp(1);//Ѫ��
	}

	@Override
	public void drawEnemy(Graphics g) {
		//���ĸ���λ
		switch (this.getDirect()) {
		case 1:
			g.drawImage(Util.IMG_ENEMYNORMALU, this.getRow(), this.getCol(), this.getRow()+Util.tankSize, 
					this.getCol()+Util.tankSize, 0, 0, Util.IMG_ENEMYNORMALU.getWidth(null), Util.IMG_ENEMYNORMALU.getHeight(null), null);
			break;
		case 2:
			g.drawImage(Util.IMG_ENEMYNORMALD, this.getRow(), this.getCol(), this.getRow()+Util.tankSize, 
					this.getCol()+Util.tankSize, 0, 0, Util.IMG_ENEMYNORMALD.getWidth(null), Util.IMG_ENEMYNORMALD.getHeight(null), null);
			break;
		case 3:
			g.drawImage(Util.IMG_ENEMYNORMALL, this.getRow(), this.getCol(), this.getRow()+Util.tankSize, 
					this.getCol()+Util.tankSize, 0, 0, Util.IMG_ENEMYNORMALL.getWidth(null), Util.IMG_ENEMYNORMALL.getHeight(null), null);
			break;
		case 4:
			g.drawImage(Util.IMG_ENEMYNORMALR, this.getRow(), this.getCol(), this.getRow()+Util.tankSize, 
					this.getCol()+Util.tankSize, 0, 0, Util.IMG_ENEMYNORMALR.getWidth(null), Util.IMG_ENEMYNORMALR.getHeight(null), null);
			break;

		default:
			break;
		}

	}

	//��Ѫ��
	@Override
	public void drawHp(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(this.getRow()-1, this.getCol() - 15, 42, 10);
		g.setColor(Color.GREEN);
		g.fillRect(this.getRow()-1, this.getCol() - 15, this.getHp()*42, 10);
		
	}
	
	//�ƶ�
	@Override
	public void moveUp() {
		if( this.getCol() > 0 ) {	
			this.setCol(this.getCol()-10);
		}
		
	}

	@Override
	public void moveDowm() {
		if(this.getCol() + Util.tankSize < Util.gameHeight) {
			this.setCol(this.getCol()+10);
		}
		
	}

	@Override
	public void moveLeft() {
		if(this.getRow() > 0) {
			this.setRow(this.getRow()-10);
		}
		
	}

	@Override
	public void moveRight() {
		if(this.getRow() + Util.tankSize < Util.gameWidth) {
			this.setRow(this.getRow()+10);
		}
		
	}

	

}
