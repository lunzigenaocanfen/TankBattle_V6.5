package thread;

import model.Bullet;
import tool.Util;
import view.MyFrame;

public class MyTankFireThread extends Thread {
	// �ҷ������߳�
	MyFrame myFrame;

	public MyTankFireThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void run() {
		while (true) {
			//�û�һ����
			if (Util.fire) {
				myFrame.getMyBulletList().add(new Bullet
						(myFrame.getMyTank().getX(), myFrame.getMyTank().getY(), myFrame.getMyTank().getDirect()));
			}
			//�û�������
			if (Util.secondFire) {
				myFrame.getMyBulletList().add
				(new Bullet(myFrame.getSecondTank().getX(), myFrame.getSecondTank().getY(), myFrame.getSecondTank().getDirect()));
			}
			
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
