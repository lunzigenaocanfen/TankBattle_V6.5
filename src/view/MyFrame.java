package view;

import java.util.ArrayList;
import javax.swing.JFrame;

import control.MyAction;
import control.MyFocus;
import control.MyKey;
import control.MyMouse;
import control.MyWindow;
import model.Bullet;
import model.Enemy;
import model.GameMap;
import model.MyTank;
import model.PropBag;
import thread.BulletHitBulletThread;
import thread.MyBulletHitEnemyThread;
import thread.EnemyAppearThread;
import thread.EnemyBulletFireThread;
import thread.EnemyBulletHitThread;
import thread.EnemyBulletMoveThread;
import thread.EnemyChangeDirectionThread;
import thread.EnemyImpactPropThread;
import thread.EnemyMoveThread;
import thread.EnemyHitMyTankThread;
import thread.MyBulletHitThread;
import thread.MyBulletMoveThread;
import thread.MyTankFireThread;
import thread.MyTankImpactPropThread;
import thread.MyTankMoveThread;
import thread.NextLevelThread;
import thread.PropBagAppearThread;
import thread.RepaintThread;
import thread.LoseThread;

public class MyFrame extends JFrame {
	// 顶级容器
	// 最开始欢迎用户面板
	private WelcomePanel welPanel = new WelcomePanel();
	// 事件监听
	private MyAction myAction = new MyAction(this);
	// 键盘监听
	private MyKey myKey = new MyKey(this);
	// 我方坦克
	private MyTank myTank = new MyTank(200, 560, 1);// 用户1
	private MyTank secondTank = new MyTank(360, 560, 2);// 用户2
	// 游戏面板
	private PlayGamePanel playGamePanel = new PlayGamePanel(this);
	// 创建地图数组
	private GameMap gameMap = new GameMap(15, 15);
	// 敌人出现线程
	private EnemyAppearThread enemyAppearThread = new EnemyAppearThread(this);
	// 敌人移动线程
	private EnemyMoveThread enemyMoveThread = new EnemyMoveThread(this);
	// 敌我子弹集合
	private ArrayList<Bullet> myBulletList = new ArrayList<Bullet>();
	private ArrayList<Enemy> EnemyList = new ArrayList<Enemy>();
	private ArrayList<Bullet> enemyBulletList = new ArrayList<Bullet>();
	// 游戏预览区面板
	private InfoPanel levelInfoPanel = new InfoPanel(this);
	// 输入姓名窗口
	private NameFrame nameFrame = new NameFrame();
	//游戏介绍
	private IntroducedFrame introducedFrame = new IntroducedFrame();
	// 游戏窗口
	private PlayGameFrame playGameFrame = new PlayGameFrame(this);
	// 我方子弹击打地图线程
	private MyBulletHitThread myBulletHitThread = new MyBulletHitThread(this);
	// 我方子弹移动线程
	private MyBulletMoveThread myBulletMoveThread = new MyBulletMoveThread(this);
	// 敌人转向线程
	private EnemyChangeDirectionThread enemyChangeDirectionThread = new EnemyChangeDirectionThread(this);
	// 敌人开火线程
	private EnemyBulletFireThread enemyBulletFireThread = new EnemyBulletFireThread(this);
	// 敌人子弹移动线程
	private EnemyBulletMoveThread enemyBulletMoveThread = new EnemyBulletMoveThread(this);
	// 敌人子弹击打地图线程
	private EnemyBulletHitThread enemyBulletHitThread = new EnemyBulletHitThread(this);
	// 我方子弹打敌人线程
	private MyBulletHitEnemyThread myBulletHitEnemyThread = new MyBulletHitEnemyThread(this);
	// 敌我子弹击打消除线程
	private BulletHitBulletThread bulletHitBulletThread = new BulletHitBulletThread(this);
	// 敌人子弹打我方坦克线程
	private EnemyHitMyTankThread enemyHitMyTankThread = new EnemyHitMyTankThread(this);
	// 判断下一关线程
	private NextLevelThread nextLevelThread = new NextLevelThread(this);
	// 我方坦克移动线程
	private MyTankMoveThread myTankMoveThread = new MyTankMoveThread(this);
	// 自定义设置面板
	private CustomPanel customPanel = new CustomPanel(this);
	// 自定义设置窗口
	private CustomFrame customFrame = new CustomFrame(this);
	// 自定义地图面板
	private CustomMapPanel customMapPanel = new CustomMapPanel(this);
	// 自定义地图的预览区面板
	private CustomMapInfoPanel customMapInfoPanel = new CustomMapInfoPanel(this);
	// 鼠标监听
	private MyMouse myMouse = new MyMouse(this);
	// 过关面板
	private PassLevelPanel passLevelPanel = new PassLevelPanel(this);
	// 过关窗口
	private PassLevelFrame passLevelFrame = new PassLevelFrame(this);
	// 道具包
	private PropBag propBag = new PropBag(400, 400, 1);
	// 道具包出现线程
	private PropBagAppearThread propBagAppearThread = new PropBagAppearThread(this);
	// 道具包判断被吃，且运作的线程
	private MyTankImpactPropThread myTankImpactPropThread = new MyTankImpactPropThread(this);
	// 敌人吃道具包
	private EnemyImpactPropThread enemyImpactPropThread = new EnemyImpactPropThread(this);
	// 我方子弹开火线程
	private MyTankFireThread myTankFireThread = new MyTankFireThread(this);
	// 判断输赢线程
	private LoseThread winOrLoseThread = new LoseThread(this);
	// 暂停
	private MyFocus myFocus = new MyFocus(this);
	// 游戏面板重绘线程
	private RepaintThread repaintThread = new RepaintThread(this);
	// 窗口监听
	private MyWindow myWindow = new MyWindow();

