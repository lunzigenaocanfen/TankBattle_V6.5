package thread;

import java.util.ArrayList;

import model.Bullet;
import tool.Util;
import view.MyFrame;

public class MyBulletMoveThread extends Thread {
	// 我方子弹移动线程
	MyFrame myFrame;

	public MyBulletMoveThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {

		while (true) {
			if (Util.pause) {
				ArrayList<Bullet> buList = myFrame.getMyBulletList();

				// 遍历我方子弹
				for (int i = buList.size() - 1; i >= 0; i--) {
					// 我方子弹移动 、边界判断
					try {
						switch (buList.get(i).getDirect()) {
						case 1:
							// 上移、超出边界移除
							if (buList.get(i).getY() > -20) {
								buList.get(i).moveUp();
							} else {
								buList.remove(i);
							}

							break;
						case 2:
							// 下移、超出边界移除
							if (buList.get(i).getY() < Util.gameHeight + 20) {
								buList.get(i).moveDown();
							} else {
								buList.remove(i);
							}
							break;

						case 3:
							// 左移、超出边界移除
							if (buList.get(i).getX() > -20) {
								buList.get(i).moveLeft();
							} else {
								buList.remove(i);
							}

							break;
						case 4:
							// 右移、超出边界移除
							if (buList.get(i).getX() < Util.gameWidth + 20) {

								buList.get(i).moveRight();
							} else {
								buList.remove(i);
							}

							break;

						default:
							break;
						}
					} catch (Exception e) {
						// TODO: handle exception
					}

				}

			}
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
