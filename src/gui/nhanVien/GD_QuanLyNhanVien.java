package gui.nhanVien;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

//import controller.QuanLyNhanVienController;
//import dao.QuanLyNhanVienDAO;
import entities.NhanVienEntity;

public class GD_QuanLyNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlQuanLyNhanVien;
	private JPanel pnlThongTinNhanVien;
	private JPanel pnlTimKiem;
	private JPanel pnlDSNhanVien;
	// JLable
	private JLabel lblThongTinNhanVien;
	private JLabel lblMaNV;
	private JLabel lblCCCD;
	private JLabel lblChucVu;
	private JLabel lblEmail;
	private JLabel lblTienLuong;
	private JLabel lblAnhDaiDien;
	private JLabel lblTimTheoChucVu;
	private JLabel lblTimTheoSoDienThoai;
	private JLabel lblTimTheoHoVaTen;
	private JLabel lblDSNhanVien;
	private JLabel lblSDT;
	private JLabel lblHoVaTen;
	private JLabel lblNamSinh;
	private JLabel lblTrangThai;
	// JTextField
	private JTextField txtMaNhanVien;
	private JTextField txtCCCD;
	private JTextField txtEmail;
	private JTextField txtTienLuong;
	private JTextField txtTimTheoSoDienThoai;
	private JTextField txtTimTheoHoVaTen;
	private JTextField txtSDT;
	private JTextField txtHoVaTen;
	private JTextField txtNamSinh;
	// JTable
	private JTable tblNhanVien;
	private DefaultTableModel tblmodelNhanVien;
	// JScrollPane
	private JScrollPane scrBangNhanVien;
	// JCombobox
	private JComboBox<String> cmbChucVu;
	private JComboBox<String> cmbTimTheoChucVu;
	private JComboBox<String> cmbTimTheoTrangThai;
	private DefaultComboBoxModel<String> cmbmodelChucVu;
	private DefaultComboBoxModel<String> cmdmodelTimTheoChucVu;
	private DefaultComboBoxModel<String> cmbmodelTimTheoTrangThai;
	// JButton
	public JButton btnTimKiem;
	public JButton btnThem;
	public JButton btnChinhSua;
	public JButton btnLamMoi;
	// JRadioButton
	private JRadioButton radDaNghi;
	private JRadioButton radDangLamViec;
	private ButtonGroup grpTrangThai;

//	private QuanLyNhanVienController controller;
	// dao
//	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
//	private List<NhanVienEntity> listNhanVien;

	public GD_QuanLyNhanVien() {
		setLayout(null);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, (int) screen.getWidth(), (int) screen.getHeight());

		pnlQuanLyNhanVien = new JPanel();
		pnlQuanLyNhanVien.setBounds(0, 0, 1365, 694);
		add(pnlQuanLyNhanVien);
		pnlQuanLyNhanVien.setLayout(null);

		pnlThongTinNhanVien = new JPanel();
		pnlThongTinNhanVien.setBorder(null);
		pnlThongTinNhanVien.setBackground(new Color(255, 192, 203));
		pnlThongTinNhanVien.setBounds(0, 0, 672, 519);
		pnlQuanLyNhanVien.add(pnlThongTinNhanVien);
		pnlThongTinNhanVien.setLayout(null);

		lblThongTinNhanVien = new JLabel("Thông tin nhân viên");
		lblThongTinNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblThongTinNhanVien.setBounds(0, 11, 672, 61);
		pnlThongTinNhanVien.add(lblThongTinNhanVien);

		lblMaNV = new JLabel("Mã NV:");
		lblMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaNV.setBounds(10, 97, 95, 30);
		pnlThongTinNhanVien.add(lblMaNV);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setDisabledTextColor(Color.BLACK);
		txtMaNhanVien.setSelectedTextColor(Color.BLACK);
		txtMaNhanVien.setSelectionColor(Color.BLACK);
		txtMaNhanVien.setBackground(Color.WHITE);
		txtMaNhanVien.setForeground(Color.BLACK);
		txtMaNhanVien.setEnabled(false);
		txtMaNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaNhanVien.setBounds(99, 97, 198, 30);
		pnlThongTinNhanVien.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);

		lblCCCD = new JLabel("CCCD:");
		lblCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCCCD.setBounds(10, 199, 95, 30);
		pnlThongTinNhanVien.add(lblCCCD);

		txtCCCD = new JTextField();
		txtCCCD.setSelectionColor(Color.BLACK);
		txtCCCD.setSelectedTextColor(Color.WHITE);
		txtCCCD.setBackground(Color.WHITE);
		txtCCCD.setDisabledTextColor(Color.BLACK);
		txtCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCCCD.setBounds(99, 199, 198, 30);
		pnlThongTinNhanVien.add(txtCCCD);
		txtCCCD.setColumns(10);

		lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblChucVu.setBounds(331, 301, 95, 30);
		pnlThongTinNhanVien.add(lblChucVu);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmail.setBounds(10, 356, 95, 30);
		pnlThongTinNhanVien.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setBounds(99, 356, 198, 30);
		pnlThongTinNhanVien.add(txtEmail);
		txtEmail.setColumns(10);

		lblTienLuong = new JLabel("Mức lương/1 giờ:");
		lblTienLuong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTienLuong.setBounds(331, 356, 117, 30);
		pnlThongTinNhanVien.add(lblTienLuong);

		txtTienLuong = new JTextField();
		txtTienLuong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTienLuong.setColumns(10);
		txtTienLuong.setBounds(456, 356, 190, 30);
		pnlThongTinNhanVien.add(txtTienLuong);

		String[] cols_chucVu = { "", "Quản lí", "Tiếp tân" };
		cmbmodelChucVu = new DefaultComboBoxModel<>(cols_chucVu);
		cmbChucVu = new JComboBox<String>(cmbmodelChucVu);
		cmbChucVu.setBounds(456, 303, 190, 30);
		pnlThongTinNhanVien.add(cmbChucVu);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(136, 445, 120, 35);
		pnlThongTinNhanVien.add(btnThem);
