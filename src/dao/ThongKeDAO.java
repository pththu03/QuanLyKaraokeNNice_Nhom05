package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.CaTrucEntity;
import entities.HoaDonEntity;
import entities.NhanVienEntity;
import entities.PhieuPhanCongEntity;
import util.ConnectDB;
import util.DateFormatter;

public class ThongKeDAO {

	private QuanLyNhanVienDAO quanLyNhanVienDAO = new QuanLyNhanVienDAO();
	private QuanLyCaTrucDAO quanLyCaTrucDAO = new QuanLyCaTrucDAO();

	public ThongKeDAO() {

	}

	/************************************
	 * HÓA ĐƠN
	 *********************************************/
	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNgay(LocalDate ngay) {
		List<HoaDonEntity> listHoaDon = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statemant = null;
		ResultSet result = null;
		if (connect != null) {
			try {
				String query = "SELECT * FROM HoaDon\r\n" + "WHERE NgayLap LIKE ?";
				statemant = connect.prepareStatement(query);
				statemant.setString(1, DateFormatter.formatSql(ngay));
				result = statemant.executeQuery();
				while (result.next()) {
					String maHoaDon = result.getString(1);
					String maNhanVien = result.getString(2);
					String maKhachHang = result.getString(3);
					LocalDate ngayLap = result.getDate(4).toLocalDate();
					LocalTime gioLap = result.getTime(5).toLocalTime();
					HoaDonEntity hoaDonEntity = new HoaDonEntity(maHoaDon, maNhanVien, maKhachHang, ngayLap, gioLap);
					listHoaDon.add(hoaDonEntity);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statemant);
				ConnectDB.closeResultSet(result);
			}
		}
		return listHoaDon;
	}

	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNamThang(LocalDate ngay) {
		List<HoaDonEntity> listHoaDon = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statemant = null;
		ResultSet result = null;
		if (connect != null) {
			try {
				String query = "SELECT * FROM HoaDon\r\n"
						+ "WHERE DATEPART(MM, NgayLap) = ? AND DATEPART(yyyy, NgayLap) = ?";
				statemant = connect.prepareStatement(query);
				statemant.setInt(1, ngay.getMonthValue());
				statemant.setInt(2, ngay.getYear());
				result = statemant.executeQuery();
				while (result.next()) {
					String maHoaDon = result.getString(1);
					String maNhanVien = result.getString(2);
					String maKhachHang = result.getString(3);
					LocalDate ngayLap = result.getDate(4).toLocalDate();
					LocalTime gioLap = result.getTime(5).toLocalTime();
					HoaDonEntity hoaDonEntity = new HoaDonEntity(maHoaDon, maNhanVien, maKhachHang, ngayLap, gioLap);
					listHoaDon.add(hoaDonEntity);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statemant);
				ConnectDB.closeResultSet(result);
			}
		}
		return listHoaDon;
	}

	public List<HoaDonEntity> duyetDanhSachHoaDonTheoNam(LocalDate ngay) {
		List<HoaDonEntity> listHoaDon = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statemant = null;
		ResultSet result = null;
		if (connect != null) {
			try {
				String query = "SELECT * FROM HoaDon\r\n" + "WHERE DATEPART(yyyy, NgayLap) = ?";
				statemant = connect.prepareStatement(query);
				statemant.setInt(1, ngay.getYear());
				result = statemant.executeQuery();
				while (result.next()) {
					String maHoaDon = result.getString(1);
					String maNhanVien = result.getString(2);
					String maKhachHang = result.getString(3);
					LocalDate ngayLap = result.getDate(4).toLocalDate();
					LocalTime gioLap = result.getTime(5).toLocalTime();
					HoaDonEntity hoaDonEntity = new HoaDonEntity(maHoaDon, maNhanVien, maKhachHang, ngayLap, gioLap);
					listHoaDon.add(hoaDonEntity);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statemant);
				ConnectDB.closeResultSet(result);
			}
		}
		return listHoaDon;
	}

