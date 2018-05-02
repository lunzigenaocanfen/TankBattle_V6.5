package thread;

import java.util.ArrayList;
import java.util.Random;

import model.Enemy;
import tool.Util;
import view.MyFrame;

public class EnemyChangeDirectionThread extends Thread {
	// 敌人集体随机换方向的线程
	MyFrame myFrame;

	public EnemyChangeDirectionThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {
		while (true) {
			if (Util.pause) {
				ArrayList<Enemy> enemyList = myFrame.getEnemyList();
				// 遍历所有敌人，每个敌人随机方向
				for (int i = enemyList.size() - 1; i >= 0; i--) {
					enemyList.get(i).setDirect(new Random().nextInt(4) + 1);

				}
			}
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
