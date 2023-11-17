package gui.datDichVu;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

//import controller.DatDichVuController;
//import dao.DatDichVuDAO;
//import dao.QuanLyDichVuDAO;
//import dao.QuanLyPhongDAO;
import entities.DichVuEntity;
import entities.PhongEntity;
public class GD_DatDichVu extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */

	private JPanel pnlChiTietDatDichVu;
	private JPanel pnlThongTinDichVu;
	private JPanel pnlTimKiem;
	private JPanel pnlDanhSachDichVu;

	private JTextField txtTimKiemTheoTenDichVu;
	private JTextField txtGiaDichVuToiThieu;
	private JTextField txtGiaDichVuToiDa;
	private JTextField txtTenDichVu;
	private JTextField txtGiaDichVu;
	private JTextField txtNhapSoLuong;
	private JTextField txtTenKhachHang;
	private JTextField txtThanhTien;

	private JLabel lblTimTheoLoaiDichVu;
	private JLabel lblThanhTien;
	private JLabel lblTenKhachHang;
	private JLabel lblChiTietDatDichVu;
	private JLabel lblNhapSoLuong;
	private JLabel lblGiaTien;
	private JLabel lblLoaiDichVu;
	private JLabel lblTenDichVu;
	private JLabel lblGiaDichVuDen;
	private JLabel lblTimKiemTheoGiaDichVu;
	private JLabel lblTimTheoTenDichVu;
	private JLabel lblChonPhong;

	private JScrollPane scrChiTietDatDichVu;
	private JScrollPane scrDichVu;

	private JTable tblDichVu;
	private JTable tblChiTietDatDichVu;
	private DefaultTableModel tblmodelDichVu;
	private DefaultTableModel tblmodelChiTietDatDichVu;

	public JComboBox<String> cmbChonPhong;
	private JComboBox<String> cmbTimLoaiDichVu;
	private JComboBox<String> cmbLoaiDichVu;
	private DefaultComboBoxModel<String> cmbmodelChonPhong;
	private DefaultComboBoxModel<String> cmbmodelTimLoaiDichVu;
	private DefaultComboBoxModel<String> cmbmodelLoaiDichVu;

	public JButton btnTimKiem;
	public JButton btnDat;
	public JButton btnXoaDaChon;
	public JButton btnChinhSua;
	public JButton btnXoaTatCa;
	public JButton btnThem;
	public JButton btnLamMoi;

	private List<DichVuEntity> listDichVu;
	private List<PhongEntity> listPhong;

//	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
//	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();
//	private DatDichVuDAO datDichVuDAO = new DatDichVuDAO();
//	private DatDichVuController controller;
	private PhongEntity phongEntity;

	public GD_DatDichVu() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		JPanel panel_DatDichVu = new JPanel();
		panel_DatDichVu.setBounds(0, 0, 1365, 694);
		add(panel_DatDichVu);
		panel_DatDichVu.setLayout(null);

		JPanel panel_DichVu = new JPanel();
		panel_DichVu.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel_DichVu.setBackground(Color.WHITE);
		panel_DichVu.setBounds(0, 0, 672, 694);
		panel_DatDichVu.add(panel_DichVu);
		panel_DichVu.setLayout(null);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(null);
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(0, 0, 672, 195);
		panel_DichVu.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimTheoTenDichVu = new JLabel("Tên dịch vụ:");
		lblTimTheoTenDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimTheoTenDichVu.setBounds(345, 30, 80, 25);
		pnlTimKiem.add(lblTimTheoTenDichVu);

		lblTimKiemTheoGiaDichVu = new JLabel("Giá dịch vụ:");
		lblTimKiemTheoGiaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimKiemTheoGiaDichVu.setBounds(30, 30, 76, 25);
		pnlTimKiem.add(lblTimKiemTheoGiaDichVu);

		txtTimKiemTheoTenDichVu = new JTextField();
		txtTimKiemTheoTenDichVu.setBounds(442, 30, 200, 30);
		pnlTimKiem.add(txtTimKiemTheoTenDichVu);
		txtTimKiemTheoTenDichVu.setColumns(10);

		txtGiaDichVuToiThieu = new JTextField();
		txtGiaDichVuToiThieu.setBounds(130, 30, 200, 30);
		pnlTimKiem.add(txtGiaDichVuToiThieu);
		txtGiaDichVuToiThieu.setColumns(10);

		lblGiaDichVuDen = new JLabel("Đến:");
		lblGiaDichVuDen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiaDichVuDen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGiaDichVuDen.setBounds(30, 80, 76, 25);
		pnlTimKiem.add(lblGiaDichVuDen);

		txtGiaDichVuToiDa = new JTextField();
		txtGiaDichVuToiDa.setBounds(130, 80, 200, 30);
		pnlTimKiem.add(txtGiaDichVuToiDa);
		txtGiaDichVuToiDa.setColumns(10);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
