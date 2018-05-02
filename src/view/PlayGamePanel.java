package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Bullet;
import model.Enemy;
import tool.Util;

public class PlayGamePanel extends JPanel{
	//��Ϸ�������
	MyFrame myFrame ;
	
	public PlayGamePanel(MyFrame myFrame) {
		this.myFrame = myFrame ;
		this.setLayout(null);
		this.setPreferredSize(new Dimension(Util.gameWidth, Util.gameHeight));
		//���ÿ��Ի�ý���
		this.setFocusable(true);
		this.requestFocus();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		//����
		
		switch (myFrame.getPlayGameFrame().getLevel()) {
		case 0://��û��ʼ��Ϸʱ�Ľ���
			g.drawImage(Util.IMG_WELCOMEUSER, 0, 0, Util.gameWidth, Util.gameHeight,
					0, 0, Util.IMG_WELCOMEUSER.getWidth(null), Util.IMG_WELCOMEUSER.getHeight(null), null);
			break;
		case 1://��һ��
			//����
			g.drawImage(Util.IMG_BACKGROUND, 0, 0, Util.gameWidth, Util.gameHeight, 0, 0, 
					Util.IMG_BACKGROUND.getWidth(null), Util.IMG_BACKGROUND.getHeight(null), null);
			
			
			//���ҷ�̹��
			myFrame.getMyTank().drawMy(g);
			//����Ҷ�
			myFrame.getSecondTank().drawMy(g); 
			//������
			drawEnemy(g);
			//����һ�ص�ͼ
			myFrame.getGameMap().drawMap(g);
			//��Ѫ��
			drawEnemyHp(g);
			//��Ҷ�Ѫ��
			myFrame.getSecondTank().drawHp(g);
			//���з��ӵ�
			drawEnemyBullet(g);
			//���ҷ�Ѫ��
			myFrame.getMyTank().drawHp(g);
			//���ҷ��ӵ�
			drawBullet(g);
			myFrame.getPropBag().drawPropBag(g);
			break;
		case 2://�ڶ���
			//����
			g.drawImage(Util.IMG_BACKGROUND, 0, 0, Util.gameWidth, Util.gameHeight, 0, 0, 
					Util.IMG_BACKGROUND.getWidth(null), Util.IMG_BACKGROUND.getHeight(null), null);
			
			//���ҷ�̹��
			myFrame.getMyTank().drawMy(g);
			//����Ҷ�
			myFrame.getSecondTank().drawMy(g); 
			//������
			drawEnemy(g);
			//�ڶ��ص�ͼ
			myFrame.getGameMap().drawMap(g);
			//��Ѫ��
			drawEnemyHp(g);
			//��Ҷ�Ѫ��
			myFrame.getSecondTank().drawHp(g);
			//���з��ӵ�
			drawEnemyBullet(g);
			//���ҷ�Ѫ��
			myFrame.getMyTank().drawHp(g);
			//���ҷ��ӵ�
			drawBullet(g);
			
			break;
		case 3://������
			//����
			g.drawImage(Util.IMG_BACKGROUND, 0, 0, Util.gameWidth, Util.gameHeight, 0, 0, 
					Util.IMG_BACKGROUND.getWidth(null), Util.IMG_BACKGROUND.getHeight(null), null);
			
			//���ҷ�̹��
			myFrame.getMyTank().drawMy(g);
			//����Ҷ�
			myFrame.getSecondTank().drawMy(g); 
			//������
			drawEnemy(g);
			//�����ص�ͼ
			myFrame.getGameMap().drawMap(g);
			//��Ѫ��
			drawEnemyHp(g);
			//���з��ӵ�
			drawEnemyBullet(g);
			//���ҷ�Ѫ��
			myFrame.getMyTank().drawHp(g);
			//��Ҷ�Ѫ��
			myFrame.getSecondTank().drawHp(g);
			//���ҷ��ӵ�
			drawBullet(g);

			
			break;
		case 98://�Զ���ؿ��ı���
			//����
			g.drawImage(Util.IMG_BACKGROUND, 0, 0, Util.gameWidth, Util.gameHeight, 0, 0, 
					Util.IMG_BACKGROUND.getWidth(null), Util.IMG_BACKGROUND.getHeight(null), null);
			//���Զ����ͼ
			myFrame.getGameMap().drawMap(g);
			break;
		case 99://�Զ���ؿ���ʼ��Ϸ
			//����
			g.drawImage(Util.IMG_BACKGROUND, 0, 0, Util.gameWidth, Util.gameHeight, 0, 0, 
					Util.IMG_BACKGROUND.getWidth(null), Util.IMG_BACKGROUND.getHeight(null), null);
			
			//���ҷ�̹��
			myFrame.getMyTank().drawMy(g);
			//����Ҷ�
			myFrame.getSecondTank().drawMy(g); 
			//������
			drawEnemy(g);
			//���Զ����ͼ
			myFrame.getGameMap().drawMap(g);
			//��Ѫ��
			drawEnemyHp(g);
			//���з��ӵ�
			drawEnemyBullet(g);
			//���ҷ�Ѫ��
			myFrame.getMyTank().drawHp(g);
			//��Ҷ�Ѫ��
			myFrame.getSecondTank().drawHp(g);
			//���ҷ��ӵ�
			drawBullet(g);
			break;
		default:
			break;
		}

	}
	//���ҷ��ӵ�   ���������ӵ�
	public void drawBullet(Graphics g) {
		ArrayList<Bullet> buList = myFrame.getMyBulletList();
		for (int i = buList.size() - 1; i >= 0 ; i--) {
			buList.get(i).drawBullet(g);
		}
	}
	
	//������ ����Ѫ��  ��������
	public void drawEnemy( Graphics g ) {
		ArrayList<Enemy> enemyList = myFrame.getEnemyList();
		for (int i = enemyList.size() - 1; i >= 0; i--) {
			enemyList.get(i).drawEnemy(g);

		}		
	}
	//�������ӵ�    ���������ӵ���
	public void drawEnemyBullet( Graphics g ) {
		ArrayList<Bullet> enemyBulletList = myFrame.getEnemyBulletList();
		for (int i = enemyBulletList.size() - 1; i >= 0 ; i--) {
			try {
				enemyBulletList.get(i).drawBullet(g);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}

	}
	public void drawEnemyHp( Graphics g ) {
		ArrayList<Enemy> enemyList = myFrame.getEnemyList();
		for (int i = enemyList.size() - 1; i >= 0; i--) {
			
			enemyList.get(i).drawHp(g);
			
		}		
	}

}
