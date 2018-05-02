package thread;

import tool.Util;
import view.MyFrame;

public class LoseThread extends Thread {
	//判断失败的线程
	MyFrame myFrame;

	public LoseThread(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}
	
	@Override
	public void run() {
		
		while(true) {
			if(Util.lose) {
				//如果失败则将关卡设置为4，然后还原生命等，避免被其他线程重复判断失败。将过关面板设置为失败面板
				Util.gameLevel = 4;
				myFrame.getPlayGameFrame().setLevel(4);
				myFrame.getMyTank().setLive(3);
				myFrame.getMyTank().setHp(3);
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getPassLevelButton());
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getRestartButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getReturnButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getGameOverButton());
				myFrame.getPassLevelPanel().updateUI();
				myFrame.getPassLevelPanel().getLevelTitle().setText(" 很遗憾失败了");
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