	public MyFrame() {

		this.setTitle("坦克大战v6.5    班级:JF1711      姓名:林士琦     学号:JF171124");
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		this.add(welPanel);
		this.setSize(740, 540);
		this.setLocationRelativeTo(null);
		// 用户输入姓名界面添加按钮监听
		nameFrame.getNamePanel().getYesBtn().addActionListener(myAction);
		nameFrame.getNamePanel().getNoBtn().addActionListener(myAction);
		// 初始化界面开始 结束游戏监听
		welPanel.getStartBtn().addActionListener(myAction);
		welPanel.getOverBtn().addActionListener(myAction);
		// 自定义添加按钮监听
		customPanel.getCustomSureButton().addActionListener(myAction);
		customPanel.getCustomCancelButton().addActionListener(myAction);
		// 操作说明面板返回监听
		introducedFrame.getIntroducePanel().getBackButton().addActionListener(myAction);
		// 游戏第一关的菜单栏添加监听
		playGameFrame.getBar().getStartItem().addActionListener(myAction);
		playGameFrame.getBar().getNewItem().addActionListener(myAction);
		playGameFrame.getBar().getCustomGameItem().addActionListener(myAction);
		playGameFrame.getBar().getCustomMapItem().addActionListener(myAction);
		playGameFrame.getBar().getQuitItem().addActionListener(myAction);
		playGameFrame.getBar().getIntroduceItem().addActionListener(myAction);
		playGameFrame.getBar().getAboutItem().addActionListener(myAction);
		// 自定义地图的按钮加监听
		customPanel.getNormalGameRaioButton().addActionListener(myAction);
		customPanel.getSelectGameRaioButton().addActionListener(myAction);
		customMapInfoPanel.getWallButton().addActionListener(myAction);
		customMapInfoPanel.getSteelButton().addActionListener(myAction);
		customMapInfoPanel.getGrassButton().addActionListener(myAction);
		customMapInfoPanel.getWaterButton().addActionListener(myAction);
		customMapInfoPanel.getDeleteButton().addActionListener(myAction);
		customMapInfoPanel.getSureButton().addActionListener(myAction);
		customMapInfoPanel.getCancelButton().addActionListener(myAction);
		// 游戏过关按钮加监听
		passLevelPanel.getPassLevelButton().addActionListener(myAction);
		passLevelPanel.getRestartButton().addActionListener(myAction);
		passLevelPanel.getReturnButton().addActionListener(myAction);
		passLevelPanel.getGameOverButton().addActionListener(myAction);
		// 第一关添加键盘监听
		playGamePanel.addKeyListener(myKey);
		// 子弹发射线程
		myBulletMoveThread.start();
		// 我方子弹碰撞
		myBulletHitThread.start();
		// 敌方转向
		enemyChangeDirectionThread.start();
		// 敌方开火
		enemyBulletFireThread.start();
		// 敌方子弹移动
		enemyBulletMoveThread.start();
		// 敌方子弹打墙
		enemyBulletHitThread.start();
		// 我方子弹打敌方
		myBulletHitEnemyThread.start();
		// 敌我子弹碰撞抵消
		bulletHitBulletThread.start();
		// 敌方子弹打到我方坦克
		enemyHitMyTankThread.start();

		// //道具包出现线程
		// propBagAppearThread.start();
		// 我方吃道具包
		myTankImpactPropThread.start();
		// 敌人吃道具包
		enemyImpactPropThread.start();

		// 游戏面板添加焦点监听
		playGamePanel.addFocusListener(myFocus);
		// 我方移动
		myTankMoveThread.start();
		// 我方子弹开火
		myTankFireThread.start();
		// 判断输赢线程启动
		winOrLoseThread.start();
		// 游戏面板重绘线程启动
		repaintThread.start();
		// 自定义地图时添加鼠标监听
		playGamePanel.addMouseListener(myMouse);

		// 所有窗口添加窗口监听
		this.addWindowListener(myWindow);
		customFrame.addWindowListener(myWindow);
		nameFrame.addWindowListener(myWindow);
		passLevelFrame.addWindowListener(myWindow);
		playGameFrame.addWindowListener(myWindow);
		introducedFrame.addWindowListener(myWindow);
		this.setVisible(true);

	}

	
	
	
// -----------------------------------
	public WelcomePanel getWelPanel() {
		return welPanel;
	}

