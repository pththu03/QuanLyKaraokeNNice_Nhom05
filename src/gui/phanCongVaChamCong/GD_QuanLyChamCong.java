package gui.phanCongVaChamCong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entities.PhieuChamCongEntity;
import entities.PhieuPhanCongEntity;
import util.DateFormatter;
import util.TimeFormatter;

public class GD_QuanLyChamCong extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrChamCong;
	private DefaultTableModel tblmodelChamCong;
	private JTable tblChamCong;
	private JPanel pnlChamCong;
	private JPanel pnlChucNang;
	private JLabel lblChamCong;
	private JPanel pnlNgayGio;
	private JLabel lblNgayChamCong;
	private JLabel lblGioChamCong;

	private List<PhieuChamCongEntity> listPhieuChamCong;
//	private PhanCongDAO phanCongDAO = new PhanCongDAO();
//	private ChamCongDAO chamCongDAO = new ChamCongDAO();
//	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
//	private QuanLyCaTrucDAO quanLyCaTrucDAO = new QuanLyCaTrucDAO();
	private JTextField txtCaTruc;
	private JTextField txtTenNV;
	private JLabel lblCaTruc;
	private JLabel lblTenNV;
	public JCheckBox chkVang;
	public JButton btnLuu;

	public GD_QuanLyChamCong() {
		setLayout(null);
		setBounds(0, 0, 1365, 694);

		pnlChamCong = new JPanel();
		pnlChamCong.setBackground(UIManager.getColor("Button.light"));
		pnlChamCong.setBounds(0, 0, 1365, 694);
		add(pnlChamCong);
		pnlChamCong.setLayout(null);

		pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(230, 230, 250));
		pnlChucNang.setBounds(0, 0, 1365, 717);
		pnlChamCong.add(pnlChucNang);
		pnlChucNang.setLayout(null);

		btnLuu = new JButton("Lưu");
		btnLuu.setFocusable(false);
		btnLuu.setBackground(new Color(144, 238, 144));
		btnLuu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLuu.setBounds(1185, 571, 150, 35);
		pnlChucNang.add(btnLuu);

		String[] cols_ChamCong = { "STT", "Mã PPC", "Tên Nhân Viên", "Ca Trực", "Ngày", "Trạng Thái", "Lương" };
		tblmodelChamCong = new DefaultTableModel(cols_ChamCong, 0);
		tblChamCong = new JTable(tblmodelChamCong);
		tblChamCong.setAutoCreateRowSorter(true);
		tblChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrChamCong = new JScrollPane(tblChamCong);
		scrChamCong.setBounds(30, 96, 1305, 465);
		pnlChucNang.add(scrChamCong);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblChamCong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblChamCong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblChamCong.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblChamCong.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tblChamCong.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblChamCong.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		tblChamCong.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);

		lblChamCong = new JLabel("Chấm Công");
		lblChamCong.setBounds(0, 28, 1365, 50);
		pnlChucNang.add(lblChamCong);
		lblChamCong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChamCong.setFont(new Font("Segoe UI", Font.BOLD, 22));

		pnlNgayGio = new JPanel();
		pnlNgayGio.setBackground(new Color(230, 230, 250));
		pnlNgayGio.setBounds(0, 620, 1365, 74);
		pnlChucNang.add(pnlNgayGio);
		pnlNgayGio.setLayout(null);

		lblNgayChamCong = new JLabel("28/06/2023");
		lblNgayChamCong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgayChamCong.setBounds(1243, 36, 94, 30);
		Timer ngayHT = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNgayChamCong.setText(DateFormatter.format(LocalDate.now()));
			}
		});
		ngayHT.start();
		pnlNgayGio.add(lblNgayChamCong);

		lblGioChamCong = new JLabel("16:06");
		lblGioChamCong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioChamCong.setBounds(1264, 16, 53, 30);
		Timer gioHT = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblGioChamCong.setText(TimeFormatter.format(LocalTime.now()));
			}
		});
		gioHT.start();
		pnlNgayGio.add(lblGioChamCong);

		lblCaTruc = new JLabel("Ca trực:");
		lblCaTruc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCaTruc.setBounds(50, 572, 80, 30);
		pnlChucNang.add(lblCaTruc);

		txtCaTruc = new JTextField();
		txtCaTruc.setBounds(130, 572, 200, 30);
		pnlChucNang.add(txtCaTruc);
		txtCaTruc.setColumns(10);

		lblTenNV = new JLabel("Nhân viên:");
		lblTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenNV.setBounds(400, 572, 80, 30);
		pnlChucNang.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setBounds(480, 572, 200, 30);
		pnlChucNang.add(txtTenNV);
		txtTenNV.setColumns(10);

		chkVang = new JCheckBox("Vắng");
		chkVang.setMargin(new Insets(1, 1, 1, 1));
		chkVang.setMinimumSize(new Dimension(81, 31));
		chkVang.setMaximumSize(new Dimension(81, 31));
		chkVang.setFocusPainted(false);
		chkVang.setBackground(new Color(230, 230, 250));
		chkVang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkVang.setBounds(780, 572, 150, 30);
		pnlChucNang.add(chkVang);

//		controller = new ChamCongController(this);
//		btnLuu.addActionListener(controller);
//		tblChamCong.addMouseListener(controller);
//		chkVang.addActionListener(controller);
	}
	
	public void hienThiThongTin() {
		
	}
	
	public void chonLuu() {
		
	}
	
	public void chonVang() {
		
	}
	

}
