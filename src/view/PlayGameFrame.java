package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import model.User;

public class PlayGameFrame extends JFrame {
	// 游戏进行的窗口

	private MyBar bar = new MyBar();// 添加菜单栏
	private User u = new User();//获取用户姓名
	private int level = 0;//当前关卡

	MyFrame myFrame;

	public PlayGameFrame(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
		this.setTitle("坦克大战v6.5    班级:JF1711      姓名:林士琦     学号:JF171124");
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setJMenuBar(bar);
		this.add(myFrame.getPlayGamePanel(), BorderLayout.WEST);
		this.add(myFrame.getLevelInfoPanel(), BorderLayout.EAST);
		this.pack();
		this.setLocationRelativeTo(null);

	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public MyBar getBar() {
		return bar;
	}

	public void setBar(MyBar bar) {
		this.bar = bar;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
