package gui.dichVu;

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

//import controller.QuanLyDichVuController;
//import dao.QuanLyDichVuDAO;
import entities.DichVuEntity;
import entities.NhanVienEntity;

public class GD_QuanLyDichVu extends JPanel {

	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlThongTin;
	private JPanel pnlChucNang;
	private JPanel pnlTimKiem;
	// JTable
	private JTable tblDichVu;

	// JTextField
	private JTextField txtMaDV;
	private JTextField txtTenDV;
	private JTextField txtGia;
	private JTextField txtGiaDen;
	private JTextField txtGiaDichVuTu;

	// JLabel
	private JLabel lblQuanLiDichVu;
	private JLabel lblMaDichVu;
	private JLabel lblLoaiDichVu;
	private JLabel lblLoaiDV;
	private JLabel lblGia;
	private JLabel lblGiaDen;
	private JLabel lblGiaDichVu;
	private JLabel lblLoaiDVTimKiem;

	// JComboBox
	private JComboBox<String> cmbLoaiDV;
	private JComboBox<String> cmbLoaiDVTimKiem;
	private DefaultComboBoxModel<String> cmbmodelLoaiDV;
	private DefaultComboBoxModel<String> cmbmodelLoaiDVTimKiem;

	// JScrollPane
	private JScrollPane scrQLDV;

	// JButton
	public JButton btnThem;
	public JButton btnXoa;
	public JButton btnChinhSua;
	public JButton btnLamMoi;
	public JButton btnTim;

	// DefaultTableModel
	private DefaultTableModel tblmodelDichVu;
//	private QuanLyDichVuController controller;
//	private List<DichVuEntity> listDichVu;
//	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();
	private NhanVienEntity nhanVienEntity;

	public GD_QuanLyDichVu(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setBounds(0, 0, 1365, 694);
		setLayout(null);

		pnlThongTin = new JPanel();
		pnlThongTin.setBackground(new Color(255, 192, 203));
		pnlThongTin.setBounds(0, 0, 672, 480);
		add(pnlThongTin);
		pnlThongTin.setLayout(null);

		lblQuanLiDichVu = new JLabel("Thông tin Dịch vụ");
		lblQuanLiDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLiDichVu.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblQuanLiDichVu.setBounds(0, 40, 672, 40);
		pnlThongTin.add(lblQuanLiDichVu);

		lblMaDichVu = new JLabel("Mã Dịch Vụ : ");
		lblMaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaDichVu.setBounds(82, 117, 104, 30);
		pnlThongTin.add(lblMaDichVu);

		lblLoaiDichVu = new JLabel("Tên Dịch Vụ :");
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu.setBounds(82, 177, 104, 30);
		pnlThongTin.add(lblLoaiDichVu);

		txtMaDV = new JTextField();
		txtMaDV.setDisabledTextColor(Color.BLACK);
		txtMaDV.setForeground(Color.BLACK);
		txtMaDV.setBackground(Color.WHITE);
		txtMaDV.setEnabled(false);
		txtMaDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaDV.setBounds(216, 115, 340, 33);
		pnlThongTin.add(txtMaDV);
		txtMaDV.setColumns(10);

		txtTenDV = new JTextField();
		txtTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenDV.setBounds(216, 175, 340, 33);
		pnlThongTin.add(txtTenDV);
		txtTenDV.setColumns(10);

		lblLoaiDV = new JLabel("Loại Dịch Vụ :");
		lblLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDV.setBounds(82, 237, 104, 30);
		pnlThongTin.add(lblLoaiDV);

		String[] cols_loaiDv = { "", "Đồ uống", "Món ăn", "Tiệc" };
		cmbmodelLoaiDV = new DefaultComboBoxModel<>(cols_loaiDv);
		cmbLoaiDV = new JComboBox<String>(cmbmodelLoaiDV);
		cmbLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiDV.setBounds(216, 235, 340, 33);
		pnlThongTin.add(cmbLoaiDV);

		btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setBounds(515, 395, 120, 40);
		pnlThongTin.add(btnLamMoi);
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
//		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnXoa = new JButton("Xóa\r\n");
		btnXoa.setBounds(357, 395, 120, 40);
		pnlThongTin.add(btnXoa);
		btnXoa.setFocusable(false);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
//		btnXoa.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconXoa3.png")));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnChinhSua = new JButton("Chỉnh Sửa");
		btnChinhSua.setBounds(199, 395, 120, 40);
		pnlThongTin.add(btnChinhSua);
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
//		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnChinhSua.setBackground(new Color(144, 238, 144));

		btnThem = new JButton("Thêm");
		btnThem.setBounds(41, 395, 120, 40);
		pnlThongTin.add(btnThem);
		btnThem.setFocusable(false);
		btnThem.setFocusCycleRoot(true);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
//		btnThem.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconThem3.png")));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblGiaDichVu = new JLabel("Giá Dịch vụ:");
		lblGiaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGiaDichVu.setBounds(82, 297, 104, 30);
		pnlThongTin.add(lblGiaDichVu);

		txtGia = new JTextField();
		txtGia.setBounds(216, 295, 340, 33);
		pnlThongTin.add(txtGia);
		txtGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGia.setColumns(10);

		pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChucNang.setBackground(new Color(255, 228, 225));
		pnlChucNang.setBounds(672, 0, 694, 694);
		add(pnlChucNang);
		pnlChucNang.setLayout(null);

		String[] cols_QLDV = { "STT", "Mã Dịch Vụ", "Tên Dịch Vụ", "Loại Dịch Vụ", "Giá" };
		tblmodelDichVu = new DefaultTableModel(cols_QLDV, 0);
		tblDichVu = new JTable(tblmodelDichVu);
		scrQLDV = new JScrollPane(tblDichVu);
		scrQLDV.setBounds(10, 79, 674, 604);
		pnlChucNang.add(scrQLDV);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblDichVu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblDichVu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblDichVu.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

		JLabel lblDanhSchDch = new JLabel("Danh sách dịch vụ");
		lblDanhSchDch.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchDch.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDanhSchDch.setBounds(0, 28, 694, 40);
		pnlChucNang.add(lblDanhSchDch);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(204, 204, 255));
		pnlTimKiem.setBounds(0, 478, 672, 216);
		add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		lblGia = new JLabel("Giá dịch vụ từ:");
		lblGia.setBounds(66, 96, 114, 30);
		pnlTimKiem.add(lblGia);
		lblGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblGiaDen = new JLabel("Đến:");
		lblGiaDen.setBounds(383, 96, 34, 30);
		pnlTimKiem.add(lblGiaDen);
		lblGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtGiaDen = new JTextField();
		txtGiaDen.setBounds(427, 95, 175, 33);
		pnlTimKiem.add(txtGiaDen);
		txtGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDen.setColumns(10);

