package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.caTruc.GD_QuanLyCaTruc;

public class QuanLyCaTrucController implements ActionListener, MouseListener{

	private GD_QuanLyCaTruc giaoDienQuanLyCaTruc;
	
	public QuanLyCaTrucController(GD_QuanLyCaTruc giaoDienQuanLyCaTruc) {
		this.giaoDienQuanLyCaTruc = giaoDienQuanLyCaTruc;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(giaoDienQuanLyCaTruc.btnLamMoi)) {
			giaoDienQuanLyCaTruc.chonLamMoi();
		} else if(o.equals(giaoDienQuanLyCaTruc.btnThem)) {
			giaoDienQuanLyCaTruc.chonThem();
		} else if(o.equals(giaoDienQuanLyCaTruc.btnXoa)) {
			giaoDienQuanLyCaTruc.chonXoa();
		} else if(o.equals(giaoDienQuanLyCaTruc.btnChinhSua)) {
			giaoDienQuanLyCaTruc.chonChinhSua();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		giaoDienQuanLyCaTruc.hienThiThongTin();
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
}
