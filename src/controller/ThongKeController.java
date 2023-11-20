package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.thongKe.GD_ThongKe;

public class ThongKeController implements ActionListener, MouseListener {

	private GD_ThongKe giaoDienThongKe;

	public ThongKeController(GD_ThongKe giaoDienThongKe) {
		this.giaoDienThongKe = giaoDienThongKe;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(giaoDienThongKe.tblHoaDon)) {
			giaoDienThongKe.hienThiThongTinDoanhThu();
		} else if (o.equals(giaoDienThongKe.tblNhanVien)) {
			giaoDienThongKe.hienThiThongTinLuongNhanVien();
		} else if (o.equals(giaoDienThongKe.tblKhachHang)) {
			giaoDienThongKe.hienThiThongTinKhachHang();
		}

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
		if (o.equals(giaoDienThongKe.btnTimKiemDoanhThuNgay)) {
			giaoDienThongKe.chonTimKiemDoanhThuNgay();
		} else if (o.equals(giaoDienThongKe.btnTimKiemDoanhThuThang)) {
			giaoDienThongKe.chonTimKiemDoanhThuThang();
		} else if (o.equals(giaoDienThongKe.btnTimKiemDoanhThuNam)) {
			giaoDienThongKe.chonTimKiemDoanhThuNam();
		} else if (o.equals(giaoDienThongKe.btnTimKiemLuong)) {
			giaoDienThongKe.chonTimKiemLuong();
		} else if (o.equals(giaoDienThongKe.btnTimKiemKhachHang)) {
			giaoDienThongKe.chonTimKiemKhachHang();
		} else if (o.equals(giaoDienThongKe.btnXemChiTietHoaDonDoanhThu)) {
			giaoDienThongKe.chonXemChiTietDoanhThu();
		} else if (o.equals(giaoDienThongKe.btnXemChiTietChamCong)) {
			giaoDienThongKe.chonXemChiTietChamCong();
		} else if (o.equals(giaoDienThongKe.btnXemChiTietHoaDonKhachHang)) {
			giaoDienThongKe.chonXemChiTietKhachHang();
		} else if (o.equals(giaoDienThongKe.radTheoNgay)) {
			giaoDienThongKe.chonTheoNgay();
		} else if (o.equals(giaoDienThongKe.radTheoThang)) {
			giaoDienThongKe.chonTheoThang();
		} else if (o.equals(giaoDienThongKe.radTheoNam)) {
			giaoDienThongKe.chonTheoNam();
		}
	}

}
