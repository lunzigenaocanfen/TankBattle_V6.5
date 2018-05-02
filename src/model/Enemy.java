package model;

import java.awt.Graphics;


public abstract class Enemy {

	private int row;//����
	private int col = 0 ;
	private int type;//����
	private int value;//��ֵ
	private int direct = 2 ;//����
	private int hp;//Ѫ���ж���

	
	public Enemy() {
		
	}
	//���Լ���Ѫ�����ƶ�
	public abstract void drawHp(Graphics g);
	public abstract void drawEnemy(Graphics g);
	public abstract void moveUp();
	public abstract void moveDowm();
	public abstract void moveLeft();
	public abstract void moveRight();

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}


		
	
	
}
