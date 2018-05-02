package thread;

import view.MyFrame;

public class RepaintThread extends Thread {
	// ��Ϸ���,�Ҳ�Ԥ�����ػ��߳�
	MyFrame myFrame;

	public RepaintThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {
		while (true) {
			myFrame.getPlayGamePanel().repaint();
			myFrame.getLevelInfoPanel().repaint();

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
