package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import tool.Util;
import view.MyFrame;

public class MyFocus implements FocusListener {
	//游戏焦点监听
	MyFrame myFrame;
	
	
	public MyFocus(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void focusGained(FocusEvent e) {
//		//获得焦点继续
//		Util.pause = true;

	}

	@Override
	public void focusLost(FocusEvent e) {
//		//丢失焦点暂停
//		//用户一
//		Util.pause = false;
//		myFrame.getMyTank().setMoveUp(false);
//		myFrame.getMyTank().setMoveDown(false);
//		myFrame.getMyTank().setMoveLeft(false);
//		myFrame.getMyTank().setMoveRight(false);
//		//用户二
//		Util.secondFire = false;
//		myFrame.getSecondTank().setMoveUp(false);
//		myFrame.getSecondTank().setMoveDown(false);
//		myFrame.getSecondTank().setMoveLeft(false);
//		myFrame.getSecondTank().setMoveRight(false);
	}

}
