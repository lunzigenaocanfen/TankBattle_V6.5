package thread;

import java.awt.Rectangle;
import java.util.ArrayList;

import model.Bullet;
import model.MyTank;
import tool.Util;
import view.MyFrame;

public class EnemyHitMyTankThread extends Thread {
	// 敌方子弹打我方线程
	MyFrame myFrame;

	public EnemyHitMyTankThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {
		//如果吃到BUFF包则线程休眠8S
		while (true) {
			if (Util.impactBuffBag) {
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Util.impactBuffBag = false;
			}

			ArrayList<Bullet> enemyBulletList = myFrame.getEnemyBulletList();
			MyTank myTank = myFrame.getMyTank();
			MyTank secondTank = myFrame.getSecondTank();
			int myTankX = myTank.getX();
			int myTankY = myTank.getY();
			int secondTankX = secondTank.getX();
			int secondTankY = secondTank.getY();
			// 遍历敌方子弹
			for (int i = enemyBulletList.size() - 1; i >= 0; i--) {
				int enemyBulletX = 0;
				int enemyBulletY = 0;
				try {
					enemyBulletX = enemyBulletList.get(i).getDirectX();
					enemyBulletY = enemyBulletList.get(i).getDirectY();
				} catch (Exception e) {
					// TODO: handle exception
				}

				Rectangle myTankRect = new Rectangle(myTankX, myTankY, Util.tankSize, Util.tankSize);
				Rectangle enemyBulletRect = new Rectangle(enemyBulletX, enemyBulletY, Util.bulletSize, Util.bulletSize);
				Rectangle secondTankRect = new Rectangle(secondTankX, secondTankY, Util.tankSize, Util.tankSize);
				// 用户一被打判断
				if (myTankRect.intersects(enemyBulletRect)) {
					// 子弹爆炸
					new BulletBoomThread(myFrame, enemyBulletX, enemyBulletY).start();

					enemyBulletList.remove(i);
					myTank.setHp(myTank.getHp() - Util.enemyBulletPower);

				}
				// 用户二被子弹打到判断
				if (secondTankRect.intersects(enemyBulletRect)) {
					// 子弹爆炸
					new BulletBoomThread(myFrame, enemyBulletX, enemyBulletY).start();

					enemyBulletList.remove(i);
					secondTank.setHp(secondTank.getHp() - Util.enemyBulletPower);

				}
				//用户一血量小于0
				if (myTank.getHp() <= 0) {
					new TankBoomThread(myFrame, myTankX, myTankY).start();
					myTank.setLive(myTank.getLive() - 1);
					myTank.setHp(3);
					// 重置我方位置
					myTank.setX(200);
					myTank.setY(560);
					myTank.setDirect(1);
					Util.fire = false;
					myFrame.getMyTank().setMoveUp(false);
					myFrame.getMyTank().setMoveDown(false);
					myFrame.getMyTank().setMoveLeft(false);
					myFrame.getMyTank().setMoveRight(false);

				}
				//用户二血量小于0
				if (secondTank.getHp() <= 0) {
					new TankBoomThread(myFrame, secondTankX, secondTankY).start();
					secondTank.setLive(secondTank.getLive() - 1);
					secondTank.setHp(3);
					// 重置用户二位置
					secondTank.setX(360);
					secondTank.setY(560);
					secondTank.setDirect(1);
					Util.secondFire = false;
					secondTank.setMoveUp(false);
					secondTank.setMoveDown(false);
					secondTank.setMoveLeft(false);
					secondTank.setMoveRight(false);

				}
				//死亡是
				if (myTank.getLive() <= 0) {
					myTank.setX(1000);
					myTank.setY(1000);
					// 让用户1移动，开火暂停
				}
				if (secondTank.getLive() <= 0) {
					secondTank.setX(1000);
					secondTank.setY(1000);
					// 让用户2移动，开火暂停
				}
				//游戏失败
				if (myTank.getLive() <= 0 && secondTank.getLive() <= 0) {
					Util.lose = true;
				}

			}

			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
