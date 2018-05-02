package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class MyWindow extends WindowAdapter {
	//当关闭弹出提示
	@Override
	public void windowClosing(WindowEvent e) {

		super.windowClosing(e);
		
		int res = JOptionPane.showConfirmDialog(null, "确定要关闭吗", "温馨提示", JOptionPane.OK_CANCEL_OPTION);
		if(res == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
		
	}
}
