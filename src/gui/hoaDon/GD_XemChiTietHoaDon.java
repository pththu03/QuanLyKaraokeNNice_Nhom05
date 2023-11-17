package gui.hoaDon;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.ChiTietDichVuEntity;
import entities.ChiTietHoaDonEntity;
import entities.HoaDonEntity;

public class GD_XemChiTietHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnlContent;
	private JTable tblPhong;
	private JTable tblDichVu;

	private DefaultTableModel tblmodelPhong;
	private DefaultTableModel tblmodelDichVu;

	public JButton btnThoat;
	public JButton btnLamMoi;

//	private ChiTietHoaDonController controller;
	private HoaDonEntity hoaDonEntity;
	private JTextField txtSoPhong;

	private List<ChiTietHoaDonEntity> listChiTietHoaDon;
	private List<ChiTietDichVuEntity> listChiTietDichVu;
//	private QuanLyChiTietHoaDonDAO quanLyChiTietHoaDonDAO = new QuanLyChiTietHoaDonDAO();
//	private QuanLyChiTietDichVuDAO quanLyChiTietDichVuDAO = new QuanLyChiTietDichVuDAO();
//	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
//	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();

	/**
	 * Create the frame.
	 */
	public GD_XemChiTietHoaDon(HoaDonEntity hoaDonEntity) {
		this.hoaDonEntity = hoaDonEntity;
//		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_ChiTietHoaDon.class.getResource("/images/iconLogo1.png")));
		setTitle("Xem chi tiết hóa đơn");
		setBounds(100, 100, 925, 548);
		setLocationRelativeTo(null);
		pnlContent = new JPanel();
		pnlContent.setBackground(SystemColor.controlHighlight);
		pnlContent.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(pnlContent);
		pnlContent.setLayout(null);

		JPanel pnlChiTietPhong = new JPanel();
		pnlChiTietPhong.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlChiTietPhong.setBackground(SystemColor.inactiveCaption);
		pnlChiTietPhong.setBounds(10, 11, 873, 180);
		pnlContent.add(pnlChiTietPhong);
		pnlChiTietPhong.setLayout(null);

		String[] col_Phong = { "STT", "Số phòng", "Loại phòng", "Sức chứa", "Giờ nhận phòng", "Giờ trả phòng" };
		tblmodelPhong = new DefaultTableModel(col_Phong, 0);
		tblPhong = new JTable(tblmodelPhong);

		JScrollPane scrPhong = new JScrollPane(tblPhong);
		scrPhong.setBounds(20, 20, 827, 138);
		pnlChiTietPhong.add(scrPhong);

		JPanel pnlChiTietDichVu = new JPanel();
		pnlChiTietDichVu.setBorder(
				new TitledBorder(null, "Danh sách dịch vụ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlChiTietDichVu.setBackground(SystemColor.inactiveCaption);
		pnlChiTietDichVu.setBounds(10, 216, 873, 229);
		pnlContent.add(pnlChiTietDichVu);
		pnlChiTietDichVu.setLayout(null);

		String[] col_DichVu = { "STT", "Tên dịch vụ", "Loại dịch vụ", "Giá tiền", "Số lượng", "Thành tiền" };
		tblmodelDichVu = new DefaultTableModel(col_DichVu, 0);
		tblDichVu = new JTable(tblmodelDichVu);

		JScrollPane scrDichVu = new JScrollPane(tblDichVu);
		scrDichVu.setBounds(20, 56, 827, 151);
		pnlChiTietDichVu.add(scrDichVu);

		JLabel lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblSoPhong.setBounds(20, 22, 70, 20);
		pnlChiTietDichVu.add(lblSoPhong);

		txtSoPhong = new JTextField();
		txtSoPhong.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtSoPhong.setForeground(Color.BLACK);
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(89, 20, 86, 25);
		pnlChiTietDichVu.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		btnThoat = new JButton("Thoát");
		btnThoat.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThoat.setBackground(new Color(144, 238, 144));
		btnThoat.setFocusable(false);
//		btnThoat.setIcon(new ImageIcon(GD_ChiTietHoaDon.class.getResource("/images/iconDangXuat1.png")));
		btnThoat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnThoat.setBounds(750, 456, 120, 35);
		pnlContent.add(btnThoat);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setFocusable(false);
//		btnLamMoi.setIcon(new ImageIcon(GD_ChiTietHoaDon.class.getResource("/images/iconLamMoi3.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLamMoi.setBounds(610, 456, 120, 35);
		pnlContent.add(btnLamMoi);

//		controller = new ChiTietHoaDonController(this);
//		btnLamMoi.addActionListener(controller);
//		btnThoat.addActionListener(controller);
//		tblPhong.addMouseListener(controller);
	}
}
