package thread;

import java.util.Random;

import tool.Util;
import view.MyFrame;

public class PropBagAppearThread extends Thread {
	// 道具包出现的线程
	MyFrame myFrame;

	public PropBagAppearThread(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	@Override
	public void run() {

		while (true) {
			if (Util.pause) {
				// 消失4秒

				myFrame.getPropBag().setBagX(800);
				myFrame.getPropBag().setBagY(800);

				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 出现10秒
				myFrame.getPropBag().setBagX(new Random().nextInt(560));// 随机出现坐标
				myFrame.getPropBag().setBagY(new Random().nextInt(560));
				myFrame.getPropBag().setBagStyle(new Random().nextInt(4) + 1);

			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
