package thread;

import java.awt.Rectangle;
import java.util.ArrayList;

import model.Bullet;
import model.MyTank;
import tool.Util;
import view.MyFrame;

public class EnemyHitMyTankThread extends Thread {
	// �з��ӵ����ҷ��߳�
	MyFrame myFrame;

	public EnemyHitMyTankThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {
		//����Ե�BUFF�����߳�����8S
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
			// �����з��ӵ�
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
				// �û�һ�����ж�
				if (myTankRect.intersects(enemyBulletRect)) {
					// �ӵ���ը
					new BulletBoomThread(myFrame, enemyBulletX, enemyBulletY).start();

					enemyBulletList.remove(i);
					myTank.setHp(myTank.getHp() - Util.enemyBulletPower);

				}
				// �û������ӵ����ж�
				if (secondTankRect.intersects(enemyBulletRect)) {
					// �ӵ���ը
					new BulletBoomThread(myFrame, enemyBulletX, enemyBulletY).start();

					enemyBulletList.remove(i);
					secondTank.setHp(secondTank.getHp() - Util.enemyBulletPower);

				}
				//�û�һѪ��С��0
				if (myTank.getHp() <= 0) {
					new TankBoomThread(myFrame, myTankX, myTankY).start();
					myTank.setLive(myTank.getLive() - 1);
					myTank.setHp(3);
					// �����ҷ�λ��
					myTank.setX(200);
					myTank.setY(560);
					myTank.setDirect(1);
					Util.fire = false;
					myFrame.getMyTank().setMoveUp(false);
					myFrame.getMyTank().setMoveDown(false);
					myFrame.getMyTank().setMoveLeft(false);
					myFrame.getMyTank().setMoveRight(false);

				}
				//�û���Ѫ��С��0
				if (secondTank.getHp() <= 0) {
					new TankBoomThread(myFrame, secondTankX, secondTankY).start();
					secondTank.setLive(secondTank.getLive() - 1);
					secondTank.setHp(3);
					// �����û���λ��
					secondTank.setX(360);
					secondTank.setY(560);
					secondTank.setDirect(1);
					Util.secondFire = false;
					secondTank.setMoveUp(false);
					secondTank.setMoveDown(false);
					secondTank.setMoveLeft(false);
					secondTank.setMoveRight(false);

				}
				//������
				if (myTank.getLive() <= 0) {
					myTank.setX(1000);
					myTank.setY(1000);
					// ���û�1�ƶ���������ͣ
				}
				if (secondTank.getLive() <= 0) {
					secondTank.setX(1000);
					secondTank.setY(1000);
					// ���û�2�ƶ���������ͣ
				}
				//��Ϸʧ��
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
