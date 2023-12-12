package gui.caTruc;

import javax.swing.JPanel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Time;
import java.time.LocalTime;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyCaTrucController;
import dao.QuanLyCaTrucDAO;
import entities.CaTrucEntity;
import entities.DichVuEntity;
import entities.KhachHangEntity;
import entities.NhanVienEntity;
import util.TimeFormatter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class GD_QuanLyCaTruc extends JPanel {

	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlCaTruc;
	private JPanel pnlDsCaTruc;

	// JLablel
	private JLabel lblChiTietCaTruc;
	private JLabel lblMaCaTruc;
	private JLabel lblTenCaTruc;
	private JLabel lblGioBD;
	private JLabel lblGioKT;
	private JLabel lblDsCaTruc;

	// JTextField
	private JTextField txtMaCaTruc;
	private JTextField txtCaTruc;
	private JTextField txtGioBD;
	private JTextField txtGioKT;

	// JTable
	private JTable tblDsCaTruc;
	private DefaultTableModel tblmodelDanhSachPhong;
	private QuanLyCaTrucDAO quanLyCaTrucDAO = new QuanLyCaTrucDAO();
	// JScrollPane
	private JScrollPane scrDsCaTruc;

	private List<CaTrucEntity> list;
	public JButton btnLamMoi;
	public JButton btnChinhSua;
	public JButton btnXoa;
	public JButton btnThem;

	private NhanVienEntity nhanVienEntity;

	public GD_QuanLyCaTruc(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlCaTruc = new JPanel();
		pnlCaTruc.setBackground(new Color(230, 230, 250));
		pnlCaTruc.setBounds(0, 0, 1365, 239);
		add(pnlCaTruc);
		pnlCaTruc.setLayout(null);

		lblChiTietCaTruc = new JLabel("Chi tiết ca trực");
		lblChiTietCaTruc.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietCaTruc.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblChiTietCaTruc.setBounds(0, 0, 1365, 60);
		pnlCaTruc.add(lblChiTietCaTruc);

		lblMaCaTruc = new JLabel("Mã ca trực:");
		lblMaCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaCaTruc.setBounds(213, 70, 90, 30);
		pnlCaTruc.add(lblMaCaTruc);

		txtMaCaTruc = new JTextField();
		txtMaCaTruc.setDisabledTextColor(Color.BLACK);
		txtMaCaTruc.setBackground(Color.WHITE);
		txtMaCaTruc.setEditable(false);
		txtMaCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaCaTruc.setBounds(300, 70, 352, 30);
		pnlCaTruc.add(txtMaCaTruc);
		txtMaCaTruc.setColumns(10);

		lblTenCaTruc = new JLabel("Tên ca trực:");
		lblTenCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenCaTruc.setBounds(700, 71, 90, 30);
		pnlCaTruc.add(lblTenCaTruc);

		txtCaTruc = new JTextField();
		txtCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCaTruc.setBounds(800, 70, 352, 30);
		pnlCaTruc.add(txtCaTruc);
		txtCaTruc.setColumns(10);

		lblGioBD = new JLabel("Giờ bắt đầu:");
		lblGioBD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGioBD.setBounds(213, 120, 90, 30);
		pnlCaTruc.add(lblGioBD);

		txtGioBD = new JTextField();
		txtGioBD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGioBD.setBounds(300, 120, 352, 30);
		pnlCaTruc.add(txtGioBD);
		txtGioBD.setColumns(10);

		lblGioKT = new JLabel("Giờ kết thúc:");
		lblGioKT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGioKT.setBounds(700, 120, 90, 30);
		pnlCaTruc.add(lblGioKT);

		txtGioKT = new JTextField();
		txtGioKT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGioKT.setBounds(800, 120, 352, 30);
		pnlCaTruc.add(txtGioKT);
		txtGioKT.setColumns(10);

		btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyCaTruc.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(882, 180, 150, 35);
		pnlCaTruc.add(btnLamMoi);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyCaTruc.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setBounds(681, 180, 150, 35);
		pnlCaTruc.add(btnChinhSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GD_QuanLyCaTruc.class.getResource("/images/iconXoa.png")));
		btnXoa.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXoa.setFocusable(false);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setBounds(480, 180, 150, 35);
		pnlCaTruc.add(btnXoa);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_QuanLyCaTruc.class.getResource("/images/iconThem.png")));
		btnThem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnThem.setFocusable(false);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setBounds(279, 180, 150, 35);
		pnlCaTruc.add(btnThem);

		pnlDsCaTruc = new JPanel();
		pnlDsCaTruc.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDsCaTruc.setBackground(new Color(230, 230, 250));
		pnlDsCaTruc.setBounds(0, 239, 1365, 455);
		add(pnlDsCaTruc);
		pnlDsCaTruc.setLayout(null);

		lblDsCaTruc = new JLabel("Danh sách ca trực");
		lblDsCaTruc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDsCaTruc.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsCaTruc.setBounds(0, 10, 1365, 40);
		pnlDsCaTruc.add(lblDsCaTruc);

		String[] colsCaTruc = { "STT", "Mã CT", "Ca trực", "Giờ bắt đầu", "Giờ kết thúc" };
		tblmodelDanhSachPhong = new DefaultTableModel(colsCaTruc, 0);
		tblDsCaTruc = new JTable(tblmodelDanhSachPhong);
		tblDsCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrDsCaTruc = new JScrollPane(tblDsCaTruc);
		scrDsCaTruc.setBounds(30, 60, 1305, 380);
		pnlDsCaTruc.add(scrDsCaTruc);

		QuanLyCaTrucController controller = new QuanLyCaTrucController(this);
		btnLamMoi.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnXoa.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		tblDsCaTruc.addMouseListener(controller);
		loadData();
		kiemTraQuyen();

	}

	private void kiemTraQuyen() {
		if (nhanVienEntity.getChucVu().equalsIgnoreCase("Quản lí")) {
			btnChinhSua.setEnabled(true);
			btnThem.setEnabled(true);
			btnXoa.setEnabled(true);
		} else {
			btnChinhSua.setEnabled(false);
			btnThem.setEnabled(false);
			btnXoa.setEnabled(false);
		}
	}

	private void loadData() {
		tblDsCaTruc.removeAll();
		tblDsCaTruc.setRowSelectionAllowed(false);
		tblmodelDanhSachPhong.setRowCount(0);
		list = new ArrayList<CaTrucEntity>();
		list = quanLyCaTrucDAO.duyetDanhSach();

		int stt = 1;
		for (CaTrucEntity caTrucEntity : list) {
			tblmodelDanhSachPhong.addRow(new Object[] { stt++, caTrucEntity.getMaCaTruc(), caTrucEntity.getTenCaTruc(),
					TimeFormatter.format(caTrucEntity.getGioBatDau()),
					TimeFormatter.format(caTrucEntity.getGioKetThuc()) });
		}
	}

	public void hienThiThongTin() {
		list = new ArrayList<CaTrucEntity>();
		list = quanLyCaTrucDAO.duyetDanhSach();
		int row = tblDsCaTruc.getSelectedRow();
		if (row >= 0) {
			txtMaCaTruc.setText(list.get(row).getMaCaTruc());
			txtCaTruc.setText(list.get(row).getTenCaTruc());
			txtGioBD.setText(TimeFormatter.format(list.get(row).getGioBatDau()));
			txtGioKT.setText(TimeFormatter.format(list.get(row).getGioKetThuc()));
		}
	}

	public void chonLamMoi() {
		txtCaTruc.setText("");
		txtGioBD.setText("");
		txtGioKT.setText("");
		txtMaCaTruc.setText("");
		tblDsCaTruc.setRowSelectionAllowed(false);
		loadData();

	}

	public void chonThem() {
		if (kiemTraDuLieuThem()) {
			String caTruc = txtCaTruc.getText();
			LocalTime gioBatDau = LocalTime.parse(txtGioBD.getText());
			LocalTime gioKetThuc = LocalTime.parse(txtGioKT.getText());
			CaTrucEntity caTrucEntity = new CaTrucEntity(caTruc, gioBatDau, gioKetThuc);
			caTrucEntity = quanLyCaTrucDAO.them(caTrucEntity);
			loadData();
		}
	}

	public void chonXoa() {
		int row = tblDsCaTruc.getSelectedRow();
		if (row >= 0) {
			if (quanLyCaTrucDAO.xoa(txtMaCaTruc.getText())) {
				tblmodelDanhSachPhong.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa Ca trực thành công", "Thông Báo",
						JOptionPane.INFORMATION_MESSAGE);
				chonLamMoi();
				loadData();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chọn Ca trực cần xóa");
			return;
		}
	}

	public void chonChinhSua() {
		if (kiemTraDuLieuChinhSua()) {
			int row = tblDsCaTruc.getSelectedRow();
			if (row >= 0) {
				String maCaTruc = txtMaCaTruc.getText().trim();
				String tenCaTruc = txtCaTruc.getText().trim();
				LocalTime gioBatDau = LocalTime.parse(txtGioBD.getText());
				LocalTime gioKetThuc = LocalTime.parse(txtGioKT.getText());
				CaTrucEntity caTrucEntity = new CaTrucEntity(maCaTruc, tenCaTruc, gioBatDau, gioKetThuc);
				if (quanLyCaTrucDAO.chinhSua(caTrucEntity)) {
					JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin Ca trực thành công", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					chonLamMoi();
					loadData();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Chọn Ca trực cần chỉnh sửa");
			}
		}
	}

	private boolean kiemTraDuLieuChinhSua() {
		if (!kiemTraTenCatruc()) {
			return false;
		}

		if (!kiemTraGio()) {
			return false;
		}
		return true;
	}

	private boolean kiemTraTenCatruc() {
		String tenCaTruc = txtCaTruc.getText();
		list = new ArrayList<>();
		list = quanLyCaTrucDAO.duyetDanhSach();
		int row = tblDsCaTruc.getSelectedRow();
		if (row >= 0) {
			if (!(tenCaTruc.length() > 0)) {
				JOptionPane.showMessageDialog(this, "Tên Ca Trực không được để trống");
				txtCaTruc.requestFocus();
				return false;
			}
			if (list.contains(new CaTrucEntity("", tenCaTruc, null, null))
					&& !tenCaTruc.equals(list.get(row).getTenCaTruc())) {
				JOptionPane.showMessageDialog(this, "Tên ca trực đã tồn tại");
				txtCaTruc.requestFocus();
				return false;
			}
		}
		return true;
	}

	private boolean kiemTraDuLieuThem() {
		if (!kiemTraTenCaTrucThem()) {
			return false;
		}
		if (!kiemTraGio()) {
			return false;
		}
		return true;
	}

	private boolean kiemTraTenCaTrucThem() {
		String tenCaTruc = txtCaTruc.getText();
		list = new ArrayList<>();
		list = quanLyCaTrucDAO.duyetDanhSach();
		if (list.contains(new CaTrucEntity("", tenCaTruc, null, null))) {
			JOptionPane.showMessageDialog(this, "Tên ca trực đã tồn tại");
			txtCaTruc.requestFocus();
			return false;
		}

		if (!tenCaTruc.matches("^Ca\\s\\w+")) {
			JOptionPane.showMessageDialog(this, "Tên ca trực bắt đầu là \"Ca ...\"");
			txtCaTruc.requestFocus();
			return false;
		}
		return true;
	}

	private boolean kiemTraGio() {
		String gioBatDau = txtGioBD.getText().trim();
		String gioKetThuc = txtGioKT.getText().trim();
		if (!gioBatDau.matches("\\d{2}:\\d{2}")) {
			JOptionPane.showMessageDialog(this, "Định dạng nhập giờ là: 00:00");
			txtGioBD.requestFocus();
			return false;
		}
		if (!gioKetThuc.matches("\\d{2}:\\d{2}")) {
			JOptionPane.showMessageDialog(this, "Định dạng nhập giờ là: 00:00");
			txtGioKT.requestFocus();
			return false;
		}

		Integer gio1 = Integer.parseInt(gioBatDau.substring(0, 2));
		Integer gio2 = Integer.parseInt(gioKetThuc.substring(0, 2));
		Integer phut1 = Integer.parseInt(gioBatDau.substring(3, 5));
		Integer phut2 = Integer.parseInt(gioKetThuc.substring(3, 5));

		if (gio1 < 8) {
			JOptionPane.showMessageDialog(this, "Giờ bắt đầu ca trực phải sau 8h");
			txtGioBD.requestFocus();
			return false;
		}
		if (phut1 < 0 || phut1 > 59) {
			JOptionPane.showMessageDialog(this, "Phút từ 0 - 59");
			txtGioBD.requestFocus();
			return false;
		}

		if (gio2 > 23) {
			JOptionPane.showMessageDialog(this, "Giờ kết thúc ca trực phải trước 24");
			txtGioKT.requestFocus();
			return false;
		}
		if (phut2 < 0 || phut2 > 59) {
			JOptionPane.showMessageDialog(this, "Phút từ 0 - 59");
			txtGioKT.requestFocus();
			return false;
		}

		return true;
	}

}
