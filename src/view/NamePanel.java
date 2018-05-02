package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NamePanel extends JPanel {

	// 提示用户输入姓名面板
	private JButton yesBtn = new JButton("确定");
	private JButton noBtn = new JButton("取消");
	private JLabel lab = new JLabel("请输入昵称：");
	private JTextField nameJtf = new JTextField(10);

	public NamePanel() {

		this.setPreferredSize(new Dimension(250, 80));
		this.add(lab);
		this.add(nameJtf);
		this.add(yesBtn);
		this.add(noBtn);

		yesBtn.setActionCommand("YES");
		noBtn.setActionCommand("NO");

	}
//------------------------------------------------
	public JButton getYesBtn() {
		return yesBtn;
	}

	public void setYesBtn(JButton yesBtn) {
		this.yesBtn = yesBtn;
	}

	public JButton getNoBtn() {
		return noBtn;
	}

	public void setNoBtn(JButton noBtn) {
		this.noBtn = noBtn;
	}

	public JLabel getLab() {
		return lab;
	}

	public void setLab(JLabel lab) {
		this.lab = lab;
	}

	public JTextField getNameJtf() {
		return nameJtf;
	}

	public void setNameJtf(JTextField nameJtf) {
		this.nameJtf = nameJtf;
	}

}
