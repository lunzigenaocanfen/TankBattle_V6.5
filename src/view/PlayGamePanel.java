package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Bullet;
import model.Enemy;
import tool.Util;

public class PlayGamePanel extends JPanel{
	//游戏运行面板
	MyFrame myFrame ;
	
	public PlayGamePanel(MyFrame myFrame) {
		this.myFrame = myFrame ;
		this.setLayout(null);
		this.setPreferredSize(new Dimension(Util.gameWidth, Util.gameHeight));
		//设置可以获得焦点
		this.setFocusable(true);
		this.requestFocus();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		//背景
		
		switch (myFrame.getPlayGameFrame().getLevel()) {
		case 0://还没开始游戏时的界面
			g.drawImage(Util.IMG_WELCOMEUSER, 0, 0, Util.gameWidth, Util.gameHeight,
					0, 0, Util.IMG_WELCOMEUSER.getWidth(null), Util.IMG_WELCOMEUSER.getHeight(null), null);
			break;
		case 1://第一关
			//背景
			g.drawImage(Util.IMG_BACKGROUND, 0, 0, Util.gameWidth, Util.gameHeight, 0, 0, 
					Util.IMG_BACKGROUND.getWidth(null), Util.IMG_BACKGROUND.getHeight(null), null);
			
			
			//画我方坦克
			myFrame.getMyTank().drawMy(g);
			//画玩家二
			myFrame.getSecondTank().drawMy(g); 
			//画敌人
			drawEnemy(g);
			//画第一关地图
			myFrame.getGameMap().drawMap(g);
			//画血条
			drawEnemyHp(g);
			//玩家二血条
			myFrame.getSecondTank().drawHp(g);
			//画敌方子弹
			drawEnemyBullet(g);
			//画我方血条
			myFrame.getMyTank().drawHp(g);
			//画我方子弹
			drawBullet(g);
			myFrame.getPropBag().drawPropBag(g);
			break;
		case 2://第二关
			//背景
			g.drawImage(Util.IMG_BACKGROUND, 0, 0, Util.gameWidth, Util.gameHeight, 0, 0, 
					Util.IMG_BACKGROUND.getWidth(null), Util.IMG_BACKGROUND.getHeight(null), null);
			
			//画我方坦克
			myFrame.getMyTank().drawMy(g);
			//画玩家二
			myFrame.getSecondTank().drawMy(g); 
			//画敌人
			drawEnemy(g);
			//第二关地图
			myFrame.getGameMap().drawMap(g);
			//画血条
			drawEnemyHp(g);
			//玩家二血条
			myFrame.getSecondTank().drawHp(g);
			//画敌方子弹
			drawEnemyBullet(g);
			//画我方血条
			myFrame.getMyTank().drawHp(g);
			//画我方子弹
			drawBullet(g);
			
			break;
		case 3://第三关
			//背景
			g.drawImage(Util.IMG_BACKGROUND, 0, 0, Util.gameWidth, Util.gameHeight, 0, 0, 
					Util.IMG_BACKGROUND.getWidth(null), Util.IMG_BACKGROUND.getHeight(null), null);
			
			//画我方坦克
			myFrame.getMyTank().drawMy(g);
			//画玩家二
			myFrame.getSecondTank().drawMy(g); 
			//画敌人
			drawEnemy(g);
			//第三关地图
			myFrame.getGameMap().drawMap(g);
			//画血条
			drawEnemyHp(g);
			//画敌方子弹
			drawEnemyBullet(g);
			//画我方血条
			myFrame.getMyTank().drawHp(g);
			//玩家二血条
			myFrame.getSecondTank().drawHp(g);
			//画我方子弹
			drawBullet(g);

			
			break;
		case 98://自定义关卡的背景
			//背景
			g.drawImage(Util.IMG_BACKGROUND, 0, 0, Util.gameWidth, Util.gameHeight, 0, 0, 
					Util.IMG_BACKGROUND.getWidth(null), Util.IMG_BACKGROUND.getHeight(null), null);
			//画自定义地图
			myFrame.getGameMap().drawMap(g);
			break;
		case 99://自定义关卡开始游戏
			//背景
			g.drawImage(Util.IMG_BACKGROUND, 0, 0, Util.gameWidth, Util.gameHeight, 0, 0, 
					Util.IMG_BACKGROUND.getWidth(null), Util.IMG_BACKGROUND.getHeight(null), null);
			
			//画我方坦克
			myFrame.getMyTank().drawMy(g);
			//画玩家二
			myFrame.getSecondTank().drawMy(g); 
			//画敌人
			drawEnemy(g);
			//画自定义地图
			myFrame.getGameMap().drawMap(g);
			//画血条
			drawEnemyHp(g);
			//画敌方子弹
			drawEnemyBullet(g);
			//画我方血条
			myFrame.getMyTank().drawHp(g);
			//玩家二血条
			myFrame.getSecondTank().drawHp(g);
			//画我方子弹
			drawBullet(g);
			break;
		default:
			break;
		}

	}
	//画我方子弹   遍历所有子弹
	public void drawBullet(Graphics g) {
		ArrayList<Bullet> buList = myFrame.getMyBulletList();
		for (int i = buList.size() - 1; i >= 0 ; i--) {
			buList.get(i).drawBullet(g);
		}
	}
	
	//画敌人 ，画血条  遍历敌人
	public void drawEnemy( Graphics g ) {
		ArrayList<Enemy> enemyList = myFrame.getEnemyList();
		for (int i = enemyList.size() - 1; i >= 0; i--) {
			enemyList.get(i).drawEnemy(g);

		}		
	}
	//画敌人子弹    遍历敌人子弹。
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
