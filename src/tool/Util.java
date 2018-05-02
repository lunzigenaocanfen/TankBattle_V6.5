package tool;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Util {
	// ��ӭ�����С
	public static final int welcomeWidth = 800;
	public static final int welcomeHeight = 600;

	// ��Ϸ�����С
	public static final int gameWidth = 600;
	public static final int gameHeight = 600;

	// �ұ���Ϣ�����С
	public static final int tipWidth = 200;
	public static final int tipHeight = 600;

	// �Զ�����Ϸ
	// ��Ϸ�ؿ�
	public static int gameLevel = 1;
	// �����ٶȱ���
	public static int enemyTankSpeed = 1;
	// �����ӵ��ٶȱ���
	public static int enemyBulletSpeed = 1;
	// �з��ӵ�������
	public static int enemyBulletPower = 1;
	// ��������
	public static int enemyNumber = 20;
	// �ϰ�������
	public static int mapStyl = 0;

	// �����Ƿ���
	public static boolean lose = false; // Ĭ��Ϊfalse
	// ��ͣ��Ϸ
	public static boolean pause = true; // Ĭ��Ϊtrue
	// �жϵ�˫����Ϸ
	public static int twoPlay = 1;

	// ̹�˴�С
	public static final int tankSize = 40;
	// �ӵ���С
	public static final int bulletSize = 14;
	// �ϰ����С
	public static final int wallSize = 40;

	// �ҷ��ӵ���С
	public static final int myBulletSize = 14;
	// �ҷ��ӵ��Ƿ����
	public static boolean fire = false;
	// �û����ӵ��Ƿ����
	public static boolean secondFire = false;
	// easy�����ƶ�����
	public static final int easyStept = 8;
	// normal�����ƶ�����
	public static final int normalStept = 10;
	// hard�����ƶ�����
	public static final int hardStept = 5;

	// �ʼ��ӭ����ͼƬ
	public static final Image IMG_WELCOME = new ImageIcon("image/WelcomeImage.png").getImage();
	// ��Ϸ�淨����
	public static final Image IMG_INTRODUCE = new ImageIcon("image/Introduce.png").getImage();
	// ��ӭ�û�ͼƬ
	public static final Image IMG_WELCOMEUSER = new ImageIcon("image/WelcomeUser.png").getImage();
	// �ܿ�����
	public static final Image IMG_BACKGROUND = new ImageIcon("image/GameBackground.png").getImage();
	// �ұ߽�����ϢͼƬ
	public static final Image IMG_INFO = new ImageIcon("image/Tip.png").getImage();
	// �Զ����ͼʱ�ұ���屳��
	public static final Image IMG_CUSTOMINFO = new ImageIcon("image/CustomInfoPanel.png").getImage();
	// ��Ϸ����ͼƬ
	public static final Image IMG_PASSLEVEL = new ImageIcon("image/PassLevel.png").getImage();
	// ���߰�
	// Ѫ��
	public static final Image IMG_BLOODBAG = new ImageIcon("image/BloodBag.png").getImage();
	// ���ڰ�
	public static final Image IMG_STEELBAG = new ImageIcon("image/SteelBag.png").getImage();
	// ըҩ��
	public static final Image IMG_EXPLOSIVEBAG = new ImageIcon("image/ExplosiveBag.png").getImage();
	// �޵а�
	public static final Image IMG_BUFFBAG = new ImageIcon("image/BuffBag.png").getImage();
	// �Ƿ�Ե��޵а�
	public static boolean impactBuffBag = false;

	// �ҷ��ӵ�
	public static final Image IMG_MYBULLET = new ImageIcon("image/MyBullet.png").getImage();

	// �ҷ�̹�˳���
	// ��
	public static final Image IMG_MYTANKU = new ImageIcon("image/MyTankU.png").getImage();
	public static final Image IMG_MYTANKD = new ImageIcon("image/MyTankD.png").getImage();
	public static final Image IMG_MYTANKL = new ImageIcon("image/MyTankL.png").getImage();
	public static final Image IMG_MYTANKR = new ImageIcon("image/MyTankR.png").getImage();
	// �û���̹��
	public static final Image IMG_SECONDTANKU = new ImageIcon("image/SecondTankUp.png").getImage();
	public static final Image IMG_SECONDTANKD = new ImageIcon("image/SecondTankDown.png").getImage();
	public static final Image IMG_SECONDTANKL = new ImageIcon("image/SecondTankLeft.png").getImage();
	public static final Image IMG_SECONDTANKR = new ImageIcon("image/SecondTankRight.png").getImage();

	// ���ϰ���
	// שǽ
	public static final Image IMG_WALL = new ImageIcon("image/Wall.png").getImage();
	// ��ǽ
	public static final Image IMG_STEEL = new ImageIcon("image/Steel.png").getImage();
	// �ݵ�
	public static final Image IMG_GRASSES = new ImageIcon("image/Grasses.png").getImage();
	// ��
	public static final Image IMG_WATER = new ImageIcon("image/Water.png").getImage();
	// ��
	public static final Image IMG_HOME = new ImageIcon("image/Home.png").getImage();

	// �з��ӵ�
	public static final Image IMG_ENEMYBULLET = new ImageIcon("image/EnemyBullet.png").getImage();
	// �з�̹��1
	public static final Image IMG_ENEMYEASYU = new ImageIcon("image/Enemy1U.png").getImage();
	public static final Image IMG_ENEMYEASYD = new ImageIcon("image/Enemy1D.png").getImage();
	public static final Image IMG_ENEMYEASYL = new ImageIcon("image/Enemy1L.png").getImage();
	public static final Image IMG_ENEMYEASYR = new ImageIcon("image/Enemy1R.png").getImage();
	// �з�̹��2
	public static final Image IMG_ENEMYNORMALU = new ImageIcon("image/Enemy2U.png").getImage();
	public static final Image IMG_ENEMYNORMALD = new ImageIcon("image/Enemy2D.png").getImage();
	public static final Image IMG_ENEMYNORMALL = new ImageIcon("image/Enemy2L.png").getImage();
	public static final Image IMG_ENEMYNORMALR = new ImageIcon("image/Enemy2R.png").getImage();
	// �з�̹��3
	public static final Image IMG_ENEMYHARDU = new ImageIcon("image/Enemy3U.png").getImage();
	public static final Image IMG_ENEMYHARDD = new ImageIcon("image/Enemy3D.png").getImage();
	public static final Image IMG_ENEMYHARDL = new ImageIcon("image/Enemy3L.png").getImage();
	public static final Image IMG_ENEMYHARDR = new ImageIcon("image/Enemy3R.png").getImage();

}
