package gui.phanCongVaChamCong;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controller.QuanLyPhanCongController;
import dao.PhanCongDAO;
import dao.QuanLyCaTrucDAO;
import dao.QuanLyNhanVienDAO;
import entities.CaTrucEntity;
import entities.NhanVienEntity;
import entities.PhieuPhanCongEntity;
import util.DateFormatter;

public class GD_QuanLyPhanCong extends JPanel {

	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlPhanCong;
	private JPanel pnlChiTietPhanCong;
	private JPanel pnlDanhSachPhanCong;
	// JtextField
	private JTextField txtMaPC;
	// Jlabel
	private JLabel lblChiTietPhanCong;
	private JLabel lblMaPC;
	private JLabel lblNgay;
	private JLabel lblNhanVien;
	private JLabel lblCaTruc;
	private JLabel lblDsPhanCong;
	// JcomboBox
	public JComboBox<String> cmbNhanVien;
	private DefaultComboBoxModel<String> cmbmodelNhanVien;
	public JComboBox<String> cmbCaTruc;
	private DefaultComboBoxModel<String> cmbmodelCaTruc;
	// Jtable
	private JTable tblPhieuPhanCong;
	private DefaultTableModel tblmodelPhieuPhanCong;
	// JScrollPane
	private JScrollPane scrPhanCong;
	// JDateChooser
	private JDateChooser dchNgay;
	// JButton
	public JButton btnThem;
	public JButton btnXoa;
	public JButton btnLamMoi;
	public JButton btnChinhSua;

	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
	private PhanCongDAO phanCongDAO = new PhanCongDAO();
	private QuanLyCaTrucDAO quanLyCaTrucDAO = new QuanLyCaTrucDAO();
	private List<PhieuPhanCongEntity> listPhieuPhanCong;
	private List<NhanVienEntity> listNhanVien;
	private List<CaTrucEntity> listCaTruc;

	public GD_QuanLyPhanCong() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlPhanCong = new JPanel();
		pnlPhanCong.setBackground(new Color(255, 255, 255));
		pnlPhanCong.setBounds(0, 0, 1365, 694);
		add(pnlPhanCong);
		pnlPhanCong.setLayout(null);

		pnlChiTietPhanCong = new JPanel();
		pnlChiTietPhanCong.setBorder(null);
		pnlChiTietPhanCong.setBackground(new Color(230, 230, 250));
		pnlChiTietPhanCong.setBounds(0, 0, 1365, 290);
		pnlPhanCong.add(pnlChiTietPhanCong);
		pnlChiTietPhanCong.setLayout(null);

		lblChiTietPhanCong = new JLabel(" Chi tiết Phân Công");
		lblChiTietPhanCong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietPhanCong.setBounds(0, 0, 1365, 60);
		lblChiTietPhanCong.setFont(new Font("Segoe UI", Font.BOLD, 22));
		pnlChiTietPhanCong.add(lblChiTietPhanCong);

		lblMaPC = new JLabel("Mã Phân Công:");
		lblMaPC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaPC.setBounds(206, 70, 110, 30);
		pnlChiTietPhanCong.add(lblMaPC);

		txtMaPC = new JTextField();
		txtMaPC.setText(" ");
		txtMaPC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaPC.setDisabledTextColor(Color.BLACK);
		txtMaPC.setSelectedTextColor(Color.BLACK);
		txtMaPC.setSelectionColor(Color.BLACK);
		txtMaPC.setEnabled(false);
		txtMaPC.setBounds(330, 70, 290, 30);
		pnlChiTietPhanCong.add(txtMaPC);
		txtMaPC.setColumns(10);

		lblNgay = new JLabel("Ngày:");
		lblNgay.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNgay.setBounds(758, 70, 80, 30);
		pnlChiTietPhanCong.add(lblNgay);

		dchNgay = new JDateChooser(new Date());
		dchNgay.setDateFormatString("dd/MM/yyyy");
		dchNgay.setBounds(815, 70, 290, 30);
		pnlChiTietPhanCong.add(dchNgay);

		lblNhanVien = new JLabel("Nhân viên:");
		lblNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNhanVien.setBounds(206, 120, 110, 30);
		pnlChiTietPhanCong.add(lblNhanVien);

		cmbmodelNhanVien = new DefaultComboBoxModel<>();
		cmbmodelNhanVien.addElement("");
		cmbNhanVien = new JComboBox<>(cmbmodelNhanVien);
		cmbNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbNhanVien.setBounds(330, 120, 290, 30);
		pnlChiTietPhanCong.add(cmbNhanVien);

		lblCaTruc = new JLabel("Ca trực:");
		lblCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCaTruc.setBounds(743, 120, 80, 30);
		pnlChiTietPhanCong.add(lblCaTruc);

