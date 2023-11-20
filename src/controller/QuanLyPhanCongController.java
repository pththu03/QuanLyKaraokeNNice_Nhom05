package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.phanCongVaChamCong.GD_QuanLyPhanCong;

public class QuanLyPhanCongController implements ActionListener, MouseListener {

	private GD_QuanLyPhanCong giaoDienPhanCong;

	public QuanLyPhanCongController(GD_QuanLyPhanCong giaoDienPhanCong) {
		this.giaoDienPhanCong = giaoDienPhanCong;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienPhanCong.hienThiThongTin();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienPhanCong.btnLamMoi)) {
			giaoDienPhanCong.chonLamMoi();
		} else if (o.equals(giaoDienPhanCong.btnThem)) {
			giaoDienPhanCong.chonThem();
		} else if (o.equals(giaoDienPhanCong.btnXoa)) {
			giaoDienPhanCong.chonXoa();
		} else if (o.equals(giaoDienPhanCong.btnChinhSua)) {
			giaoDienPhanCong.chonChinhSua();
		}
	}

}