	public void setWelPanel(WelcomePanel welPanel) {
		this.welPanel = welPanel;
	}

	public PlayGamePanel getPlayGamePanel() {
		return playGamePanel;
	}

	public void setPlayGamePanel(PlayGamePanel playGamePanel) {
		this.playGamePanel = playGamePanel;
	}

	public GameMap getGameMap() {
		return gameMap;
	}

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	public EnemyAppearThread getEnemyAppearThread() {
		return enemyAppearThread;
	}

	public void setEnemyAppearThread(EnemyAppearThread enemyAppearThread) {
		this.enemyAppearThread = enemyAppearThread;
	}

	public EnemyMoveThread getEnemyMoveThread() {
		return enemyMoveThread;
	}

	public void setEnemyMoveThread(EnemyMoveThread enemyMoveThread) {
		this.enemyMoveThread = enemyMoveThread;
	}

	public ArrayList<Enemy> getEnemyList() {
		return EnemyList;
	}

	public void setEnemyList(ArrayList<Enemy> enemyList) {
		EnemyList = enemyList;
	}

	public ArrayList<Bullet> getEnemyBulletList() {
		return enemyBulletList;
	}

	public void setEnemyBulletList(ArrayList<Bullet> enemyBulletList) {
		this.enemyBulletList = enemyBulletList;
	}

	public PlayGameFrame getPlayGameFrame() {
		return playGameFrame;
	}

	public void setPlayGameFrame(PlayGameFrame playGameFrame) {
		this.playGameFrame = playGameFrame;
	}

	public MyBulletHitThread getMyBulletHitThread() {
		return myBulletHitThread;
	}