//		btnTimKiem.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiem.setBackground(new Color(144, 238, 144));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnTimKiem.setBounds(522, 130, 120, 35);
		pnlTimKiem.add(btnTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBackground(new Color(144, 238, 144));
//		btnLamMoi.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(371, 130, 120, 35);
		pnlTimKiem.add(btnLamMoi);

		lblTimTheoLoaiDichVu = new JLabel("Loại dịch vụ:");
		lblTimTheoLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTimTheoLoaiDichVu.setBounds(345, 80, 93, 25);
		pnlTimKiem.add(lblTimTheoLoaiDichVu);

		cmbmodelTimLoaiDichVu = new DefaultComboBoxModel<>(new String[] { "Tất cả", "Đồ uống", "Món ăn", "Tiệc" });
		cmbTimLoaiDichVu = new JComboBox<String>(cmbmodelTimLoaiDichVu);
		cmbTimLoaiDichVu.setBounds(442, 80, 200, 30);
		pnlTimKiem.add(cmbTimLoaiDichVu);

		pnlDanhSachDichVu = new JPanel();
		pnlDanhSachDichVu.setBorder(null);
		pnlDanhSachDichVu.setBackground(new Color(250, 240, 230));
		pnlDanhSachDichVu.setBounds(0, 195, 672, 318);
		panel_DichVu.add(pnlDanhSachDichVu);
		pnlDanhSachDichVu.setLayout(null);

		String[] cols_DichVu = { "STT", "Mã dịch vụ", "Tên dịch vụ", "Loại dịch vụ", "Giá" };
		tblmodelDichVu = new DefaultTableModel(cols_DichVu, 0);
		tblDichVu = new JTable(tblmodelDichVu);
		scrDichVu = new JScrollPane(tblDichVu);
		scrDichVu.setBounds(10, 10, 652, 292);
		pnlDanhSachDichVu.add(scrDichVu);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblDichVu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblDichVu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblDichVu.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

		pnlThongTinDichVu = new JPanel();
		pnlThongTinDichVu.setBorder(null);
		pnlThongTinDichVu.setBackground(new Color(204, 204, 255));
		pnlThongTinDichVu.setBounds(0, 513, 672, 181);
		panel_DichVu.add(pnlThongTinDichVu);
		pnlThongTinDichVu.setLayout(null);

		lblTenDichVu = new JLabel("Tên dịch vụ:");
		lblTenDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenDichVu.setBounds(30, 30, 86, 30);
		pnlThongTinDichVu.add(lblTenDichVu);

		txtTenDichVu = new JTextField();
		txtTenDichVu.setBackground(new Color(255, 255, 255));
		txtTenDichVu.setBorder(null);
		txtTenDichVu.setEditable(false);
		txtTenDichVu.setBounds(116, 30, 200, 30);
		pnlThongTinDichVu.add(txtTenDichVu);
		txtTenDichVu.setColumns(10);

		lblLoaiDichVu = new JLabel("Loại dịch vụ:");
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu.setBounds(357, 30, 86, 30);
		pnlThongTinDichVu.add(lblLoaiDichVu);

		lblGiaTien = new JLabel("Giá dịch vụ:");
		lblGiaTien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGiaTien.setBounds(30, 80, 80, 30);
		pnlThongTinDichVu.add(lblGiaTien);

		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setBackground(new Color(255, 255, 255));
		txtGiaDichVu.setBorder(null);
		txtGiaDichVu.setEditable(false);
		txtGiaDichVu.setBounds(116, 80, 200, 30);
		pnlThongTinDichVu.add(txtGiaDichVu);
		txtGiaDichVu.setColumns(10);

		lblNhapSoLuong = new JLabel("Nhập số lượng:");
		lblNhapSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNhapSoLuong.setBounds(357, 80, 110, 30);
		pnlThongTinDichVu.add(lblNhapSoLuong);

		txtNhapSoLuong = new JTextField();
		txtNhapSoLuong.setBounds(466, 80, 175, 30);
		pnlThongTinDichVu.add(txtNhapSoLuong);
		txtNhapSoLuong.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnThem.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
//		btnThem.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconThem3.png")));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThem.setBounds(521, 130, 120, 35);
		pnlThongTinDichVu.add(btnThem);

		cmbmodelLoaiDichVu = new DefaultComboBoxModel<>(new String[] { " ", "Đồ uống", "Món ăn", "Tiệc" });
		cmbLoaiDichVu = new JComboBox<String>(cmbmodelLoaiDichVu);
		cmbLoaiDichVu.setBounds(442, 30, 200, 30);
		pnlThongTinDichVu.add(cmbLoaiDichVu);

		pnlChiTietDatDichVu = new JPanel();
		pnlChiTietDatDichVu.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChiTietDatDichVu.setBackground(new Color(255, 192, 203));
		pnlChiTietDatDichVu.setBounds(672, 0, 694, 694);
		panel_DatDichVu.add(pnlChiTietDatDichVu);
		pnlChiTietDatDichVu.setLayout(null);

		lblChiTietDatDichVu = new JLabel("Chi Tiết Đặt Dịch Vụ");
		lblChiTietDatDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDatDichVu.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblChiTietDatDichVu.setBounds(0, 40, 694, 50);
		pnlChiTietDatDichVu.add(lblChiTietDatDichVu);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(344, 101, 120, 30);
		pnlChiTietDatDichVu.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setDisabledTextColor(Color.BLACK);
		txtTenKhachHang.setEnabled(false);
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setBounds(464, 101, 200, 30);
		pnlChiTietDatDichVu.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		lblThanhTien = new JLabel("Thành tiền:");
		lblThanhTien.setHorizontalAlignment(SwingConstants.LEFT);
		lblThanhTien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblThanhTien.setBounds(30, 155, 105, 30);
		pnlChiTietDatDichVu.add(lblThanhTien);

		txtThanhTien = new JTextField();
		txtThanhTien.setDisabledTextColor(Color.BLACK);
		txtThanhTien.setEnabled(false);
		txtThanhTien.setBorder(null);
		txtThanhTien.setBounds(134, 155, 200, 30);
		pnlChiTietDatDichVu.add(txtThanhTien);
		txtThanhTien.setColumns(10);

		String[] cols_ChiTietDat = { "STT", "Mã dịch vụ", "Tên dịch vụ", "Loại dịch vụ", "Số lượng", "Thành tiền" };
		tblmodelChiTietDatDichVu = new DefaultTableModel(cols_ChiTietDat, 0);
		tblChiTietDatDichVu = new JTable(tblmodelChiTietDatDichVu);
		scrChiTietDatDichVu = new JScrollPane(tblChiTietDatDichVu);
		scrChiTietDatDichVu.setBounds(10, 210, 674, 373);
		pnlChiTietDatDichVu.add(scrChiTietDatDichVu);

		tblChiTietDatDichVu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblChiTietDatDichVu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		tblChiTietDatDichVu.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

		btnXoaTatCa = new JButton("Xóa toàn bộ");
		btnXoaTatCa.setFocusable(false);
		btnXoaTatCa.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaTatCa.setBackground(new Color(144, 238, 144));
//		btnXoaTatCa.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconXoa3.png")));
		btnXoaTatCa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnXoaTatCa.setBounds(360, 621, 135, 33);
		pnlChiTietDatDichVu.add(btnXoaTatCa);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//		btnChinhSua.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setBounds(30, 621, 135, 33);
		pnlChiTietDatDichVu.add(btnChinhSua);

		btnXoaDaChon = new JButton("Xóa đã chọn");
		btnXoaDaChon.setFocusable(false);
		btnXoaDaChon.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaDaChon.setBackground(new Color(144, 238, 144));
		btnXoaDaChon.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//		btnXoaDaChon.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconHuy2.png")));
		btnXoaDaChon.setBounds(195, 621, 135, 33);
		pnlChiTietDatDichVu.add(btnXoaDaChon);

		btnDat = new JButton("Đặt dịch vụ");
		btnDat.setFocusable(false);
		btnDat.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDat.setBackground(new Color(144, 238, 144));
		btnDat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//		btnDat.setIcon(new ImageIcon(GD_DatDichVu.class.getResource("/images/iconChon1.png")));
		btnDat.setBounds(525, 621, 135, 33);
		pnlChiTietDatDichVu.add(btnDat);

		lblChonPhong = new JLabel("Chọn phòng:");
		lblChonPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblChonPhong.setBounds(30, 101, 93, 30);
		pnlChiTietDatDichVu.add(lblChonPhong);

		cmbmodelChonPhong = new DefaultComboBoxModel<>();
		cmbChonPhong = new JComboBox<String>(cmbmodelChonPhong);
		cmbChonPhong.setBounds(134, 101, 200, 30);
		pnlChiTietDatDichVu.add(cmbChonPhong);

//		controller = new DatDichVuController(this);
//		btnTimKiem.addActionListener(controller);
//		btnThem.addActionListener(controller);
//		btnXoaTatCa.addActionListener(controller);
//		btnXoaDaChon.addActionListener(controller);
//		btnChinhSua.addActionListener(controller);
//		btnDat.addActionListener(controller);
//		btnLamMoi.addActionListener(controller);
//		tblChiTietDatDichVu.addMouseListener(controller);
//		tblDichVu.addMouseListener(controller);
//		cmbChonPhong.addItemListener(controller);
	}

}
