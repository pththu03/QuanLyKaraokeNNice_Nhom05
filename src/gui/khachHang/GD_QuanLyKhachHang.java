package gui.khachHang;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.KhachHangEntity;

public class GD_QuanLyKhachHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel pnlKhachHang;
	private JPanel pnlTimKiem;
	private JPanel pnlChucNang;

	// JTextField
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtNamSinh;
	private JTextField txtEmail;
	private JTextField txtSoDienThoai;

	// JTable
	private JTable tblKhachHang;

	// JLabel
	private JLabel lblMaKhachHang;
	private JLabel lblTenKhachHang;
	private JLabel lblSDT;
	private JLabel lblNamSinh;
	private JLabel lblSoDienThoai;
	private JLabel lblEmail;
	private JLabel lblKhachHang;
	private JLabel lblTenKH;

	// JButton
	public JButton btnChinhSua;
	public JButton btnTimKiem;
	public JButton btnThem;
	public JButton btnLamMoi;

	// JScrollPane
	private JScrollPane scrKhachHang;
	private DefaultTableModel tblmdelKhachHang;
//	private QuanLyKhachHangController controller;
//	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
	private List<KhachHangEntity> list;
	private JTextField txtSLDatPhong;
	private JLabel lblSLDatPhong;
	private JTextField txtTenKhachHang;
	private JLabel lblDanhSchKhch;
	private JTextField txtSoLanDatPhongTu;
	private JTextField txtSoLanDatPhongDen;

	public GD_QuanLyKhachHang() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlKhachHang = new JPanel();
		pnlKhachHang.setBackground(new Color(211, 211, 211));
		pnlKhachHang.setBounds(0, 0, 1365, 694);
		add(pnlKhachHang);
		pnlKhachHang.setLayout(null);

		pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChucNang.setBackground(new Color(250, 240, 230));
		pnlChucNang.setBounds(672, 1, 694, 693);
		pnlKhachHang.add(pnlChucNang);
		pnlChucNang.setLayout(null);

		String[] cols_KhachHang = { "STT", "Mã Khách Hàng", "Tên khách hàng", "Số điện thoại", "Email", "Năm Sinh",
				"Số Lượng Đặt Phòng" };
		tblmdelKhachHang = new DefaultTableModel(cols_KhachHang, 0);
		tblKhachHang = new JTable(tblmdelKhachHang);
		scrKhachHang = new JScrollPane(tblKhachHang);
		scrKhachHang.setBounds(10, 89, 674, 593);
		pnlChucNang.add(scrKhachHang);

		lblDanhSchKhch = new JLabel("Danh sách khách hàng");
		lblDanhSchKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchKhch.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSchKhch.setBounds(0, 24, 694, 40);
		pnlChucNang.add(lblDanhSchKhch);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBounds(0, 519, 672, 175);
		pnlKhachHang.add(pnlTimKiem);
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setLayout(null);

		lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setBounds(22, 71, 110, 25);
		pnlTimKiem.add(lblSDT);
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
//		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBounds(510, 122, 120, 35);
		pnlTimKiem.add(btnTimKiem);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(135, 70, 171, 27);
		pnlTimKiem.add(txtSoDienThoai);

		lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenKH.setBounds(22, 24, 110, 20);
		pnlTimKiem.add(lblTenKH);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(135, 21, 178, 27);
		pnlTimKiem.add(txtTenKhachHang);

		JPanel pnlTimTheoSoLanDatPhong = new JPanel();
		pnlTimTheoSoLanDatPhong.setBackground(new Color(204, 204, 255));
		pnlTimTheoSoLanDatPhong.setBorder(new TitledBorder(null, "S\u1ED1 l\u1EA7n \u0111\u1EB7t ph\u00F2ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTimTheoSoLanDatPhong.setBounds(350, 11, 280, 100);
		pnlTimKiem.add(pnlTimTheoSoLanDatPhong);
		pnlTimTheoSoLanDatPhong.setLayout(null);

		JLabel lblSoLanDatPhongTu = new JLabel("Từ:");
		lblSoLanDatPhongTu.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoLanDatPhongTu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoLanDatPhongTu.setBounds(21, 21, 40, 27);
		pnlTimTheoSoLanDatPhong.add(lblSoLanDatPhongTu);

		JLabel lblSoLanDatPhongDen = new JLabel("Đến:");
		lblSoLanDatPhongDen.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoLanDatPhongDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoLanDatPhongDen.setBounds(21, 60, 54, 27);
		pnlTimTheoSoLanDatPhong.add(lblSoLanDatPhongDen);

		txtSoLanDatPhongTu = new JTextField();
		txtSoLanDatPhongTu.setColumns(10);
		txtSoLanDatPhongTu.setBounds(71, 21, 178, 27);
		pnlTimTheoSoLanDatPhong.add(txtSoLanDatPhongTu);

		txtSoLanDatPhongDen = new JTextField();
		txtSoLanDatPhongDen.setColumns(10);
		txtSoLanDatPhongDen.setBounds(71, 59, 178, 27);
		pnlTimTheoSoLanDatPhong.add(txtSoLanDatPhongDen);

		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setBackground(new Color(255, 192, 203));
		pnlThongTin.setBounds(0, 1, 672, 519);
		pnlKhachHang.add(pnlThongTin);
		pnlThongTin.setLayout(null);

		lblMaKhachHang = new JLabel("Mã Khách Hàng :");
		lblMaKhachHang.setBounds(80, 106, 112, 25);
		pnlThongTin.add(lblMaKhachHang);
		lblMaKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtMaKH = new JTextField();
		txtMaKH.setDisabledTextColor(Color.BLACK);
		txtMaKH.setForeground(Color.BLACK);
		txtMaKH.setBackground(Color.WHITE);
		txtMaKH.setBounds(228, 105, 351, 27);
		pnlThongTin.add(txtMaKH);
		txtMaKH.setEnabled(false);
		txtMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaKH.setColumns(10);

		lblTenKhachHang = new JLabel("Tên Khách Hàng :");
		lblTenKhachHang.setBounds(80, 156, 112, 25);
		pnlThongTin.add(lblTenKhachHang);
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtTenKH = new JTextField();
		txtTenKH.setBounds(228, 155, 351, 27);
		pnlThongTin.add(txtTenKH);
		txtTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKH.setColumns(10);

		lblNamSinh = new JLabel("Năm Sinh :");
		lblNamSinh.setBounds(80, 206, 99, 25);
		pnlThongTin.add(lblNamSinh);
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtSDT = new JTextField();
		txtSDT.setBounds(228, 255, 351, 27);
		pnlThongTin.add(txtSDT);
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSDT.setColumns(10);

		lblSoDienThoai = new JLabel("Số Điện Thoại :");
		lblSoDienThoai.setBounds(80, 256, 99, 25);
		pnlThongTin.add(lblSoDienThoai);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtNamSinh = new JTextField();
		txtNamSinh.setBounds(228, 205, 351, 27);
		pnlThongTin.add(txtNamSinh);
		txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(80, 306, 59, 25);
		pnlThongTin.add(lblEmail);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtEmail = new JTextField();
		txtEmail.setBounds(228, 305, 351, 27);
		pnlThongTin.add(txtEmail);
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setColumns(10);

		lblKhachHang = new JLabel("Thông Tin Khách Hàng");
		lblKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblKhachHang.setBounds(0, 34, 672, 61);
		pnlThongTin.add(lblKhachHang);

		btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setBounds(425, 411, 120, 35);
		pnlThongTin.add(btnChinhSua);
		btnChinhSua.setFocusable(false);
//		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));

		btnThem = new JButton("Thêm");
		btnThem.setBounds(279, 411, 120, 35);
		pnlThongTin.add(btnThem);
//		btnThem.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconThem3.png")));
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtSLDatPhong = new JTextField();
		txtSLDatPhong.setBackground(Color.WHITE);
		txtSLDatPhong.setEditable(false);
		txtSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSLDatPhong.setColumns(10);
		txtSLDatPhong.setBounds(228, 355, 351, 27);
		pnlThongTin.add(txtSLDatPhong);

		lblSLDatPhong = new JLabel("Số lượng đặt phòng:");
		lblSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSLDatPhong.setBounds(80, 356, 129, 25);
		pnlThongTin.add(lblSLDatPhong);

		btnLamMoi = new JButton("Làm mới");
//		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(133, 411, 120, 35);
		pnlThongTin.add(btnLamMoi);

//		controller = new QuanLyKhachHangController(this);
//		btnThem.addActionListener(controller);
//		btnChinhSua.addActionListener(controller);
//		btnTimKiem.addActionListener(controller);
//		btnLamMoi.addActionListener(controller);
//		tblKhachHang.addMouseListener(controller);

	}

}
