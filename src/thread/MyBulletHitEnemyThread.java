package thread;

import java.awt.Rectangle;
import java.util.ArrayList;

import model.Bullet;
import model.EasyEnemy;
import model.Enemy;
import model.HardEnemy;
import model.NormalEnemy;
import tool.Util;
import view.MyFrame;

public class MyBulletHitEnemyThread extends Thread {
	// �ҷ��ӵ�������ж�
	private int killEnemy = 0;
	private int totalKillEnemy = 0;
	private int currentScore = 0;
	private int totalScore = 0;

	private int killEasy = 0;
	private int killNormal = 0;
	private int killHard = 0;

	MyFrame myFrame;

	public MyBulletHitEnemyThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {

		while (true) {
			// ���˼���
			ArrayList<Enemy> enemyList = myFrame.getEnemyList();
			// �ҷ��ӵ�����
			ArrayList<Bullet> buList = myFrame.getMyBulletList();

			// �����ҷ��ӵ�
			for (int i = buList.size() - 1; i >= 0; i--) {
				int bulletX = -100;
				int bulletY = -100;
				try {
					bulletX = buList.get(i).getDirectX();
					bulletY = buList.get(i).getDirectY();
				} catch (Exception e) {
					// TODO: handle exception
				}

				// �����з�̹��
				for (int j = enemyList.size() - 1; j >= 0; j--) {

					int enemyX = enemyList.get(j).getRow();
					int enemyY = enemyList.get(j).getCol();

					Rectangle bulletRect = new Rectangle(bulletX, bulletY, Util.bulletSize, Util.bulletSize);
					Rectangle enemyRect = new Rectangle(enemyX, enemyY, Util.tankSize, Util.tankSize);
					// ��ײ��⣬ײ����Ѫ��Ѫû�����Ƴ�
					if (bulletRect.intersects(enemyRect)) {
						try {
							new BulletBoomThread(myFrame, bulletX, bulletY).start();
							buList.remove(i);// �ӵ��Ƴ�
						} catch (Exception e) {
							// TODO: handle exception
						}

						// ��Ѫ

						enemyList.get(j).setHp(enemyList.get(j).getHp() - 1);

						// ûѪ������
						if (enemyList.get(j).getHp() <= 0) {
							// �жϻ�ɱ����,Ԥ���������Ϣ��

							if (enemyList.get(j) instanceof EasyEnemy) {
								killEasy++;
								this.currentScore += enemyList.get(j).getValue();
								this.totalScore += enemyList.get(j).getValue();

							}
							if (enemyList.get(j) instanceof NormalEnemy) {
								killNormal++;
								this.currentScore += enemyList.get(j).getValue();
								this.totalScore += enemyList.get(j).getValue();
							}
							if (enemyList.get(j) instanceof HardEnemy) {
								killHard++;
								this.currentScore += enemyList.get(j).getValue();
								this.totalScore += enemyList.get(j).getValue();
							}
							this.killEnemy++;
							this.totalKillEnemy++;

							// ��ը
							new TankBoomThread(myFrame, enemyList.get(j).getRow(), enemyList.get(j).getCol()).start();
							enemyList.remove(j);
						}

					}
				}
			}
			// �Ҳ���Ϣ���
			myFrame.getLevelInfoPanel().getKillEnemyLabel().setText(this.getKillEnemy() + "");
			// myFrame.getLevelInfoPanel().getTotalKillEnemyLabel().setText(this.getTotalKillEnemy()+"");
			myFrame.getLevelInfoPanel().getCurrentScoreLabel().setText(this.getCurrentScore() + "");
			myFrame.getLevelInfoPanel().getTotalScoreLabel().setText(this.getTotalScore() + "");
			myFrame.getLevelInfoPanel().getLeftLiveLabel()
					.setText("P1:" + myFrame.getMyTank().getLive() + "    P2:" + myFrame.getSecondTank().getLive());
			// ����ͳ��
			myFrame.getPassLevelPanel().getUserName().setText("�û���" + myFrame.getPlayGameFrame().getU().getName());
			// myFrame.getPassLevelPanel().getLevelTitle().setText("��ǰ�ؿ���"+myFrame.getPlayGameFrame().getLevel()+"��");
			myFrame.getPassLevelPanel().getKillEasyEnemy().setText(killEasy + "");
			myFrame.getPassLevelPanel().getKillNormalEnemy().setText(killNormal + "");
			myFrame.getPassLevelPanel().getKillHardEnemy().setText(killHard + "");

			myFrame.getPassLevelPanel().getEasyEnemyScore().setText(killEasy * 100 + "");
			myFrame.getPassLevelPanel().getNormalEnemylScore().setText(killNormal * 200 + "");
			myFrame.getPassLevelPanel().getHardEnemyScore().setText(killHard * 300 + "");

			myFrame.getPassLevelPanel().getCurrentKillEnemy().setText("��ǰ��ɱ:" + killEnemy);
			myFrame.getPassLevelPanel().getTotalKillEnemy().setText("�ܹ���ɱ" + totalKillEnemy);

			myFrame.getPassLevelPanel().getCurrentScore().setText("��ǰ�÷�" + currentScore);
			myFrame.getPassLevelPanel().getTotalScore().setText("�ܹ��÷�" + totalScore);

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int getKillEnemy() {
		return killEnemy;
	}

	public void setKillEnemy(int killEnemy) {
		this.killEnemy = killEnemy;
	}

	public int getTotalKillEnemy() {
		return totalKillEnemy;
	}

	public void setTotalKillEnemy(int totalKillEnemy) {
		this.totalKillEnemy = totalKillEnemy;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getKillEasy() {
		return killEasy;
	}

	public void setKillEasy(int killEasy) {
		this.killEasy = killEasy;
	}

	public int getKillNormal() {
		return killNormal;
	}

	public void setKillNormal(int killNormal) {
		this.killNormal = killNormal;
	}

	public int getKillHard() {
		return killHard;
	}

	public void setKillHard(int killHard) {
		this.killHard = killHard;
	}

}
