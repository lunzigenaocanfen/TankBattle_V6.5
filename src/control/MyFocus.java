package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import tool.Util;
import view.MyFrame;

public class MyFocus implements FocusListener {
	//��Ϸ�������
	MyFrame myFrame;
	
	
	public MyFocus(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}

	@Override
	public void focusGained(FocusEvent e) {
//		//��ý������
//		Util.pause = true;

	}

	@Override
	public void focusLost(FocusEvent e) {
//		//��ʧ������ͣ
//		//�û�һ
//		Util.pause = false;
//		myFrame.getMyTank().setMoveUp(false);
//		myFrame.getMyTank().setMoveDown(false);
//		myFrame.getMyTank().setMoveLeft(false);
//		myFrame.getMyTank().setMoveRight(false);
//		//�û���
//		Util.secondFire = false;
//		myFrame.getSecondTank().setMoveUp(false);
//		myFrame.getSecondTank().setMoveDown(false);
//		myFrame.getSecondTank().setMoveLeft(false);
//		myFrame.getSecondTank().setMoveRight(false);
	}

}
