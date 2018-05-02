package thread;

import java.awt.Rectangle;
import java.util.ArrayList;

import model.Bullet;
import tool.Util;
import view.MyFrame;

public class EnemyBulletHitThread extends Thread {
	// 敌人子弹撞墙线程
	MyFrame myFrame;

	public EnemyBulletHitThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {

		while (true) {
			// 遍历敌人子弹。然后遍历地图
			ArrayList<Bullet> enemyBulletList = myFrame.getEnemyBulletList();
			int[][] gameMap = myFrame.getGameMap().getArr();

			for (int i = enemyBulletList.size() - 1; i >= 0; i--) {
				int enemyBulletX = 0;
				int enemyBulletY = 0;
				try {
					enemyBulletX = enemyBulletList.get(i).getDirectX();
					enemyBulletY = enemyBulletList.get(i).getDirectY();
				} catch (Exception e) {
					// TODO: handle exception
				}

				j: for (int j = 0; j < gameMap.length; j++) {
					for (int j2 = 0; j2 < gameMap[j].length; j2++) {
						Rectangle enemyBulletRect = new Rectangle(enemyBulletX, enemyBulletY, Util.bulletSize,
								Util.bulletSize);
						// 如果是砖墙的话
						if (gameMap[j][j2] == 1) {
							int mapWallX = j2 * Util.wallSize;
							int mapWallY = j * Util.wallSize;
							Rectangle mapWallRect = new Rectangle(mapWallX, mapWallY, Util.wallSize, Util.wallSize);
							if (enemyBulletRect.intersects(mapWallRect)) {
								// 打中砖头消失
								gameMap[j][j2] = 0;
								// 爆炸
								new BulletBoomThread(myFrame, enemyBulletX, enemyBulletY).start();
								enemyBulletList.remove(i);

								break j;
							}
							// 如果是铁墙的话
						} else if (gameMap[j][j2] == 2) {
							int mapSteelX = j2 * Util.wallSize;
							int mapSteelY = j * Util.wallSize;
							Rectangle mapSteelRect = new Rectangle(mapSteelX, mapSteelY, Util.wallSize, Util.wallSize);

							if (enemyBulletRect.intersects(mapSteelRect)) {
								// 子弹爆炸
								// 移除子弹
								new BulletBoomThread(myFrame, enemyBulletX, enemyBulletY).start();
								enemyBulletList.remove(i);

								break j;
							}
						} else if (gameMap[j][j2] == 5) {
							int homeX = j2 * Util.wallSize;
							int homeY = j * Util.wallSize;
							Rectangle homeRect = new Rectangle(homeX, homeY, Util.wallSize, Util.wallSize);
							if (enemyBulletRect.intersects(homeRect)) {
								Util.lose = true;
								// 子弹爆炸
								// 移除子弹
								new BulletBoomThread(myFrame, enemyBulletX, enemyBulletY).start();
								enemyBulletList.remove(i);

								break j;
							}
						}
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
