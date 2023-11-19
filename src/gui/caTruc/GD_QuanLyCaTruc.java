package gui.caTruc;

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
import javax.swing.table.DefaultTableModel;

import controller.QuanLyCaTrucController;
import entities.CaTrucEntity;

public class GD_QuanLyCaTruc extends JPanel {

	private static final long serialVersionUID = 1L;
	// JPanel
	private JPanel pnlCaTruc;
	private JPanel pnlDsCaTruc;

	// JLablel
	private JLabel lblChiTietCaTruc;
	private JLabel lblMaCaTruc;
	private JLabel lblTenCaTruc;
	private JLabel lblGioBD;
	private JLabel lblGioKT;
	private JLabel lblDsCaTruc;

	// JTextField
	private JTextField txtMaCaTruc;
	private JTextField txtCaTruc;
	private JTextField txtGioBD;
	private JTextField txtGioKT;

	// JTable
	private JTable tblDsCaTruc;
	private DefaultTableModel tblmodelDanhSachPhong;
	// JScrollPane
	private JScrollPane scrDsCaTruc;

	private List<CaTrucEntity> list;
	public JButton btnLamMoi;
	public JButton btnChinhSua;
	public JButton btnXoa;
	public JButton btnThem;

	public GD_QuanLyCaTruc() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlCaTruc = new JPanel();
		pnlCaTruc.setBackground(new Color(230, 230, 250));
		pnlCaTruc.setBounds(0, 0, 1365, 239);
		add(pnlCaTruc);
		pnlCaTruc.setLayout(null);

		lblChiTietCaTruc = new JLabel("Chi tiết ca trực");
		lblChiTietCaTruc.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietCaTruc.setFont(new Font("Segoe UI", Font.BOLD, 27));
		lblChiTietCaTruc.setBounds(0, 0, 1365, 60);
		pnlCaTruc.add(lblChiTietCaTruc);

		lblMaCaTruc = new JLabel("Mã ca trực:");
		lblMaCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMaCaTruc.setBounds(213, 70, 90, 30);
		pnlCaTruc.add(lblMaCaTruc);

		txtMaCaTruc = new JTextField();
		txtMaCaTruc.setDisabledTextColor(Color.BLACK);
		txtMaCaTruc.setBackground(Color.WHITE);
		txtMaCaTruc.setEditable(false);
		txtMaCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMaCaTruc.setBounds(300, 70, 352, 30);
		pnlCaTruc.add(txtMaCaTruc);
		txtMaCaTruc.setColumns(10);

		lblTenCaTruc = new JLabel("Tên ca trực:");
		lblTenCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenCaTruc.setBounds(700, 71, 90, 30);
		pnlCaTruc.add(lblTenCaTruc);

		txtCaTruc = new JTextField();
		txtCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCaTruc.setBounds(800, 70, 352, 30);
		pnlCaTruc.add(txtCaTruc);
		txtCaTruc.setColumns(10);

		lblGioBD = new JLabel("Giờ bắt đầu:");
		lblGioBD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGioBD.setBounds(213, 120, 90, 30);
		pnlCaTruc.add(lblGioBD);

		txtGioBD = new JTextField();
		txtGioBD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGioBD.setBounds(300, 120, 352, 30);
		pnlCaTruc.add(txtGioBD);
		txtGioBD.setColumns(10);

		lblGioKT = new JLabel("Giờ kết thúc:");
		lblGioKT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGioKT.setBounds(700, 120, 90, 30);
		pnlCaTruc.add(lblGioKT);

		txtGioKT = new JTextField();
		txtGioKT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGioKT.setBounds(800, 120, 352, 30);
		pnlCaTruc.add(txtGioKT);
		txtGioKT.setColumns(10);

		btnLamMoi = new JButton("Làm mới\r\n");
		btnLamMoi.setIcon(new ImageIcon(GD_QuanLyCaTruc.class.getResource("/images/iconLamMoi.png")));
		btnLamMoi.setFont(new Font("Cambria", Font.BOLD, 14));
		btnLamMoi.setFocusable(false);
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setBounds(882, 180, 150, 35);
		pnlCaTruc.add(btnLamMoi);

		btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.setIcon(new ImageIcon(GD_QuanLyCaTruc.class.getResource("/images/iconChinhSua1.png")));
		btnChinhSua.setFont(new Font("Cambria", Font.BOLD, 14));
		btnChinhSua.setFocusable(false);
		btnChinhSua.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnChinhSua.setBackground(new Color(144, 238, 144));
		btnChinhSua.setBounds(681, 180, 150, 35);
		pnlCaTruc.add(btnChinhSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GD_QuanLyCaTruc.class.getResource("/images/iconXoa.png")));
		btnXoa.setFont(new Font("Cambria", Font.BOLD, 14));
		btnXoa.setFocusable(false);
		btnXoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setBackground(new Color(144, 238, 144));
		btnXoa.setBounds(480, 180, 150, 35);
		pnlCaTruc.add(btnXoa);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_QuanLyCaTruc.class.getResource("/images/iconThem.png")));
		btnThem.setFont(new Font("Cambria", Font.BOLD, 14));
		btnThem.setFocusable(false);
		btnThem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(144, 238, 144));
		btnThem.setBounds(279, 180, 150, 35);
		pnlCaTruc.add(btnThem);

		pnlDsCaTruc = new JPanel();
		pnlDsCaTruc.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDsCaTruc.setBackground(new Color(230, 230, 250));
		pnlDsCaTruc.setBounds(0, 239, 1365, 455);
		add(pnlDsCaTruc);
		pnlDsCaTruc.setLayout(null);

		lblDsCaTruc = new JLabel("Danh sách ca trực");
		lblDsCaTruc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDsCaTruc.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDsCaTruc.setBounds(0, 10, 1365, 40);
		pnlDsCaTruc.add(lblDsCaTruc);

		String[] colsCaTruc = { "STT", "Mã CT", "Ca trực", "Giờ bắt đầu", "Giờ kết thúc" };
		tblmodelDanhSachPhong = new DefaultTableModel(colsCaTruc, 0);
		tblDsCaTruc = new JTable(tblmodelDanhSachPhong);
		tblDsCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrDsCaTruc = new JScrollPane(tblDsCaTruc);
		scrDsCaTruc.setBounds(30, 60, 1305, 380);
		pnlDsCaTruc.add(scrDsCaTruc);

		QuanLyCaTrucController controller = new QuanLyCaTrucController(this);
		btnLamMoi.addActionListener(controller);
		btnThem.addActionListener(controller);
		btnXoa.addActionListener(controller);
		btnChinhSua.addActionListener(controller);
		tblDsCaTruc.addMouseListener(controller);

	}

	public void chonLamMoi() {

	}

	public void chonThem() {

	}

	public void chonXoa() {

	}

	public void chonChinhSua() {

	}

	public void hienThiThongTin() {

	}

}
