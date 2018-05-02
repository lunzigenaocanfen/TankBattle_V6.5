package thread;

import java.awt.Rectangle;
import java.util.ArrayList;

import model.Bullet;
import tool.Util;
import view.MyFrame;

public class MyBulletHitThread extends Thread {
	// 我方子弹击打障碍物线程
	MyFrame myFrame;

	public MyBulletHitThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {

		while (true) {
			ArrayList<Bullet> buList = myFrame.getMyBulletList();
			int[][] gameMap = myFrame.getGameMap().getArr();

			for (int i = buList.size() - 1; i >= 0; i--) {
				// 先遍历子弹
				int buX = 0;
				int buY = 0;
				try {
					buX = buList.get(i).getDirectX();
					buY = buList.get(i).getDirectY();
				} catch (Exception e) {
					// TODO: handle exception
				}

				for (int j = 0; j < gameMap.length; j++) {
					for (int j2 = 0; j2 < gameMap[j].length; j2++) {
						Rectangle bulletRect = new Rectangle(buX, buY, Util.bulletSize, Util.bulletSize);

						// 地形为砖头
						if (gameMap[j][j2] == 1) {
							int mapX = j2 * Util.wallSize;
							int mapY = j * Util.wallSize;
							Rectangle mapWallRect = new Rectangle(mapX, mapY, Util.wallSize, Util.wallSize);
							// 判断是否打中
							if (bulletRect.intersects(mapWallRect)) {
								// 移除子弹 墙
								// 子弹墙爆炸

								try {
									new BulletBoomThread(myFrame, buX, buY).start();
									buList.remove(i);
								} catch (Exception e) {
									// TODO: handle exception
								}

								gameMap[j][j2] = 0;
								continue;
							}
						} else if (gameMap[j][j2] == 2) {
							int mapSteelX = j2 * Util.wallSize;
							int mapSteelY = j * Util.wallSize;
							Rectangle mapSteelRect = new Rectangle(mapSteelX, mapSteelY, Util.wallSize, Util.wallSize);

							if (bulletRect.intersects(mapSteelRect)) {
								// 移除子弹
								// 子弹爆炸

								try {
									new BulletBoomThread(myFrame, buX, buY).start();
									buList.remove(i);
								} catch (Exception e) {
									// TODO: handle exception
								}

								continue;

							}
						} else if (gameMap[j][j2] == 5) {
							int homeX = j2 * Util.wallSize;
							int homeY = j * Util.wallSize;
							Rectangle homeRect = new Rectangle(homeX, homeY, Util.wallSize, Util.wallSize);
							if (bulletRect.intersects(homeRect)) {
								// 子弹爆炸

								try {
									new BulletBoomThread(myFrame, buX, buY).start();
									buList.remove(i);
								} catch (Exception e) {
									// TODO: handle exception
								}
								Util.lose = true;
								continue;
							}
						}
					}
				}
			}

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
