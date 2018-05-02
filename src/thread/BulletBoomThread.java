package thread;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tool.Util;
import view.MyFrame;

public class BulletBoomThread extends Thread {
	// �ӵ���ը��ǩ�߳�
	MyFrame myFrame;
	int x;
	int y;

	public BulletBoomThread(MyFrame myFrame, int x, int y) {
		super();
		this.myFrame = myFrame;
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		// ����0.08s���Ƴ�
		JLabel bulletBoomLabel = new JLabel(new ImageIcon("image/BulletBoom.png"));
		bulletBoomLabel.setBounds(x, y, Util.bulletSize, Util.bulletSize);
		myFrame.getPlayGamePanel().add(bulletBoomLabel);
		try {
			Thread.sleep(80);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myFrame.getPlayGamePanel().remove(bulletBoomLabel);
	}

}
