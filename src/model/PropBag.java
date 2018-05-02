package model;

import java.awt.Graphics;

import tool.Util;

public class PropBag {

	private int bagX;//����
	private int bagY;
	private int bagStyle;//����

	public PropBag(int bagX, int bagY, int bagStyle) {
		this.bagX = bagX;
		this.bagY = bagY;
		this.bagStyle = bagStyle;

	}

	public void drawPropBag(Graphics g) {

		switch (bagStyle) {
		case 1:// Ѫ��
			g.drawImage(Util.IMG_BLOODBAG, bagX, bagY, bagX + Util.wallSize, bagY + Util.wallSize, 0, 0,
					Util.IMG_BLOODBAG.getWidth(null), Util.IMG_BLOODBAG.getHeight(null), null);

			break;
		case 2:// ���ڰ�
			g.drawImage(Util.IMG_STEELBAG, bagX, bagY, bagX + Util.wallSize, bagY + Util.wallSize, 0, 0,
					Util.IMG_STEELBAG.getWidth(null), Util.IMG_STEELBAG.getHeight(null), null);
			break;
		case 3:// ըҩ��
			g.drawImage(Util.IMG_EXPLOSIVEBAG, bagX, bagY, bagX + Util.wallSize, bagY + Util.wallSize, 0, 0,
					Util.IMG_EXPLOSIVEBAG.getWidth(null), Util.IMG_EXPLOSIVEBAG.getHeight(null), null);
			break;
		case 4://�޵а�
			g.drawImage(Util.IMG_BUFFBAG, bagX, bagY, bagX + Util.wallSize, bagY + Util.wallSize, 0, 0,
					Util.IMG_BUFFBAG.getWidth(null), Util.IMG_BUFFBAG.getHeight(null), null);
			break;
		default:
			break;
		}

	}

	// ----------------------------------
	public int getBagX() {
		return bagX;
	}

	public void setBagX(int bagX) {
		this.bagX = bagX;
	}

	public int getBagY() {
		return bagY;
	}

	public void setBagY(int bagY) {
		this.bagY = bagY;
	}

	public int getBagStyle() {
		return bagStyle;
	}

	public void setBagStyle(int bagStyle) {
		this.bagStyle = bagStyle;
	}

}
