package thread;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tool.Util;
import view.MyFrame;

public class TankBoomThread extends Thread {
	//̹�˱�ը��ǩͼƬ�߳�
	MyFrame myFrame;
	int x;
	int y;
	
	public TankBoomThread(MyFrame myFrame, int x, int y) {
		super();
		this.myFrame = myFrame;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void run() {
		//�߳̿�ʼ0.08S���Ƴ�
		JLabel tankBoomLabel = new JLabel(new ImageIcon("image/TankBoom.png"));
		tankBoomLabel.setBounds(x, y, Util.tankSize, Util.tankSize);
		myFrame.getPlayGamePanel().add(tankBoomLabel);
		try {
			Thread.sleep(80);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myFrame.getPlayGamePanel().remove(tankBoomLabel);
	}
}
