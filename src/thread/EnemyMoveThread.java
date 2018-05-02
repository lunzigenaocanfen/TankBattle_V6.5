package thread;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import model.Enemy;
import tool.Util;
import view.MyFrame;

public class EnemyMoveThread extends Thread {
	// �����ƶ��߳�
	MyFrame myFrame;

	public EnemyMoveThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {

		while (true) {
			if (Util.pause) {
				ArrayList<Enemy> enemyList = myFrame.getEnemyList();
				int[][] gameMap = myFrame.getGameMap().getArr();
				// �����з�̹�ˣ��з�̹���ƶ��ҵ���߽�ʱ������
				for (int i = enemyList.size() - 1; i >= 0; i--) {
					int key = enemyList.get(i).getDirect();
					// ��ȡ����Ȼ���ƶ�
					switch (key) {
					case 1:
						// ����
						if (enemyList.get(i).getCol() == 0) {
							enemyList.get(i).setDirect(new Random().nextInt(4) + 1);
						}
						enemyList.get(i).moveUp();
						break;
					case 2:
						// ����
						if (enemyList.get(i).getCol() + Util.tankSize == Util.gameHeight) {
							enemyList.get(i).setDirect(new Random().nextInt(4) + 1);
						}
						enemyList.get(i).moveDowm();
						break;
					case 3:
						// ����
						if (enemyList.get(i).getRow() == 0) {
							enemyList.get(i).setDirect(new Random().nextInt(4) + 1);
						}
						enemyList.get(i).moveLeft();

						break;
					case 4:
						// ����
						if (enemyList.get(i).getRow() + Util.tankSize == Util.gameWidth) {
							enemyList.get(i).setDirect(new Random().nextInt(4) + 1);
						}
						enemyList.get(i).moveRight();
						break;

					default:
						break;
					}

					int enemyX = enemyList.get(i).getRow();
					int enemyY = enemyList.get(i).getCol();
					j: for (int j = 0; j < gameMap.length; j++) {
						for (int j2 = 0; j2 < gameMap.length; j2++) {
							Rectangle enemyRect = new Rectangle(enemyX, enemyY, Util.tankSize, Util.tankSize);
							// �ж�ײ�������ײ��ǽ���˻أ�Ȼ���������
							if (gameMap[j][j2] == 1 || gameMap[j][j2] == 2 || gameMap[j][j2] == 4
									|| gameMap[j][j2] == 5) {
								int gameMapX = j2 * Util.wallSize;
								int gameMapY = j * Util.wallSize;
								Rectangle mapWallRect = new Rectangle(gameMapX, gameMapY, Util.wallSize, Util.wallSize);
								if (enemyRect.intersects(mapWallRect)) {

									switch (key) {
									case 1:
										enemyList.get(i).moveDowm();
										// �������
										enemyList.get(i).setDirect(new Random().nextInt(4) + 1);
										break;
									case 2:
										enemyList.get(i).moveUp();
										enemyList.get(i).setDirect(new Random().nextInt(4) + 1);
										break;
									case 3:
										enemyList.get(i).moveRight();
										enemyList.get(i).setDirect(new Random().nextInt(4) + 1);
										break;
									case 4:
										enemyList.get(i).moveLeft();
										enemyList.get(i).setDirect(new Random().nextInt(4) + 1);
										break;

									default:
										break;
									}
									break j;

								}

							}
						}
					}

				}

			}
			try {
				Thread.sleep(120 / Util.enemyTankSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