	public void setMyBulletHitThread(MyBulletHitThread myBulletHitThread) {
		this.myBulletHitThread = myBulletHitThread;
	}

	public EnemyChangeDirectionThread getEnemyChangeDirectionThread() {
		return enemyChangeDirectionThread;
	}

	public void setEnemyChangeDirectionThread(EnemyChangeDirectionThread enemyChangeDirectionThread) {
		this.enemyChangeDirectionThread = enemyChangeDirectionThread;
	}

	public EnemyBulletFireThread getEnemyBulletFireThread() {
		return enemyBulletFireThread;
	}

	public void setEnemyBulletFireThread(EnemyBulletFireThread enemyBulletFireThread) {
		this.enemyBulletFireThread = enemyBulletFireThread;
	}

	public EnemyBulletMoveThread getEnemyBulletMoveThread() {
		return enemyBulletMoveThread;
	}

	public void setEnemyBulletMoveThread(EnemyBulletMoveThread enemyBulletMoveThread) {
		this.enemyBulletMoveThread = enemyBulletMoveThread;
	}

	public EnemyBulletHitThread getEnemyBulletHitThread() {
		return enemyBulletHitThread;
	}

	public void setEnemyBulletHitThread(EnemyBulletHitThread enemyBulletHitThread) {
		this.enemyBulletHitThread = enemyBulletHitThread;
	}

	public BulletHitBulletThread getBulletHitBulletThread() {
		return bulletHitBulletThread;
	}

	public void setBulletHitBulletThread(BulletHitBulletThread bulletHitBulletThread) {
		this.bulletHitBulletThread = bulletHitBulletThread;
	}

	public EnemyHitMyTankThread getEnemyHitMyTankThread() {
		return enemyHitMyTankThread;
	}

	public void setEnemyHitMyTankThread(EnemyHitMyTankThread enemyHitMyTankThread) {
		this.enemyHitMyTankThread = enemyHitMyTankThread;
	}

	public LoseThread getWinOrLoseThread() {
		return winOrLoseThread;
	}

	public void setWinOrLoseThread(LoseThread winOrLoseThread) {
		this.winOrLoseThread = winOrLoseThread;
	}

	public NextLevelThread getNextLevelThread() {
		return nextLevelThread;
	}

	public void setNextLevelThread(NextLevelThread nextLevelThread) {
		this.nextLevelThread = nextLevelThread;
	}

	public MyTankMoveThread getMyTankMoveThread() {
		return myTankMoveThread;
	}

	public void setMyTankMoveThread(MyTankMoveThread myTankMoveThread) {
		this.myTankMoveThread = myTankMoveThread;
	}

	public CustomPanel getCustomPanel() {
		return customPanel;
	}

	public void setCustomPanel(CustomPanel customPanel) {
		this.customPanel = customPanel;
	}

	public CustomFrame getCustomFrame() {
		return customFrame;
	}

	public void setCustomFrame(CustomFrame customFrame) {
		this.customFrame = customFrame;
	}

	public CustomMapPanel getCustomMapPanel() {
		return customMapPanel;
	}

	public void setCustomMapPanel(CustomMapPanel customMapPanel) {
		this.customMapPanel = customMapPanel;
	}

	public CustomMapInfoPanel getCustomMapInfoPanel() {
		return customMapInfoPanel;
	}

	public void setCustomMapInfoPanel(CustomMapInfoPanel customMapInfoPanel) {
		this.customMapInfoPanel = customMapInfoPanel;
	}

	public MyMouse getMyMouse() {
		return myMouse;
	}

	public void setMyMouse(MyMouse myMouse) {
		this.myMouse = myMouse;
	}

	public PropBag getPropBag() {
		return propBag;
	}

	public void setPropBag(PropBag propBag) {
		this.propBag = propBag;
	}

	public PropBagAppearThread getPropBagAppearThread() {
		return propBagAppearThread;
	}

