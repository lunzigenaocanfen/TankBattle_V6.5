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
	// ��������
	// �ʼ��ӭ�û����
	private WelcomePanel welPanel = new WelcomePanel();
	// �¼�����
	private MyAction myAction = new MyAction(this);
	// ���̼���
	private MyKey myKey = new MyKey(this);
	// �ҷ�̹��
	private MyTank myTank = new MyTank(200, 560, 1);// �û�1
	private MyTank secondTank = new MyTank(360, 560, 2);// �û�2
	// ��Ϸ���
	private PlayGamePanel playGamePanel = new PlayGamePanel(this);
	// ������ͼ����
	private GameMap gameMap = new GameMap(15, 15);
	// ���˳����߳�
	private EnemyAppearThread enemyAppearThread = new EnemyAppearThread(this);
	// �����ƶ��߳�
	private EnemyMoveThread enemyMoveThread = new EnemyMoveThread(this);
	// �����ӵ�����
	private ArrayList<Bullet> myBulletList = new ArrayList<Bullet>();
	private ArrayList<Enemy> EnemyList = new ArrayList<Enemy>();
	private ArrayList<Bullet> enemyBulletList = new ArrayList<Bullet>();
	// ��ϷԤ�������
	private InfoPanel levelInfoPanel = new InfoPanel(this);
	// ������������
	private NameFrame nameFrame = new NameFrame();
	//��Ϸ����
	private IntroducedFrame introducedFrame = new IntroducedFrame();
	// ��Ϸ����
	private PlayGameFrame playGameFrame = new PlayGameFrame(this);
	// �ҷ��ӵ������ͼ�߳�
	private MyBulletHitThread myBulletHitThread = new MyBulletHitThread(this);
	// �ҷ��ӵ��ƶ��߳�
	private MyBulletMoveThread myBulletMoveThread = new MyBulletMoveThread(this);
	// ����ת���߳�
	private EnemyChangeDirectionThread enemyChangeDirectionThread = new EnemyChangeDirectionThread(this);
	// ���˿����߳�
	private EnemyBulletFireThread enemyBulletFireThread = new EnemyBulletFireThread(this);
	// �����ӵ��ƶ��߳�
	private EnemyBulletMoveThread enemyBulletMoveThread = new EnemyBulletMoveThread(this);
	// �����ӵ������ͼ�߳�
	private EnemyBulletHitThread enemyBulletHitThread = new EnemyBulletHitThread(this);
	// �ҷ��ӵ�������߳�
	private MyBulletHitEnemyThread myBulletHitEnemyThread = new MyBulletHitEnemyThread(this);
	// �����ӵ����������߳�
	private BulletHitBulletThread bulletHitBulletThread = new BulletHitBulletThread(this);
	// �����ӵ����ҷ�̹���߳�
	private EnemyHitMyTankThread enemyHitMyTankThread = new EnemyHitMyTankThread(this);
	// �ж���һ���߳�
	private NextLevelThread nextLevelThread = new NextLevelThread(this);
	// �ҷ�̹���ƶ��߳�
	private MyTankMoveThread myTankMoveThread = new MyTankMoveThread(this);
	// �Զ����������
	private CustomPanel customPanel = new CustomPanel(this);
	// �Զ������ô���
	private CustomFrame customFrame = new CustomFrame(this);
	// �Զ����ͼ���
	private CustomMapPanel customMapPanel = new CustomMapPanel(this);
	// �Զ����ͼ��Ԥ�������
	private CustomMapInfoPanel customMapInfoPanel = new CustomMapInfoPanel(this);
	// ������
	private MyMouse myMouse = new MyMouse(this);
	// �������
	private PassLevelPanel passLevelPanel = new PassLevelPanel(this);
	// ���ش���
	private PassLevelFrame passLevelFrame = new PassLevelFrame(this);
	// ���߰�
	private PropBag propBag = new PropBag(400, 400, 1);
	// ���߰������߳�
	private PropBagAppearThread propBagAppearThread = new PropBagAppearThread(this);
	// ���߰��жϱ��ԣ����������߳�
	private MyTankImpactPropThread myTankImpactPropThread = new MyTankImpactPropThread(this);
	// ���˳Ե��߰�
	private EnemyImpactPropThread enemyImpactPropThread = new EnemyImpactPropThread(this);
	// �ҷ��ӵ������߳�
	private MyTankFireThread myTankFireThread = new MyTankFireThread(this);
	// �ж���Ӯ�߳�
	private LoseThread winOrLoseThread = new LoseThread(this);
	// ��ͣ
	private MyFocus myFocus = new MyFocus(this);
	// ��Ϸ����ػ��߳�
	private RepaintThread repaintThread = new RepaintThread(this);
	// ���ڼ���
	private MyWindow myWindow = new MyWindow();

	public MyFrame() {

		this.setTitle("̹�˴�սv6.5    �༶:JF1711      ����:��ʿ��     ѧ��:JF171124");
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		this.add(welPanel);
		this.setSize(740, 540);
		this.setLocationRelativeTo(null);
		// �û���������������Ӱ�ť����
		nameFrame.getNamePanel().getYesBtn().addActionListener(myAction);
		nameFrame.getNamePanel().getNoBtn().addActionListener(myAction);
		// ��ʼ�����濪ʼ ������Ϸ����
		welPanel.getStartBtn().addActionListener(myAction);
		welPanel.getOverBtn().addActionListener(myAction);
		// �Զ�����Ӱ�ť����
		customPanel.getCustomSureButton().addActionListener(myAction);
		customPanel.getCustomCancelButton().addActionListener(myAction);
		// ����˵����巵�ؼ���
		introducedFrame.getIntroducePanel().getBackButton().addActionListener(myAction);
		// ��Ϸ��һ�صĲ˵�����Ӽ���
		playGameFrame.getBar().getStartItem().addActionListener(myAction);
		playGameFrame.getBar().getNewItem().addActionListener(myAction);
		playGameFrame.getBar().getCustomGameItem().addActionListener(myAction);
		playGameFrame.getBar().getCustomMapItem().addActionListener(myAction);
		playGameFrame.getBar().getQuitItem().addActionListener(myAction);
		playGameFrame.getBar().getIntroduceItem().addActionListener(myAction);
		playGameFrame.getBar().getAboutItem().addActionListener(myAction);
		// �Զ����ͼ�İ�ť�Ӽ���
		customPanel.getNormalGameRaioButton().addActionListener(myAction);
		customPanel.getSelectGameRaioButton().addActionListener(myAction);
		customMapInfoPanel.getWallButton().addActionListener(myAction);
		customMapInfoPanel.getSteelButton().addActionListener(myAction);
		customMapInfoPanel.getGrassButton().addActionListener(myAction);
		customMapInfoPanel.getWaterButton().addActionListener(myAction);
		customMapInfoPanel.getDeleteButton().addActionListener(myAction);
		customMapInfoPanel.getSureButton().addActionListener(myAction);
		customMapInfoPanel.getCancelButton().addActionListener(myAction);
		// ��Ϸ���ذ�ť�Ӽ���
		passLevelPanel.getPassLevelButton().addActionListener(myAction);
		passLevelPanel.getRestartButton().addActionListener(myAction);
		passLevelPanel.getReturnButton().addActionListener(myAction);
		passLevelPanel.getGameOverButton().addActionListener(myAction);
		// ��һ����Ӽ��̼���
		playGamePanel.addKeyListener(myKey);
		// �ӵ������߳�
		myBulletMoveThread.start();
		// �ҷ��ӵ���ײ
		myBulletHitThread.start();
		// �з�ת��
		enemyChangeDirectionThread.start();
		// �з�����
		enemyBulletFireThread.start();
		// �з��ӵ��ƶ�
		enemyBulletMoveThread.start();
		// �з��ӵ���ǽ
		enemyBulletHitThread.start();
		// �ҷ��ӵ���з�
		myBulletHitEnemyThread.start();
		// �����ӵ���ײ����
		bulletHitBulletThread.start();
		// �з��ӵ����ҷ�̹��
		enemyHitMyTankThread.start();

		// //���߰������߳�
		// propBagAppearThread.start();
		// �ҷ��Ե��߰�
		myTankImpactPropThread.start();
		// ���˳Ե��߰�
		enemyImpactPropThread.start();

		// ��Ϸ�����ӽ������
		playGamePanel.addFocusListener(myFocus);
		// �ҷ��ƶ�
		myTankMoveThread.start();
		// �ҷ��ӵ�����
		myTankFireThread.start();
		// �ж���Ӯ�߳�����
		winOrLoseThread.start();
		// ��Ϸ����ػ��߳�����
		repaintThread.start();
		// �Զ����ͼʱ���������
		playGamePanel.addMouseListener(myMouse);

		// ���д�����Ӵ��ڼ���
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