//		btnThem.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/iconThem3.png")));
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setForeground(Color.BLACK);
		btnThem.setFocusPainted(false);
		btnThem.setFont(new Font("Dialog", Font.PLAIN, 12));

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setBounds(292, 445, 120, 35);
		pnlThongTinNhanVien.add(btnChinhSua);
//		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setForeground(Color.BLACK);
		btnChinhSua.setFocusPainted(false);
		btnChinhSua.setFont(new Font("Dialog", Font.PLAIN, 12));

		lblAnhDaiDien = new JLabel("");
		lblAnhDaiDien.setBounds(408, 97, 130, 130);
		pnlThongTinNhanVien.add(lblAnhDaiDien);
//		lblAnhDaiDien.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/avatar_default_!.png")));

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBounds(99, 250, 198, 30);
		pnlThongTinNhanVien.add(txtSDT);

		lblSDT = new JLabel("SĐT:");
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSDT.setBounds(10, 250, 95, 30);
		pnlThongTinNhanVien.add(lblSDT);

		txtHoVaTen = new JTextField();
		txtHoVaTen.setDisabledTextColor(Color.BLACK);
		txtHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtHoVaTen.setColumns(10);
		txtHoVaTen.setBounds(99, 148, 198, 30);
		pnlThongTinNhanVien.add(txtHoVaTen);

		lblHoVaTen = new JLabel("Họ và tên:");
		lblHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblHoVaTen.setBounds(10, 148, 95, 30);
		pnlThongTinNhanVien.add(lblHoVaTen);

		txtNamSinh = new JTextField();
		txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(99, 301, 198, 30);
		pnlThongTinNhanVien.add(txtNamSinh);

		lblNamSinh = new JLabel("Năm sinh:");
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNamSinh.setBounds(10, 301, 95, 30);
		pnlThongTinNhanVien.add(lblNamSinh);

		radDangLamViec = new JRadioButton("Đang làm việc");
		radDangLamViec.setFocusable(false);
		radDangLamViec.setBackground(new Color(255, 192, 203));
		radDangLamViec.setBounds(393, 234, 107, 23);
		pnlThongTinNhanVien.add(radDangLamViec);

		radDaNghi = new JRadioButton("Đã nghỉ");
		radDaNghi.setFocusable(false);
		radDaNghi.setBackground(new Color(255, 192, 203));
		radDaNghi.setBounds(502, 234, 69, 23);
		pnlThongTinNhanVien.add(radDaNghi);

		grpTrangThai = new ButtonGroup();
		grpTrangThai.add(radDangLamViec);
		grpTrangThai.add(radDaNghi);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(448, 445, 120, 35);
		pnlThongTinNhanVien.add(btnLamMoi);
//		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setFont(new Font("Dialog", Font.PLAIN, 12));

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 519, 672, 175);
		pnlQuanLyNhanVien.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);