	public void setPropBagAppearThread(PropBagAppearThread propBagAppearThread) {
		this.propBagAppearThread = propBagAppearThread;
	}

	public MyTankImpactPropThread getMyTankImpactPropThread() {
		return myTankImpactPropThread;
	}

	public void setMyTankImpactPropThread(MyTankImpactPropThread myTankImpactPropThread) {
		this.myTankImpactPropThread = myTankImpactPropThread;
	}

	public EnemyImpactPropThread getEnemyImpactPropThread() {
		return enemyImpactPropThread;
	}

	public void setEnemyImpactPropThread(EnemyImpactPropThread enemyImpactPropThread) {
		this.enemyImpactPropThread = enemyImpactPropThread;
	}

	public MyTankFireThread getMyTankFireThread() {
		return myTankFireThread;
	}

	public void setMyTankFireThread(MyTankFireThread myTankFireThread) {
		this.myTankFireThread = myTankFireThread;
	}

	public MyFocus getMyFocus() {
		return myFocus;
	}

	public void setMyFocus(MyFocus myFocus) {
		this.myFocus = myFocus;
	}

	public ArrayList<Bullet> getMyBulletList() {
		return myBulletList;
	}

	public void setMyBulletList(ArrayList<Bullet> myBulletList) {
		this.myBulletList = myBulletList;
	}

	public NameFrame getNameFrame() {
		return nameFrame;
	}

	public void setNameFrame(NameFrame nameFrame) {
		this.nameFrame = nameFrame;
	}

	public InfoPanel getLevelInfoPanel() {
		return levelInfoPanel;
	}

	public void setLevelInfoPanel(InfoPanel levelInfoPanel) {
		this.levelInfoPanel = levelInfoPanel;
	}

	public MyBulletMoveThread getMyBulletMoveThread() {
		return myBulletMoveThread;
	}

	public void setMyBulletMoveThread(MyBulletMoveThread myBulletMoveThread) {
		this.myBulletMoveThread = myBulletMoveThread;
	}

	public MyAction getMyAction() {
		return myAction;
	}

	public void setMyAction(MyAction myAction) {
		this.myAction = myAction;
	}

	public MyKey getMyKey() {
		return myKey;
	}

	public void setMyKey(MyKey myKey) {
		this.myKey = myKey;
	}

	public MyTank getMyTank() {
		return myTank;
	}

	public void setMyTank(MyTank myTank) {
		this.myTank = myTank;
	}

	public PassLevelFrame getPassLevelFrame() {
		return passLevelFrame;
	}

	public void setPassLevelFrame(PassLevelFrame passLevelFrame) {
		this.passLevelFrame = passLevelFrame;
	}

	public PassLevelPanel getPassLevelPanel() {
		return passLevelPanel;
	}

	public void setPassLevelPanel(PassLevelPanel passLevelPanel) {
		this.passLevelPanel = passLevelPanel;
	}

	public RepaintThread getRepaintThread() {
		return repaintThread;
	}

	public void setRepaintThread(RepaintThread repaintThread) {
		this.repaintThread = repaintThread;
	}

	public MyWindow getMyWindow() {
		return myWindow;
	}

	public void setMyWindow(MyWindow myWindow) {
		this.myWindow = myWindow;
	}

	public MyTank getSecondTank() {
		return secondTank;
	}

	public void setSecondTank(MyTank secondTank) {
		this.secondTank = secondTank;
	}

	public MyBulletHitEnemyThread getMyBulletHitEnemyThread() {
		return myBulletHitEnemyThread;
	}

	public void setMyBulletHitEnemyThread(MyBulletHitEnemyThread myBulletHitEnemyThread) {
		this.myBulletHitEnemyThread = myBulletHitEnemyThread;
	}

	public IntroducedFrame getIntroducedFrame() {
		return introducedFrame;
	}

	public void setIntroducedFrame(IntroducedFrame introducedFrame) {
		this.introducedFrame = introducedFrame;
	}

}
