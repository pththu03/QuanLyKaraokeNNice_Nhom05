package gui.dichVu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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

import controller.QuanLyDichVuController;
import entities.DichVuEntity;
import entities.NhanVienEntity;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	// DefaultTableModel
	private DefaultTableModel tblmodelDichVu;
	private NhanVienEntity nhanVienEntity;
	private JPanel pnlDichVu;
	private JPanel pnlLoaiDichVu;
	private JTextField textField;
	private JLabel lblTnLoiDch;
	private JTextField textField_1;
	private JLabel lblLoaiDichVu_2;
	private JPanel panel;

	public JButton btnThemLoaiDichVu;
	public JButton btnXoaLoaiDichVu;
	public JButton btnChinhSuaLoaiDichVu;
	public JButton btnThemDichVu;
	public JButton btnTimKiem;
	public JButton btnLamMoi;
	public JButton btnXoaDichVu;
	public JButton btnChinhSuaDichVu;

	public GD_QuanLyDichVu(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
		setBounds(0, 0, 1365, 694);
		setLayout(null);

		pnlThongTin = new JPanel();
		pnlThongTin.setBackground(new Color(230, 230, 250));
		pnlThongTin.setBounds(0, 142, 1365, 251);
		add(pnlThongTin);
		pnlThongTin.setLayout(null);

		lblQuanLiDichVu = new JLabel("Thông tin Dịch vụ");
		lblQuanLiDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLiDichVu.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblQuanLiDichVu.setBounds(0, 11, 1356, 40);
		pnlThongTin.add(lblQuanLiDichVu);

		String[] cols_loaiDv = { "", "Đồ uống", "Món ăn", "Tiệc" };
		cmbmodelLoaiDV = new DefaultComboBoxModel<>(cols_loaiDv);

		pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlChucNang.setBackground(new Color(230, 230, 250));
		pnlChucNang.setBounds(0, 393, 1365, 301);
		add(pnlChucNang);
		pnlChucNang.setLayout(null);

		String[] cols_QLDV = { "STT", "Mã Dịch Vụ", "Tên Dịch Vụ", "Loại Dịch Vụ", "Giá" };
		tblmodelDichVu = new DefaultTableModel(cols_QLDV, 0);
		tblDichVu = new JTable(tblmodelDichVu);
		scrQLDV = new JScrollPane(tblDichVu);
		scrQLDV.setBounds(30, 65, 1305, 225);
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
		lblDanhSchDch.setBounds(0, 10, 1356, 40);
		pnlChucNang.add(lblDanhSchDch);

		pnlTimKiem = new JPanel();
		pnlTimKiem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pnlTimKiem.setBackground(new Color(230, 230, 250));
		pnlTimKiem.setBounds(0, 0, 1365, 142);
		add(pnlTimKiem);
		pnlTimKiem.setLayout(null);
//		btnTim.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconTimKiem1.png")));

		lblLoaiDVTimKiem = new JLabel("Loại Dịch Vụ :");
		lblLoaiDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDVTimKiem.setBounds(66, 34, 114, 30);
		pnlTimKiem.add(lblLoaiDVTimKiem);

		String[] cols_LoaiDVTimKiem = { "Tất cả", "Đồ uống", "Món ăn", "Tiệc" };
		cmbmodelLoaiDVTimKiem = new DefaultComboBoxModel<>(cols_LoaiDVTimKiem);

		panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(38, 11, 1299, 71);
		pnlTimKiem.add(panel);
		panel.setLayout(null);

		lblGia = new JLabel("Giá dịch vụ từ:");
		lblGia.setBounds(480, 23, 114, 30);
		panel.add(lblGia);
		lblGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtGiaDichVuTu = new JTextField();
		txtGiaDichVuTu.setBounds(588, 22, 290, 33);
		panel.add(txtGiaDichVuTu);
		txtGiaDichVuTu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDichVuTu.setColumns(10);

		lblGiaDen = new JLabel("Đến:");
		lblGiaDen.setBounds(936, 23, 34, 30);
		panel.add(lblGiaDen);
		lblGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtGiaDen = new JTextField();
		txtGiaDen.setBounds(980, 22, 290, 33);
		panel.add(txtGiaDen);
		txtGiaDen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGiaDen.setColumns(10);
		cmbLoaiDVTimKiem = new JComboBox<String>(cmbmodelLoaiDVTimKiem);
		cmbLoaiDVTimKiem.setBounds(142, 22, 290, 33);
		panel.add(cmbLoaiDVTimKiem);
		cmbLoaiDVTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconTimKiem.png")));
		btnTimKiem.setForeground(Color.BLACK);
		btnTimKiem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTimKiem.setBackground(new Color(152, 251, 152));
		btnTimKiem.setBounds(1187, 92, 150, 35);
		pnlTimKiem.add(btnTimKiem);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(152, 251, 152));
		btnLamMoi.setBounds(976, 92, 150, 35);
		pnlTimKiem.add(btnLamMoi);

		pnlDichVu = new JPanel();
		pnlDichVu.setBorder(
				new TitledBorder(null, "D\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDichVu.setBackground(new Color(230, 230, 250));
		pnlDichVu.setBounds(35, 61, 764, 179);
		pnlThongTin.add(pnlDichVu);
		pnlDichVu.setLayout(null);

		lblMaDichVu = new JLabel("Mã Dịch Vụ : ");
		lblMaDichVu.setBounds(28, 35, 104, 30);
		pnlDichVu.add(lblMaDichVu);
		lblMaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtMaDV = new JTextField();
		txtMaDV.setBounds(130, 34, 230, 33);
		pnlDichVu.add(txtMaDV);
		txtMaDV.setDisabledTextColor(Color.BLACK);
		txtMaDV.setForeground(Color.BLACK);
		txtMaDV.setBackground(Color.WHITE);
		txtMaDV.setEnabled(false);
		txtMaDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaDV.setColumns(10);

		lblLoaiDV = new JLabel("Loại Dịch Vụ :");
		lblLoaiDV.setBounds(28, 91, 104, 30);
		pnlDichVu.add(lblLoaiDV);
		lblLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbLoaiDV = new JComboBox<String>(cmbmodelLoaiDV);
		cmbLoaiDV.setBounds(130, 90, 233, 33);
		pnlDichVu.add(cmbLoaiDV);
		cmbLoaiDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		lblLoaiDichVu = new JLabel("Tên Dịch Vụ :");
		lblLoaiDichVu.setBounds(390, 35, 104, 30);
		pnlDichVu.add(lblLoaiDichVu);
		lblLoaiDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtGia = new JTextField();
		txtGia.setBounds(500, 90, 230, 33);
		pnlDichVu.add(txtGia);
		txtGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGia.setColumns(10);

		txtTenDV = new JTextField();
		txtTenDV.setBounds(500, 34, 230, 33);
		pnlDichVu.add(txtTenDV);
		txtTenDV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTenDV.setColumns(10);

		lblGiaDichVu = new JLabel("Giá Dịch vụ:");
		lblGiaDichVu.setBounds(390, 91, 104, 30);
		pnlDichVu.add(lblGiaDichVu);
		lblGiaDichVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		btnThemDichVu = new JButton("Thêm dịch vụ");
		btnThemDichVu.setBounds(73, 134, 150, 35);
		pnlDichVu.add(btnThemDichVu);
		btnThemDichVu.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconThem.png")));
		btnThemDichVu.setForeground(Color.BLACK);
		btnThemDichVu.setFont(new Font("Cambria", Font.BOLD, 14));
		btnThemDichVu.setFocusPainted(false);
		btnThemDichVu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThemDichVu.setBackground(new Color(152, 251, 152));

		btnXoaDichVu = new JButton("Xóa dịch vụ");
		btnXoaDichVu.setBounds(296, 133, 150, 35);
		pnlDichVu.add(btnXoaDichVu);
		btnXoaDichVu.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconXoa.png")));
		btnXoaDichVu.setForeground(Color.BLACK);
		btnXoaDichVu.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXoaDichVu.setFocusPainted(false);
		btnXoaDichVu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaDichVu.setBackground(new Color(152, 251, 152));

		btnChinhSuaDichVu = new JButton("Chỉnh sửa dịch vụ");
		btnChinhSuaDichVu.setBounds(519, 134, 170, 35);
		pnlDichVu.add(btnChinhSuaDichVu);
		btnChinhSuaDichVu.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSuaDichVu.setForeground(Color.BLACK);
		btnChinhSuaDichVu.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSuaDichVu.setFocusPainted(false);
		btnChinhSuaDichVu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSuaDichVu.setBackground(new Color(152, 251, 152));

		pnlLoaiDichVu = new JPanel();
		pnlLoaiDichVu.setBorder(new TitledBorder(null, "Lo\u1EA1i d\u1ECBch v\u1EE5", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlLoaiDichVu.setBackground(new Color(230, 230, 250));
		pnlLoaiDichVu.setBounds(830, 62, 509, 179);
		pnlThongTin.add(pnlLoaiDichVu);
		pnlLoaiDichVu.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(163, 88, 295, 33);
		pnlLoaiDichVu.add(textField);

		lblTnLoiDch = new JLabel("Tên loại dịch vụ:");
		lblTnLoiDch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTnLoiDch.setBounds(28, 89, 115, 30);
		pnlLoaiDichVu.add(lblTnLoiDch);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(163, 34, 295, 33);
		pnlLoaiDichVu.add(textField_1);

		lblLoaiDichVu_2 = new JLabel("Mã loại dịch vụ:");
		lblLoaiDichVu_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLoaiDichVu_2.setBounds(28, 35, 110, 30);
		pnlLoaiDichVu.add(lblLoaiDichVu_2);

		btnThemLoaiDichVu = new JButton("Thêm");
		btnThemLoaiDichVu.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconThem2.png")));
		btnThemLoaiDichVu.setForeground(Color.BLACK);
		btnThemLoaiDichVu.setFont(new Font("Cambria", Font.BOLD, 13));
		btnThemLoaiDichVu.setFocusPainted(false);
		btnThemLoaiDichVu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThemLoaiDichVu.setBackground(new Color(255, 128, 128));
		btnThemLoaiDichVu.setBounds(44, 132, 110, 30);
		pnlLoaiDichVu.add(btnThemLoaiDichVu);

		btnXoaLoaiDichVu = new JButton("Xóa");
		btnXoaLoaiDichVu.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconXoa1.png")));
		btnXoaLoaiDichVu.setForeground(Color.BLACK);
		btnXoaLoaiDichVu.setFont(new Font("Cambria", Font.BOLD, 13));
		btnXoaLoaiDichVu.setFocusPainted(false);
		btnXoaLoaiDichVu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoaLoaiDichVu.setBackground(new Color(255, 128, 128));
		btnXoaLoaiDichVu.setBounds(198, 132, 110, 30);
		pnlLoaiDichVu.add(btnXoaLoaiDichVu);

		btnChinhSuaLoaiDichVu = new JButton("Chỉnh sửa");
		btnChinhSuaLoaiDichVu.setIcon(new ImageIcon(GD_QuanLyDichVu.class.getResource("/images/iconChinhSua2.png")));
		btnChinhSuaLoaiDichVu.setForeground(Color.BLACK);
		btnChinhSuaLoaiDichVu.setFont(new Font("Cambria", Font.BOLD, 13));
		btnChinhSuaLoaiDichVu.setFocusPainted(false);
		btnChinhSuaLoaiDichVu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSuaLoaiDichVu.setBackground(new Color(255, 128, 128));
		btnChinhSuaLoaiDichVu.setBounds(352, 132, 110, 30);
		pnlLoaiDichVu.add(btnChinhSuaLoaiDichVu);

		QuanLyDichVuController controller = new QuanLyDichVuController(this);
		btnLamMoi.addActionListener(controller);
		btnTimKiem.addActionListener(controller);
		btnThemDichVu.addActionListener(controller);
		btnXoaDichVu.addActionListener(controller);
		btnChinhSuaDichVu.addActionListener(controller);
		btnThemLoaiDichVu.addActionListener(controller);
		btnXoaLoaiDichVu.addActionListener(controller);
		btnChinhSuaLoaiDichVu.addActionListener(controller);
	}

	public void hienThiThongTin() {

	}

	public void chonLamMoi() {

	}

	public void chonTimKiem() {

	}

	public void chonThemDichVu() {

	}

	public void chonXoaDichVu() {

	}

	public void chonChinhSuaDichVu() {

	}

	public void chonThemLoaiDichVu() {

	}

	public void chonXoaLoaiDichVu() {

	}

	public void chonChinhSuaLoaiDichVu() {

	}
}
