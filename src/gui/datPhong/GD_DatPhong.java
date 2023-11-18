package gui.datPhong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalTime;
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
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

//import controller.DatPhongController;
//import dao.DatPhongDAO;
//import dao.QuanLyChiTietHoaDonDAO;
//import dao.QuanLyHoaDonDAO;
//import dao.QuanLyKhachHangDAO;
//import dao.QuanLyPhongDAO;
import entities.KhachHangEntity;
import entities.NhanVienEntity;
import entities.PhongEntity;
import util.DateFormatter;
import util.TimeFormatter;

public class GD_DatPhong extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */

	private JLabel lblSucChua;
	private JLabel lblImgTrangThaiPhong;
	private JLabel lblVIP;
	private JLabel lblChuThichPhongVIP;
	private JLabel lblImgChuThichPhongVIP;
	private JLabel lblChuThichPhongDangSuDung;
	private JLabel lblImgChuThichPhongDangSuDung;
	private JLabel lblChuThichPhongCho;
	private JLabel lblImgChuThichPhongCho;
	private JLabel lblChuThichPhongTrong;
	private JLabel lblImgChuThichPhongTrong;
	private JLabel lblTenKhachHang;
	private JLabel lblSDTKhachHang;
	private JLabel lblLoaiPhong;
	private JLabel lblSoPhong;
	private JLabel lblChiTietDatPhong;
	private JLabel lblTimKiemTheoSucChua;
	private JLabel lblTimKiemTheoSoPhong;
	private JLabel lblTimKiemTheoLoaiPhong;
	private JLabel lblTimKiemTheoTrangThai;
	private JLabel lblPhutTraPhong;
	private JLabel lblGioTraPhong;
	public JLabel lblGioHienTai;
	public JLabel lblNgayHienTai;

	private JPanel pnlChanTrang;
	private JPanel pnlChiTietDatPhong;
	private JPanel pnlDSPhong;
	private JPanel pnlTimKiem;
	private JPanel pnlDSTatCaPhong;
	private JPanel pnlPhongDaChon;
	private JPanel pnlGioNhanPhong;
	private JPanel pnlGioTraPhong;

	private JTextField txtTimKiemTheoSoPhong;
	private JTextField txtSoPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtSucChua;
	private JTextField txtTenKhachHang;
	private JTextField txtSDTKhachHang;

	private JComboBox<String> cmbTimKiemTheoTrangThai;
	private JComboBox<String> cmbTimKiemTheoLoaiPhong;
	private JComboBox<String> cmbTimKiemTheoSucChua;
	private JComboBox<Integer> cmbGioNhanPhong;
	private JComboBox<Integer> cmbPhutNhanPhong;
	private JComboBox<Integer> cmbGioTraPhong;
	private JComboBox<Integer> cmbPhutTraPhong;
	private DefaultComboBoxModel<String> cmbmodelTrangThai;
	private DefaultComboBoxModel<String> cmbmodelLoaiPhong;
	private DefaultComboBoxModel<String> cmbmodelSucChua;
	private DefaultComboBoxModel<Integer> cmbmodelGioNhanPhong;
	private DefaultComboBoxModel<Integer> cmbmodelPhutNhanPhong;
	private DefaultComboBoxModel<Integer> cmbmodelGioTraPhong;
	private DefaultComboBoxModel<Integer> cmbmodelPhutTraPhong;

	private ButtonGroup grpDatPhong;
	public JRadioButton radDatPhongNgay;
	public JRadioButton radDatPhongTruoc;

	private Timer ngayHT;
	private Timer gioHT;

	public JButton btnTimKiemPhong;
	public JButton btnLamMoi;
	public JButton btnTimKiemKhachHang;
	public JButton btnDatPhong;
	public JButton btnDoiPhong;
	public JButton btnXoaPhongDaChon;
	public JButton btnChonPhong;
	public JButton btnHuyPhongDatTruoc;

	private JScrollPane scrDSPhong;
	private JScrollPane scrDSPhongDaChon;

	public JTable tblPhong;
	public JTable tblPhongDaChon;
	private DefaultTableModel tblmodelPhong;
	private DefaultTableModel tblmodelPhongDaChon;

//	private DatPhongController controller;

	private List<PhongEntity> listPhong;
	private List<KhachHangEntity> listKhachHang;

