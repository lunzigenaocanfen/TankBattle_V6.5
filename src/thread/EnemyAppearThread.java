package thread;

import java.util.ArrayList;
import model.EasyEnemy;
import model.Enemy;
import model.HardEnemy;
import model.NormalEnemy;
import tool.Util;
import view.MyFrame;

public class EnemyAppearThread extends Thread {
	// ���˳����߳�
	MyFrame myFrame;
	private int easy = 0;
	private int normal = 0;
	private int hard = 0;

	public EnemyAppearThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {

		while (true) {
			if (Util.pause) {
				ArrayList<Enemy> enemyList = myFrame.getEnemyList();
				ArrayList<Enemy> infoEnemyList = myFrame.getLevelInfoPanel().getInfoEnemyList();
				//����Ϸ�е���С��5ʱ����Ԥ�������˳�������Ϸ��
				if (enemyList.size() < 5 && infoEnemyList.size() != 0) {
					enemyList.add(infoEnemyList.get(infoEnemyList.size() - 1));
					infoEnemyList.remove(infoEnemyList.size() - 1);

				}
				//�ж�Ԥ���������������͡�
				for (int i = infoEnemyList.size() - 1; i >= 0; i--) {

					if (infoEnemyList.get(i) instanceof EasyEnemy) {
						easy++;

					}
					if (infoEnemyList.get(i) instanceof NormalEnemy) {
						normal++;

					}
					if (infoEnemyList.get(i) instanceof HardEnemy) {
						hard++;

					}
				}
				// Ԥ������Ϣ���

				myFrame.getLevelInfoPanel().getEasyLabel().setText(easy + "");
				myFrame.getLevelInfoPanel().getNormalLabel().setText(normal + "");
				myFrame.getLevelInfoPanel().getHardLabel().setText(hard + "");
				myFrame.getLevelInfoPanel().getLevelLabel().setText(myFrame.getPlayGameFrame().getLevel() + "");

				easy = 0;
				normal = 0;
				hard = 0;

			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int getEasy() {
		return easy;
	}

	public void setEasy(int easy) {
		this.easy = easy;
	}

	public int getNormal() {
		return normal;
	}

	public void setNormal(int normal) {
		this.normal = normal;
	}

	public int getHard() {
		return hard;
	}

	public void setHard(int hard) {
		this.hard = hard;
	}

}
