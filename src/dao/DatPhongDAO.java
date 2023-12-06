package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.ChiTietDatPhongEntity;
import entities.ChiTietDichVuEntity;
import entities.ChiTietHoaDonEntity;
import entities.ChiTietPhieuDatPhongEntity;
import entities.DichVuEntity;
import entities.LoaiPhong;
import entities.PhieuDatPhongEntity;
import entities.PhongEntity;
import util.ConnectDB;
import util.DateFormatter;
import util.TimeFormatter;

public class DatPhongDAO {
	public DatPhongDAO() {

	}

	private QuanLyPhongDAO quanLyPhongDAO = new QuanLyPhongDAO();
	private QuanLyDichVuDAO quanLyDichVuDAO = new QuanLyDichVuDAO();
	private QuanLyHoaDonDAO quanLyHoaDonDAO = new QuanLyHoaDonDAO();

	/************************************
	 * TÌM KIẾM PHÒNG
	 ************************************/

	public List<PhongEntity> timPhong(String trangThai, String loaiPhong, int soPhong, int sucChua) {
		List<PhongEntity> listPhong = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				StringBuilder query = new StringBuilder(
						"SELECT MaPhong, SoPhong, LP.MaLoaiPhong, TenLoai, SucChua, TrangThai\r\n"
								+ "FROM Phong P JOIN LoaiPhong LP ON P.MaLoaiPhong = LP.MaLoaiPhong ");
				if (!trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && soPhong >= 0 && sucChua >= 0) {
					// 1 trangThai + loaiPhong + soPhong + sucChua
					query.append(String.format(
							"WHERE TrangThai LIKE N'%%%s%%' AND TenLoai LIKE N'%%%s%%' AND SoPhong LIKE '%%%d%%' AND SucChua = %d",
							trangThai, loaiPhong, soPhong, sucChua));
				} else if (!trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && soPhong >= 0
						&& !(sucChua >= 0)) {
					// 2 trangThai + loaiPhong + soPhong
					query.append(String.format(
							"WHERE TrangThai LIKE N'%%%s%%' AND TenLoai LIKE N'%%%s%%' AND SoPhong LIKE '%%%d%%'",
							trangThai, loaiPhong, soPhong));
				} else if (!trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& sucChua >= 0) {
					// 3 trangThai + loaiPhong + sucChua
					query.append(
							String.format("WHERE TrangThai LIKE N'%%%s%%' AND TenLoai LIKE N'%%%s%%' AND SucChua = %d",
									trangThai, loaiPhong, sucChua));
				} else if (!trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && soPhong >= 0 && sucChua >= 0) {
					// 4 trangThai + soPhong + sucChua
					query.append(
							String.format("WHERE TrangThai LIKE N'%%%s%%' AND SoPhong LIKE '%%%d%%' AND SucChua = %d",
									trangThai, soPhong, sucChua));
				} else if (trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && soPhong >= 0 && sucChua >= 0) {
					// 5 loaiPhong + soPhong + sucChua
					query.append(
							String.format("WHERE TenLoai LIKE N'%%%s%%' AND SoPhong LIKE '%%%d%%' AND SucChua = %d",
									loaiPhong, soPhong, sucChua));
				} else if (!trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& !(sucChua >= 0)) {
					// 6 trangThai + loaiPhong
					query.append(String.format("WHERE TrangThai LIKE N'%%%s%%' AND TenLoai LIKE N'%%%s%%'", trangThai,
							loaiPhong));
				} else if (!trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && soPhong >= 0
						&& !(sucChua >= 0)) {
					// 7 trangThai + soPhong
					query.append(String.format("WHERE TrangThai LIKE N'%%%s%%' AND SoPhong LIKE '%%%d%%'", trangThai,
							soPhong));
				} else if (!trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& sucChua >= 0) {
					// 8 trangThai + sucChua
					query.append(String.format("WHERE TrangThai LIKE N'%%%s%%' AND SucChua = %d", trangThai, sucChua));
				} else if (trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && soPhong >= 0
						&& !(sucChua >= 0)) {
					// 9 loaiPhong + soPhong
					query.append(String.format("WHERE TenLoai LIKE N'%%%s%%' AND SoPhong LIKE '%%%d%%'", loaiPhong,
							soPhong));
				} else if (trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& sucChua >= 0) {
					// 10 loaiPhong + sucChua
					query.append(String.format("WHERE TenLoai LIKE N'%%%s%%' AND SucChua = %d", loaiPhong, sucChua));
				} else if (trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && soPhong >= 0 && sucChua >= 0) {
					// 11 soPhong + sucChua
					query.append(String.format("WHERE SoPhong LIKE '%%%d%%' AND SucChua = %d", soPhong, sucChua));
				} else if (trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && soPhong >= 0
						&& !(sucChua >= 0)) {
					// 12 soPhong
					query.append(String.format("WHERE SoPhong LIKE '%%%d%%'", soPhong));
				} else if (trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& sucChua >= 0) {
					// 13 sucChua
					query.append(String.format("WHERE SucChua = %d", sucChua));
				} else if (!trangThai.equals("Tất cả") && loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& !(sucChua >= 0)) {
					// 14 trangThai
					query.append(String.format("WHERE TrangThai LIKE N'%%%s%%'", trangThai));
				} else if (trangThai.equals("Tất cả") && !loaiPhong.equals("Tất cả") && !(soPhong >= 0)
						&& !(sucChua >= 0)) {
					// loaiPhong
					query.append(String.format("WHERE TenLoai LIKE N'%%%s%%'", loaiPhong));
				}

				statement = connect.createStatement();
				result = statement.executeQuery(query.toString());
				while (result.next()) {
					String maPhongKetQua = result.getString(1);
					int soPhongKetQua = result.getInt(2);
					int sucChuaKetQua = result.getInt(5);
					String trangThaiKetQua = result.getString(6);
					LoaiPhong loaiPhongKetQua = new LoaiPhong(result.getString(3), result.getString(4));
					PhongEntity phongEntity = new PhongEntity(maPhongKetQua, soPhongKetQua, loaiPhongKetQua,
							trangThaiKetQua, sucChuaKetQua);
					listPhong.add(phongEntity);
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
		return listPhong;
	}

	public int demChiTietDatPhongChuaThanhToanCuaPhong(String maPhong) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;
		if (connect != null) {
			try {
				String query = "SELECT COUNT(*) FROM ChiTietDatPhong CTDP JOIN ChiTietHoaDon CTHD\r\n"
						+ "	ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong JOIN Phong P\r\n"
						+ "	ON CTDP.MaPhong = P.MaPhong\r\n" + "WHERE P.MaPhong LIKE ? AND MaHoaDon IS NULL";
				statement = connect.prepareStatement(query);
				statement.setString(1, maPhong);
				result = statement.executeQuery();
				while (result.next()) {
					return result.getInt(1);
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
		return 0;
	}

	public int demChiTietDichVuTheoChiTietHoaDon(ChiTietHoaDonEntity chiTietHoaDonEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;
		if (connect != null) {
			try {
				String query = "SELECT COUNT(*) FROM ChiTietDichVu CTDV JOIN ChiTietHoaDon CTHD\r\n"
						+ "	ON CTDV.MaChiTietHoaDon = CTHD.MaChiTietHoaDon\r\n"
						+ "WHERE CTDV.MaChiTietHoaDon LIKE ? AND MaHoaDon IS NULL\r\n";
				statement = connect.prepareStatement(query);
				statement.setString(1, chiTietHoaDonEntity.getMaChiTietHoaDon());
				result = statement.executeQuery();
				while (result.next()) {
					return result.getInt(1);
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
		return 0;
	}

	public int demChiTietPhieuDatPhongTheoMaPhieuDatPhong(String maPhieuDatPhongEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;
		if (connect != null) {
			try {
				String query = "SELECT COUNT(*) FROM ChiTietPhieuDatPhong\r\n" + "WHERE MaPhieuDatPhong LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maPhieuDatPhongEntity);
				result = statement.executeQuery();
				while (result.next()) {
					return result.getInt(1);
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
		return 0;
	}

	public boolean doiPhong(ChiTietDatPhongEntity chiTietDatPhongEntity, String maPhong) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "UPDATE ChiTietDatPhong\r\n" + "SET MaPhong = ?\r\n"
						+ "FROM ChiTietDatPhong CTDP JOIN ChiTietHoaDon CTHD \r\n"
						+ "ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong\r\n"
						+ "WHERE MaHoaDon IS NULL AND CTDP.MaChiTietDatPhong LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maPhong);
				statement.setString(2, chiTietDatPhongEntity.getMaChiTietDatPhong());
				return statement.executeUpdate() > 0;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeStatement(statement);
			}
		}
		return false;
	}

	public List<PhongEntity> timPhongTrongTheoNgayVaGio(LocalDate ngay, LocalTime gioNhan, LocalTime gioTra) {
		List<PhongEntity> listPhong = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT * FROM Phong P\r\n"
						+ "WHERE NOT EXISTS (SELECT MaPhong FROM ChiTietDatPhong CTDP JOIN ChiTietHoaDon CTHD\r\n"
						+ "	ON CTDP.MaChiTietDatPhong = CTHD.MaChiTietDatPhong \r\n"
						+ "	WHERE CTDP.MaPhong = P.MaPhong AND MaHoaDon IS NULL\r\n"
						+ "	AND NgayDatPhong = ? AND (GioNhanPhong >= ? AND GioNhanPhong <= ?) AND (GioTraPhong >= ? AND GioTraPhong <= ?))\r\n";
				statement = connect.prepareStatement(query);
				statement.setString(1, DateFormatter.formatSql(ngay));
				statement.setString(2, TimeFormatter.formatSql(gioNhan.minusMinutes(30)));
				statement.setString(3, TimeFormatter.formatSql(gioTra.plusMinutes(30)));
				statement.setString(4, TimeFormatter.formatSql(gioNhan.minusMinutes(30)));
				statement.setString(5, TimeFormatter.formatSql(gioTra.plusMinutes(30)));
				result = statement.executeQuery();
				while (result.next()) {
					String maPhongKetQua = result.getString(1);
					int soPhongKetQua = result.getInt(2);
					int sucChuaKetQua = result.getInt(5);
					String trangThaiKetQua = result.getString(4);
					LoaiPhong loaiPhongKetQua = quanLyPhongDAO.timTheoMaLoaiPhong(result.getString(3));
					PhongEntity phongEntity = new PhongEntity(maPhongKetQua, soPhongKetQua, loaiPhongKetQua,
							trangThaiKetQua, sucChuaKetQua);
					listPhong.add(phongEntity);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}
		return listPhong;
	}

	public int demPhieuDatPhongTheoPhong(PhongEntity phongEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;
		if (connect != null) {
			try {
				String query = "SELECT COUNT(*) FROM ChiTietDatPhong CTDP JOIN Phong P\r\n"
						+ "ON P.MaPhong = CTDP.MaPhong JOIN ChiTietHoaDon CTHD\r\n"
						+ "ON CTHD.MaChiTietDatPhong = CTDP.MaChiTietDatPhong\r\n"
						+ "WHERE CTDP.MaPhong LIKE ? AND MaHoaDon IS NULL";
				statement = connect.prepareStatement(query);
				statement.setString(1, phongEntity.getMaPhong());
				result = statement.executeQuery();
				while (result.next()) {
					return result.getInt(1);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statement);
				ConnectDB.closeResultSet(result);
			}
		}
		return 0;
	}
}
