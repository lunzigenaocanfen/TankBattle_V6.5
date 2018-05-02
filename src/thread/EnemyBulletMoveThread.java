package thread;

import java.util.ArrayList;

import model.Bullet;
import tool.Util;
import view.MyFrame;

public class EnemyBulletMoveThread extends Thread {
	// 敌人子弹移动与边界判断线程
	MyFrame myFrame;

	public EnemyBulletMoveThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {

		while (true) {
			if (Util.pause) {
				ArrayList<Bullet> enemyBulletList = myFrame.getEnemyBulletList();
				try {
					// 遍历每一个子弹
					for (int i = enemyBulletList.size() - 1; i >= 0; i--) {
						int bulletDirection = 0;

						bulletDirection = enemyBulletList.get(i).getDirect();

						switch (bulletDirection) {
						case 1:
							// 上移时，越界时移除
							if (enemyBulletList.get(i).getDirectY() > -20) {
								enemyBulletList.get(i).moveUp();
							} else {
								enemyBulletList.remove(i);
							}
							break;
						case 2:
							// 下移时，越界时移除
							if (enemyBulletList.get(i).getDirectY() < Util.gameHeight + 20) {
								enemyBulletList.get(i).moveDown();
							} else {
								enemyBulletList.remove(i);
							}

							break;
						case 3:
							// 左移时，越界时移除
							if (enemyBulletList.get(i).getDirectX() > -20) {
								enemyBulletList.get(i).moveLeft();
							} else {
								enemyBulletList.remove(i);
							}
							break;
						case 4:
							// 右移时，越界时移除
							if (enemyBulletList.get(i).getDirectX() < Util.gameWidth + 20) {
								enemyBulletList.get(i).moveRight();
							} else {
								enemyBulletList.remove(i);
							}
							break;
						default:
							break;
						}

					}
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
			try {
				Thread.sleep(50 / Util.enemyBulletSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
