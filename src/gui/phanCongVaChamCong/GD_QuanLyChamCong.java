package gui.phanCongVaChamCong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controller.QuanLyChamCongController;
import dao.ChamCongDAO;
import dao.PhanCongDAO;
import entities.PhieuChamCongEntity;
import entities.PhieuPhanCongEntity;
import util.DateFormatter;
import util.TimeFormatter;

public class GD_QuanLyChamCong extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrChamCong;
	private DefaultTableModel tblmodelPhieuChamCong;
	private JTable tblPhieuChamCong;
	private JPanel pnlChamCong;
	private JPanel pnlChucNang;
	private JLabel lblChamCong;
	private JPanel pnlNgayGio;
	private JLabel lblNgayChamCong;
	private JLabel lblGioChamCong;

	private List<PhieuChamCongEntity> listPhieuChamCong;
	private List<PhieuPhanCongEntity> listPhieuPhanCong;
	private QuanLyChamCongController controller;
	private PhanCongDAO phanCongDAO = new PhanCongDAO();
	private ChamCongDAO chamCongDAO = new ChamCongDAO();
	private JTextField txtCaTruc;
	private JTextField txtTenNV;
	private JLabel lblCaTruc;
	private JLabel lblTenNV;
	public JCheckBox chkVang;
	public JButton btnLuu;
	private JTextField txtSoDienThoai;

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

		String[] cols_ChamCong = { "STT", "Mã phiếu phân công", "Tên nhân viên", "Số điện thoại", "Ca Trực", "Ngày",
				"Trạng Thái" };
		tblmodelPhieuChamCong = new DefaultTableModel(cols_ChamCong, 0);
		tblPhieuChamCong = new JTable(tblmodelPhieuChamCong);
		tblPhieuChamCong.setAutoCreateRowSorter(true);
		tblPhieuChamCong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrChamCong = new JScrollPane(tblPhieuChamCong);
		scrChamCong.setBounds(30, 96, 1305, 465);
		pnlChucNang.add(scrChamCong);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblPhieuChamCong.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblPhieuChamCong.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblPhieuChamCong.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblPhieuChamCong.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

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
		lblCaTruc.setBounds(725, 573, 80, 30);
		pnlChucNang.add(lblCaTruc);

		txtCaTruc = new JTextField();
		txtCaTruc.setBounds(794, 573, 200, 30);
		pnlChucNang.add(txtCaTruc);
		txtCaTruc.setColumns(10);

		lblTenNV = new JLabel("Nhân viên:");
		lblTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTenNV.setBounds(30, 573, 80, 30);
		pnlChucNang.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setBounds(109, 573, 200, 30);
		pnlChucNang.add(txtTenNV);
		txtTenNV.setColumns(10);

		chkVang = new JCheckBox("Vắng");
		chkVang.setMargin(new Insets(1, 1, 1, 1));
		chkVang.setMinimumSize(new Dimension(81, 31));
		chkVang.setMaximumSize(new Dimension(81, 31));
		chkVang.setFocusPainted(false);
		chkVang.setBackground(new Color(230, 230, 250));
		chkVang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chkVang.setBounds(1017, 573, 150, 30);
		pnlChucNang.add(chkVang);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setBounds(373, 573, 96, 30);
		pnlChucNang.add(lblSoDienThoai);
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(468, 573, 200, 30);
		pnlChucNang.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		controller = new QuanLyChamCongController(this);
		btnLuu.addActionListener(controller);
		tblPhieuChamCong.addMouseListener(controller);
		chkVang.addActionListener(controller);
		loadData();
	}

	private void loadData() {
		tblPhieuChamCong.removeAll();
		tblPhieuChamCong.setRowSelectionAllowed(false);
		tblmodelPhieuChamCong.setRowCount(0);
		listPhieuPhanCong = new ArrayList<PhieuPhanCongEntity>();
		listPhieuPhanCong = phanCongDAO.duyetDanhSachPhanCongCuaNgay(new Date());
		listPhieuChamCong = new ArrayList<PhieuChamCongEntity>();
		listPhieuChamCong = chamCongDAO.duyetDanhSach();

		boolean flag = false;
		int stt = 1;
		for (PhieuPhanCongEntity phieuPhanCongEntity : listPhieuPhanCong) {
			flag = false;
			for (PhieuChamCongEntity phieuChamCongEntity : listPhieuChamCong) {
				String trangThai = "Không vắng";
				if (phieuChamCongEntity.isTrangThai()) {
					trangThai = "Vắng";
				}
				if (phieuChamCongEntity.getPhieuPhanCong().equals(phieuPhanCongEntity)) {
					flag = true;
					tblmodelPhieuChamCong.addRow(new Object[] { stt++, phieuPhanCongEntity.getMaPhieuPhanCong(),
							phieuPhanCongEntity.getNhanVien().getHoTen(),
							phieuPhanCongEntity.getNhanVien().getSoDienThoai(),
							phieuPhanCongEntity.getCaTruc().getTenCaTruc(),
							DateFormatter.format(phieuPhanCongEntity.getNgay()), trangThai });
				}
			}
			if (flag == false) {
				tblmodelPhieuChamCong.addRow(new Object[] { stt++, phieuPhanCongEntity.getMaPhieuPhanCong(),
						phieuPhanCongEntity.getNhanVien().getHoTen(),
						phieuPhanCongEntity.getNhanVien().getSoDienThoai(),
						phieuPhanCongEntity.getCaTruc().getTenCaTruc(),
						DateFormatter.format(phieuPhanCongEntity.getNgay()), "" });
			}
		}
	}

	public void hienThiThongTin() {
		int row = tblPhieuChamCong.getSelectedRow();
		if (row >= 0) {
			txtTenNV.setText(tblPhieuChamCong.getValueAt(row, 2).toString());
			txtSoDienThoai.setText(tblPhieuChamCong.getValueAt(row, 3).toString());
			txtCaTruc.setText(tblPhieuChamCong.getValueAt(row, 4).toString());
		}
	}

	public void chonLuu() {
		int row = tblPhieuChamCong.getSelectedRow();
		boolean trangThai = false;
		if (chkVang.isSelected()) {
			trangThai = true;
		}
		PhieuChamCongEntity phieuChamCongEntity = new PhieuChamCongEntity(
				phanCongDAO.timTheoMa(tblPhieuChamCong.getValueAt(row, 1).toString()), trangThai);
		if (chamCongDAO.themPhieuChamCong(phieuChamCongEntity)) {
			JOptionPane.showMessageDialog(this, "Chấm công thành công");
			lamMoi();
		}
	}

	private void lamMoi() {
		txtCaTruc.setText("");
		txtSoDienThoai.setText("");
		txtTenNV.setText("");
		chkVang.setSelected(false);
		loadData();
	}
}