//	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
//	private QuanLyKhachHangDAO quanLyKhachHangDAO = new QuanLyKhachHangDAO();
//	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();
//	private QuanLyChiTietHoaDonDAO quanLyChiTietHoaDonDAO = new QuanLyChiTietHoaDonDAO();
//	private DatPhongDAO datPhongDAO = new DatPhongDAO();

	private NhanVienEntity nhanVienEntity;
	private KhachHangEntity khachHangEntity;

	private String maPhongCu = null;
	private String maPhongMoi = null;
	private JButton btnNhanPhong;

	public GD_DatPhong(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setLayout(null);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, (int) screen.getWidth(), (int) screen.getHeight());

		JPanel pnlDatPhong = new JPanel();
		pnlDatPhong.setBounds(0, 0, 1365, 694);
		add(pnlDatPhong);
		pnlDatPhong.setLayout(null);

		JPanel pnlChinh = new JPanel();
		pnlChinh.setBounds(0, 0, 672, 618);
		pnlDatPhong.add(pnlChinh);
		pnlChinh.setLayout(null);

		JPanel panel_NoiDung = new JPanel();
		panel_NoiDung.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel_NoiDung.setBackground(Color.WHITE);
		panel_NoiDung.setBounds(0, 0, 672, 618);
		pnlChinh.add(panel_NoiDung);
		panel_NoiDung.setLayout(null);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(null);
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(0, 0, 672, 163);
		panel_NoiDung.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblTimKiemTheoTrangThai = new JLabel("Trạng thái:");
		lblTimKiemTheoTrangThai.setSize(new Dimension(0, 35));
		lblTimKiemTheoTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTimKiemTheoTrangThai.setBounds(363, 20, 80, 30);
		pnlTimKiem.add(lblTimKiemTheoTrangThai);

		String[] itemTrangThai = { "Tất cả", "Trống", "Đặt trước", "Đang sử dụng" };
		cmbmodelTrangThai = new DefaultComboBoxModel<String>(itemTrangThai);
		cmbTimKiemTheoTrangThai = new JComboBox<String>(cmbmodelTrangThai);
		cmbTimKiemTheoTrangThai.setSize(new Dimension(0, 35));
		cmbTimKiemTheoTrangThai.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoTrangThai.setBounds(442, 21, 200, 30);
		pnlTimKiem.add(cmbTimKiemTheoTrangThai);

		lblTimKiemTheoLoaiPhong = new JLabel("Loại phòng:");
		lblTimKiemTheoLoaiPhong.setSize(new Dimension(0, 35));
		lblTimKiemTheoLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTimKiemTheoLoaiPhong.setBounds(30, 60, 80, 35);
		pnlTimKiem.add(lblTimKiemTheoLoaiPhong);

		String[] itemLoaiPhong = { "Tất cả", "Thường", "VIP" };
		cmbmodelLoaiPhong = new DefaultComboBoxModel<>(itemLoaiPhong);
		cmbTimKiemTheoLoaiPhong = new JComboBox<String>(cmbmodelLoaiPhong);
		cmbTimKiemTheoLoaiPhong.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoLoaiPhong.setSize(new Dimension(0, 35));
		cmbTimKiemTheoLoaiPhong.setBounds(110, 60, 200, 30);
		pnlTimKiem.add(cmbTimKiemTheoLoaiPhong);

		lblTimKiemTheoSoPhong = new JLabel("Số phòng:");
		lblTimKiemTheoSoPhong.setSize(new Dimension(0, 35));
		lblTimKiemTheoSoPhong.setForeground(Color.BLACK);
		lblTimKiemTheoSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTimKiemTheoSoPhong.setBounds(30, 20, 80, 30);
		pnlTimKiem.add(lblTimKiemTheoSoPhong);

		txtTimKiemTheoSoPhong = new JTextField();
		txtTimKiemTheoSoPhong.setSize(new Dimension(0, 35));
		txtTimKiemTheoSoPhong.setBounds(110, 20, 200, 30);
		pnlTimKiem.add(txtTimKiemTheoSoPhong);
		txtTimKiemTheoSoPhong.setColumns(10);

		btnTimKiemPhong = new JButton("Tìm kiếm");
		btnTimKiemPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiemPhong.setBackground(new Color(144, 238, 144));
		btnTimKiemPhong.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiemPhong.setFocusable(false);
