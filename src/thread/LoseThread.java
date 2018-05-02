package thread;

import tool.Util;
import view.MyFrame;

public class LoseThread extends Thread {
	//�ж�ʧ�ܵ��߳�
	MyFrame myFrame;

	public LoseThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}
	
	@Override
	public void run() {
		
		while(true) {
			if(Util.lose) {
				//���ʧ���򽫹ؿ�����Ϊ4��Ȼ��ԭ�����ȣ����ⱻ�����߳��ظ��ж�ʧ�ܡ��������������Ϊʧ�����
				Util.gameLevel = 4;
				myFrame.getPlayGameFrame().setLevel(4);
				myFrame.getMyTank().setLive(3);
				myFrame.getMyTank().setHp(3);
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getPassLevelButton());
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getRestartButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getReturnButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getGameOverButton());
				myFrame.getPassLevelPanel().updateUI();
				myFrame.getPassLevelPanel().getLevelTitle().setText(" ���ź�ʧ����");
				myFrame.getPassLevelFrame().setVisible(true);
				myFrame.getPlayGameFrame().setVisible(false);
				Util.lose = false;
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
