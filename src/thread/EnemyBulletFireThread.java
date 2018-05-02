package thread;

import java.util.ArrayList;

import model.Bullet;
import model.Enemy;
import tool.Util;
import view.MyFrame;

public class EnemyBulletFireThread extends Thread {
	// 敌人开火线程
	MyFrame myFrame;

	public EnemyBulletFireThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {
		while (true) {
			if (Util.pause) {
				ArrayList<Bullet> enemyBulletList = myFrame.getEnemyBulletList();
				ArrayList<Enemy> enemyList = myFrame.getEnemyList();
				// 遍历所有敌人，然后给敌人子弹集合中添加每个敌人的子弹；
				for (int i = enemyList.size() - 1; i >= 0; i--) {
					int enemyX = enemyList.get(i).getRow();
					int enemyY = enemyList.get(i).getCol();
					int enemyDirection = enemyList.get(i).getDirect();
					enemyBulletList.add(new Bullet(enemyX, enemyY, enemyDirection));
				}

			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
