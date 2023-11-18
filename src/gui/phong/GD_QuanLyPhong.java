package gui.phong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entities.PhongEntity;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class GD_QuanLyPhong extends JPanel {

	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlQuanLiPhong;
	private JPanel pnlThongTinPhong;
	private JPanel pnlDsPhong;
	private JPanel pnlTimKiem;
	private JPanel pnlTK;
	private JLabel lblPhongHat;
	private JLabel lblMaPhong;
	private JLabel lblSoPhong;
	private JLabel lblSucChua;
	private JLabel lblTrangThai;
	private JLabel lblLoaiPhong;
	private JLabel lblTimKiemBangSoPhong;
	private JLabel lblTimKiemBangTrangThai;
	private JLabel lblTimKiemBangSucChua;
	private JLabel lblTimKiemBangLoaiPhong;
	private JLabel lblDanhSachPhong;
	// JTextField
	private JTextField txtMaPhong;
	private JTextField txtSoPhong;
	private JTextField txtSucChua;
	private JTextField txtTimKiemBangSoPhong;
	private JTextField txtTimKiemBangSucChua;
	private JTextField txtTimBangTrangThai;
	private JTextField txtTimKiemBangLoaiPhong;
	private JTextField txtMaLoaiPhong;
	private JTextField txtTenLoaiPhong;
	// JTable
	private JTable tblPhong;
	private DefaultTableModel tblmodelPhong;
	// JScrollPane
	private JScrollPane scrDanhSachPhong;
	// JComboBox
	private JComboBox<String> cmbTrangThai;
	private DefaultComboBoxModel<String> cmbmodelTrangThai;
	private JComboBox<String> cmbLoaiPhong;
	private DefaultComboBoxModel<String> cmbmodelLoaiPhong;

	// JButton
	public JButton btnLamMoi;
	public JButton btnTimKiem;
	public JButton btnThemLoaiPhong;
	public JButton btnXoaLoaiPhong;
	public JButton btnSuaLoaiPhong;
	public JButton btnThem;
	public JButton btnXoaPhong;
	public JButton btnChinhSuaPhong;

	public GD_QuanLyPhong() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlQuanLiPhong = new JPanel();
		pnlQuanLiPhong.setBounds(0, 0, 1365, 694);
		add(pnlQuanLiPhong);
		pnlQuanLiPhong.setLayout(null);

		String[] colsTrangThai = { "", "Trống", "Chờ", "Đang sử dụng" };
		cmbmodelTrangThai = new DefaultComboBoxModel<>(colsTrangThai);

		String[] colsLoaiPhong = { "", "Thường", "VIP" };
		cmbmodelLoaiPhong = new DefaultComboBoxModel<>(colsLoaiPhong);

		pnlDsPhong = new JPanel();
		pnlDsPhong.setBackground(new Color(230, 230, 250));
		pnlDsPhong.setBounds(0, 395, 1365, 299);
		pnlQuanLiPhong.add(pnlDsPhong);
		pnlDsPhong.setLayout(null);

		lblDanhSachPhong = new JLabel("Danh sách phòng");
		lblDanhSachPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSachPhong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSachPhong.setBounds(0, 11, 1356, 40);
		pnlDsPhong.add(lblDanhSachPhong);

		String[] colsPhong = { "STT", "Mã phòng", "Số phòng", "Loại phòng", "Sức chứa", "Trạng thái" };
		tblmodelPhong = new DefaultTableModel(colsPhong, 0);
		tblPhong = new JTable(tblmodelPhong);
		tblPhong.setAutoCreateRowSorter(true);
		tblPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrDanhSachPhong = new JScrollPane(tblPhong);
		scrDanhSachPhong.setBounds(35, 65, 1281, 223);
		pnlDsPhong.add(scrDanhSachPhong);

		pnlThongTinPhong = new JPanel();
		pnlThongTinPhong.setBounds(0, 0, 1365, 251);
		pnlQuanLiPhong.add(pnlThongTinPhong);
		pnlThongTinPhong.setBorder(null);
		pnlThongTinPhong.setBackground(new Color(230, 230, 250));
		pnlThongTinPhong.setLayout(null);

		lblPhongHat = new JLabel("Thông tin phòng");
		lblPhongHat.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhongHat.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblPhongHat.setBounds(0, 11, 1365, 50);
		pnlThongTinPhong.add(lblPhongHat);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(null, "Ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(35, 61, 780, 179);
		pnlThongTinPhong.add(panel);
		panel.setLayout(null);

		lblMaPhong = new JLabel("Mã phòng:");
		lblMaPhong.setBounds(28, 22, 80, 30);
		panel.add(lblMaPhong);
		lblMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(118, 22, 230, 30);
		panel.add(txtMaPhong);
		txtMaPhong.setBackground(Color.WHITE);
		txtMaPhong.setEnabled(false);
		txtMaPhong.setDisabledTextColor(Color.BLACK);
		txtMaPhong.setSelectedTextColor(Color.BLACK);
		txtMaPhong.setSelectionColor(Color.BLACK);
		txtMaPhong.setForeground(SystemColor.BLACK);
		txtMaPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaPhong.setColumns(10);

		txtSoPhong = new JTextField();
		txtSoPhong.setBounds(489, 22, 230, 30);
		panel.add(txtSoPhong);
		txtSoPhong.setBackground(Color.WHITE);
		txtSoPhong.setDisabledTextColor(Color.BLACK);
		txtSoPhong.setSelectionColor(Color.BLACK);
		txtSoPhong.setSelectedTextColor(Color.BLACK);
		txtSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSoPhong.setColumns(10);

		lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setBounds(399, 22, 80, 30);
		panel.add(lblSoPhong);
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblLoaiPhong = new JLabel("Loại phòng: ");
		lblLoaiPhong.setBounds(28, 74, 100, 30);
		panel.add(lblLoaiPhong);
		lblLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiPhong = new JComboBox<String>(cmbmodelLoaiPhong);
		cmbLoaiPhong.setBounds(119, 74, 230, 30);
		panel.add(cmbLoaiPhong);
		cmbLoaiPhong.setBackground(Color.WHITE);
		cmbLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtSucChua = new JTextField();
		txtSucChua.setBounds(118, 126, 230, 30);
		panel.add(txtSucChua);
		txtSucChua.setBackground(Color.WHITE);
		txtSucChua.setEditable(false);
		txtSucChua.setColumns(10);

		lblSucChua = new JLabel("Sức chứa:");
		lblSucChua.setBounds(28, 126, 100, 30);
		panel.add(lblSucChua);
		lblSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setBounds(399, 63, 80, 30);
		panel.add(lblTrangThai);
		lblTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbTrangThai = new JComboBox<String>(cmbmodelTrangThai);
		cmbTrangThai.setBounds(489, 63, 230, 30);
		panel.add(cmbTrangThai);
		cmbTrangThai.setBackground(Color.WHITE);
		cmbTrangThai.setForeground(Color.BLACK);
		cmbTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Lo\u1EA1i ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(843, 61, 472, 179);
		pnlThongTinPhong.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaLoaiPhong = new JLabel("Mã loại phòng:");
		lblMaLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaLoaiPhong.setBounds(30, 35, 110, 30);
		panel_1.add(lblMaLoaiPhong);

		txtMaLoaiPhong = new JTextField();
		txtMaLoaiPhong.setBounds(151, 35, 275, 30);
		panel_1.add(txtMaLoaiPhong);
		txtMaLoaiPhong.setColumns(10);

		JLabel lblTenLoaiPhong = new JLabel("Tên loại phòng;");
		lblTenLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenLoaiPhong.setBounds(30, 76, 119, 30);
		panel_1.add(lblTenLoaiPhong);

		txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setBounds(151, 76, 275, 30);
		panel_1.add(txtTenLoaiPhong);
		txtTenLoaiPhong.setColumns(10);

		btnThemLoaiPhong = new JButton("Thêm");
		btnThemLoaiPhong.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconThem2.png")));
		btnThemLoaiPhong.setForeground(Color.BLACK);
		btnThemLoaiPhong.setFont(new Font("Cambria", Font.BOLD, 13));
		btnThemLoaiPhong.setFocusPainted(false);
		btnThemLoaiPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThemLoaiPhong.setBackground(new Color(255, 128, 128));
		btnThemLoaiPhong.setBounds(30, 133, 100, 30);
		panel_1.add(btnThemLoaiPhong);

		btnXoaLoaiPhong = new JButton("Xóa");
		btnXoaLoaiPhong.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconXoa1.png")));
		btnXoaLoaiPhong.setForeground(Color.BLACK);
		btnXoaLoaiPhong.setFont(new Font("Cambria", Font.BOLD, 13));
		btnXoaLoaiPhong.setFocusPainted(false);
		btnXoaLoaiPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaLoaiPhong.setBackground(new Color(255, 128, 128));
		btnXoaLoaiPhong.setBounds(173, 133, 100, 30);
		panel_1.add(btnXoaLoaiPhong);

		btnSuaLoaiPhong = new JButton("Chỉnh sửa");
		btnSuaLoaiPhong.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconChinhSua2.png")));
		btnSuaLoaiPhong.setForeground(Color.BLACK);
		btnSuaLoaiPhong.setFont(new Font("Cambria", Font.BOLD, 13));
		btnSuaLoaiPhong.setFocusPainted(false);
		btnSuaLoaiPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSuaLoaiPhong.setBackground(new Color(255, 128, 128));
		btnSuaLoaiPhong.setBounds(316, 133, 110, 30);
		panel_1.add(btnSuaLoaiPhong);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBounds(0, 254, 1365, 142);
		pnlQuanLiPhong.add(pnlTimKiem);
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setLayout(null);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setForeground(Color.BLACK);
		btnTimKiem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBackground(new Color(152, 251, 152));
		btnTimKiem.setBounds(858, 96, 130, 35);
		pnlTimKiem.add(btnTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setBounds(1007, 96, 130, 35);
		pnlTimKiem.add(btnLamMoi);
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setBackground(new Color(152, 251, 152));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));

		pnlTK = new JPanel();
		pnlTK.setBackground(new Color(230, 230, 250));
		pnlTK.setBorder(
				new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTK.setBounds(35, 11, 780, 120);
		pnlTimKiem.add(pnlTK);
		pnlTK.setLayout(null);

		txtTimKiemBangLoaiPhong = new JTextField();
		txtTimKiemBangLoaiPhong.setBounds(489, 66, 230, 30);
		pnlTK.add(txtTimKiemBangLoaiPhong);
		txtTimKiemBangLoaiPhong.setColumns(10);

		lblTimKiemBangLoaiPhong = new JLabel("Loại phòng:");
		lblTimKiemBangLoaiPhong.setBounds(399, 66, 100, 30);
		pnlTK.add(lblTimKiemBangLoaiPhong);
		lblTimKiemBangLoaiPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtTimKiemBangSucChua = new JTextField();
		txtTimKiemBangSucChua.setBounds(489, 25, 230, 30);
		pnlTK.add(txtTimKiemBangSucChua);
		txtTimKiemBangSucChua.setColumns(10);

		lblTimKiemBangSucChua = new JLabel("Sức chứa:");
		lblTimKiemBangSucChua.setBounds(399, 25, 100, 30);
		pnlTK.add(lblTimKiemBangSucChua);
		lblTimKiemBangSucChua.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtTimKiemBangSoPhong = new JTextField();
		txtTimKiemBangSoPhong.setBounds(118, 25, 230, 30);
		pnlTK.add(txtTimKiemBangSoPhong);
		txtTimKiemBangSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTimKiemBangSoPhong.setColumns(10);

		txtTimBangTrangThai = new JTextField();
		txtTimBangTrangThai.setBounds(118, 66, 230, 30);
		pnlTK.add(txtTimBangTrangThai);
		txtTimBangTrangThai.setColumns(10);

		lblTimKiemBangTrangThai = new JLabel("Trạng thái: ");
		lblTimKiemBangTrangThai.setBounds(28, 66, 100, 30);
		pnlTK.add(lblTimKiemBangTrangThai);
		lblTimKiemBangTrangThai.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblTimKiemBangSoPhong = new JLabel("Số phòng:");
		lblTimKiemBangSoPhong.setBounds(28, 25, 100, 30);
		pnlTK.add(lblTimKiemBangSoPhong);
		lblTimKiemBangSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnThem = new JButton("Thêm phòng");
		btnThem.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconThem.png")));
		btnThem.setForeground(Color.BLACK);
		btnThem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnThem.setFocusPainted(false);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(152, 251, 152));
		btnThem.setBounds(858, 27, 130, 35);
		pnlTimKiem.add(btnThem);

		btnXoaPhong = new JButton("Xóa phòng");
		btnXoaPhong.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconXoa.png")));
		btnXoaPhong.setForeground(Color.BLACK);
		btnXoaPhong.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXoaPhong.setFocusPainted(false);
		btnXoaPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaPhong.setBackground(new Color(152, 251, 152));
		btnXoaPhong.setBounds(1010, 27, 130, 35);
		pnlTimKiem.add(btnXoaPhong);

		btnChinhSuaPhong = new JButton("Chỉnh sửa phòng");
		btnChinhSuaPhong.setIcon(new ImageIcon(GD_QuanLyPhong.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSuaPhong.setForeground(Color.BLACK);
		btnChinhSuaPhong.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSuaPhong.setFocusPainted(false);
		btnChinhSuaPhong.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSuaPhong.setBackground(new Color(152, 251, 152));
		btnChinhSuaPhong.setBounds(1165, 27, 150, 35);
		pnlTimKiem.add(btnChinhSuaPhong);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblPhong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tblPhong.getColumnModel().getColumn(0).setPreferredWidth(40);
	}
}
