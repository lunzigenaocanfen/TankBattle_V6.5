package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class MyWindow extends WindowAdapter {
	//���رյ�����ʾ
	@Override
	public void windowClosing(WindowEvent e) {

		super.windowClosing(e);
		
		int res = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�ر���", "��ܰ��ʾ", JOptionPane.OK_CANCEL_OPTION);
		if(res == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
		
	}
}
