package thread;

import java.awt.Rectangle;
import java.util.ArrayList;

import model.Enemy;
import tool.Util;
import view.MyFrame;

public class EnemyImpactPropThread extends Thread {
	// �з�̹�˳�Ѫ��
	MyFrame myFrame;

	public EnemyImpactPropThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {
		while (true) {
			ArrayList<Enemy> enemyList = myFrame.getEnemyList();
			// ��������
			int propX = myFrame.getPropBag().getBagX();
			int propY = myFrame.getPropBag().getBagY();

			// ������������ �ж��Ƿ���������
			for (int i = enemyList.size() - 1; i >= 0; i--) {
				int enemyX = enemyList.get(i).getRow();
				int enemyY = enemyList.get(i).getCol();
				Rectangle propRect = new Rectangle(propX, propY, Util.wallSize, Util.wallSize);
				Rectangle enemyRect = new Rectangle(enemyX, enemyY, Util.tankSize, Util.tankSize);
				if (propRect.intersects(enemyRect)) {
					// �������߰����ѵ��߰��Ƴ�
					if (myFrame.getPropBag().getBagStyle() == 1) {
						switch (enemyList.get(i).getType()) {
						case 0:
							enemyList.get(i).setHp(2);
							break;
						case 2:
							enemyList.get(i).setHp(3);
							break;

						default:
							break;
						}
						myFrame.getPropBag().setBagX(800);
						myFrame.getPropBag().setBagY(800);
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
