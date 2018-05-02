package thread;

import java.awt.Rectangle;
import java.util.ArrayList;

import model.Bullet;
import tool.Util;
import view.MyFrame;

public class BulletHitBulletThread extends Thread {

	// 我方子弹撞击敌方子弹消除的线程
	MyFrame myFrame;

	public BulletHitBulletThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {

		ArrayList<Bullet> myBulletList = myFrame.getMyBulletList();
		ArrayList<Bullet> enemyBulletList = myFrame.getEnemyBulletList();
		while (true) {
			// 遍历我方子弹
			for (int i = myBulletList.size() - 1; i >= 0; i--) {

				int myBulletX = 0;
				int myBulletY = 0;
				try {
					myBulletX = myBulletList.get(i).getDirectX();
					myBulletY = myBulletList.get(i).getDirectY();
				} catch (Exception e) {
					// TODO: handle exception
				}
				// 遍历敌方子弹
				for (int j = enemyBulletList.size() - 1; j >= 0; j--) {
					int enemyBulletX = 0;
					int enemyBulletY = 0;
					try {
						enemyBulletX = enemyBulletList.get(j).getDirectX();
						enemyBulletY = enemyBulletList.get(j).getDirectY();
					} catch (Exception e) {
						// TODO: handle exception
					}

					// 判断两者碰撞，撞到则移除并爆炸
					Rectangle myBulletRect = new Rectangle(myBulletX, myBulletY, Util.bulletSize, Util.bulletSize);
					Rectangle enemyBulletRect = new Rectangle(enemyBulletX, enemyBulletY, Util.bulletSize,
							Util.bulletSize);
					if (myBulletRect.intersects(enemyBulletRect)) {
						try {
							new BulletBoomThread(myFrame, enemyBulletX, enemyBulletY).start();
							enemyBulletList.remove(j);
							myBulletList.remove(i);
						} catch (Exception e) {
							// TODO: handle exception
						}

						break;
					}

				}
			}

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