	public double tinhTongTienDichVuCuaHoaDon(HoaDonEntity hoaDonEntity) {
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statemant = null;
		if (connect != null) {
			try {
				String query = "SELECT SUM((SoLuong*Gia)) AS N'Tổng' FROM ChiTietDichVu CTDV\r\n"
						+ "JOIN ChiTietHoaDon CTHD ON CTHD.MaChiTietHoaDon = CTDV.MaChiTietHoaDon\r\n"
						+ "JOIN HoaDon HD ON HD.MaHoaDon = CTHD.MaHoaDon \r\n"
						+ "JOIN DichVu DV ON DV.MaDichVu = CTDV.MaDichVu\r\n" + "WHERE CTHD.MaHoaDon = ?";
				statemant = connect.prepareStatement(query);
				statemant.setString(1, hoaDonEntity.getMaHoaDon());
				result = statemant.executeQuery();
				while (result.next()) {
					return result.getDouble(1);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closePreStatement(statemant);
				ConnectDB.closeResultSet(result);
			}
		}
		return 0;
	}

	/************************************
	 * NHÂN VIÊN
	 *********************************************/

	public List<NhanVienEntity> duyetDanhSachNhanVienDangLamVien() {
		List<NhanVienEntity> listNhanVien = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statemant = null;

		if (connect != null) {
			try {
				String query = "SELECT * FROM NhanVien\r\n" + "WHERE TrangThai LIKE N'Đang làm việc'";
				statemant = connect.createStatement();
				result = statemant.executeQuery(query);
				while (result.next()) {
					String maNhanVien = result.getString(1);
					String hoTen = result.getString(2);
					String soDienThoai = result.getString(3);
					String email = result.getString(4);
					String CCCD = result.getString(5);
					String password = result.getString(6);
					int namSinh = result.getInt(7);
					double mucLuong = result.getDouble(8);
					String ChucVu = result.getString(9);
					boolean trangThai = false;
					if (result.getString(10).equalsIgnoreCase("Đang làm việc")) {
						trangThai = true;
					}
					NhanVienEntity nhanVienEntity = new NhanVienEntity(maNhanVien, hoTen, soDienThoai, email, CCCD,
							password, namSinh, mucLuong, ChucVu, trangThai);
					listNhanVien.add(nhanVienEntity);
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
		return listNhanVien;
	}

	public List<PhieuPhanCongEntity> duyetDanhSachPhieuPhanCongTheoNhanVien(NhanVienEntity nhanVienEntity,
			LocalDate ngay) {
		List<PhieuPhanCongEntity> listPhieuPhanCong = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;
		if (connect != null) {
			try {
				String query = "SELECT * FROM PhieuPhanCong\r\n"
						+ "WHERE MaNhanVien = ? AND DATEPART(MM, Ngay) = ? AND DATEPART(yyyy,Ngay) = ? ";
				statement = connect.prepareStatement(query);
				statement.setString(1, nhanVienEntity.getMaNhanVien());
				statement.setInt(2, ngay.getMonthValue());
				statement.setInt(3, ngay.getYear());
				result = statement.executeQuery();
				while (result.next()) {
					String maPhieuPhanCong = result.getString(1);
					NhanVienEntity nhanVienEntity1 = quanLyNhanVienDAO.timTheoMa(result.getString(2));
					CaTrucEntity caTrucEntity = quanLyCaTrucDAO.timTheoMa(result.getString(3));
					LocalDate ngay1 = result.getDate(4).toLocalDate();
					PhieuPhanCongEntity phanCongEntity = new PhieuPhanCongEntity(maPhieuPhanCong, nhanVienEntity1,
							caTrucEntity, ngay1);
					listPhieuPhanCong.add(phanCongEntity);
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
		return listPhieuPhanCong;
	}

	public int demSoCaVang(NhanVienEntity nhanVienEntity, LocalDate ngay) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT COUNT(*) FROM PhieuChamCong PCC \r\n"
						+ "JOIN PhieuPhanCong PPC ON PCC.MaPhieuPhanCong = PPC.MaPhieuPhanCong\r\n"
						+ "JOIN CaTruc CT ON PPC.MaCaTruc = CT.MaCaTruc \r\n"
						+ "JOIN NhanVien NV ON NV.MaNhanVien = PPC.MaNhanVien\r\n"
						+ "WHERE PCC.TrangThai LIKE N'Vắng' AND PPC.MaNhanVien = ? AND DATEPART(MM, PPC.Ngay) = ?  "
						+ "AND DATEPART(yyyy, PPC.Ngay) = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, nhanVienEntity.getMaNhanVien());
				statement.setInt(2, ngay.getMonthValue());
				statement.setInt(3, ngay.getYear());
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

	public int demSoGioLamViec(NhanVienEntity nhanVienEntity, LocalDate ngay) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "SELECT SUM(DATEDIFF(HOUR, GioBatDau ,GioKetThuc)) FROM PhieuChamCong PCC \r\n"
						+ "JOIN PhieuPhanCong PPC ON PCC.MaPhieuPhanCong = PPC.MaPhieuPhanCong\r\n"
						+ "JOIN CaTruc CT ON PPC.MaCaTruc = CT.MaCaTruc \r\n"
						+ "JOIN NhanVien NV ON NV.MaNhanVien = PPC.MaNhanVien\r\n"
						+ "WHERE PCC.TrangThai LIKE N'Không vắng' AND PPC.MaNhanVien = ? AND DATEPART(MM, PPC.Ngay) = ?  "
						+ "AND DATEPART(yyyy, PPC.Ngay) = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, nhanVienEntity.getMaNhanVien());
				statement.setInt(2, ngay.getMonthValue());
				statement.setInt(3, ngay.getYear());
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
