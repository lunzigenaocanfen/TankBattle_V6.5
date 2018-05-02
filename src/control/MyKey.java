package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import tool.Util;
import view.MyFrame;

public class MyKey extends KeyAdapter {
	//键盘监听
	MyFrame myFrame ;

	public MyKey(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(Util.pause){
		
		
		int key = e.getKeyCode();
		//控制用户移动和画不同位置

			
			switch (key) {
			case KeyEvent.VK_W :
				//用户上移
				myFrame.getMyTank().setDirect(1);
				myFrame.getMyTank().setMoveUp(true);
				myFrame.getMyTank().setMoveDown(false);
				myFrame.getMyTank().setMoveLeft(false);
				myFrame.getMyTank().setMoveRight(false);
				break;
				//我方下移
			case KeyEvent.VK_S :
				myFrame.getMyTank().setDirect(2);
				myFrame.getMyTank().setMoveUp(false);
				myFrame.getMyTank().setMoveDown(true);
				myFrame.getMyTank().setMoveLeft(false);
				myFrame.getMyTank().setMoveRight(false);
			
				break;
				//我方左移
			case KeyEvent.VK_A :
				myFrame.getMyTank().setDirect(3);
				myFrame.getMyTank().setMoveUp(false);
				myFrame.getMyTank().setMoveDown(false);
				myFrame.getMyTank().setMoveLeft(true);
				myFrame.getMyTank().setMoveRight(false);
			
			
				break;
			
			case KeyEvent.VK_D :
				//我方右移
				myFrame.getMyTank().setDirect(4);
				myFrame.getMyTank().setMoveUp(false);
				myFrame.getMyTank().setMoveDown(false);
				myFrame.getMyTank().setMoveLeft(false);
				myFrame.getMyTank().setMoveRight(true);
				break;
			case KeyEvent.VK_J :
				//我方发射子弹
				Util.fire = true;
				break;
			case KeyEvent.VK_UP :
				//用户二上移
				myFrame.getSecondTank().setDirect(1);
				myFrame.getSecondTank().setMoveUp(true);
				myFrame.getSecondTank().setMoveDown(false);
				myFrame.getSecondTank().setMoveLeft(false);
				myFrame.getSecondTank().setMoveRight(false);
				break;
				//用户二下移
			case KeyEvent.VK_DOWN :
				myFrame.getSecondTank().setDirect(2);
				myFrame.getSecondTank().setMoveUp(false);
				myFrame.getSecondTank().setMoveDown(true);
				myFrame.getSecondTank().setMoveLeft(false);
				myFrame.getSecondTank().setMoveRight(false);
			
				break;
				//用户二左移
			case KeyEvent.VK_LEFT :
				myFrame.getSecondTank().setDirect(3);
				myFrame.getSecondTank().setMoveUp(false);
				myFrame.getSecondTank().setMoveDown(false);
				myFrame.getSecondTank().setMoveLeft(true);
				myFrame.getSecondTank().setMoveRight(false);
			
			
				break;
			
			case KeyEvent.VK_RIGHT :
				//用户二右移
				myFrame.getSecondTank().setDirect(4);
				myFrame.getSecondTank().setMoveUp(false);
				myFrame.getSecondTank().setMoveDown(false);
				myFrame.getSecondTank().setMoveLeft(false);
				myFrame.getSecondTank().setMoveRight(true);
				break;
			case KeyEvent.VK_M :
				//用户二发射子弹
				Util.secondFire = true;
				break;

			default:
				break;
			}

		
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//当松开时，取消移动和发射，暂停。
		int key = e.getKeyCode();
		switch (key) {
		//暂停
		case KeyEvent.VK_J :
			Util.fire = false;
			break;
			//继续
		case KeyEvent.VK_C:
			Util.pause = true;
			break;
			//暂停
		case KeyEvent.VK_P:
			Util.pause = false;
			break;
		case KeyEvent.VK_W:
			myFrame.getMyTank().setMoveUp(false);
			break;
		case KeyEvent.VK_S:
			myFrame.getMyTank().setMoveDown(false);
			break;
		case KeyEvent.VK_A:
			myFrame.getMyTank().setMoveLeft(false);
			break;
		case KeyEvent.VK_D:
			myFrame.getMyTank().setMoveRight(false);
			break;
		case KeyEvent.VK_M :
			Util.secondFire = false;
			break;
		case KeyEvent.VK_UP:
			myFrame.getSecondTank().setMoveUp(false);
			break;
		case KeyEvent.VK_DOWN:
			myFrame.getSecondTank().setMoveDown(false);
			break;
		case KeyEvent.VK_LEFT:
			myFrame.getSecondTank().setMoveLeft(false);
			break;
		case KeyEvent.VK_RIGHT:
			myFrame.getSecondTank().setMoveRight(false);
			break;
			
		default:
			break;
		}
		
		
	}
	
	
	
	
}