//		ImageIcon icon = new ImageIcon(GD_QuanLyTaiKhoan.class.getResource("/images/avatar_default.png"));
//		Image image = icon.getImage();
//		Image scaledImage = image.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
//		icon = new ImageIcon(scaledImage);

		lblTimTheoChucVu = new JLabel("Chức vụ:");
		lblTimTheoChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimTheoChucVu.setBounds(21, 78, 100, 30);
		pnlTimKiem.add(lblTimTheoChucVu);

		String[] cols_chucVu_1 = { "Tất cả", "Quản lí", "Tiếp tân" };
		cmdmodelTimTheoChucVu = new DefaultComboBoxModel<>(cols_chucVu_1);
		cmbTimTheoChucVu = new JComboBox<String>(cmdmodelTimTheoChucVu);
		cmbTimTheoChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTimTheoChucVu.setBounds(94, 78, 215, 30);
		pnlTimKiem.add(cmbTimTheoChucVu);

		lblTimTheoSoDienThoai = new JLabel("Số điện thoại:");
		lblTimTheoSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimTheoSoDienThoai.setBounds(334, 27, 100, 30);
		pnlTimKiem.add(lblTimTheoSoDienThoai);

		txtTimTheoSoDienThoai = new JTextField();
		txtTimTheoSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimTheoSoDienThoai.setBounds(431, 27, 215, 30);
		pnlTimKiem.add(txtTimTheoSoDienThoai);
		txtTimTheoSoDienThoai.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
//		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBounds(526, 119, 120, 35);
		pnlTimKiem.add(btnTimKiem);

		lblTimTheoHoVaTen = new JLabel("Họ và tên:");
		lblTimTheoHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimTheoHoVaTen.setBounds(21, 27, 100, 30);
		pnlTimKiem.add(lblTimTheoHoVaTen);

		txtTimTheoHoVaTen = new JTextField();
		txtTimTheoHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimTheoHoVaTen.setBounds(94, 27, 215, 30);
		pnlTimKiem.add(txtTimTheoHoVaTen);
		txtTimTheoHoVaTen.setColumns(10);

		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTrangThai.setBounds(334, 78, 100, 30);
		pnlTimKiem.add(lblTrangThai);

		cmbmodelTimTheoTrangThai = new DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang làm việc", "Đã nghỉ" });
		cmbTimTheoTrangThai = new JComboBox<String>(cmbmodelTimTheoTrangThai);
		cmbTimTheoTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTimTheoTrangThai.setBounds(431, 78, 215, 30);
		pnlTimKiem.add(cmbTimTheoTrangThai);

		pnlDSNhanVien = new JPanel();
		pnlDSNhanVien.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDSNhanVien.setBackground(new Color(250, 240, 230));
		pnlDSNhanVien.setBounds(672, 0, 694, 694);
		pnlQuanLyNhanVien.add(pnlDSNhanVien);
		pnlDSNhanVien.setLayout(null);

		String[] cols = { "STT", "Mã NV", "Họ và tên", "Chức vụ", "Năm sinh", "SĐT", "CCCD", "Email", "Trạng thái",
				"Lương/giờ" };
		tblmodelNhanVien = new DefaultTableModel(cols, 0);
		tblNhanVien = new JTable(tblmodelNhanVien);
		tblNhanVien.setAutoCreateRowSorter(true);
		tblNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrBangNhanVien = new JScrollPane(tblNhanVien);
		scrBangNhanVien.setBounds(10, 70, 674, 601);
		pnlDSNhanVien.add(scrBangNhanVien);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblNhanVien.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblNhanVien.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblNhanVien.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tblNhanVien.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblNhanVien.getColumnModel().getColumn(1).setPreferredWidth(50);
		tblNhanVien.getColumnModel().getColumn(3).setPreferredWidth(65);
		tblNhanVien.getColumnModel().getColumn(4).setPreferredWidth(60);

		lblDSNhanVien = new JLabel("Danh sách nhân viên");
		lblDSNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblDSNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDSNhanVien.setBounds(0, 19, 694, 40);
		pnlDSNhanVien.add(lblDSNhanVien);

//		controller = new QuanLyNhanVienController(this);
//		btnTimKiem.addActionListener(controller);
//		btnThem.addActionListener(controller);
//		btnChinhSua.addActionListener(controller);
//		btnLamMoi.addActionListener(controller);
//		tblNhanVien.addMouseListener(controller);
	}
}