//		btnTimKiemPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiemPhong.setBounds(522, 110, 120, 35);
		pnlTimKiem.add(btnTimKiemPhong);

		lblTimKiemTheoSucChua = new JLabel("Sức chứa:");
		lblTimKiemTheoSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTimKiemTheoSucChua.setBounds(363, 61, 80, 30);
		pnlTimKiem.add(lblTimKiemTheoSucChua);

		String[] itemSucChua = { "Tất cả", "10 người", "20 người" };
		cmbmodelSucChua = new DefaultComboBoxModel<>(itemSucChua);
		cmbTimKiemTheoSucChua = new JComboBox<String>(cmbmodelSucChua);
		cmbTimKiemTheoSucChua.setBackground(new Color(255, 250, 250));
		cmbTimKiemTheoSucChua.setBounds(442, 61, 200, 30);
		pnlTimKiem.add(cmbTimKiemTheoSucChua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setMnemonic(KeyEvent.VK_R);
		btnLamMoi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
//		btnLamMoi.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(373, 110, 120, 35);
		pnlTimKiem.add(btnLamMoi);

		pnlDSPhong = new JPanel();
		pnlDSPhong.setBorder(null);
		pnlDSPhong.setBackground(new Color(250, 240, 230));
		pnlDSPhong.setBounds(0, 163, 672, 455);
		panel_NoiDung.add(pnlDSPhong);
		pnlDSPhong.setLayout(null);

		pnlDSTatCaPhong = new JPanel();
		pnlDSTatCaPhong.setBorder(new TitledBorder(null, "Danh S\u00E1ch Ph\u00F2ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDSTatCaPhong.setBackground(new Color(250, 240, 230));
		pnlDSTatCaPhong.setBounds(167, 11, 495, 184);
		pnlDSPhong.add(pnlDSTatCaPhong);

		String[] cols = { "STT", "Mã phòng", "Số phòng", "Loại phòng", "Sức chứa", "Trạng thái" };
		tblmodelPhong = new DefaultTableModel(cols, 0);
		pnlDSTatCaPhong.setLayout(new BorderLayout(0, 0));
		tblPhong = new JTable(tblmodelPhong);
		tblPhong.setBorder(new CompoundBorder());
		scrDSPhong = new JScrollPane(tblPhong);
		scrDSPhong.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrDSPhong.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pnlDSTatCaPhong.add(scrDSPhong);
		scrDSPhong.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblPhong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		pnlPhongDaChon = new JPanel();
		pnlPhongDaChon.setBackground(new Color(250, 240, 230));
		pnlPhongDaChon.setBorder(new TitledBorder(null, "Ph\u00F2ng \u0111\u00E3 ch\u1ECDn", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlPhongDaChon.setBounds(167, 204, 495, 184);
		pnlDSPhong.add(pnlPhongDaChon);

		tblmodelPhongDaChon = new DefaultTableModel(cols, 0);
		pnlPhongDaChon.setLayout(new BorderLayout(0, 0));
		tblPhongDaChon = new JTable(tblmodelPhongDaChon);
		scrDSPhongDaChon = new JScrollPane(tblPhongDaChon);
		scrDSPhongDaChon.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrDSPhongDaChon.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		pnlPhongDaChon.add(scrDSPhongDaChon);

		tblPhongDaChon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhongDaChon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhongDaChon.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblPhongDaChon.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		JPanel pnlButtonChucNang = new JPanel();
		pnlButtonChucNang.setBorder(null);
		pnlButtonChucNang.setBackground(new Color(250, 240, 230));
		pnlButtonChucNang.setFocusable(false);
		pnlButtonChucNang.setBounds(10, 26, 147, 356);
		pnlDSPhong.add(pnlButtonChucNang);
		pnlButtonChucNang.setLayout(new GridLayout(7, 1, 10, 10));

		btnChonPhong = new JButton("Chọn phòng");
		pnlButtonChucNang.add(btnChonPhong);
//		btnChonPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconThem3.png")));
		btnChonPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChonPhong.setFocusable(false);
		btnChonPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnChonPhong.setBackground(new Color(144, 238, 144));

		btnNhanPhong = new JButton("Nhận phòng");
//		btnNhanPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconTick1.png")));
		btnNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnNhanPhong.setFocusable(false);
		btnNhanPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnNhanPhong.setBackground(new Color(144, 238, 144));
		pnlButtonChucNang.add(btnNhanPhong);

		btnDoiPhong = new JButton("Đổi phòng");
		pnlButtonChucNang.add(btnDoiPhong);
//		btnDoiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconDoi.png")));
		btnDoiPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDoiPhong.setFocusable(false);
		btnDoiPhong.setBackground(new Color(144, 238, 144));
		btnDoiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnXoaPhongDaChon = new JButton("Xóa đã chọn");
		pnlButtonChucNang.add(btnXoaPhongDaChon);
//		btnXoaPhongDaChon.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconXoa3.png")));
		btnXoaPhongDaChon.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnXoaPhongDaChon.setFocusable(false);
		btnXoaPhongDaChon.setBackground(new Color(144, 238, 144));
		btnXoaPhongDaChon.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnHuyPhongDatTruoc = new JButton("Hủy đặt trước");
		pnlButtonChucNang.add(btnHuyPhongDatTruoc);
//		btnHuyPhongDatTruoc.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconChon1.png")));
		btnHuyPhongDatTruoc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnHuyPhongDatTruoc.setFocusable(false);
		btnHuyPhongDatTruoc.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnHuyPhongDatTruoc.setBackground(new Color(144, 238, 144));

		Integer[] gioNhanPhong = new Integer[15];
		for (int i = 0; i <= 14; i++) {
			gioNhanPhong[i] = i + 8;
		}

		Integer[] phutNhanPhong = new Integer[60];
		for (int i = 0; i < 60; i++) {
			phutNhanPhong[i] = i;
		}

		Integer[] gioTraPhong = new Integer[15];
		for (int i = 0; i <= 14; i++) {
			gioTraPhong[i] = i + 9;
		}

		Integer[] phutTraPhong = new Integer[60];
		for (int i = 0; i < 60; i++) {
			phutTraPhong[i] = i;
		}

		pnlChiTietDatPhong = new JPanel();
		pnlChiTietDatPhong.setBounds(672, 0, 694, 618);
		pnlDatPhong.add(pnlChiTietDatPhong);
		pnlChiTietDatPhong.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChiTietDatPhong.setBackground(new Color(255, 192, 203));
		pnlChiTietDatPhong.setLayout(null);

		pnlGioNhanPhong = new JPanel();
		pnlGioNhanPhong.setBackground(new Color(255, 192, 203));
		pnlGioNhanPhong.setBorder(new TitledBorder(null, "Gi\u1EDD nh\u1EADn ph\u00F2ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlGioNhanPhong.setBounds(50, 396, 246, 96);
		pnlGioNhanPhong.setLayout(null);
		pnlChiTietDatPhong.add(pnlGioNhanPhong);

		cmbmodelGioNhanPhong = new DefaultComboBoxModel<>(gioNhanPhong);
		cmbGioNhanPhong = new JComboBox<Integer>(cmbmodelGioNhanPhong);
		cmbGioNhanPhong.setMaximumRowCount(4);
		cmbGioNhanPhong.setEnabled(false);
		cmbGioNhanPhong.setBounds(21, 18, 143, 25);
		pnlGioNhanPhong.add(cmbGioNhanPhong);

		cmbmodelPhutNhanPhong = new DefaultComboBoxModel<>(phutNhanPhong);
		cmbPhutNhanPhong = new JComboBox<Integer>(cmbmodelPhutNhanPhong);
		cmbPhutNhanPhong.setMaximumRowCount(4);
		cmbPhutNhanPhong.setEnabled(false);
		cmbPhutNhanPhong.setBounds(21, 60, 143, 25);
		pnlGioNhanPhong.add(cmbPhutNhanPhong);

		JLabel lblPhutNhanPhong = new JLabel("Phút");
		lblPhutNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhutNhanPhong.setBounds(185, 60, 40, 25);
		pnlGioNhanPhong.add(lblPhutNhanPhong);

		JLabel lblGioNhanPhong = new JLabel("Giờ");
		lblGioNhanPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioNhanPhong.setBounds(185, 18, 40, 25);
		pnlGioNhanPhong.add(lblGioNhanPhong);

		pnlGioTraPhong = new JPanel();
		pnlGioTraPhong.setLayout(null);
		pnlGioTraPhong.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Giờ trả phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlGioTraPhong.setBackground(new Color(255, 192, 203));
		pnlGioTraPhong.setBounds(363, 396, 246, 97);
		pnlChiTietDatPhong.add(pnlGioTraPhong);

		cmbmodelGioTraPhong = new DefaultComboBoxModel<>(gioTraPhong);
		cmbGioTraPhong = new JComboBox<Integer>(cmbmodelGioTraPhong);
		cmbGioTraPhong.setMaximumRowCount(4);
		cmbGioTraPhong.setBounds(23, 18, 144, 25);
		pnlGioTraPhong.add(cmbGioTraPhong);

		cmbmodelPhutTraPhong = new DefaultComboBoxModel<>(phutTraPhong);
		cmbPhutTraPhong = new JComboBox<Integer>(cmbmodelPhutTraPhong);
		cmbPhutTraPhong.setMaximumRowCount(4);
		cmbPhutTraPhong.setBounds(23, 60, 144, 25);
		pnlGioTraPhong.add(cmbPhutTraPhong);

		lblPhutTraPhong = new JLabel("Phút");
		lblPhutTraPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhutTraPhong.setBounds(177, 60, 40, 25);
		pnlGioTraPhong.add(lblPhutTraPhong);

		lblGioTraPhong = new JLabel("Giờ");
		lblGioTraPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGioTraPhong.setBounds(177, 18, 40, 25);
		pnlGioTraPhong.add(lblGioTraPhong);

		pnlChanTrang = new JPanel();
		pnlChanTrang.setBackground(new Color(211, 211, 211));
		pnlChanTrang.setBounds(0, 616, 1365, 78);
		pnlDatPhong.add(pnlChanTrang);
		pnlChanTrang.setLayout(null);

		lblImgChuThichPhongTrong = new JLabel("");
//		lblImgChuThichPhongTrong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongTrong.png")));
		lblImgChuThichPhongTrong.setBounds(70, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongTrong);

		lblChuThichPhongTrong = new JLabel("Phòng trống");
		lblChuThichPhongTrong.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongTrong.setBounds(57, 48, 67, 18);
		pnlChanTrang.add(lblChuThichPhongTrong);

		lblImgChuThichPhongCho = new JLabel("");
//		lblImgChuThichPhongCho.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongCho.png")));
		lblImgChuThichPhongCho.setBounds(195, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongCho);

		lblChuThichPhongCho = new JLabel("Phòng đặt trước");
		lblChuThichPhongCho.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongCho.setBounds(186, 48, 76, 18);
		pnlChanTrang.add(lblChuThichPhongCho);

		lblImgChuThichPhongDangSuDung = new JLabel("");
//		lblImgChuThichPhongDangSuDung
//				.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhongDangSuDung.png")));
		lblImgChuThichPhongDangSuDung.setBounds(320, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongDangSuDung);

		lblChuThichPhongDangSuDung = new JLabel("Phòng đang sử dụng");
		lblChuThichPhongDangSuDung.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongDangSuDung.setBounds(285, 48, 111, 18);
		pnlChanTrang.add(lblChuThichPhongDangSuDung);

		lblImgChuThichPhongVIP = new JLabel("");
//		lblImgChuThichPhongVIP.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconVuongMien1.png")));
		lblImgChuThichPhongVIP.setBounds(454, 7, 40, 40);
		pnlChanTrang.add(lblImgChuThichPhongVIP);

		lblChuThichPhongVIP = new JLabel("VIP");
		lblChuThichPhongVIP.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblChuThichPhongVIP.setBounds(466, 48, 17, 18);
		pnlChanTrang.add(lblChuThichPhongVIP);

		lblNgayHienTai = new JLabel("28/06/2023");
		lblNgayHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayHienTai.setBounds(1243, 36, 94, 30);
		ngayHT = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNgayHienTai.setText(DateFormatter.format(LocalDate.now()));
			}
		});
		ngayHT.start();
		pnlChanTrang.add(lblNgayHienTai);

		lblGioHienTai = new JLabel("16:06");
		lblGioHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioHienTai.setBounds(1264, 16, 53, 30);
		gioHT = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblGioHienTai.setText(TimeFormatter.format(LocalTime.now()));
			}
		});
		gioHT.start();
		pnlChanTrang.add(lblGioHienTai);

		lblVIP = new JLabel("");
//		lblVIP.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconVuongMien.png")));
		lblVIP.setBounds(506, 118, 60, 53);
		lblVIP.setVisible(false);
		pnlChiTietDatPhong.add(lblVIP);

		lblChiTietDatPhong = new JLabel("Chi tiết đặt phòng");
		lblChiTietDatPhong.setBounds(0, 57, 694, 50);
		lblChiTietDatPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDatPhong.setFont(new Font("Segoe UI", Font.BOLD, 22));
		pnlChiTietDatPhong.add(lblChiTietDatPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setBorder(null);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(200, 120, 200, 25);
		pnlChiTietDatPhong.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSoPhong.setBounds(50, 120, 110, 25);
		pnlChiTietDatPhong.add(lblSoPhong);

		lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(50, 170, 111, 25);
		pnlChiTietDatPhong.add(lblLoaiPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setBorder(null);
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setBounds(200, 170, 200, 25);
		pnlChiTietDatPhong.add(txtLoaiPhong);
		txtLoaiPhong.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSucChua.setBounds(51, 220, 110, 25);
		pnlChiTietDatPhong.add(lblSucChua);

		txtSucChua = new JTextField();
		txtSucChua.setBorder(null);
		txtSucChua.setEditable(false);
		txtSucChua.setBounds(200, 220, 200, 25);
		pnlChiTietDatPhong.add(txtSucChua);
		txtSucChua.setColumns(10);

		lblImgTrangThaiPhong = new JLabel("");
//		lblImgTrangThaiPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconPhong5.png")));
		lblImgTrangThaiPhong.setBounds(458, 124, 180, 180);
		pnlChiTietDatPhong.add(lblImgTrangThaiPhong);

		lblSDTKhachHang = new JLabel("SĐT khách hàng:");
		lblSDTKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSDTKhachHang.setBounds(50, 320, 120, 25);
		pnlChiTietDatPhong.add(lblSDTKhachHang);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(51, 270, 120, 25);
		pnlChiTietDatPhong.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBorder(null);
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(200, 270, 200, 25);
		pnlChiTietDatPhong.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtSDTKhachHang = new JTextField();
		txtSDTKhachHang.setToolTipText("Nhập SĐT khách hàng cần tìm");
		txtSDTKhachHang.setBounds(200, 320, 200, 25);
		pnlChiTietDatPhong.add(txtSDTKhachHang);
		txtSDTKhachHang.setColumns(10);

		btnTimKiemKhachHang = new JButton("Tìm kiếm");
		btnTimKiemKhachHang.setMnemonic(KeyEvent.VK_F);
//		btnTimKiemKhachHang.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconTimKiem1.png")));
		btnTimKiemKhachHang.setFocusable(false);
		btnTimKiemKhachHang.setBackground(new Color(144, 238, 144));
		btnTimKiemKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTimKiemKhachHang.setBounds(428, 318, 120, 30);
		pnlChiTietDatPhong.add(btnTimKiemKhachHang);

		radDatPhongNgay = new JRadioButton("Đặt phòng ngay");
		radDatPhongNgay.setBackground(new Color(255, 192, 203));
		radDatPhongNgay.setSelected(true);
		radDatPhongNgay.setName("");
		radDatPhongNgay.setFocusable(false);
		radDatPhongNgay.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radDatPhongNgay.setBounds(109, 538, 140, 30);
		pnlChiTietDatPhong.add(radDatPhongNgay);

		radDatPhongTruoc = new JRadioButton("Đặt phòng trước");
		radDatPhongTruoc.setBackground(new Color(255, 192, 203));
		radDatPhongTruoc.setName("");
		radDatPhongTruoc.setFocusable(false);
		radDatPhongTruoc.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		radDatPhongTruoc.setBounds(267, 538, 150, 30);
		pnlChiTietDatPhong.add(radDatPhongTruoc);

		grpDatPhong = new ButtonGroup();
		grpDatPhong.add(radDatPhongNgay);
		grpDatPhong.add(radDatPhongTruoc);

		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setMnemonic(KeyEvent.VK_ENTER);
//		btnDatPhong.setIcon(new ImageIcon(GD_DatPhong.class.getResource("/images/iconDatPhong1.png")));
		btnDatPhong.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDatPhong.setFocusable(false);
		btnDatPhong.setBackground(new Color(144, 238, 144));
		btnDatPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnDatPhong.setBounds(459, 533, 140, 40);
		pnlChiTietDatPhong.add(btnDatPhong);

//		controller = new DatPhongController(this);
//		radDatPhongNgay.addActionListener(controller);
//		radDatPhongTruoc.addActionListener(controller);
//		btnTimKiemKhachHang.addActionListener(controller);
//		btnDatPhong.addActionListener(controller);
//		btnNhanPhong.addActionListener(controller);
//		btnTimKiemPhong.addActionListener(controller);
//		btnLamMoi.addActionListener(controller);
//		btnDoiPhong.addActionListener(controller);
//		btnHuyPhongDatTruoc.addActionListener(controller);
//		btnChonPhong.addActionListener(controller);
//		tblPhong.addMouseListener(controller);
//		tblPhongDaChon.addMouseListener(controller);

	}
}