		btnTim = new JButton("Tìm kiếm");
		btnTim.setBounds(472, 161, 130, 35);
		pnlTimKiem.add(btnTim);
		btnTim.setBackground(new Color(144, 238, 144));
		btnTim.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
//		btnTim.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconTimKiem1.png")));

		lblLoaiDVTimKiem = new JLabel("Loại Dịch Vụ :");
		lblLoaiDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDVTimKiem.setBounds(66, 31, 114, 30);
		pnlTimKiem.add(lblLoaiDVTimKiem);

		String[] cols_LoaiDVTimKiem = { "Tất cả", "Đồ uống", "Món ăn", "Tiệc" };
		cmbmodelLoaiDVTimKiem = new DefaultComboBoxModel<>(cols_LoaiDVTimKiem);
		cmbLoaiDVTimKiem = new JComboBox<String>(cmbmodelLoaiDVTimKiem);
		cmbLoaiDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiDVTimKiem.setBounds(202, 30, 399, 33);
		pnlTimKiem.add(cmbLoaiDVTimKiem);

		txtGiaDichVuTu = new JTextField();
		txtGiaDichVuTu.setBounds(202, 95, 166, 33);
		pnlTimKiem.add(txtGiaDichVuTu);
		txtGiaDichVuTu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDichVuTu.setColumns(10);

//		controller = new QuanLyDichVuController(this);
//		btnTim.addActionListener(controller);
//		btnThem.addActionListener(controller);
//		btnChinhSua.addActionListener(controller);
//		btnLamMoi.addActionListener(controller);
//		btnXoa.addActionListener(controller);
//		tblDichVu.addMouseListener(controller);
//		btnThem.setEnabled(false);
		btnChinhSua.setEnabled(false);
		btnXoa.setEnabled(false);
	}

}
