package thread;

import java.awt.Rectangle;
import java.util.ArrayList;

import model.EasyEnemy;
import model.Enemy;
import model.HardEnemy;
import model.NormalEnemy;
import tool.Util;
import view.MyFrame;

public class MyTankImpactPropThread extends Thread {
	//���߰����Ե��߳�
	MyFrame myFrame;

	public MyTankImpactPropThread(MyFrame myFrame) {
		
		this.myFrame = myFrame;
	}
	@Override
	public void run() {
		
		while(true) {
			//��ȡ�û�һ���û��������߰�������
			int propX = myFrame.getPropBag().getBagX();
			int propY = myFrame.getPropBag().getBagY();
			ArrayList<Enemy> enemyList = myFrame.getEnemyList();
			int myTankX = myFrame.getMyTank().getX();
			int myTankY = myFrame.getMyTank().getY();
			int secondX = myFrame.getSecondTank().getX();
			int secondY = myFrame.getSecondTank().getY();
			Rectangle propRect = new Rectangle(propX,propY,Util.wallSize,Util.wallSize);
			Rectangle myTankRect = new Rectangle(myTankX,myTankY,Util.tankSize,Util.tankSize);
			Rectangle secondTankRect = new Rectangle(secondX,secondY,Util.tankSize,Util.tankSize);
			//�û�һ�ж�
			if(propRect.intersects(myTankRect)) {
				switch (myFrame.getPropBag().getBagStyle()) {
				
				case 1://Ѫ��
					myFrame.getMyTank().setHp(3);
					//ʹ���߲���ʾ����Ϸ��
					myFrame.getPropBag().setBagX(800);
					myFrame.getPropBag().setBagY(800);
					break;
				case 2://���ڰ�
					myFrame.getGameMap().getArr()[13][6] = 2;								
					myFrame.getGameMap().getArr()[13][7] = 2;									
					myFrame.getGameMap().getArr()[13][8] = 2;									
					myFrame.getGameMap().getArr()[14][8] = 2;									
					myFrame.getGameMap().getArr()[14][6] = 2;
					//ʹ���߲���ʾ����Ϸ��
					myFrame.getPropBag().setBagX(800);
					myFrame.getPropBag().setBagY(800);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					myFrame.getGameMap().getArr()[13][6] = 1;								
					myFrame.getGameMap().getArr()[13][7] = 1;									
					myFrame.getGameMap().getArr()[13][8] = 1;									
					myFrame.getGameMap().getArr()[14][8] = 1;									
					myFrame.getGameMap().getArr()[14][6] = 1;
															
					break;
				case 3://ը����
					for (int i = enemyList.size() - 1; i >= 0; i--) {
						myFrame.getMyBulletHitEnemyThread().setKillEnemy(myFrame.getMyBulletHitEnemyThread().getKillEnemy()+1);
						myFrame.getMyBulletHitEnemyThread().setTotalKillEnemy(myFrame.getMyBulletHitEnemyThread().getTotalKillEnemy()+1);
						if(enemyList.get(i) instanceof EasyEnemy) {
							myFrame.getMyBulletHitEnemyThread().setKillEasy(myFrame.getMyBulletHitEnemyThread().getKillEasy()+1);
						}
						if(enemyList.get(i) instanceof NormalEnemy) {
							myFrame.getMyBulletHitEnemyThread().setKillNormal(myFrame.getMyBulletHitEnemyThread().getKillNormal()+1);
						}
						if(enemyList.get(i) instanceof HardEnemy) {
							myFrame.getMyBulletHitEnemyThread().setKillHard(myFrame.getMyBulletHitEnemyThread().getKillHard()+1);
						}
						//��ը
						new TankBoomThread(myFrame, enemyList.get(i).getRow(), enemyList.get(i).getCol()).start();
						enemyList.remove(i);
						
						//ʹ���߲���ʾ����Ϸ��
						myFrame.getPropBag().setBagX(800);
						myFrame.getPropBag().setBagY(800);
					}
				case 4:
					Util.impactBuffBag = true;
					myFrame.getPropBag().setBagX(800);
					myFrame.getPropBag().setBagY(800);
					break;

				default:
					break;
				}
				
								
			}
			//�û����ж�
			if(propRect.intersects(secondTankRect)) {
				switch (myFrame.getPropBag().getBagStyle()) {
				
				case 1://Ѫ��
					myFrame.getSecondTank().setHp(3);
					//ʹ���߲���ʾ����Ϸ��
					myFrame.getPropBag().setBagX(800);
					myFrame.getPropBag().setBagY(800);
					break;
				case 2://���ڰ�
					myFrame.getGameMap().getArr()[13][6] = 2;								
					myFrame.getGameMap().getArr()[13][7] = 2;									
					myFrame.getGameMap().getArr()[13][8] = 2;									
					myFrame.getGameMap().getArr()[14][8] = 2;									
					myFrame.getGameMap().getArr()[14][6] = 2;
					//ʹ���߲���ʾ����Ϸ��
					myFrame.getPropBag().setBagX(800);
					myFrame.getPropBag().setBagY(800);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					myFrame.getGameMap().getArr()[13][6] = 1;								
					myFrame.getGameMap().getArr()[13][7] = 1;									
					myFrame.getGameMap().getArr()[13][8] = 1;									
					myFrame.getGameMap().getArr()[14][8] = 1;									
					myFrame.getGameMap().getArr()[14][6] = 1;
															
					break;
				case 3://ը����
					for (int i = enemyList.size() - 1; i >= 0; i--) {
						myFrame.getMyBulletHitEnemyThread().setKillEnemy(myFrame.getMyBulletHitEnemyThread().getKillEnemy()+1);
						myFrame.getMyBulletHitEnemyThread().setTotalKillEnemy(myFrame.getMyBulletHitEnemyThread().getTotalKillEnemy()+1);
						if(enemyList.get(i) instanceof EasyEnemy) {
							myFrame.getMyBulletHitEnemyThread().setKillEasy(myFrame.getMyBulletHitEnemyThread().getKillEasy()+1);
						}
						if(enemyList.get(i) instanceof NormalEnemy) {
							myFrame.getMyBulletHitEnemyThread().setKillNormal(myFrame.getMyBulletHitEnemyThread().getKillNormal()+1);
						}
						if(enemyList.get(i) instanceof HardEnemy) {
							myFrame.getMyBulletHitEnemyThread().setKillHard(myFrame.getMyBulletHitEnemyThread().getKillHard()+1);
						}
						//��ը
						new TankBoomThread(myFrame, enemyList.get(i).getRow(), enemyList.get(i).getCol()).start();
						enemyList.remove(i);
						
						//ʹ���߲���ʾ����Ϸ��
						myFrame.getPropBag().setBagX(800);
						myFrame.getPropBag().setBagY(800);
					}
				case 4:
					Util.impactBuffBag = true;
					myFrame.getPropBag().setBagX(800);
					myFrame.getPropBag().setBagY(800);
					break;

				default:
					break;
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
