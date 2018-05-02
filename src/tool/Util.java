package tool;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Util {
	// 欢迎界面大小
	public static final int welcomeWidth = 800;
	public static final int welcomeHeight = 600;

	// 游戏界面大小
	public static final int gameWidth = 600;
	public static final int gameHeight = 600;

	// 右边信息界面大小
	public static final int tipWidth = 200;
	public static final int tipHeight = 600;

	// 自定义游戏
	// 游戏关卡
	public static int gameLevel = 1;
	// 敌人速度倍数
	public static int enemyTankSpeed = 1;
	// 敌人子弹速度倍数
	public static int enemyBulletSpeed = 1;
	// 敌方子弹攻击力
	public static int enemyBulletPower = 1;
	// 敌人数量
	public static int enemyNumber = 20;
	// 障碍物类型
	public static int mapStyl = 0;

	// 设置是否输
	public static boolean lose = false; // 默认为false
	// 暂停游戏
	public static boolean pause = true; // 默认为true
	// 判断单双人游戏
	public static int twoPlay = 1;

	// 坦克大小
	public static final int tankSize = 40;
	// 子弹大小
	public static final int bulletSize = 14;
	// 障碍物大小
	public static final int wallSize = 40;

	// 我方子弹大小
	public static final int myBulletSize = 14;
	// 我方子弹是否射击
	public static boolean fire = false;
	// 用户二子弹是否射击
	public static boolean secondFire = false;
	// easy敌人移动步伐
	public static final int easyStept = 8;
	// normal敌人移动步伐
	public static final int normalStept = 10;
	// hard敌人移动步伐
	public static final int hardStept = 5;

	// 最开始欢迎界面图片
	public static final Image IMG_WELCOME = new ImageIcon("image/WelcomeImage.png").getImage();
	// 游戏玩法介绍
	public static final Image IMG_INTRODUCE = new ImageIcon("image/Introduce.png").getImage();
	// 欢迎用户图片
	public static final Image IMG_WELCOMEUSER = new ImageIcon("image/WelcomeUser.png").getImage();
	// 管卡背景
	public static final Image IMG_BACKGROUND = new ImageIcon("image/GameBackground.png").getImage();
	// 右边界面信息图片
	public static final Image IMG_INFO = new ImageIcon("image/Tip.png").getImage();
	// 自定义地图时右边面板背景
	public static final Image IMG_CUSTOMINFO = new ImageIcon("image/CustomInfoPanel.png").getImage();
	// 游戏过关图片
	public static final Image IMG_PASSLEVEL = new ImageIcon("image/PassLevel.png").getImage();
	// 道具包
	// 血包
	public static final Image IMG_BLOODBAG = new ImageIcon("image/BloodBag.png").getImage();
	// 铁壁包
	public static final Image IMG_STEELBAG = new ImageIcon("image/SteelBag.png").getImage();
	// 炸药包
	public static final Image IMG_EXPLOSIVEBAG = new ImageIcon("image/ExplosiveBag.png").getImage();
	// 无敌包
	public static final Image IMG_BUFFBAG = new ImageIcon("image/BuffBag.png").getImage();
	// 是否吃到无敌包
	public static boolean impactBuffBag = false;

	// 我方子弹
	public static final Image IMG_MYBULLET = new ImageIcon("image/MyBullet.png").getImage();

	// 我方坦克朝向
	// 上
	public static final Image IMG_MYTANKU = new ImageIcon("image/MyTankU.png").getImage();
	public static final Image IMG_MYTANKD = new ImageIcon("image/MyTankD.png").getImage();
	public static final Image IMG_MYTANKL = new ImageIcon("image/MyTankL.png").getImage();
	public static final Image IMG_MYTANKR = new ImageIcon("image/MyTankR.png").getImage();
	// 用户二坦克
	public static final Image IMG_SECONDTANKU = new ImageIcon("image/SecondTankUp.png").getImage();
	public static final Image IMG_SECONDTANKD = new ImageIcon("image/SecondTankDown.png").getImage();
	public static final Image IMG_SECONDTANKL = new ImageIcon("image/SecondTankLeft.png").getImage();
	public static final Image IMG_SECONDTANKR = new ImageIcon("image/SecondTankRight.png").getImage();

	// 画障碍物
	// 砖墙
	public static final Image IMG_WALL = new ImageIcon("image/Wall.png").getImage();
	// 铁墙
	public static final Image IMG_STEEL = new ImageIcon("image/Steel.png").getImage();
	// 草地
	public static final Image IMG_GRASSES = new ImageIcon("image/Grasses.png").getImage();
	// 河
	public static final Image IMG_WATER = new ImageIcon("image/Water.png").getImage();
	// 家
	public static final Image IMG_HOME = new ImageIcon("image/Home.png").getImage();

	// 敌方子弹
	public static final Image IMG_ENEMYBULLET = new ImageIcon("image/EnemyBullet.png").getImage();
	// 敌方坦克1
	public static final Image IMG_ENEMYEASYU = new ImageIcon("image/Enemy1U.png").getImage();
	public static final Image IMG_ENEMYEASYD = new ImageIcon("image/Enemy1D.png").getImage();
	public static final Image IMG_ENEMYEASYL = new ImageIcon("image/Enemy1L.png").getImage();
	public static final Image IMG_ENEMYEASYR = new ImageIcon("image/Enemy1R.png").getImage();
	// 敌方坦克2
	public static final Image IMG_ENEMYNORMALU = new ImageIcon("image/Enemy2U.png").getImage();
	public static final Image IMG_ENEMYNORMALD = new ImageIcon("image/Enemy2D.png").getImage();
	public static final Image IMG_ENEMYNORMALL = new ImageIcon("image/Enemy2L.png").getImage();
	public static final Image IMG_ENEMYNORMALR = new ImageIcon("image/Enemy2R.png").getImage();
	// 敌方坦克3
	public static final Image IMG_ENEMYHARDU = new ImageIcon("image/Enemy3U.png").getImage();
	public static final Image IMG_ENEMYHARDD = new ImageIcon("image/Enemy3D.png").getImage();
	public static final Image IMG_ENEMYHARDL = new ImageIcon("image/Enemy3L.png").getImage();
	public static final Image IMG_ENEMYHARDR = new ImageIcon("image/Enemy3R.png").getImage();

}
