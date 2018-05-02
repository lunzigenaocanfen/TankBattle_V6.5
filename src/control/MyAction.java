package control;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

import tool.Util;
import view.MyFrame;

public class MyAction implements ActionListener {
	//��������
	MyFrame myFrame;
	int x = 0;
	public MyAction(MyFrame myFrame) {
		
		this.myFrame = myFrame;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		String action = e.getActionCommand();
		if(action.equals("START")) {
			//��ʼ���濪ʼ��Ϸ
			myFrame.setVisible(false);
			myFrame.getNameFrame().setVisible(true);
			
		}
		
		if(action.equals("QUIT")) {
			//��ʼ�����˳���Ϸ
			int res = JOptionPane.showConfirmDialog(null, "���Ƿ�ȷ���˳�", "��ܰ��ʾ", JOptionPane.OK_CANCEL_OPTION,1);
			if(res==JOptionPane.OK_OPTION) {
				
				System.exit(0);
			}
			
		}
		
		if(action.equals("YES")) {
			//�û���������ʱȷ�ϰ�ť
			String name = myFrame.getNameFrame().getNamePanel().getNameJtf().getText().trim();
			if(name.equals("")) {
				JOptionPane.showConfirmDialog(null,"�û���������Ϊ��","��ܰ��ʾ",JOptionPane.CLOSED_OPTION);
				myFrame.getNameFrame().getNamePanel().getNameJtf().setText("");
			}else {
				myFrame.getPlayGameFrame().getU().setName(name);
				int res = JOptionPane.showConfirmDialog(null, "��ӭ�û�:"+myFrame.getPlayGameFrame().getU().getName(), "��ӭ", JOptionPane.CLOSED_OPTION);
				myFrame.getNameFrame().setVisible(false);
				if(res != JOptionPane.CLOSED_OPTION) {
					myFrame.getPlayGameFrame().setVisible(true);
				}
			}
			
		}
		
		if(action.equals("NO")) {
			//�û���������ʱȡ����ť
			int res = JOptionPane.showConfirmDialog(null, "���Ƿ�ȷ��ȡ��", "��ܰ��ʾ", JOptionPane.OK_CANCEL_OPTION,1);
			if(res==JOptionPane.OK_OPTION) {
			myFrame.getPlayGameFrame().setVisible(false);
			myFrame.getNameFrame().setVisible(false);
			myFrame.setVisible(true);
			}
			
		}
		//����������Ľ���˵���
		if(action.equals("STARTGAME")) {
			//��ʼ��Ϸ
			myFrame.getGameMap().setArr(new int[15][15]);
			//��ӵ�����Ԥ����
			myFrame.getLevelInfoPanel().addEnemy();
			//�жϹؿ�
			myFrame.getPlayGameFrame().setLevel(Util.gameLevel);

			//��ʼ��Ϸʱ���жϹؿ��ǲ����Զ��壬����Զ��壬�ؿ�����Ϊ99.
			drawMapAndJudge();

			//�����Ϸ����ϵļ��ϵķ���
			clearScreamList();
			myFrame.getLevelInfoPanel().addEnemy();
			//��ť���ÿ��԰���
			myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(false);
			//ʹ�߳�ֻ����һ��
			if(x == 0) {
				myFrame.getEnemyAppearThread().start();
				myFrame.getEnemyMoveThread().start();
				myFrame.getNextLevelThread().start();
				myFrame.getPropBagAppearThread().start();
			}
			x++;
			//���ҷ�̹���ƻ���壬������
			myFrame.getMyTank().setX(200);
			myFrame.getMyTank().setY(560);
			myFrame.getMyTank().setDirect(1);
			myFrame.getMyTank().setLive(3);
			myFrame.getMyTank().setHp(3);
			Util.fire = false;
			myFrame.getMyTank().setMoveUp(false);
			myFrame.getMyTank().setMoveDown(false);
			myFrame.getMyTank().setMoveLeft(false);
			myFrame.getMyTank().setMoveRight(false);
			//�жϵ�˫��
			if(Util.twoPlay == 1) {
				myFrame.getSecondTank().setX(1000);
				myFrame.getSecondTank().setY(1000);
				myFrame.getSecondTank().setDirect(1);
				myFrame.getSecondTank().setLive(0);
				
			}else if(Util.twoPlay == 2) {
				myFrame.getSecondTank().setX(360);
				myFrame.getSecondTank().setY(560);
				myFrame.getSecondTank().setDirect(1);
				myFrame.getSecondTank().setLive(3);
				myFrame.getSecondTank().setHp(3);
			}
			Util.secondFire = false;
			myFrame.getSecondTank().setMoveUp(false);
			myFrame.getSecondTank().setMoveDown(false);
			myFrame.getSecondTank().setMoveLeft(false);
			myFrame.getSecondTank().setMoveRight(false);
			//���߰����õ������
			myFrame.getPropBag().setBagX(800);
			myFrame.getPropBag().setBagY(800);
			//���ؿ�Ϊ���һ�ػ����Զ���ʱ
			//����ͳ������ϣ��Ƴ���һ�أ����¿�ʼ��ť����ӷ��أ���Ϸ������ť
			if(myFrame.getPlayGameFrame().getLevel()==3||myFrame.getPlayGameFrame().getLevel()==99) {
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getPassLevelButton());
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getRestartButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getReturnButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getGameOverButton());
				myFrame.getPassLevelPanel().updateUI();
			}else {
				//����������һ�ػ����Զ���ʱ
				//����ͳ������ϣ��Ƴ����أ���Ϸ������ť�������һ�أ����¿�ʼ��ť
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getReturnButton());
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getGameOverButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getPassLevelButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getRestartButton());
				myFrame.getPassLevelPanel().updateUI();
				
			}
		}
		//���¿�ʼ��Ϸ
		if(action.equals("NEWGAME")) {
			//��ͼ���
			myFrame.getGameMap().setArr(new int[15][15]);
			//���ݹؿ�����ͼ
			drawMap();		
			//�ҷ�����
			myFrame.getMyTank().setDirect(1);
			myFrame.getMyTank().setHp(3);
			myFrame.getMyTank().setLive(3);
			myFrame.getMyTank().setX(200);
			myFrame.getMyTank().setY(560);
			Util.fire = false;
			myFrame.getMyTank().setMoveUp(false);
			myFrame.getMyTank().setMoveDown(false);
			myFrame.getMyTank().setMoveLeft(false);
			myFrame.getMyTank().setMoveRight(false);
			//�жϵ�˫��
			if(Util.twoPlay == 1) {
				myFrame.getSecondTank().setX(1000);
				myFrame.getSecondTank().setY(1000);
				myFrame.getSecondTank().setDirect(1);
				myFrame.getSecondTank().setLive(0);
			}else if(Util.twoPlay == 2) {
				myFrame.getSecondTank().setX(360);
				myFrame.getSecondTank().setY(560);
				myFrame.getSecondTank().setDirect(1);
				myFrame.getSecondTank().setLive(3);
				myFrame.getSecondTank().setHp(3);
			}
			Util.secondFire = false;
			myFrame.getSecondTank().setMoveUp(false);
			myFrame.getSecondTank().setMoveDown(false);
			myFrame.getSecondTank().setMoveLeft(false);
			myFrame.getSecondTank().setMoveRight(false);

			//�����Ϸ����ϵļ��ϵķ���
			clearScreamList();
			myFrame.getLevelInfoPanel().addEnemy();
			myFrame.getMyBulletHitEnemyThread().setKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setTotalKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setTotalScore(0);
			myFrame.getMyBulletHitEnemyThread().setCurrentScore(0);
			//���ҷ�̹���ƻ����
			myFrame.getMyTank().setX(200);
			myFrame.getMyTank().setY(560);
			//���߰��赽�߽���
			myFrame.getPropBag().setBagX(800);
			myFrame.getPropBag().setBagY(800);
		}
		//�Զ�����Ϸ
		if(action.equals("CUSTOMGAME")) {
			//��ʾ�Զ��壬��Ϸ���أ�������Ϸ������ģʽĬ����Ϊѡ��
			myFrame.getCustomFrame().setVisible(true);
			myFrame.getPlayGameFrame().setVisible(false);
			myFrame.getCustomPanel().getNormalGameRaioButton().setSelected(true);
			myFrame.getCustomPanel().getSinglePlayerRaioButton().setSelected(true);

		}
		
		//����ģʽ
		if(myFrame.getCustomPanel().getNormalGameRaioButton().isSelected()) {
			//������ģʽ��ѡ��ʱ�����øı�Ĭ��ѡ��
			myFrame.getCustomPanel().getLevelBox().setEnabled(false);
			myFrame.getCustomPanel().getEnemyTankSpeedBox().setEnabled(false);
			myFrame.getCustomPanel().getEnemyBulletSpeedBox().setEnabled(false);
			myFrame.getCustomPanel().getEnemyNumberTextField().setEnabled(false);
			myFrame.getCustomPanel().getEnemyBulletPowerBox().setEnabled(false);
			
			myFrame.getCustomPanel().getLevelBox().setSelectedIndex(0);
			myFrame.getCustomPanel().getEnemyTankSpeedBox().setSelectedIndex(0);
			myFrame.getCustomPanel().getEnemyBulletSpeedBox().setSelectedIndex(0);
			myFrame.getCustomPanel().getEnemyNumberTextField().setText("20");
			myFrame.getCustomPanel().getEnemyBulletPowerBox().setSelectedIndex(0);
			
		}
		//��ѡģʽ
		if(myFrame.getCustomPanel().getSelectGameRaioButton().isSelected()) {
			//��ѡģʽ���Ըı�ѡ��
			myFrame.getCustomPanel().getLevelBox().setEnabled(true);
			myFrame.getCustomPanel().getEnemyTankSpeedBox().setEnabled(true);
			myFrame.getCustomPanel().getEnemyBulletSpeedBox().setEnabled(true);
			myFrame.getCustomPanel().getEnemyNumberTextField().setEnabled(true);
			myFrame.getCustomPanel().getEnemyBulletPowerBox().setEnabled(true);
		}
		

		//�Զ����ȷ��
		if(action.equals("CUSTOMSURE")) {
			
			if(myFrame.getCustomPanel().getSinglePlayerRaioButton().isSelected()) {
				//������Ϸ
				Util.twoPlay = 1;
			}else if(myFrame.getCustomPanel().getDoublePlayerRaioButton().isSelected()) {
				//˫����Ϸ
				Util.twoPlay = 2;
			}
			//����ģʽ
			if(myFrame.getCustomPanel().getNormalGameRaioButton().isSelected()) {
				//���óɹ����ص���Ϸ����
				myFrame.getCustomFrame().setVisible(false);
				myFrame.getPlayGameFrame().setVisible(true);
				//�����Զ�������
				Util.gameLevel = Integer.parseInt((String)myFrame.getCustomPanel().getLevelBox().getSelectedItem());
				Util.enemyTankSpeed = Integer.parseInt((String)myFrame.getCustomPanel().getEnemyTankSpeedBox().getSelectedItem());
				Util.enemyBulletSpeed = Integer.parseInt((String)myFrame.getCustomPanel().getEnemyBulletSpeedBox().getSelectedItem());
				Util.enemyBulletPower = Integer.parseInt((String)myFrame.getCustomPanel().getEnemyBulletPowerBox().getSelectedItem());
				Util.enemyNumber = Integer.parseInt(myFrame.getCustomPanel().getEnemyNumberTextField().getText().trim());
				myFrame.getPlayGameFrame().setLevel(0);
				//���óɹ����ص���Ϸ����
				myFrame.getCustomFrame().setVisible(false);
				myFrame.getPlayGameFrame().setVisible(true);
				//��ʼ��Ϸ��ť���ÿ��԰���
				myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(true);
				
			
			}else if(myFrame.getCustomPanel().getSelectGameRaioButton().isSelected()) {
				//��ѡģʽ
				//�����Զ�������
				Util.gameLevel = Integer.parseInt((String)myFrame.getCustomPanel().getLevelBox().getSelectedItem());
				Util.enemyTankSpeed = Integer.parseInt((String)myFrame.getCustomPanel().getEnemyTankSpeedBox().getSelectedItem());
				Util.enemyBulletSpeed = Integer.parseInt((String)myFrame.getCustomPanel().getEnemyBulletSpeedBox().getSelectedItem());
				Util.enemyBulletPower = Integer.parseInt((String)myFrame.getCustomPanel().getEnemyBulletPowerBox().getSelectedItem());
				//�ж�����Ϊ�ջ��߲�������
				if(myFrame.getCustomPanel().getEnemyNumberTextField().getText().trim().equals("")){
					JOptionPane.showConfirmDialog(null, "̹����������Ϊ��", "��ܰ��ʾ", JOptionPane.CLOSED_OPTION);
				}else {
					int enemyNumber = 0;
					int point = 0;
					try {
						enemyNumber = Integer.parseInt(myFrame.getCustomPanel().getEnemyNumberTextField().getText().trim());
					} catch (Exception e2) {
						//������ε���
						point = 1;
					}
					
					if((enemyNumber < 10 || enemyNumber > 50) && point == 0) {
						JOptionPane.showConfirmDialog(null, "̹������������Χ", "��ܰ��ʾ", JOptionPane.CLOSED_OPTION);
					}else if(point == 1){
						JOptionPane.showConfirmDialog(null, "�Ƿ�����", "��ܰ��ʾ", JOptionPane.CLOSED_OPTION);
					}else {
						Util.enemyNumber = enemyNumber;
						myFrame.getPlayGameFrame().setLevel(0);
						//���óɹ����ص���Ϸ����
						myFrame.getCustomFrame().setVisible(false);
						myFrame.getPlayGameFrame().setVisible(true);
						//��ʼ��Ϸ��ť���ÿ��԰���
						myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(true);
					}
				}
			}
			
			
		}
		//�Զ������õ�ȡ��
		if(action.equals("CUSTOMCANCEL")) {
			myFrame.getCustomFrame().setVisible(false);
			myFrame.getPlayGameFrame().setVisible(true);
		}
		//�Զ����ͼ
		if(action.equals("CUSTOMMAP")) {
			//�����Ϸ�������ļ��ϵķ���
			clearScreamList();

			//���ϳ��̶��ڵײ�
			int[][] map = myFrame.getGameMap().getArr();
			map[14][7] = 5;
			
			//���ҷ�̹���Ƴ����
			myFrame.getMyTank().setX(700);
			myFrame.getMyTank().setY(700);
			myFrame.getSecondTank().setX(1000);
			myFrame.getSecondTank().setY(1000);
			//Ԥ��������Ƴ��������Զ������
			myFrame.getPlayGameFrame().remove(myFrame.getLevelInfoPanel());
			myFrame.getPlayGameFrame().add(myFrame.getCustomMapInfoPanel(),BorderLayout.EAST);
			Util.gameLevel = 98;
			myFrame.getPlayGameFrame().setLevel(Util.gameLevel);//���ùؿ�Ϊ�Զ���

			myFrame.getPlayGamePanel().updateUI();
			myFrame.getCustomMapInfoPanel().updateUI();
			//�˵������ɰ��µ�����
			myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(false);
			myFrame.getPlayGameFrame().getBar().getNewItem().setEnabled(false);
			myFrame.getPlayGameFrame().getBar().getCustomGameItem().setEnabled(false);
			myFrame.getPlayGameFrame().getBar().getCustomMapItem().setEnabled(false);
		}
		//�Զ����ͼ��ȷ����ť
		if(action.equals("CUSTOMMAPSURE")) {
			//�Ƴ��Զ�����壬����Ԥ�������
			myFrame.getPlayGameFrame().remove(myFrame.getCustomMapInfoPanel());
			myFrame.getPlayGameFrame().add(myFrame.getLevelInfoPanel(),BorderLayout.EAST);
			myFrame.getPlayGamePanel().updateUI();
			myFrame.getLevelInfoPanel().updateUI();
			//���⿪ʼ��Ϸ�󻹻��������ͼ
			Util.mapStyl = 0;
			myFrame.getPlayGameFrame().setLevel(0);
			//�˵������ÿ��԰���
			myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(true);
			myFrame.getPlayGameFrame().getBar().getNewItem().setEnabled(true);
			myFrame.getPlayGameFrame().getBar().getCustomGameItem().setEnabled(true);
			myFrame.getPlayGameFrame().getBar().getCustomMapItem().setEnabled(true);
		}
		//�Զ����ͼ��ȡ����ť
		if(action.equals("CUSTOMCANCEL")) {
			//�ؿ�����Ϊ��һ��
			Util.gameLevel = 1;
			//�Ƴ��Զ�����壬����Ԥ�������
			myFrame.getPlayGameFrame().remove(myFrame.getCustomMapInfoPanel());
			myFrame.getPlayGameFrame().add(myFrame.getLevelInfoPanel());
			myFrame.getPlayGamePanel().updateUI();
			myFrame.getLevelInfoPanel().updateUI();
			myFrame.getGameMap().setArr(new int[15][15]);
			//���⿪ʼ��Ϸ�󻹻��������ͼ
			Util.mapStyl = 0;
			myFrame.getPlayGameFrame().setLevel(0);
			//�˵������ÿ��԰���
			myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(true);
			myFrame.getPlayGameFrame().getBar().getNewItem().setEnabled(true);
			myFrame.getPlayGameFrame().getBar().getCustomGameItem().setEnabled(true);
			myFrame.getPlayGameFrame().getBar().getCustomMapItem().setEnabled(true);
		}
		//�Զ����ͼ����ϵİ�ť����ש�������ݣ�ˮ��ɾ����
		if(action.equals("WALL")) {
			Util.mapStyl = 1;
		}
		if(action.equals("STEEL")) {
			Util.mapStyl = 2;
		}
		if(action.equals("GRASS")) {
			Util.mapStyl = 3;
		}
		if(action.equals("WATER")) {
			Util.mapStyl = 4;
		}
		if(action.equals("DELETE")) {
			Util.mapStyl = 0;
		}
		
		//����ڳ�ʼ�������ܵ�����¿�ʼ��Ϸ
		if(myFrame.getPlayGameFrame().getLevel()==0 || myFrame.getPlayGameFrame().getLevel()==98) {
			myFrame.getPlayGameFrame().getBar().getNewItem().setEnabled(false);
		}else {
			myFrame.getPlayGameFrame().getBar().getNewItem().setEnabled(true);
		}
		//��Ϸ���أ������һ��
		if(action.equals("PASSLEVEL")) {
			
			myFrame.getGameMap().setArr(new int[15][15]);

			//��ɱ��¼��ԭ
			myFrame.getMyBulletHitEnemyThread().setKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setCurrentScore(0);
			myFrame.getMyBulletHitEnemyThread().setKillEasy(0);
			myFrame.getMyBulletHitEnemyThread().setKillHard(0);
			myFrame.getMyBulletHitEnemyThread().setKillNormal(0);

			//�ҷ�λ�û�ԭ
			myFrame.getMyTank().setX(200);
			myFrame.getMyTank().setY(560);
			myFrame.getMyTank().setDirect(1);
			Util.fire = false;
			myFrame.getMyTank().setMoveUp(false);
			myFrame.getMyTank().setMoveDown(false);
			myFrame.getMyTank().setMoveLeft(false);
			myFrame.getMyTank().setMoveRight(false);
			//�жϵ�˫��
			if(Util.twoPlay == 1) {
				myFrame.getSecondTank().setX(1000);
				myFrame.getSecondTank().setY(1000);
				myFrame.getSecondTank().setDirect(1);
				myFrame.getSecondTank().setLive(0);
			}else if(Util.twoPlay == 2) {
				myFrame.getSecondTank().setX(360);
				myFrame.getSecondTank().setY(560);
				myFrame.getSecondTank().setDirect(1);
			}
			Util.secondFire = false;
			myFrame.getSecondTank().setMoveUp(false);
			myFrame.getSecondTank().setMoveDown(false);
			myFrame.getSecondTank().setMoveLeft(false);
			myFrame.getSecondTank().setMoveRight(false);
			//�����Ϸ����ϵļ��ϵķ���
			clearScreamList();
			//��ӵ�����Ԥ����
			myFrame.getLevelInfoPanel().addEnemy();
			Util.gameLevel++;
			myFrame.getPlayGameFrame().setLevel(myFrame.getPlayGameFrame().getLevel()+1);
			//����һ�ص�ͼ

			//��ʼ��Ϸʱ���жϹؿ��ǲ����Զ��壬����Զ��壬�ؿ�����Ϊ99.
			drawMapAndJudge();
			myFrame.getPassLevelFrame().setVisible(false);
			myFrame.getPlayGameFrame().setVisible(true);
			//���ذ�ť���ǽ�����Ϸ�İ�ť�жϲ������ɾ��
			if(myFrame.getPlayGameFrame().getLevel()==3||myFrame.getPlayGameFrame().getLevel()==99) {
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getPassLevelButton());
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getRestartButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getReturnButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getGameOverButton());
				myFrame.getPassLevelPanel().updateUI();
			}else {
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getReturnButton());
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getGameOverButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getPassLevelButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getRestartButton());
				myFrame.getPassLevelPanel().updateUI();
				
			}

		}
		//���غ����¿�ʼ��Ϸ
		if(action.equals("RESTART")) {
			//��ͼ���
			myFrame.getGameMap().setArr(new int[15][15]);

			//���ݹؿ�����ͼ
			drawMap();
			//�ҷ�����
			myFrame.getMyTank().setDirect(1);
			myFrame.getMyTank().setHp(3);
			myFrame.getMyTank().setLive(3);
			myFrame.getMyTank().setX(200);
			myFrame.getMyTank().setY(560);
			Util.fire = false;
			myFrame.getMyTank().setMoveUp(false);
			myFrame.getMyTank().setMoveDown(false);
			myFrame.getMyTank().setMoveLeft(false);
			myFrame.getMyTank().setMoveRight(false);
			//�жϵ�˫��
			if(Util.twoPlay == 1) {
				myFrame.getSecondTank().setX(1000);
				myFrame.getSecondTank().setY(1000);
				myFrame.getSecondTank().setDirect(1);
				myFrame.getSecondTank().setLive(0);
			}else if(Util.twoPlay == 2) {
				myFrame.getSecondTank().setX(360);
				myFrame.getSecondTank().setY(560);
				myFrame.getSecondTank().setDirect(1);
				myFrame.getSecondTank().setLive(3);
				myFrame.getSecondTank().setHp(3);
			}
			Util.secondFire = false;
			myFrame.getSecondTank().setMoveUp(false);
			myFrame.getSecondTank().setMoveDown(false);
			myFrame.getSecondTank().setMoveLeft(false);
			myFrame.getSecondTank().setMoveRight(false);
			//�����Ϸ����ϵļ��ϵķ���
			clearScreamList();
			myFrame.getLevelInfoPanel().addEnemy();
			//��ɱ��¼��ԭ
			myFrame.getMyBulletHitEnemyThread().setKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setCurrentScore(0);
			myFrame.getMyBulletHitEnemyThread().setKillEasy(0);
			myFrame.getMyBulletHitEnemyThread().setKillHard(0);
			myFrame.getMyBulletHitEnemyThread().setKillNormal(0);
			myFrame.getMyBulletHitEnemyThread().setTotalKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setTotalScore(0);
			//���߰��赽�߽���
			myFrame.getPropBag().setBagX(800);
			myFrame.getPropBag().setBagY(800);
			
			myFrame.getPassLevelFrame().setVisible(false);
			myFrame.getPlayGameFrame().setVisible(true);
		}
		//ͨ�ط��������
		if(action.equals("RETURN")) {
			myFrame.getPassLevelFrame().setVisible(false);
			myFrame.getPlayGameFrame().setVisible(true);
			Util.gameLevel = 1;
			myFrame.getPlayGameFrame().setLevel(0);
			myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(true);
			//��������
			clearScreamList();
			//��ɱ��¼��ԭ
			myFrame.getMyBulletHitEnemyThread().setKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setCurrentScore(0);
			myFrame.getMyBulletHitEnemyThread().setKillEasy(0);
			myFrame.getMyBulletHitEnemyThread().setKillHard(0);
			myFrame.getMyBulletHitEnemyThread().setKillNormal(0);
			myFrame.getMyBulletHitEnemyThread().setTotalKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setTotalScore(0);
			
		}
		//ͨ�ؽ�����Ϸ
		if(action.equals("GAMEOVER")) {
			int res = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ������Ϸ��", "��ܰ��ʾ", JOptionPane.OK_CANCEL_OPTION);
			if(res == JOptionPane.OK_OPTION) {
				System.exit(0);
			}
		}
		//����
		if(action.equals("INTRODUCE")) {
			myFrame.getIntroducedFrame().setVisible(true);
			myFrame.getPlayGameFrame().setVisible(false);
		}
		//����
		if(action.equals("BACK")) {
			myFrame.getIntroducedFrame().setVisible(false);
			myFrame.getPlayGameFrame().setVisible(true);
		}
		//����
		if(action.equals("ABOUT")) {
			JOptionPane.showMessageDialog(null, "��˾��׿Ծ����\n"+"���ߣ���ʿ��\n"+"�༶��JF1711\n"+"ѧ�ţ�JF171124\n"+"�汾��v6.4");
		}

	}

	
	//�����Ϸ����ϵļ��ϵķ���
	public void clearScreamList() {
		for (int i = myFrame.getMyBulletList().size() - 1; i >= 0; i--) {
			myFrame.getMyBulletList().remove(i);
		}
		for (int i = myFrame.getEnemyBulletList().size() - 1; i >= 0; i--) {
			myFrame.getEnemyBulletList().remove(i);
		}
		for (int i = myFrame.getEnemyList().size() - 1; i >= 0; i--) {
			myFrame.getEnemyList().remove(i);
		}
		for (int i = myFrame.getLevelInfoPanel().getInfoEnemyList().size() - 1; i >= 0; i--) {
			myFrame.getLevelInfoPanel().getInfoEnemyList().remove(i);
		}
		
	}
	//���¿�ʼ�Ļ���ͼ����
	public void drawMap() {
		switch (Util.gameLevel) {
		case 1:
			myFrame.getGameMap().drawLevelFirst();
			break;
		case 2:
			myFrame.getGameMap().drawLevelSecend();
			break;
		case 3:
			myFrame.getGameMap().drawLevelThird();
			break;
		case 99://�Զ����
			myFrame.getGameMap().setArr(myFrame.getMyMouse().getMap());
			break;

		default:
			break;
		}
	}
	//��ʼ��Ϸ���жϵ�ǰ�ؿ�������ͼ�ķ���
	public void drawMapAndJudge() {
		
		switch (myFrame.getPlayGameFrame().getLevel()) {
		case 1://��һ��
			myFrame.getGameMap().drawLevelFirst();
			break;
		case 2://�ڶ���
			myFrame.getGameMap().drawLevelSecend();
			break;
		case 3://������
			myFrame.getGameMap().drawLevelThird();
			break;
		case 98://�Զ����
			Util.gameLevel = 99;
			myFrame.getPlayGameFrame().setLevel(99);
			myFrame.getGameMap().setArr(myFrame.getMyMouse().getMap());
			break;

		default:
			break;
		}
		
		
		
	}
	
	
}
