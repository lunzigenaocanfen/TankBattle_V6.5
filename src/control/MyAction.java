package control;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

import tool.Util;
import view.MyFrame;

public class MyAction implements ActionListener {
	//动作监听
	MyFrame myFrame;
	int x = 0;
	public MyAction(MyFrame myFrame) {
		
		this.myFrame = myFrame;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		String action = e.getActionCommand();
		if(action.equals("START")) {
			//初始界面开始游戏
			myFrame.setVisible(false);
			myFrame.getNameFrame().setVisible(true);
			
		}
		
		if(action.equals("QUIT")) {
			//初始界面退出游戏
			int res = JOptionPane.showConfirmDialog(null, "您是否确定退出", "温馨提示", JOptionPane.OK_CANCEL_OPTION,1);
			if(res==JOptionPane.OK_OPTION) {
				
				System.exit(0);
			}
			
		}
		
		if(action.equals("YES")) {
			//用户输入姓名时确认按钮
			String name = myFrame.getNameFrame().getNamePanel().getNameJtf().getText().trim();
			if(name.equals("")) {
				JOptionPane.showConfirmDialog(null,"用户姓名不能为空","温馨提示",JOptionPane.CLOSED_OPTION);
				myFrame.getNameFrame().getNamePanel().getNameJtf().setText("");
			}else {
				myFrame.getPlayGameFrame().getU().setName(name);
				int res = JOptionPane.showConfirmDialog(null, "欢迎用户:"+myFrame.getPlayGameFrame().getU().getName(), "欢迎", JOptionPane.CLOSED_OPTION);
				myFrame.getNameFrame().setVisible(false);
				if(res != JOptionPane.CLOSED_OPTION) {
					myFrame.getPlayGameFrame().setVisible(true);
				}
			}
			
		}
		
		if(action.equals("NO")) {
			//用户输入姓名时取消按钮
			int res = JOptionPane.showConfirmDialog(null, "您是否确定取消", "温馨提示", JOptionPane.OK_CANCEL_OPTION,1);
			if(res==JOptionPane.OK_OPTION) {
			myFrame.getPlayGameFrame().setVisible(false);
			myFrame.getNameFrame().setVisible(false);
			myFrame.setVisible(true);
			}
			
		}
		//输入姓名后的界面菜单栏
		if(action.equals("STARTGAME")) {
			//开始游戏
			myFrame.getGameMap().setArr(new int[15][15]);
			//添加敌人至预览区
			myFrame.getLevelInfoPanel().addEnemy();
			//判断关卡
			myFrame.getPlayGameFrame().setLevel(Util.gameLevel);

			//开始游戏时，判断关卡是不是自定义，如果自定义，关卡设置为99.
			drawMapAndJudge();

			//清除游戏面板上的集合的方法
			clearScreamList();
			myFrame.getLevelInfoPanel().addEnemy();
			//按钮设置可以按下
			myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(false);
			//使线程只启动一次
			if(x == 0) {
				myFrame.getEnemyAppearThread().start();
				myFrame.getEnemyMoveThread().start();
				myFrame.getNextLevelThread().start();
				myFrame.getPropBagAppearThread().start();
			}
			x++;
			//将我方坦克移回面板，且重置
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
			//判断单双人
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
			//道具包设置到面板外
			myFrame.getPropBag().setBagX(800);
			myFrame.getPropBag().setBagY(800);
			//当关卡为最后一关或者自定义时
			//过关统计面板上，移除下一关，重新开始按钮，添加返回，游戏结束按钮
			if(myFrame.getPlayGameFrame().getLevel()==3||myFrame.getPlayGameFrame().getLevel()==99) {
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getPassLevelButton());
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getRestartButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getReturnButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getGameOverButton());
				myFrame.getPassLevelPanel().updateUI();
			}else {
				//如果不是最后一关或者自定义时
				//过关统计面板上，移除返回，游戏结束按钮，添加下一关，重新开始按钮
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getReturnButton());
				myFrame.getPassLevelPanel().remove(myFrame.getPassLevelPanel().getGameOverButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getPassLevelButton());
				myFrame.getPassLevelPanel().add(myFrame.getPassLevelPanel().getRestartButton());
				myFrame.getPassLevelPanel().updateUI();
				
			}
		}
		//重新开始游戏
		if(action.equals("NEWGAME")) {
			//地图清空
			myFrame.getGameMap().setArr(new int[15][15]);
			//根据关卡画地图
			drawMap();		
			//我方重置
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
			//判断单双人
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

			//清除游戏面板上的集合的方法
			clearScreamList();
			myFrame.getLevelInfoPanel().addEnemy();
			myFrame.getMyBulletHitEnemyThread().setKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setTotalKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setTotalScore(0);
			myFrame.getMyBulletHitEnemyThread().setCurrentScore(0);
			//将我方坦克移回面板
			myFrame.getMyTank().setX(200);
			myFrame.getMyTank().setY(560);
			//道具包设到边界外
			myFrame.getPropBag().setBagX(800);
			myFrame.getPropBag().setBagY(800);
		}
		//自定义游戏
		if(action.equals("CUSTOMGAME")) {
			//显示自定义，游戏隐藏，单人游戏，正常模式默认设为选择
			myFrame.getCustomFrame().setVisible(true);
			myFrame.getPlayGameFrame().setVisible(false);
			myFrame.getCustomPanel().getNormalGameRaioButton().setSelected(true);
			myFrame.getCustomPanel().getSinglePlayerRaioButton().setSelected(true);

		}
		
		//正常模式
		if(myFrame.getCustomPanel().getNormalGameRaioButton().isSelected()) {
			//当正常模式被选择时，不让改变默认选项
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
		//自选模式
		if(myFrame.getCustomPanel().getSelectGameRaioButton().isSelected()) {
			//自选模式可以改变选项
			myFrame.getCustomPanel().getLevelBox().setEnabled(true);
			myFrame.getCustomPanel().getEnemyTankSpeedBox().setEnabled(true);
			myFrame.getCustomPanel().getEnemyBulletSpeedBox().setEnabled(true);
			myFrame.getCustomPanel().getEnemyNumberTextField().setEnabled(true);
			myFrame.getCustomPanel().getEnemyBulletPowerBox().setEnabled(true);
		}
		

		//自定义的确定
		if(action.equals("CUSTOMSURE")) {
			
			if(myFrame.getCustomPanel().getSinglePlayerRaioButton().isSelected()) {
				//单人游戏
				Util.twoPlay = 1;
			}else if(myFrame.getCustomPanel().getDoublePlayerRaioButton().isSelected()) {
				//双人游戏
				Util.twoPlay = 2;
			}
			//正常模式
			if(myFrame.getCustomPanel().getNormalGameRaioButton().isSelected()) {
				//设置成功，回到游戏窗口
				myFrame.getCustomFrame().setVisible(false);
				myFrame.getPlayGameFrame().setVisible(true);
				//设置自定义属性
				Util.gameLevel = Integer.parseInt((String)myFrame.getCustomPanel().getLevelBox().getSelectedItem());
				Util.enemyTankSpeed = Integer.parseInt((String)myFrame.getCustomPanel().getEnemyTankSpeedBox().getSelectedItem());
				Util.enemyBulletSpeed = Integer.parseInt((String)myFrame.getCustomPanel().getEnemyBulletSpeedBox().getSelectedItem());
				Util.enemyBulletPower = Integer.parseInt((String)myFrame.getCustomPanel().getEnemyBulletPowerBox().getSelectedItem());
				Util.enemyNumber = Integer.parseInt(myFrame.getCustomPanel().getEnemyNumberTextField().getText().trim());
				myFrame.getPlayGameFrame().setLevel(0);
				//设置成功，回到游戏窗口
				myFrame.getCustomFrame().setVisible(false);
				myFrame.getPlayGameFrame().setVisible(true);
				//开始游戏按钮设置可以按下
				myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(true);
				
			
			}else if(myFrame.getCustomPanel().getSelectGameRaioButton().isSelected()) {
				//自选模式
				//设置自定义属性
				Util.gameLevel = Integer.parseInt((String)myFrame.getCustomPanel().getLevelBox().getSelectedItem());
				Util.enemyTankSpeed = Integer.parseInt((String)myFrame.getCustomPanel().getEnemyTankSpeedBox().getSelectedItem());
				Util.enemyBulletSpeed = Integer.parseInt((String)myFrame.getCustomPanel().getEnemyBulletSpeedBox().getSelectedItem());
				Util.enemyBulletPower = Integer.parseInt((String)myFrame.getCustomPanel().getEnemyBulletPowerBox().getSelectedItem());
				//判断输入为空或者不是数字
				if(myFrame.getCustomPanel().getEnemyNumberTextField().getText().trim().equals("")){
					JOptionPane.showConfirmDialog(null, "坦克数量不能为空", "温馨提示", JOptionPane.CLOSED_OPTION);
				}else {
					int enemyNumber = 0;
					int point = 0;
					try {
						enemyNumber = Integer.parseInt(myFrame.getCustomPanel().getEnemyNumberTextField().getText().trim());
					} catch (Exception e2) {
						//避免二次弹窗
						point = 1;
					}
					
					if((enemyNumber < 10 || enemyNumber > 50) && point == 0) {
						JOptionPane.showConfirmDialog(null, "坦克数量超出范围", "温馨提示", JOptionPane.CLOSED_OPTION);
					}else if(point == 1){
						JOptionPane.showConfirmDialog(null, "非法输入", "温馨提示", JOptionPane.CLOSED_OPTION);
					}else {
						Util.enemyNumber = enemyNumber;
						myFrame.getPlayGameFrame().setLevel(0);
						//设置成功，回到游戏窗口
						myFrame.getCustomFrame().setVisible(false);
						myFrame.getPlayGameFrame().setVisible(true);
						//开始游戏按钮设置可以按下
						myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(true);
					}
				}
			}
			
			
		}
		//自定义设置的取消
		if(action.equals("CUSTOMCANCEL")) {
			myFrame.getCustomFrame().setVisible(false);
			myFrame.getPlayGameFrame().setVisible(true);
		}
		//自定义地图
		if(action.equals("CUSTOMMAP")) {
			//清空游戏面板里面的集合的方法
			clearScreamList();

			//将老巢固定在底部
			int[][] map = myFrame.getGameMap().getArr();
			map[14][7] = 5;
			
			//将我方坦克移出面板
			myFrame.getMyTank().setX(700);
			myFrame.getMyTank().setY(700);
			myFrame.getSecondTank().setX(1000);
			myFrame.getSecondTank().setY(1000);
			//预览区面板移除，换成自定义面板
			myFrame.getPlayGameFrame().remove(myFrame.getLevelInfoPanel());
			myFrame.getPlayGameFrame().add(myFrame.getCustomMapInfoPanel(),BorderLayout.EAST);
			Util.gameLevel = 98;
			myFrame.getPlayGameFrame().setLevel(Util.gameLevel);//设置关卡为自定义

			myFrame.getPlayGamePanel().updateUI();
			myFrame.getCustomMapInfoPanel().updateUI();
			//菜单栏不可按下的设置
			myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(false);
			myFrame.getPlayGameFrame().getBar().getNewItem().setEnabled(false);
			myFrame.getPlayGameFrame().getBar().getCustomGameItem().setEnabled(false);
			myFrame.getPlayGameFrame().getBar().getCustomMapItem().setEnabled(false);
		}
		//自定义地图的确定按钮
		if(action.equals("CUSTOMMAPSURE")) {
			//移除自定义面板，换成预览区面板
			myFrame.getPlayGameFrame().remove(myFrame.getCustomMapInfoPanel());
			myFrame.getPlayGameFrame().add(myFrame.getLevelInfoPanel(),BorderLayout.EAST);
			myFrame.getPlayGamePanel().updateUI();
			myFrame.getLevelInfoPanel().updateUI();
			//避免开始游戏后还会继续画地图
			Util.mapStyl = 0;
			myFrame.getPlayGameFrame().setLevel(0);
			//菜单栏设置可以按下
			myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(true);
			myFrame.getPlayGameFrame().getBar().getNewItem().setEnabled(true);
			myFrame.getPlayGameFrame().getBar().getCustomGameItem().setEnabled(true);
			myFrame.getPlayGameFrame().getBar().getCustomMapItem().setEnabled(true);
		}
		//自定义地图的取消按钮
		if(action.equals("CUSTOMCANCEL")) {
			//关卡设置为第一关
			Util.gameLevel = 1;
			//移除自定义面板，换成预览区面板
			myFrame.getPlayGameFrame().remove(myFrame.getCustomMapInfoPanel());
			myFrame.getPlayGameFrame().add(myFrame.getLevelInfoPanel());
			myFrame.getPlayGamePanel().updateUI();
			myFrame.getLevelInfoPanel().updateUI();
			myFrame.getGameMap().setArr(new int[15][15]);
			//避免开始游戏后还会继续画地图
			Util.mapStyl = 0;
			myFrame.getPlayGameFrame().setLevel(0);
			//菜单栏设置可以按下
			myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(true);
			myFrame.getPlayGameFrame().getBar().getNewItem().setEnabled(true);
			myFrame.getPlayGameFrame().getBar().getCustomGameItem().setEnabled(true);
			myFrame.getPlayGameFrame().getBar().getCustomMapItem().setEnabled(true);
		}
		//自定义地图面板上的按钮，画砖，铁，草，水，删除。
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
		
		//如果在初始界面则不能点击重新开始游戏
		if(myFrame.getPlayGameFrame().getLevel()==0 || myFrame.getPlayGameFrame().getLevel()==98) {
			myFrame.getPlayGameFrame().getBar().getNewItem().setEnabled(false);
		}else {
			myFrame.getPlayGameFrame().getBar().getNewItem().setEnabled(true);
		}
		//游戏过关，点击下一关
		if(action.equals("PASSLEVEL")) {
			
			myFrame.getGameMap().setArr(new int[15][15]);

			//击杀记录还原
			myFrame.getMyBulletHitEnemyThread().setKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setCurrentScore(0);
			myFrame.getMyBulletHitEnemyThread().setKillEasy(0);
			myFrame.getMyBulletHitEnemyThread().setKillHard(0);
			myFrame.getMyBulletHitEnemyThread().setKillNormal(0);

			//我方位置还原
			myFrame.getMyTank().setX(200);
			myFrame.getMyTank().setY(560);
			myFrame.getMyTank().setDirect(1);
			Util.fire = false;
			myFrame.getMyTank().setMoveUp(false);
			myFrame.getMyTank().setMoveDown(false);
			myFrame.getMyTank().setMoveLeft(false);
			myFrame.getMyTank().setMoveRight(false);
			//判断单双人
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
			//清除游戏面板上的集合的方法
			clearScreamList();
			//添加敌人至预览区
			myFrame.getLevelInfoPanel().addEnemy();
			Util.gameLevel++;
			myFrame.getPlayGameFrame().setLevel(myFrame.getPlayGameFrame().getLevel()+1);
			//画下一关地图

			//开始游戏时，判断关卡是不是自定义，如果自定义，关卡设置为99.
			drawMapAndJudge();
			myFrame.getPassLevelFrame().setVisible(false);
			myFrame.getPlayGameFrame().setVisible(true);
			//过关按钮还是结束游戏的按钮判断并添加与删除
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
		//过关后重新开始游戏
		if(action.equals("RESTART")) {
			//地图清空
			myFrame.getGameMap().setArr(new int[15][15]);

			//根据关卡画地图
			drawMap();
			//我方重置
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
			//判断单双人
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
			//清除游戏面板上的集合的方法
			clearScreamList();
			myFrame.getLevelInfoPanel().addEnemy();
			//击杀记录还原
			myFrame.getMyBulletHitEnemyThread().setKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setCurrentScore(0);
			myFrame.getMyBulletHitEnemyThread().setKillEasy(0);
			myFrame.getMyBulletHitEnemyThread().setKillHard(0);
			myFrame.getMyBulletHitEnemyThread().setKillNormal(0);
			myFrame.getMyBulletHitEnemyThread().setTotalKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setTotalScore(0);
			//道具包设到边界外
			myFrame.getPropBag().setBagX(800);
			myFrame.getPropBag().setBagY(800);
			
			myFrame.getPassLevelFrame().setVisible(false);
			myFrame.getPlayGameFrame().setVisible(true);
		}
		//通关返回主面板
		if(action.equals("RETURN")) {
			myFrame.getPassLevelFrame().setVisible(false);
			myFrame.getPlayGameFrame().setVisible(true);
			Util.gameLevel = 1;
			myFrame.getPlayGameFrame().setLevel(0);
			myFrame.getPlayGameFrame().getBar().getStartItem().setEnabled(true);
			//数据清零
			clearScreamList();
			//击杀记录还原
			myFrame.getMyBulletHitEnemyThread().setKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setCurrentScore(0);
			myFrame.getMyBulletHitEnemyThread().setKillEasy(0);
			myFrame.getMyBulletHitEnemyThread().setKillHard(0);
			myFrame.getMyBulletHitEnemyThread().setKillNormal(0);
			myFrame.getMyBulletHitEnemyThread().setTotalKillEnemy(0);
			myFrame.getMyBulletHitEnemyThread().setTotalScore(0);
			
		}
		//通关结束游戏
		if(action.equals("GAMEOVER")) {
			int res = JOptionPane.showConfirmDialog(null, "确定要结束游戏吗？", "温馨提示", JOptionPane.OK_CANCEL_OPTION);
			if(res == JOptionPane.OK_OPTION) {
				System.exit(0);
			}
		}
		//帮助
		if(action.equals("INTRODUCE")) {
			myFrame.getIntroducedFrame().setVisible(true);
			myFrame.getPlayGameFrame().setVisible(false);
		}
		//返回
		if(action.equals("BACK")) {
			myFrame.getIntroducedFrame().setVisible(false);
			myFrame.getPlayGameFrame().setVisible(true);
		}
		//关于
		if(action.equals("ABOUT")) {
			JOptionPane.showMessageDialog(null, "公司：卓跃教育\n"+"作者：林士琦\n"+"班级：JF1711\n"+"学号：JF171124\n"+"版本：v6.4");
		}

	}

	
	//清除游戏面板上的集合的方法
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
	//重新开始的画地图方法
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
		case 99://自定义关
			myFrame.getGameMap().setArr(myFrame.getMyMouse().getMap());
			break;

		default:
			break;
		}
	}
	//开始游戏的判断当前关卡并画地图的方法
	public void drawMapAndJudge() {
		
		switch (myFrame.getPlayGameFrame().getLevel()) {
		case 1://第一关
			myFrame.getGameMap().drawLevelFirst();
			break;
		case 2://第二关
			myFrame.getGameMap().drawLevelSecend();
			break;
		case 3://第三关
			myFrame.getGameMap().drawLevelThird();
			break;
		case 98://自定义关
			Util.gameLevel = 99;
			myFrame.getPlayGameFrame().setLevel(99);
			myFrame.getGameMap().setArr(myFrame.getMyMouse().getMap());
			break;

		default:
			break;
		}
		
		
		
	}
	
	
}
