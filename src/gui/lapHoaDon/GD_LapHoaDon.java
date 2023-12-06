package gui.lapHoaDon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.LapHoaDonController;
//import controller.LapHoaDonController;
//import dao.LapHoaDonDAO;
//import dao.QuanLyChiTietDichVuDAO;
//import dao.QuanLyChiTietHoaDonDAO;
//import dao.QuanLyDichVuDAO;
//import dao.QuanLyHoaDonDAO;
//import dao.QuanLyKhachHangDAO;
//import dao.QuanLyNhanVienDAO;
//import dao.QuanLyPhongDAO;
//import entities.ChiTietDichVuEntity;
import entities.ChiTietHoaDonEntity;
import entities.HoaDonEntity;
import util.DateFormatter;
import util.TimeFormatter;

public class GD_LapHoaDon extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txtTienDichVu;
	private JTextField txtTienTraKhach;
	private JTextField txtTienNhan;
	private JTextField txtSoLuongPhong;
	private JTextField txtTongTien;
	private JLabel lblNgayHienTai;
	private JLabel lblGioHienTai;
	private JPanel pnlChanTrang;
	private JLabel lblTongTien;
	private JLabel lblSoLuongPhong;
	private JLabel lblTienTraKhach;
	private JLabel lblTienNhan;
	private JLabel lblTienDichVu;
	private JLabel lblSoDienThoai;
	private JLabel lblTenKhachHang;
	private JPanel pnlChiTietLapHoaDon;
	private JScrollPane scrDSHoaDon;
	private JLabel lblChiTietLapHoaDon;

	private HoaDonEntity hoaDonEntity;
	private JPanel pnlTimKiem;
	private JLabel lblTimKiemTheoSDT;
	private JTextField textField;

	private JTable tblHoaDon;
	private DefaultTableModel tblmodelHoaDon;
	private JCheckBox chkXuatHoaDon;

	public JButton btnTimKiem;
	public JButton btnLamMoi;
	public JButton btnLapHoaDon;
	public JButton btnXemChiTiet;

