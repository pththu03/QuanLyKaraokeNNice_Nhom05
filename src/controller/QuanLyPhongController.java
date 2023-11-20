package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.phong.GD_QuanLyPhong;

public class QuanLyPhongController implements ActionListener, MouseListener {

	private GD_QuanLyPhong giaoDienQuanLyPhong;

	public QuanLyPhongController(GD_QuanLyPhong giaoDienQuanLyPhong) {
		this.giaoDienQuanLyPhong = giaoDienQuanLyPhong;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienQuanLyPhong.hienThiThongTin();
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
		if (o.equals(giaoDienQuanLyPhong.btnLamMoi)) {
			giaoDienQuanLyPhong.chonLamMoi();
		} else if (o.equals(giaoDienQuanLyPhong.btnTimKiem)) {
			giaoDienQuanLyPhong.chonTimKiem();
		} else if (o.equals(giaoDienQuanLyPhong.btnThem)) {
			giaoDienQuanLyPhong.chonThemPhong();
		} else if (o.equals(giaoDienQuanLyPhong.btnXoaPhong)) {
			giaoDienQuanLyPhong.chonXoaPhong();
		} else if (o.equals(giaoDienQuanLyPhong.btnChinhSuaPhong)) {
			giaoDienQuanLyPhong.chonChinhSuaPhong();
		} else if (o.equals(giaoDienQuanLyPhong.btnThemLoaiPhong)) {
			giaoDienQuanLyPhong.chonThemLoaiPhong();
		} else if (o.equals(giaoDienQuanLyPhong.btnXoaLoaiPhong)) {
			giaoDienQuanLyPhong.chonXoaLoaiPhong();
		} else if (o.equals(giaoDienQuanLyPhong.btnSuaLoaiPhong)) {
			giaoDienQuanLyPhong.chonChinhSuaLoaiPhong();
		}
	}

}
