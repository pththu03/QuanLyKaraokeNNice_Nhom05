package gui.phanCongVaChamCong;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ChamCongDAO;
import dao.ThongKeDAO;
import entities.CaTrucEntity;
import entities.NhanVienEntity;
import entities.PhieuChamCongEntity;
import entities.PhieuPhanCongEntity;
import util.DateFormatter;
import util.TimeFormatter;

import javax.swing.JTable;

public class GD_XemChiTietChamCong extends JDialog implements ActionListener {

	private final JPanel pnlChinh = new JPanel();
	private JTable tblChamCong;
	private DefaultTableModel tblmodelChamCong;
	private JButton btnThoat;
	private NhanVienEntity nhanVienEntity;
	private LocalDate ngay;
	private List<PhieuPhanCongEntity> listPhieuPhanCong;
	private ThongKeDAO thongKeDAO = new ThongKeDAO();
	private ChamCongDAO chamCongDAO = new ChamCongDAO();

	/**
	 * Create the dialog.
	 */
	public GD_XemChiTietChamCong(NhanVienEntity nhanVienEntity, LocalDate ngay) {
		this.nhanVienEntity = nhanVienEntity;
		this.ngay = ngay;
		setTitle("Xem chi tiết chấm công nhân viên " + nhanVienEntity.getHoTen());
		setBounds(100, 100, 547, 409);
		getContentPane().setLayout(new BorderLayout());
		pnlChinh.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlChinh, BorderLayout.CENTER);
		pnlChinh.setLayout(null);

		String[] cols = { "STT", "Ngày", "Ca trực", "Giờ bắt đầu", "Giờ kết thúc", "Trạng thái" };
		tblmodelChamCong = new DefaultTableModel(cols, 0);
		tblChamCong = new JTable(tblmodelChamCong);
		JScrollPane scrChamCong = new JScrollPane(tblChamCong);
		scrChamCong.setBounds(10, 11, 511, 315);
		pnlChinh.add(scrChamCong);

		JPanel pnlButton = new JPanel();
		pnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(pnlButton, BorderLayout.SOUTH);

		btnThoat = new JButton("Thoát");
		btnThoat.setActionCommand("Cancel");
		pnlButton.add(btnThoat);
		loadData();
	}

	private void loadData() {
		tblChamCong.removeAll();
		tblChamCong.setRowSelectionAllowed(false);
		tblmodelChamCong.setRowCount(0);
		listPhieuPhanCong = new ArrayList<>();
		listPhieuPhanCong = thongKeDAO.duyetDanhSachPhieuPhanCongTheoNhanVien(nhanVienEntity, ngay);

		int stt = 1;
		for (PhieuPhanCongEntity phieuPhanCongEntity : listPhieuPhanCong) {
			PhieuChamCongEntity phieuChamCongEntity = chamCongDAO
					.timTheoMaPhieuPhanCong(phieuPhanCongEntity.getMaPhieuPhanCong());
			CaTrucEntity caTrucEntity = phieuPhanCongEntity.getCaTruc();
			String trangThai = "Không vắng";
			if (phieuChamCongEntity.isTrangThai()) {
				trangThai = "Vắng";
			}
			tblmodelChamCong.addRow(new Object[] { stt++, DateFormatter.format(phieuPhanCongEntity.getNgay()),
					caTrucEntity.getTenCaTruc(), TimeFormatter.format(caTrucEntity.getGioBatDau()),
					TimeFormatter.format(caTrucEntity.getGioKetThuc()), trangThai });
		}
	}

	private void chonThoat() {
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThoat)) {
			chonThoat();
		}
	}
}
