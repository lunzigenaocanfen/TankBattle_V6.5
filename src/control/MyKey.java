package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import tool.Util;
import view.MyFrame;

public class MyKey extends KeyAdapter {
	//���̼���
	MyFrame myFrame ;

	public MyKey(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(Util.pause){
		
		
		int key = e.getKeyCode();
		//�����û��ƶ��ͻ���ͬλ��

			
			switch (key) {
			case KeyEvent.VK_W :
				//�û�����
				myFrame.getMyTank().setDirect(1);
				myFrame.getMyTank().setMoveUp(true);
				myFrame.getMyTank().setMoveDown(false);
				myFrame.getMyTank().setMoveLeft(false);
				myFrame.getMyTank().setMoveRight(false);
				break;
				//�ҷ�����
			case KeyEvent.VK_S :
				myFrame.getMyTank().setDirect(2);
				myFrame.getMyTank().setMoveUp(false);
				myFrame.getMyTank().setMoveDown(true);
				myFrame.getMyTank().setMoveLeft(false);
				myFrame.getMyTank().setMoveRight(false);
			
				break;
				//�ҷ�����
			case KeyEvent.VK_A :
				myFrame.getMyTank().setDirect(3);
				myFrame.getMyTank().setMoveUp(false);
				myFrame.getMyTank().setMoveDown(false);
				myFrame.getMyTank().setMoveLeft(true);
				myFrame.getMyTank().setMoveRight(false);
			
			
				break;
			
			case KeyEvent.VK_D :
				//�ҷ�����
				myFrame.getMyTank().setDirect(4);
				myFrame.getMyTank().setMoveUp(false);
				myFrame.getMyTank().setMoveDown(false);
				myFrame.getMyTank().setMoveLeft(false);
				myFrame.getMyTank().setMoveRight(true);
				break;
			case KeyEvent.VK_J :
				//�ҷ������ӵ�
				Util.fire = true;
				break;
			case KeyEvent.VK_UP :
				//�û�������
				myFrame.getSecondTank().setDirect(1);
				myFrame.getSecondTank().setMoveUp(true);
				myFrame.getSecondTank().setMoveDown(false);
				myFrame.getSecondTank().setMoveLeft(false);
				myFrame.getSecondTank().setMoveRight(false);
				break;
				//�û�������
			case KeyEvent.VK_DOWN :
				myFrame.getSecondTank().setDirect(2);
				myFrame.getSecondTank().setMoveUp(false);
				myFrame.getSecondTank().setMoveDown(true);
				myFrame.getSecondTank().setMoveLeft(false);
				myFrame.getSecondTank().setMoveRight(false);
			
				break;
				//�û�������
			case KeyEvent.VK_LEFT :
				myFrame.getSecondTank().setDirect(3);
				myFrame.getSecondTank().setMoveUp(false);
				myFrame.getSecondTank().setMoveDown(false);
				myFrame.getSecondTank().setMoveLeft(true);
				myFrame.getSecondTank().setMoveRight(false);
			
			
				break;
			
			case KeyEvent.VK_RIGHT :
				//�û�������
				myFrame.getSecondTank().setDirect(4);
				myFrame.getSecondTank().setMoveUp(false);
				myFrame.getSecondTank().setMoveDown(false);
				myFrame.getSecondTank().setMoveLeft(false);
				myFrame.getSecondTank().setMoveRight(true);
				break;
			case KeyEvent.VK_M :
				//�û��������ӵ�
				Util.secondFire = true;
				break;

			default:
				break;
			}

		
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//���ɿ�ʱ��ȡ���ƶ��ͷ��䣬��ͣ��
		int key = e.getKeyCode();
		switch (key) {
		//��ͣ
		case KeyEvent.VK_J :
			Util.fire = false;
			break;
			//����
		case KeyEvent.VK_C:
			Util.pause = true;
			break;
			//��ͣ
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
