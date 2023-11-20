package gui.khachHang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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

import controller.QuanLyKhachHangController;
import entities.KhachHangEntity;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	// JScrollPane
	private JScrollPane scrKhachHang;
	private DefaultTableModel tblmdelKhachHang;
	private List<KhachHangEntity> list;
	private JTextField txtSLDatPhong;
	private JLabel lblSLDatPhong;
	private JTextField txtTenKhachHang;
	private JLabel lblDanhSchKhch;
	private JTextField txtSoLanDatPhongTu;
	private JTextField txtSoLanDatPhongDen;

	public JButton btnChinhSua;
	public JButton btnTimKiem;
	public JButton btnThem;
	public JButton btnLamMoi;

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
		pnlChucNang.setBackground(new Color(230, 230, 250));
		pnlChucNang.setBounds(0, 370, 1365, 324);
		pnlKhachHang.add(pnlChucNang);
		pnlChucNang.setLayout(null);

		String[] cols_KhachHang = { "STT", "Mã Khách Hàng", "Tên khách hàng", "Số điện thoại", "Email", "Năm Sinh",
				"Số Lượng Đặt Phòng" };
		tblmdelKhachHang = new DefaultTableModel(cols_KhachHang, 0);
		tblKhachHang = new JTable(tblmdelKhachHang);
		scrKhachHang = new JScrollPane(tblKhachHang);
		scrKhachHang.setBounds(30, 58, 1305, 256);
		pnlChucNang.add(scrKhachHang);

		lblDanhSchKhch = new JLabel("Danh sách khách hàng");
		lblDanhSchKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchKhch.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSchKhch.setBounds(0, 10, 1365, 40);
		pnlChucNang.add(lblDanhSchKhch);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiem.setBounds(0, 0, 1365, 137);
		pnlKhachHang.add(pnlTimKiem);
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setLayout(null);

		lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setBounds(380, 30, 110, 30);
		pnlTimKiem.add(lblSDT);
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBounds(1185, 85, 150, 35);
		pnlTimKiem.add(btnTimKiem);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(480, 30, 200, 30);
		pnlTimKiem.add(txtSoDienThoai);

		lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenKH.setBounds(30, 30, 110, 30);
		pnlTimKiem.add(lblTenKH);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(140, 30, 200, 30);
		pnlTimKiem.add(txtTenKhachHang);

		JPanel pnlTimTheoSoLanDatPhong = new JPanel();
		pnlTimTheoSoLanDatPhong.setBackground(new Color(230, 230, 250));
		pnlTimTheoSoLanDatPhong.setBorder(new TitledBorder(null, "S\u1ED1 l\u1EA7n \u0111\u1EB7t ph\u00F2ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTimTheoSoLanDatPhong.setBounds(725, 15, 610, 60);
		pnlTimKiem.add(pnlTimTheoSoLanDatPhong);
		pnlTimTheoSoLanDatPhong.setLayout(null);

		JLabel lblSoLanDatPhongTu = new JLabel("Từ:");
		lblSoLanDatPhongTu.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoLanDatPhongTu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoLanDatPhongTu.setBounds(21, 20, 40, 30);
		pnlTimTheoSoLanDatPhong.add(lblSoLanDatPhongTu);

		JLabel lblSoLanDatPhongDen = new JLabel("Đến:");
		lblSoLanDatPhongDen.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoLanDatPhongDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSoLanDatPhongDen.setBounds(300, 19, 54, 30);
		pnlTimTheoSoLanDatPhong.add(lblSoLanDatPhongDen);

		txtSoLanDatPhongTu = new JTextField();
		txtSoLanDatPhongTu.setColumns(10);
		txtSoLanDatPhongTu.setBounds(60, 20, 200, 30);
		pnlTimTheoSoLanDatPhong.add(txtSoLanDatPhongTu);

		txtSoLanDatPhongDen = new JTextField();
		txtSoLanDatPhongDen.setColumns(10);
		txtSoLanDatPhongDen.setBounds(350, 20, 200, 30);
		pnlTimTheoSoLanDatPhong.add(txtSoLanDatPhongDen);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setBounds(1000, 85, 150, 35);
		pnlTimKiem.add(btnLamMoi);
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));

		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setBorder(null);
		pnlThongTin.setBackground(new Color(230, 230, 250));
		pnlThongTin.setBounds(0, 137, 1365, 233);
		pnlKhachHang.add(pnlThongTin);
		pnlThongTin.setLayout(null);

		lblMaKhachHang = new JLabel("Mã Khách Hàng:");
		lblMaKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaKhachHang.setBounds(27, 70, 112, 30);
		pnlThongTin.add(lblMaKhachHang);
		lblMaKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtMaKH = new JTextField();
		txtMaKH.setDisabledTextColor(Color.BLACK);
		txtMaKH.setForeground(Color.BLACK);
		txtMaKH.setBackground(Color.WHITE);
		txtMaKH.setBounds(150, 70, 290, 30);
		pnlThongTin.add(txtMaKH);
		txtMaKH.setEnabled(false);
		txtMaKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaKH.setColumns(10);

		lblTenKhachHang = new JLabel("Tên Khách Hàng:");
		lblTenKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenKhachHang.setBounds(466, 70, 112, 30);
		pnlThongTin.add(lblTenKhachHang);
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtTenKH = new JTextField();
		txtTenKH.setBounds(585, 70, 290, 30);
		pnlThongTin.add(txtTenKH);
		txtTenKH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenKH.setColumns(10);

		lblNamSinh = new JLabel("Năm Sinh:");
		lblNamSinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNamSinh.setBounds(40, 120, 99, 30);
		pnlThongTin.add(lblNamSinh);
		lblNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtSDT = new JTextField();
		txtSDT.setBounds(585, 120, 290, 30);
		pnlThongTin.add(txtSDT);
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSDT.setColumns(10);

		lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai.setBounds(479, 120, 99, 30);
		pnlThongTin.add(lblSoDienThoai);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtNamSinh = new JTextField();
		txtNamSinh.setBounds(150, 120, 290, 30);
		pnlThongTin.add(txtNamSinh);
		txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNamSinh.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(978, 120, 59, 30);
		pnlThongTin.add(lblEmail);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtEmail = new JTextField();
		txtEmail.setBounds(1045, 120, 290, 30);
		pnlThongTin.add(txtEmail);
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setColumns(10);

		lblKhachHang = new JLabel("Thông Tin Khách Hàng");
		lblKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhachHang.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblKhachHang.setBounds(0, 0, 1365, 60);
		pnlThongTin.add(lblKhachHang);

		btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setBounds(1185, 170, 150, 35);
		pnlThongTin.add(btnChinhSua);
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_QuanLyKhachHang.class.getResource("/images/iconThem.png")));
		btnThem.setBounds(1000, 170, 150, 35);
		pnlThongTin.add(btnThem);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Cambria", Font.BOLD, 14));

		txtSLDatPhong = new JTextField();
		txtSLDatPhong.setBackground(Color.WHITE);
		txtSLDatPhong.setEditable(false);
		txtSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSLDatPhong.setColumns(10);
		txtSLDatPhong.setBounds(1045, 70, 290, 30);
		pnlThongTin.add(txtSLDatPhong);

		lblSLDatPhong = new JLabel("Số lần đặt phòng:");
		lblSLDatPhong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSLDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSLDatPhong.setBounds(897, 70, 140, 30);
		pnlThongTin.add(lblSLDatPhong);

		QuanLyKhachHangController controller = new QuanLyKhachHangController(this);
		btnThem.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		btnLamMoi.addActionListener(controller);
		tblKhachHang.addMouseListener(controller);

	}

	public void hienThiThongTin() {

	}

	public void chonLamMoi() {

	}

	public void chonTimKiem() {

	}

	public void chonThem() {

	}

	public void chonChinhSua() {

	}
}
