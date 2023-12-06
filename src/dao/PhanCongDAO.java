package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import entities.CaTrucEntity;
import entities.NhanVienEntity;
import entities.PhieuPhanCongEntity;
import util.ConnectDB;
import util.DateFormatter;

public class PhanCongDAO {
	PhieuPhanCongEntity phieuPhanCongEntity;

	public PhanCongDAO() {
	}

	/**
	 * duyệt toàn bộ danh sách phân công
	 */
	public List<PhieuPhanCongEntity> duyetDanhSach() {
		List<PhieuPhanCongEntity> listPhieuPhanCong = new ArrayList<PhieuPhanCongEntity>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statement = null;
		try {
			String query = "select MaPhieuPhanCong, nv.MaNhanVien, HoTen, SoDienThoai, ct.MaCaTruc, TenCaTruc, Ngay\r\n"
					+ "from PhieuPhanCong ppc join NhanVien nv on ppc.MaNhanVien = nv.MaNhanVien\r\n"
					+ "join CaTruc ct on ppc.MaCaTruc = ct.MaCaTruc";
			statement = connect.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				String maPhieuPhanCong = result.getString(1);
				String maNhanVien = result.getString(2);
				String tenNhanVien = result.getString(3);
				String soDienThoai = result.getString(4);
				String maCaTruc = result.getString(5);
				String tenCaTruc = result.getString(6);
				LocalDate ngayPhanCong = result.getDate(7).toLocalDate();

				phieuPhanCongEntity = new PhieuPhanCongEntity(maPhieuPhanCong,
						new NhanVienEntity(maNhanVien, tenNhanVien, soDienThoai), new CaTrucEntity(maCaTruc, tenCaTruc),
						ngayPhanCong);
				listPhieuPhanCong.add(phieuPhanCongEntity);
			}
		} catch (

		SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closeStatement(statement);
			ConnectDB.closeResultSet(result);
		}
		return listPhieuPhanCong;
	}

	/**
	 * Thêm phiếu phân công
	 */
	public boolean themPhieuPhanCong(PhieuPhanCongEntity phieuPhanCongEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "insert PhieuPhanCong (MaNhanVien, MaCaTruc, Ngay)\r\n" + "values (?, ?, ?)";
				statement = connect.prepareStatement(query);
				statement.setString(1, phieuPhanCongEntity.getNhanVien().getMaNhanVien());
				statement.setString(2, phieuPhanCongEntity.getCaTruc().getMaCaTruc());
				statement.setDate(3, java.sql.Date.valueOf(phieuPhanCongEntity.getNgay()));
				return statement.executeUpdate() > 0;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
			}
		}
		return false;
	}

	/**
	 * Xóa phiếu phân công
	 */
	public boolean xoaPhieuPhanCong(String maPhieuPhanCong) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "DELETE PhieuPhanCong WHERE MaPhieuPhanCong LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maPhieuPhanCong);
				return statement.executeUpdate() > 0;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
			}
		}
		return false;
	}

	/**
	 * Chỉnh sửa phiếu phân công
	 */
	public boolean chinhSuaPhieuPhanCong(PhieuPhanCongEntity phieuPhanCongEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "UPDATE PhieuPhanCong\r\n" + "SET MaNhanVien = ?, MaCaTruc = ?, Ngay = ?\r\n"
						+ "WHERE MaPhieuPhanCong LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, phieuPhanCongEntity.getNhanVien().getMaNhanVien());
				statement.setString(2, phieuPhanCongEntity.getCaTruc().getMaCaTruc());
				statement.setDate(3, java.sql.Date.valueOf(phieuPhanCongEntity.getNgay()));
				statement.setString(4, phieuPhanCongEntity.getMaPhieuPhanCong());
				return statement.executeUpdate() > 0;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
			}
		}
		return false;
	}

	/**
	 * Tìm theo maPhieuPhanCong
	 */
	public PhieuPhanCongEntity timTheoMa(String maPhieuPhanCong) {
		PhieuPhanCongEntity phieuPhanCongKetQua = null;
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "select MaPhieuPhanCong, nv.MaNhanVien, HoTen, SoDienThoai, ct.MaCaTruc, TenCaTruc, Ngay\r\n"
						+ "from PhieuPhanCong ppc join NhanVien nv on ppc.MaNhanVien = nv.MaNhanVien\r\n"
						+ "join CaTruc ct on ppc.MaCaTruc = ct.MaCaTruc\r\n" + "where MaPhieuPhanCong LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maPhieuPhanCong);
				result = statement.executeQuery();
				while (result.next()) {
					String maNhanVien = result.getString(2);
					String tenNhanVien = result.getString(3);
					String soDienThoai = result.getString(4);
					String maCaTruc = result.getString(5);
					String tenCaTruc = result.getString(6);
					LocalDate ngayPhanCong = result.getDate(7).toLocalDate();

					phieuPhanCongKetQua = new PhieuPhanCongEntity(maPhieuPhanCong,
							new NhanVienEntity(maNhanVien, tenNhanVien, soDienThoai),
							new CaTrucEntity(maCaTruc, tenCaTruc), ngayPhanCong);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}
		return phieuPhanCongKetQua;
	}

	/**
	 * Duyệt danh sách phân công của ngày hiện tại
	 */
	public List<PhieuPhanCongEntity> duyetDanhSachPhanCongCuaNgay(Date ngayHienTai) {
		List<PhieuPhanCongEntity> listPhieuPhanCong = new ArrayList<PhieuPhanCongEntity>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		try {
			String query = "select MaPhieuPhanCong, nv.MaNhanVien, HoTen, SoDienThoai, ct.MaCaTruc, TenCaTruc, Ngay\r\n"
					+ "from PhieuPhanCong ppc join NhanVien nv on ppc.MaNhanVien = nv.MaNhanVien\r\n"
					+ "join CaTruc ct on ppc.MaCaTruc = ct.MaCaTruc\r\n" + "where Ngay = ?";
			statement = connect.prepareStatement(query);
			statement.setString(1, DateFormatter.formatSql(ngayHienTai));
			result = statement.executeQuery();
			while (result.next()) {
				String maPhieuPhanCong = result.getString(1);
				String maNhanVien = result.getString(2);
				String tenNhanVien = result.getString(3);
				String soDienThoai = result.getString(4);
				String maCaTruc = result.getString(5);
				String tenCaTruc = result.getString(6);
				LocalDate ngayPhanCong = result.getDate(7).toLocalDate();

				phieuPhanCongEntity = new PhieuPhanCongEntity(maPhieuPhanCong,
						new NhanVienEntity(maNhanVien, tenNhanVien, soDienThoai), new CaTrucEntity(maCaTruc, tenCaTruc),
						ngayPhanCong);
				listPhieuPhanCong.add(phieuPhanCongEntity);
			}
		} catch (

		SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closeStatement(statement);
			ConnectDB.closeResultSet(result);
		}
		return listPhieuPhanCong;
	}

	public List<PhieuPhanCongEntity> duyetDanhSachLichLamViecTheoNhanVien(NhanVienEntity nhanVienEntity) {
		List<PhieuPhanCongEntity> listPhieuPhanCong = new ArrayList<PhieuPhanCongEntity>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statemant = null;
		if (connect != null) {
			try {
				String query = "select MaPhieuPhanCong, nv.MaNhanVien, HoTen, SoDienThoai, ct.MaCaTruc, TenCaTruc, Ngay, GioBatDau, GioKetThuc\r\n"
						+ "from PhieuPhanCong ppc join NhanVien nv on ppc.MaNhanVien = nv.MaNhanVien\r\n"
						+ "join CaTruc ct on ppc.MaCaTruc = ct.MaCaTruc where nv.MaNhanVien = ?";
				statemant = connect.prepareStatement(query);
				statemant.setString(1, nhanVienEntity.getMaNhanVien());
				result = statemant.executeQuery();
				while (result.next()) {
					String maPhieuPhanCong = result.getString(1);
					String maNhanVien = result.getString(2);
					String tenNhanVien = result.getString(3);
					String soDienThoai = result.getString(4);
					String maCaTruc = result.getString(5);
					String tenCaTruc = result.getString(6);
					LocalDate ngayPhanCong = result.getDate(7).toLocalDate();
					LocalTime gioBatDau = result.getTime(8).toLocalTime();
					LocalTime gioKetThuc = result.getTime(9).toLocalTime();
					phieuPhanCongEntity = new PhieuPhanCongEntity(maPhieuPhanCong,
							new NhanVienEntity(maNhanVien, tenNhanVien, soDienThoai),
							new CaTrucEntity(maCaTruc, tenCaTruc, gioBatDau, gioKetThuc), ngayPhanCong);
					listPhieuPhanCong.add(phieuPhanCongEntity);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeStatement(statemant);
				ConnectDB.closeResultSet(result);
			}
		}
		return listPhieuPhanCong;
	}
}
