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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GD_QuanLyNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlQuanLyNhanVien;
	private JPanel pnlThongTinNhanVien;
	private JPanel pnlTimKiem;
	private JPanel pnlDSNhanVien;
	// JLable
	private JLabel lblThongTinNhanVien;
	private JLabel lblMaNhanVien;
	private JLabel lblCCCD;
	private JLabel lblChucVu;
	private JLabel lblEmail;
	private JLabel lblTienLuong;
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
		pnlThongTinNhanVien.setBackground(new Color(230, 230, 250));
		pnlThongTinNhanVien.setBounds(0, 137, 1365, 275);
		pnlQuanLyNhanVien.add(pnlThongTinNhanVien);
		pnlThongTinNhanVien.setLayout(null);

		lblThongTinNhanVien = new JLabel("Thông tin nhân viên");
		lblThongTinNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblThongTinNhanVien.setBounds(0, 0, 1365, 60);
		pnlThongTinNhanVien.add(lblThongTinNhanVien);

		lblMaNhanVien = new JLabel("Mã Nhân Viên:");
		lblMaNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaNhanVien.setBounds(50, 70, 95, 30);
		pnlThongTinNhanVien.add(lblMaNhanVien);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setDisabledTextColor(Color.BLACK);
		txtMaNhanVien.setSelectedTextColor(Color.BLACK);
		txtMaNhanVien.setSelectionColor(Color.BLACK);
		txtMaNhanVien.setBackground(Color.WHITE);
		txtMaNhanVien.setForeground(Color.BLACK);
		txtMaNhanVien.setEnabled(false);
		txtMaNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaNhanVien.setBounds(155, 70, 290, 30);
		pnlThongTinNhanVien.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);

		lblCCCD = new JLabel("CCCD:");
		lblCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCCCD.setBounds(515, 120, 90, 30);
		pnlThongTinNhanVien.add(lblCCCD);

		txtCCCD = new JTextField();
		txtCCCD.setSelectionColor(Color.BLACK);
		txtCCCD.setSelectedTextColor(Color.WHITE);
		txtCCCD.setBackground(Color.WHITE);
		txtCCCD.setDisabledTextColor(Color.BLACK);
		txtCCCD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCCCD.setBounds(575, 120, 290, 30);
		pnlThongTinNhanVien.add(txtCCCD);
		txtCCCD.setColumns(10);

		lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblChucVu.setBounds(505, 170, 95, 30);
		pnlThongTinNhanVien.add(lblChucVu);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmail.setBounds(104, 170, 95, 30);
		pnlThongTinNhanVien.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setBounds(155, 170, 290, 30);
		pnlThongTinNhanVien.add(txtEmail);
		txtEmail.setColumns(10);

		lblTienLuong = new JLabel("Mức lương/1 giờ:");
		lblTienLuong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTienLuong.setBounds(900, 170, 117, 30);
		pnlThongTinNhanVien.add(lblTienLuong);

		txtTienLuong = new JTextField();
		txtTienLuong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTienLuong.setColumns(10);
		txtTienLuong.setBounds(1023, 170, 290, 30);
		pnlThongTinNhanVien.add(txtTienLuong);

		String[] cols_chucVu = { "", "Quản lí", "Tiếp tân" };
		cmbmodelChucVu = new DefaultComboBoxModel<>(cols_chucVu);
		cmbChucVu = new JComboBox<String>(cmbmodelChucVu);
		cmbChucVu.setBounds(572, 170, 290, 30);
		pnlThongTinNhanVien.add(cmbChucVu);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/iconThem.png")));
		btnThem.setBounds(970, 220, 150, 35);
		pnlThongTinNhanVien.add(btnThem);
//		btnThem.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/iconThem3.png")));
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setForeground(Color.BLACK);
		btnThem.setFocusPainted(false);
		btnThem.setFont(new Font("Cambria", Font.BOLD, 14));

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setBounds(1163, 220, 150, 35);
		pnlThongTinNhanVien.add(btnChinhSua);
//		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setForeground(Color.BLACK);
		btnChinhSua.setFocusPainted(false);
		btnChinhSua.setFont(new Font("Cambria", Font.BOLD, 14));
//		lblAnhDaiDien.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/avatar_default_!.png")));

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSDT.setColumns(10);
		txtSDT.setBounds(1023, 120, 290, 30);
		pnlThongTinNhanVien.add(txtSDT);

		lblSDT = new JLabel("SĐT:");
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSDT.setBounds(974, 120, 95, 30);
		pnlThongTinNhanVien.add(lblSDT);

		txtHoVaTen = new JTextField();
		txtHoVaTen.setDisabledTextColor(Color.BLACK);
		txtHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtHoVaTen.setColumns(10);
		txtHoVaTen.setBounds(575, 70, 290, 30);
		pnlThongTinNhanVien.add(txtHoVaTen);

		lblHoVaTen = new JLabel("Họ Và Tên:");
		lblHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblHoVaTen.setBounds(488, 70, 95, 30);
		pnlThongTinNhanVien.add(lblHoVaTen);

		txtNamSinh = new JTextField();
		txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(155, 120, 290, 30);
		pnlThongTinNhanVien.add(txtNamSinh);

		lblNamSinh = new JLabel("Năm Sinh:");
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNamSinh.setBounds(78, 120, 95, 30);
		pnlThongTinNhanVien.add(lblNamSinh);

		radDangLamViec = new JRadioButton("Đang làm việc");
		radDangLamViec.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		radDangLamViec.setFocusable(false);
		radDangLamViec.setBackground(new Color(230, 230, 250));
		radDangLamViec.setBounds(970, 70, 150, 30);
		pnlThongTinNhanVien.add(radDangLamViec);

		radDaNghi = new JRadioButton("Đã nghỉ");
		radDaNghi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		radDaNghi.setFocusable(false);
		radDaNghi.setBackground(new Color(230, 230, 250));
		radDaNghi.setBounds(1122, 70, 150, 30);
		pnlThongTinNhanVien.add(radDaNghi);

		grpTrangThai = new ButtonGroup();
		grpTrangThai.add(radDangLamViec);
		grpTrangThai.add(radDaNghi);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 0, 1365, 137);
		pnlQuanLyNhanVien.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);