		cmbmodelCaTruc = new DefaultComboBoxModel<>();
		cmbmodelCaTruc.addElement("");
		cmbCaTruc = new JComboBox<>(cmbmodelCaTruc);
		cmbCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbCaTruc.setBounds(815, 120, 290, 30);
		pnlChiTietPhanCong.add(cmbCaTruc);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_QuanLyPhanCong.class.getResource("/images/iconThem.png")));
		btnThem.setForeground(Color.BLACK);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setFocusPainted(false);
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnThem.setBounds(279, 230, 150, 35);
		pnlChiTietPhanCong.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GD_QuanLyPhanCong.class.getResource("/images/iconXoa.png")));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setFocusPainted(false);
		btnXoa.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXoa.setBounds(480, 230, 150, 35);
		pnlChiTietPhanCong.add(btnXoa);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyPhanCong.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setBounds(882, 230, 150, 35);
		pnlChiTietPhanCong.add(btnLamMoi);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyPhanCong.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setForeground(Color.BLACK);
		btnChinhSua.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSua.setFocusPainted(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setBounds(681, 230, 150, 35);
		pnlChiTietPhanCong.add(btnChinhSua);

		pnlDanhSachPhanCong = new JPanel();
		pnlDanhSachPhanCong.setBackground(new Color(230, 230, 250));
		pnlDanhSachPhanCong.setBounds(0, 290, 1365, 404);
		pnlPhanCong.add(pnlDanhSachPhanCong);
		pnlDanhSachPhanCong.setLayout(null);

		String[] cols = { "STT", "Mã PC", "Họ và tên", "Số điện thoại", "Ca trực", "Ngày" };
		tblmodelPhieuPhanCong = new DefaultTableModel(cols, 0);
		tblPhieuPhanCong = new JTable(tblmodelPhieuPhanCong);
		tblPhieuPhanCong.setAutoCreateRowSorter(true);
		tblPhieuPhanCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrPhanCong = new JScrollPane(tblPhieuPhanCong);
		scrPhanCong.setBounds(30, 70, 1305, 320);
		pnlDanhSachPhanCong.add(scrPhanCong);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblPhieuPhanCong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhieuPhanCong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhieuPhanCong.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblPhieuPhanCong.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

		lblDsPhanCong = new JLabel("Danh sách phân công");
		lblDsPhanCong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDsPhanCong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsPhanCong.setBounds(0, 10, 1365, 50);
		pnlDanhSachPhanCong.add(lblDsPhanCong);

		QuanLyPhanCongController controller = new QuanLyPhanCongController(this);
		btnLamMoi.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnXoa.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		tblPhieuPhanCong.addMouseListener(controller);
		loadCmbNhanVien();
		loadCmbCaTruc();
		loadData();
	}

	/**** loadData *****/
	private void loadData() {
		tblPhieuPhanCong.removeAll();
		tblPhieuPhanCong.setRowSelectionAllowed(false);
		tblmodelPhieuPhanCong.setRowCount(0);
		listPhieuPhanCong = new ArrayList<PhieuPhanCongEntity>();
		listPhieuPhanCong = phanCongDAO.duyetDanhSach();

		int stt = 1;
		for (PhieuPhanCongEntity phieuPhanCongEntity : listPhieuPhanCong) {
			tblmodelPhieuPhanCong.addRow(new Object[] { stt++, phieuPhanCongEntity.getMaPhieuPhanCong(),
					phieuPhanCongEntity.getNhanVien().getHoTen(), phieuPhanCongEntity.getNhanVien().getSoDienThoai(),
					phieuPhanCongEntity.getCaTruc().getTenCaTruc(),
					DateFormatter.format(phieuPhanCongEntity.getNgay()) });
		}
	}

	public void hienThiThongTin() {
		listPhieuPhanCong = new ArrayList<PhieuPhanCongEntity>();
		listPhieuPhanCong = phanCongDAO.duyetDanhSach();
		int row = tblPhieuPhanCong.getSelectedRow();
		if (row >= 0) {
			txtMaPC.setText(listPhieuPhanCong.get(row).getMaPhieuPhanCong());
			cmbNhanVien
					.setSelectedItem(tblPhieuPhanCong.getValueAt(row, 2) + " - " + tblPhieuPhanCong.getValueAt(row, 3));
			cmbCaTruc.setSelectedItem(tblPhieuPhanCong.getValueAt(row, 4));
			dchNgay.setDate(java.sql.Date.valueOf(listPhieuPhanCong.get(row).getNgay()));
		}
	}

	public void chonLamMoi() {
		txtMaPC.setText("");
		cmbCaTruc.setSelectedIndex(0);
		cmbNhanVien.setSelectedIndex(0);
		dchNgay.setDate(new Date());
		loadCmbCaTruc();
		loadCmbNhanVien();
		loadData();
	}

	/***** THÊM *****/
	public void chonThem() {
		if (kiemTraDuLieu()) {
			listNhanVien = new ArrayList<NhanVienEntity>();
			listNhanVien = quanLyNhanVienDAO.duyetDanhSachNhanVienDangLamViec();
			listCaTruc = new ArrayList<CaTrucEntity>();
			listCaTruc = quanLyCaTrucDAO.duyetDanhSach();
			String maNhanVien = listNhanVien.get(cmbNhanVien.getSelectedIndex() - 1).getMaNhanVien();
			String maCaTruc = listCaTruc.get(cmbCaTruc.getSelectedIndex() - 1).getMaCaTruc();
			LocalDate ngayPhanCong = dchNgay.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			PhieuPhanCongEntity phieuPhanCongEntity = new PhieuPhanCongEntity(quanLyNhanVienDAO.timTheoMa(maNhanVien),
					quanLyCaTrucDAO.timTheoMa(maCaTruc), ngayPhanCong);

			if (phanCongDAO.themPhieuPhanCong(phieuPhanCongEntity)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				chonLamMoi();
				loadData();
			}
		}
	}

	/***** XÓA *****/
	public void chonXoa() {
		int row = tblPhieuPhanCong.getSelectedRow();
		if (row >= 0) {
			if (phanCongDAO.xoaPhieuPhanCong(txtMaPC.getText())) {
				tblmodelPhieuPhanCong.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa phiếu phân công thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				chonLamMoi();
				loadData();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Hãy chọn phòng cần xóa");
			return;
		}
	}

	public void chonChinhSua() {
		int row = tblPhieuPhanCong.getSelectedRow();
		if (row >= 0) {
			if (kiemTraDuLieu()) {
				listNhanVien = new ArrayList<NhanVienEntity>();
				listNhanVien = quanLyNhanVienDAO.duyetDanhSachNhanVienDangLamViec();
				listCaTruc = new ArrayList<CaTrucEntity>();
				listCaTruc = quanLyCaTrucDAO.duyetDanhSach();
				String maPhieuPhanCong = txtMaPC.getText();
				String maNhanVien = listNhanVien.get(cmbNhanVien.getSelectedIndex() - 1).getMaNhanVien();
				String maCaTruc = listCaTruc.get(cmbCaTruc.getSelectedIndex() - 1).getMaCaTruc();
				LocalDate ngayPhanCong = dchNgay.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

				PhieuPhanCongEntity phieuPhanCongEntity = new PhieuPhanCongEntity(maPhieuPhanCong,
						quanLyNhanVienDAO.timTheoMa(maNhanVien), quanLyCaTrucDAO.timTheoMa(maCaTruc), ngayPhanCong);

				if (phanCongDAO.chinhSuaPhieuPhanCong(phieuPhanCongEntity)) {
					JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin thành công");
					chonLamMoi();
				} else {
					JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin thất bại");
					return;
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Hãy chọn phòng cần chỉnh sửa");
			return;
		}
	}

	private void loadCmbNhanVien() {
		listNhanVien = new ArrayList<NhanVienEntity>();
		listNhanVien = quanLyNhanVienDAO.duyetDanhSachNhanVienDangLamViec();
		cmbmodelNhanVien.removeAllElements();
		cmbmodelNhanVien.addElement("");
		for (NhanVienEntity nhanVienEntity : listNhanVien) {
			cmbmodelNhanVien.addElement(nhanVienEntity.getHoTen() + " - " + nhanVienEntity.getSoDienThoai());
		}
	}

	private void loadCmbCaTruc() {
		listCaTruc = new ArrayList<CaTrucEntity>();
		listCaTruc = quanLyCaTrucDAO.duyetDanhSach();
		cmbmodelCaTruc.removeAllElements();
		cmbmodelCaTruc.addElement("");
		for (CaTrucEntity caTrucEntity : listCaTruc) {
			cmbmodelCaTruc.addElement(caTrucEntity.getTenCaTruc());
		}
	}

	/***** KIỂM TRA DỮ LIỆU *****/
	private boolean kiemTraDuLieu() {
		if (!kiemTraNgayPhanCong()) {
			return false;
		}
		if (!kiemTraCmbCaTruc()) {
			return false;
		}
		if (!kiemTraCmbNhanVien()) {
			return false;
		}
		return true;
	}

	private boolean kiemTraNgayPhanCong() {
		Date ngayHienTai = new Date();
		if (dchNgay.getDate().before(ngayHienTai)) {
			JOptionPane.showMessageDialog(this, "Hãy chọn ngày phân công sau ngày " + DateFormatter.format(ngayHienTai),
					"Thông báo", JOptionPane.INFORMATION_MESSAGE);
			dchNgay.requestFocus();
			return false;
		}
		return true;
	}

	private boolean kiemTraCmbCaTruc() {
		if (cmbCaTruc.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn ca trực cho nhân viên", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			cmbCaTruc.requestFocus();
			return false;
		}
		return true;
	}

	private boolean kiemTraCmbNhanVien() {
		if (cmbNhanVien.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			cmbNhanVien.requestFocus();
			return false;
		}
		return true;
	}
}