//	private LapHoaDonController controller;
//	private List<HoaDonEntity> listHoaDon;
//	private List<ChiTietHoaDonEntity> listChiTietHoaDon;
//	private List<ChiTietDichVuEntity> listChiTietDichVu;
//	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
//	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
//	private LapHoaDonDAO lapHoaDonDAO = new LapHoaDonDAO();
//	private QuanLyChiTietHoaDonDAO quanLyChiTietHoaDonDAO = new QuanLyChiTietHoaDonDAO();
//	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
//	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();
//	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
//	private QuanLyChiTietDichVuDAO quanLyChiTietDichVuDAO = new QuanLyChiTietDichVuDAO();
//	private double tienTra = 0;

	public GD_LapHoaDon() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		JPanel pnlLapHoaDon = new JPanel();
		pnlLapHoaDon.setBounds(0, 0, 1365, 694);
		add(pnlLapHoaDon);
		pnlLapHoaDon.setLayout(null);

		JPanel pnlChinh = new JPanel();
		pnlChinh.setBackground(new Color(230, 230, 250));
		pnlChinh.setBounds(0, 0, 1365, 616);
		pnlLapHoaDon.add(pnlChinh);
		pnlChinh.setLayout(null);

		JPanel pnlDSHoaDon = new JPanel();
		pnlDSHoaDon.setBorder(null);
		pnlDSHoaDon.setBackground(new Color(230, 230, 250));
		pnlDSHoaDon.setBounds(0, 144, 672, 472);
		pnlChinh.add(pnlDSHoaDon);
		pnlDSHoaDon.setLayout(null);

		String[] cols_DSHoaDon = { "STT", "Tên khách hàng", "Số điện thoại khách hàng", "Số lượng phòng", "Tổng tiền" };
		tblmodelHoaDon = new DefaultTableModel(cols_DSHoaDon, 0);
		tblHoaDon = new JTable(tblmodelHoaDon);
		tblHoaDon.setAutoCreateRowSorter(true);
		scrDSHoaDon = new JScrollPane(tblHoaDon);
		scrDSHoaDon.setBounds(10, 10, 652, 451);
		pnlDSHoaDon.add(scrDSHoaDon);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblHoaDon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblHoaDon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblHoaDon.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

		pnlChiTietLapHoaDon = new JPanel();
		pnlChiTietLapHoaDon.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChiTietLapHoaDon.setBackground(new Color(230, 230, 250));
		pnlChiTietLapHoaDon.setBounds(672, 0, 694, 616);
		pnlChinh.add(pnlChiTietLapHoaDon);
		pnlChiTietLapHoaDon.setLayout(null);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(116, 129, 120, 25);
		pnlChiTietLapHoaDon.add(lblTenKhachHang);

		lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoDienThoai.setBounds(116, 179, 120, 25);
		pnlChiTietLapHoaDon.add(lblSoDienThoai);

		lblTienDichVu = new JLabel("Tiền dịch vụ:");
		lblTienDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienDichVu.setBounds(116, 279, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienDichVu);

		lblTienNhan = new JLabel("Tiền nhận:");
		lblTienNhan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienNhan.setBounds(116, 379, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienNhan);

		lblTienTraKhach = new JLabel("Tiền trả khách:");
		lblTienTraKhach.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTienTraKhach.setBounds(116, 429, 120, 25);
		pnlChiTietLapHoaDon.add(lblTienTraKhach);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBackground(Color.WHITE);
		txtTenKhachHang.setDisabledTextColor(Color.BLACK);
		txtTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(236, 129, 340, 25);
		pnlChiTietLapHoaDon.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBackground(Color.WHITE);
		txtSoDienThoai.setDisabledTextColor(Color.BLACK);
		txtSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtSoDienThoai.setBorder(null);
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(236, 179, 340, 25);
		pnlChiTietLapHoaDon.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		txtTienDichVu = new JTextField();
		txtTienDichVu.setBackground(Color.WHITE);
		txtTienDichVu.setDisabledTextColor(Color.BLACK);
		txtTienDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTienDichVu.setBorder(null);
		txtTienDichVu.setEditable(false);
		txtTienDichVu.setBounds(236, 279, 340, 25);
		pnlChiTietLapHoaDon.add(txtTienDichVu);
		txtTienDichVu.setColumns(10);

		txtTienTraKhach = new JTextField();
		txtTienTraKhach.setBackground(Color.WHITE);
		txtTienTraKhach.setDisabledTextColor(Color.BLACK);
		txtTienTraKhach.setEnabled(false);
		txtTienTraKhach.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTienTraKhach.setBorder(null);
		txtTienTraKhach.setBounds(236, 429, 340, 25);
		pnlChiTietLapHoaDon.add(txtTienTraKhach);
		txtTienTraKhach.setColumns(10);

		txtTienNhan = new JTextField();
		txtTienNhan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTienNhan.setBounds(236, 379, 340, 25);
		pnlChiTietLapHoaDon.add(txtTienNhan);
		txtTienNhan.setColumns(10);

		lblSoLuongPhong = new JLabel("Số lượng phòng:");
		lblSoLuongPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoLuongPhong.setBounds(116, 229, 120, 25);
		pnlChiTietLapHoaDon.add(lblSoLuongPhong);

		txtSoLuongPhong = new JTextField();
		txtSoLuongPhong.setBackground(Color.WHITE);
		txtSoLuongPhong.setDisabledTextColor(Color.BLACK);
		txtSoLuongPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtSoLuongPhong.setBorder(null);
		txtSoLuongPhong.setEditable(false);
		txtSoLuongPhong.setBounds(236, 229, 340, 25);
		pnlChiTietLapHoaDon.add(txtSoLuongPhong);
		txtSoLuongPhong.setColumns(10);

		lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTongTien.setBounds(116, 329, 120, 25);
		pnlChiTietLapHoaDon.add(lblTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setBackground(Color.WHITE);
		txtTongTien.setDisabledTextColor(Color.BLACK);
		txtTongTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtTongTien.setBorder(null);
		txtTongTien.setEditable(false);
		txtTongTien.setBounds(236, 329, 340, 25);
		pnlChiTietLapHoaDon.add(txtTongTien);
		txtTongTien.setColumns(10);

		btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconTick.png")));
		btnLapHoaDon.setMnemonic(KeyEvent.VK_ENTER);
		btnLapHoaDon.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLapHoaDon.setBackground(new Color(255, 128, 128));
		btnLapHoaDon.setFocusable(false);
		btnLapHoaDon.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLapHoaDon.setBounds(450, 550, 195, 39);
		pnlChiTietLapHoaDon.add(btnLapHoaDon);

		chkXuatHoaDon = new JCheckBox("Xuất hóa đơn");
		chkXuatHoaDon.setBackground(new Color(230, 230, 250));
		chkXuatHoaDon.setFocusable(false);
		chkXuatHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		chkXuatHoaDon.setBounds(330, 559, 97, 25);
		pnlChiTietLapHoaDon.add(chkXuatHoaDon);

		lblChiTietLapHoaDon = new JLabel("Chi tiết Lập Hóa Đơn");
		lblChiTietLapHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblChiTietLapHoaDon.setBounds(0, 40, 694, 50);
		pnlChiTietLapHoaDon.add(lblChiTietLapHoaDon);

		btnXemChiTiet = new JButton("Xem chi tiết hóa đơn");
		btnXemChiTiet.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconMatMo.png")));
		btnXemChiTiet.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXemChiTiet.setFocusable(false);
		btnXemChiTiet.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXemChiTiet.setBackground(new Color(144, 238, 144));
		btnXemChiTiet.setBounds(450, 482, 195, 39);
		pnlChiTietLapHoaDon.add(btnXemChiTiet);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setLayout(null);
		pnlTimKiem.setBorder(null);
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 0, 672, 144);
		pnlChinh.add(pnlTimKiem);

		lblTimKiemTheoSDT = new JLabel("SĐT Khách hàng:");
		lblTimKiemTheoSDT.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoSDT.setBounds(80, 30, 120, 30);
		pnlTimKiem.add(lblTimKiemTheoSDT);

		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(210, 30, 382, 30);
		pnlTimKiem.add(textField);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setBounds(442, 80, 150, 35);
		pnlTimKiem.add(btnTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(249, 80, 150, 35);
		pnlTimKiem.add(btnLamMoi);

		pnlChanTrang = new JPanel();
		pnlChanTrang.setBorder(null);
		pnlChanTrang.setBackground(new Color(230, 230, 250));
		pnlChanTrang.setBounds(0, 616, 1365, 78);
		pnlLapHoaDon.add(pnlChanTrang);
		pnlChanTrang.setLayout(null);

		lblGioHienTai = new JLabel("16:06");
		lblGioHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioHienTai.setBounds(1282, 17, 53, 30);
		Timer gioHT = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblGioHienTai.setText(TimeFormatter.format(LocalTime.now()));
			}
		});
		gioHT.start();
		pnlChanTrang.add(lblGioHienTai);

		lblNgayHienTai = new JLabel("28/06/2023");
		lblNgayHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayHienTai.setBounds(1241, 37, 94, 30);
		Timer ngayHT = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblNgayHienTai.setText(DateFormatter.format(LocalDate.now()));
			}
		});
		ngayHT.start();
		pnlChanTrang.add(lblNgayHienTai);
		txtTienNhan.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
//				tinhTienTraKhach();
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		LapHoaDonController controller = new LapHoaDonController(this);
		btnLamMoi.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		btnXemChiTiet.addActionListener(controller);
		btnLapHoaDon.addActionListener(controller);
		tblHoaDon.addMouseListener(controller);

	}

	public void hienThiThongTin() {

	}

	public void chonLamMoi() {

	}

	public void chonTimKiem() {

	}

	public void chonXemChiTiet() {

	}

	public void chonLapHoaDon() {

	}
}