//		ImageIcon icon = new ImageIcon(GD_QuanLyTaiKhoan.class.getResource("/images/avatar_default.png"));
//		Image image = icon.getImage();
//		Image scaledImage = image.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
//		icon = new ImageIcon(scaledImage);

		lblTimTheoChucVu = new JLabel("Chức vụ:");
		lblTimTheoChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimTheoChucVu.setBounds(728, 30, 100, 30);
		pnlTimKiem.add(lblTimTheoChucVu);

		String[] cols_chucVu_1 = { "Tất cả", "Quản lí", "Tiếp tân" };
		cmdmodelTimTheoChucVu = new DefaultComboBoxModel<>(cols_chucVu_1);
		cmbTimTheoChucVu = new JComboBox<String>(cmdmodelTimTheoChucVu);
		cmbTimTheoChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTimTheoChucVu.setBounds(796, 30, 200, 30);
		pnlTimKiem.add(cmbTimTheoChucVu);

		lblTimTheoSoDienThoai = new JLabel("Số điện thoại:");
		lblTimTheoSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimTheoSoDienThoai.setBounds(366, 30, 100, 30);
		pnlTimKiem.add(lblTimTheoSoDienThoai);

		txtTimTheoSoDienThoai = new JTextField();
		txtTimTheoSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimTheoSoDienThoai.setBounds(464, 30, 200, 30);
		pnlTimKiem.add(txtTimTheoSoDienThoai);
		txtTimTheoSoDienThoai.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
//		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBounds(1185, 85, 150, 35);
		pnlTimKiem.add(btnTimKiem);

		lblTimTheoHoVaTen = new JLabel("Họ và tên:");
		lblTimTheoHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTimTheoHoVaTen.setBounds(30, 30, 100, 30);
		pnlTimKiem.add(lblTimTheoHoVaTen);

		txtTimTheoHoVaTen = new JTextField();
		txtTimTheoHoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimTheoHoVaTen.setBounds(106, 30, 200, 30);
		pnlTimKiem.add(txtTimTheoHoVaTen);
		txtTimTheoHoVaTen.setColumns(10);

		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTrangThai.setBounds(1050, 30, 100, 30);
		pnlTimKiem.add(lblTrangThai);

		cmbmodelTimTheoTrangThai = new DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang làm việc", "Đã nghỉ" });
		cmbTimTheoTrangThai = new JComboBox<String>(cmbmodelTimTheoTrangThai);
		cmbTimTheoTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTimTheoTrangThai.setBounds(1135, 30, 200, 30);
		pnlTimKiem.add(cmbTimTheoTrangThai);
		
				btnLamMoi = new JButton("Làm mới");
				btnLamMoi.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/iconLamMoi.png")));
				btnLamMoi.setBounds(1000, 86, 150, 35);
				pnlTimKiem.add(btnLamMoi);
				//		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyNhanVien.class.getResource("/images/iconLamMoi3.png")));
						btnLamMoi.setBackground(new Color(144, 238, 144));
						btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
						btnLamMoi.setForeground(Color.BLACK);
						btnLamMoi.setFocusPainted(false);
						btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));

		pnlDSNhanVien = new JPanel();
		pnlDSNhanVien.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDSNhanVien.setBackground(new Color(230, 230, 250));
		pnlDSNhanVien.setBounds(0, 412, 1365, 282);
		pnlQuanLyNhanVien.add(pnlDSNhanVien);
		pnlDSNhanVien.setLayout(null);

		String[] cols = { "STT", "Mã NV", "Họ và tên", "Chức vụ", "Năm sinh", "SĐT", "CCCD", "Email", "Trạng thái",
				"Lương/giờ" };
		tblmodelNhanVien = new DefaultTableModel(cols, 0);
		tblNhanVien = new JTable(tblmodelNhanVien);
		tblNhanVien.setAutoCreateRowSorter(true);
		tblNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrBangNhanVien = new JScrollPane(tblNhanVien);
		scrBangNhanVien.setBounds(30, 60, 1305, 212);
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
		lblDSNhanVien.setBounds(0, 10, 1365, 40);
		pnlDSNhanVien.add(lblDSNhanVien);

//		controller = new QuanLyNhanVienController(this);
//		btnTimKiem.addActionListener(controller);
//		btnThem.addActionListener(controller);
//		btnChinhSua.addActionListener(controller);
//		btnLamMoi.addActionListener(controller);
//		tblNhanVien.addMouseListener(controller);
	}
}
