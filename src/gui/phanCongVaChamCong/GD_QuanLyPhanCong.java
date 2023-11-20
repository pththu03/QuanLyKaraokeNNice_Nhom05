package gui.phanCongVaChamCong;

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

import com.toedter.calendar.JDateChooser;

import controller.QuanLyPhanCongController;
import entities.CaTrucEntity;
import entities.NhanVienEntity;
import entities.PhieuPhanCongEntity;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GD_QuanLyPhanCong extends JPanel {

	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlPhanCong;
	private JPanel pnlChiTietPhanCong;
	private JPanel pnlDanhSachPhanCong;
	// JtextField
	private JTextField txtMaPC;
	// Jlabel
	private JLabel lblChiTietPhanCong;
	private JLabel lblMaPC;
	private JLabel lblNgay;
	private JLabel lblNhanVien;
	private JLabel lblCaTruc;
	private JLabel lblDsPhanCong;
	// JcomboBox
	public JComboBox<String> cmbNhanVien;
	private DefaultComboBoxModel<String> cmbmodelMaNV;
	public JComboBox<String> cmbCaTruc;
	private DefaultComboBoxModel<String> cmbmodelCaTruc;
	// Jtable
	private JTable tblPhanCong;
	private DefaultTableModel tblmodelPhanCong;
	// JScrollPane
	private JScrollPane scrPhanCong;
	// JDateChooser
	private JDateChooser dchNgay;
	// JButton
	public JButton btnThem;
	public JButton btnXoa;
	public JButton btnLamMoi;
	public JButton btnChinhSua;

//	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
//	private PhanCongDAO phanCongDAO = new PhanCongDAO();
//	private QuanLyCaTrucDAO quanLyCaTrucDAO = new QuanLyCaTrucDAO();
	private List<PhieuPhanCongEntity> listPhieuPhanCong;
	private List<NhanVienEntity> listNhanVien;
	private List<CaTrucEntity> listCaTruc;

	public GD_QuanLyPhanCong() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlPhanCong = new JPanel();
		pnlPhanCong.setBackground(new Color(255, 255, 255));
		pnlPhanCong.setBounds(0, 0, 1365, 694);
		add(pnlPhanCong);
		pnlPhanCong.setLayout(null);

		pnlChiTietPhanCong = new JPanel();
		pnlChiTietPhanCong.setBorder(null);
		pnlChiTietPhanCong.setBackground(new Color(230, 230, 250));
		pnlChiTietPhanCong.setBounds(0, 0, 1365, 290);
		pnlPhanCong.add(pnlChiTietPhanCong);
		pnlChiTietPhanCong.setLayout(null);

		lblChiTietPhanCong = new JLabel(" Chi tiết Phân Công");
		lblChiTietPhanCong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietPhanCong.setBounds(0, 0, 1365, 60);
		lblChiTietPhanCong.setFont(new Font("Segoe UI", Font.BOLD, 22));
		pnlChiTietPhanCong.add(lblChiTietPhanCong);

		lblMaPC = new JLabel("Mã Phân Công:");
		lblMaPC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaPC.setBounds(206, 70, 110, 30);
		pnlChiTietPhanCong.add(lblMaPC);

		txtMaPC = new JTextField();
		txtMaPC.setText(" ");
		txtMaPC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaPC.setDisabledTextColor(Color.BLACK);
		txtMaPC.setSelectedTextColor(Color.BLACK);
		txtMaPC.setSelectionColor(Color.BLACK);
		txtMaPC.setEnabled(false);
		txtMaPC.setBounds(330, 70, 290, 30);
		pnlChiTietPhanCong.add(txtMaPC);
		txtMaPC.setColumns(10);

		lblNgay = new JLabel("Ngày:");
		lblNgay.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNgay.setBounds(758, 70, 80, 30);
		pnlChiTietPhanCong.add(lblNgay);

		dchNgay = new JDateChooser();
		dchNgay.setDateFormatString("dd/MM/yyyy");
		dchNgay.setBounds(815, 70, 290, 30);
		pnlChiTietPhanCong.add(dchNgay);

		lblNhanVien = new JLabel("Mã Nhân Viên:");
		lblNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNhanVien.setBounds(206, 120, 110, 30);
		pnlChiTietPhanCong.add(lblNhanVien);

		cmbmodelMaNV = new DefaultComboBoxModel<>();
		cmbmodelMaNV.addElement("");
		cmbNhanVien = new JComboBox<>(cmbmodelMaNV);
		cmbNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbNhanVien.setBounds(330, 120, 290, 30);
		pnlChiTietPhanCong.add(cmbNhanVien);

		lblCaTruc = new JLabel("Mã ca trực:");
		lblCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCaTruc.setBounds(725, 120, 80, 30);
		pnlChiTietPhanCong.add(lblCaTruc);

		cmbmodelCaTruc = new DefaultComboBoxModel<>();
		cmbmodelCaTruc.addElement("");
		cmbCaTruc = new JComboBox<>(cmbmodelCaTruc);
		cmbCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cmbCaTruc.setBounds(815, 120, 290, 30);
		pnlChiTietPhanCong.add(cmbCaTruc);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_QuanLyPhanCong.class.getResource("/images/iconThem.png")));
		btnThem.setForeground(Color.BLACK);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setFocusPainted(false);
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnThem.setBounds(279, 230, 150, 35);
		pnlChiTietPhanCong.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GD_QuanLyPhanCong.class.getResource("/images/iconXoa.png")));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setFocusPainted(false);
		btnXoa.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXoa.setBounds(480, 230, 150, 35);
		pnlChiTietPhanCong.add(btnXoa);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyPhanCong.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFocusPainted(false);
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setBounds(882, 230, 150, 35);
		pnlChiTietPhanCong.add(btnLamMoi);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyPhanCong.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setForeground(Color.BLACK);
		btnChinhSua.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSua.setFocusPainted(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setBounds(681, 230, 150, 35);
		pnlChiTietPhanCong.add(btnChinhSua);

		pnlDanhSachPhanCong = new JPanel();
		pnlDanhSachPhanCong.setBackground(new Color(230, 230, 250));
		pnlDanhSachPhanCong.setBounds(0, 290, 1365, 404);
		pnlPhanCong.add(pnlDanhSachPhanCong);
		pnlDanhSachPhanCong.setLayout(null);

		String[] cols = { "STT", "Mã PC", "Họ và tên", "Ca trực", "Ngày" };
		tblmodelPhanCong = new DefaultTableModel(cols, 0);
		tblPhanCong = new JTable(tblmodelPhanCong);
		tblPhanCong.setAutoCreateRowSorter(true);
		tblPhanCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrPhanCong = new JScrollPane(tblPhanCong);
		scrPhanCong.setBounds(30, 70, 1305, 320);
		pnlDanhSachPhanCong.add(scrPhanCong);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblPhanCong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhanCong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhanCong.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblPhanCong.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

		lblDsPhanCong = new JLabel("Danh sách phân công");
		lblDsPhanCong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDsPhanCong.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsPhanCong.setBounds(0, 10, 1365, 50);
		pnlDanhSachPhanCong.add(lblDsPhanCong);

		QuanLyPhanCongController controller = new QuanLyPhanCongController(this);
		btnLamMoi.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnXoa.addActionListener(controller);
		tblPhanCong.addMouseListener(controller);
//		cmbMaCaTruc.addActionListener(controller);
//		cmbMaNV.addActionListener(controller);

	}

	public void hienThiThongTin() {

	}

	public void chonLamMoi() {

	}

	public void chonThem() {

	}

	public void chonXoa() {

	}

	public void chonChinhSua() {

	}
}
