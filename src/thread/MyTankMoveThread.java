package thread;

import java.awt.Rectangle;

import model.MyTank;
import tool.Util;
import view.MyFrame;

public class MyTankMoveThread extends Thread {
	// �ҷ�̹���ƶ�������ײ�ϰ����ж�
	MyFrame myFrame;

	public MyTankMoveThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {
		while (true) {
			if (Util.pause) {
				int[][] gameMap = myFrame.getGameMap().getArr();
				MyTank u = myFrame.getMyTank();
				// �û�1�ƶ�
				if (u.isMoveUp()) {

					u.moveUp();
				}
				if (u.isMoveDown()) {

					u.moveDown();
				}
				if (u.isMoveLeft()) {

					u.moveLeft();
				}
				if (u.isMoveRight()) {

					u.moveRight();
				}
				// �û�2�ƶ�
				MyTank secondUser = myFrame.getSecondTank();

				if (secondUser.isMoveUp()) {

					secondUser.moveUp();
				}
				if (secondUser.isMoveDown()) {

					secondUser.moveDown();
				}
				if (secondUser.isMoveLeft()) {

					secondUser.moveLeft();
				}
				if (secondUser.isMoveRight()) {

					secondUser.moveRight();
				}
				// ������ͼ���ϰ�����ײ�ж�
				for (int i = 0; i < gameMap.length; i++) {
					for (int j = 0; j < gameMap[i].length; j++) {
						if (gameMap[i][j] == 1 || gameMap[i][j] == 2 || gameMap[i][j] == 4 || gameMap[i][j] == 5) {
							int mapX = j * Util.wallSize;
							int mapY = i * Util.wallSize;
							int userX = u.getX();
							int userY = u.getY();
							int secondX = secondUser.getX();
							int secondY = secondUser.getY();
							Rectangle mapWallRect = new Rectangle(mapX, mapY, Util.wallSize, Util.wallSize);
							Rectangle userRect = new Rectangle(userX, userY, Util.tankSize, Util.tankSize);
							Rectangle secondUserRect = new Rectangle(secondX, secondY, Util.tankSize, Util.tankSize);
							// �û�һ
							if (mapWallRect.intersects(userRect)) {
								switch (u.getDirect()) {
								case 1:
									u.setY(u.getY() + 10);
									break;
								case 2:
									u.setY(u.getY() - 10);
									break;
								case 3:
									u.setX(u.getX() + 10);
									break;
								case 4:
									u.setX(u.getX() - 10);
									break;

								default:
									break;
								}

							}
							// �û���
							if (mapWallRect.intersects(secondUserRect)) {
								switch (secondUser.getDirect()) {
								case 1:
									secondUser.setY(secondUser.getY() + 10);
									break;
								case 2:
									secondUser.setY(secondUser.getY() - 10);
									break;
								case 3:
									secondUser.setX(secondUser.getX() + 10);
									break;
								case 4:
									secondUser.setX(secondUser.getX() - 10);
									break;

								default:
									break;
								}

							}
						}
					}
				}
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
