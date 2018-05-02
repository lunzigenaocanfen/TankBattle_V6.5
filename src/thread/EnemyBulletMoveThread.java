package thread;

import java.util.ArrayList;

import model.Bullet;
import tool.Util;
import view.MyFrame;

public class EnemyBulletMoveThread extends Thread {
	// �����ӵ��ƶ���߽��ж��߳�
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
					// ����ÿһ���ӵ�
					for (int i = enemyBulletList.size() - 1; i >= 0; i--) {
						int bulletDirection = 0;

						bulletDirection = enemyBulletList.get(i).getDirect();

						switch (bulletDirection) {
						case 1:
							// ����ʱ��Խ��ʱ�Ƴ�
							if (enemyBulletList.get(i).getDirectY() > -20) {
								enemyBulletList.get(i).moveUp();
							} else {
								enemyBulletList.remove(i);
							}
							break;
						case 2:
							// ����ʱ��Խ��ʱ�Ƴ�
							if (enemyBulletList.get(i).getDirectY() < Util.gameHeight + 20) {
								enemyBulletList.get(i).moveDown();
							} else {
								enemyBulletList.remove(i);
							}

							break;
						case 3:
							// ����ʱ��Խ��ʱ�Ƴ�
							if (enemyBulletList.get(i).getDirectX() > -20) {
								enemyBulletList.get(i).moveLeft();
							} else {
								enemyBulletList.remove(i);
							}
							break;
						case 4:
							// ����ʱ��Խ��ʱ�Ƴ�
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
