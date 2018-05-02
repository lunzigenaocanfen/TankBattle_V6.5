package thread;

import java.util.ArrayList;

import model.Enemy;
import view.MyFrame;

public class NextLevelThread extends Thread {
	//下一关，胜利的判断
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
			// 当地图敌人与预览区敌人都为0,且关卡不为0时，则过关
			if (enemyList.size() == 0 && infoEnemyList.size() == 0 & myFrame.getPlayGameFrame().getLevel() != 98) {
				//过第一关
				if (myFrame.getPlayGameFrame().getLevel() == 1) {
					//弹出过关统计
					myFrame.getPassLevelPanel().getLevelTitle().setText("当前关卡【" + myFrame.getPlayGameFrame().getLevel() + "】");
					myFrame.getPassLevelFrame().setVisible(true);
					myFrame.getPlayGameFrame().setVisible(false);
					myFrame.getLevelInfoPanel().addEnemy();
					continue;
				}
				//过第二关
				if (myFrame.getPlayGameFrame().getLevel() == 2) {
					//弹出过关统计
					myFrame.getPassLevelPanel().getLevelTitle().setText("当前关卡【" + myFrame.getPlayGameFrame().getLevel() + "】");
					myFrame.getPassLevelFrame().setVisible(true);
					myFrame.getPlayGameFrame().setVisible(false);
					myFrame.getLevelInfoPanel().addEnemy();
					continue;
				}

				if (myFrame.getPlayGameFrame().getLevel() == 3) {
					// 游戏通关，弹出过关统计
					myFrame.getPassLevelPanel().getLevelTitle().setText("     恭喜胜利");
					myFrame.getPassLevelFrame().setVisible(true);
					myFrame.getPlayGameFrame().setVisible(false);
					myFrame.getLevelInfoPanel().addEnemy();

					continue;
				}
				if (myFrame.getPlayGameFrame().getLevel() == 99) {
					// 自定义通关游戏通关，弹出过关统计
					myFrame.getPassLevelPanel().getLevelTitle().setText("     恭喜胜利");
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
