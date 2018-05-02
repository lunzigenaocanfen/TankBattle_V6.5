package thread;

import java.util.ArrayList;

import model.Enemy;
import view.MyFrame;

public class NextLevelThread extends Thread {
	//��һ�أ�ʤ�����ж�
	MyFrame myFrame;

	public NextLevelThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {

		while (true) {
			ArrayList<Enemy> enemyList = myFrame.getEnemyList();
			ArrayList<Enemy> infoEnemyList = myFrame.getLevelInfoPanel().getInfoEnemyList();
			// ����ͼ������Ԥ�������˶�Ϊ0,�ҹؿ���Ϊ0ʱ�������
			if (enemyList.size() == 0 && infoEnemyList.size() == 0 & myFrame.getPlayGameFrame().getLevel() != 98) {
				//����һ��
				if (myFrame.getPlayGameFrame().getLevel() == 1) {
					//��������ͳ��
					myFrame.getPassLevelPanel().getLevelTitle().setText("��ǰ�ؿ���" + myFrame.getPlayGameFrame().getLevel() + "��");
					myFrame.getPassLevelFrame().setVisible(true);
					myFrame.getPlayGameFrame().setVisible(false);
					myFrame.getLevelInfoPanel().addEnemy();
					continue;
				}
				//���ڶ���
				if (myFrame.getPlayGameFrame().getLevel() == 2) {
					//��������ͳ��
					myFrame.getPassLevelPanel().getLevelTitle().setText("��ǰ�ؿ���" + myFrame.getPlayGameFrame().getLevel() + "��");
					myFrame.getPassLevelFrame().setVisible(true);
					myFrame.getPlayGameFrame().setVisible(false);
					myFrame.getLevelInfoPanel().addEnemy();
					continue;
				}

				if (myFrame.getPlayGameFrame().getLevel() == 3) {
					// ��Ϸͨ�أ���������ͳ��
					myFrame.getPassLevelPanel().getLevelTitle().setText("     ��ϲʤ��");
					myFrame.getPassLevelFrame().setVisible(true);
					myFrame.getPlayGameFrame().setVisible(false);
					myFrame.getLevelInfoPanel().addEnemy();

					continue;
				}
				if (myFrame.getPlayGameFrame().getLevel() == 99) {
					// �Զ���ͨ����Ϸͨ�أ���������ͳ��
					myFrame.getPassLevelPanel().getLevelTitle().setText("     ��ϲʤ��");
					myFrame.getPassLevelFrame().setVisible(true);
					myFrame.getPlayGameFrame().setVisible(false);
					myFrame.getLevelInfoPanel().addEnemy();

					continue;
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
