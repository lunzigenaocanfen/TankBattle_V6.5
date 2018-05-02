package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import model.User;

public class PlayGameFrame extends JFrame {
	// ��Ϸ���еĴ���

	private MyBar bar = new MyBar();// ��Ӳ˵���
	private User u = new User();//��ȡ�û�����
	private int level = 0;//��ǰ�ؿ�

	MyFrame myFrame;

	public PlayGameFrame(MyFrame myFrame) {
		super();
		this.myFrame = myFrame;
		this.setTitle("̹�˴�սv6.5    �༶:JF1711      ����:��ʿ��     ѧ��:JF171124");
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
