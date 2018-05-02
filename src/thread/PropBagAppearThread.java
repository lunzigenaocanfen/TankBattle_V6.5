package thread;

import java.util.Random;

import tool.Util;
import view.MyFrame;

public class PropBagAppearThread extends Thread {
	// ���߰����ֵ��߳�
	MyFrame myFrame;

	public PropBagAppearThread(MyFrame myFrame) {
		this.myFrame = myFrame;
	}

	@Override
	public void run() {

		while (true) {
			if (Util.pause) {
				// ��ʧ4��

				myFrame.getPropBag().setBagX(800);
				myFrame.getPropBag().setBagY(800);

				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// ����10��
				myFrame.getPropBag().setBagX(new Random().nextInt(560));// �����������
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
