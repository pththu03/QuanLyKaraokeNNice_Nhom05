package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.CaTrucEntity;
import entities.KhachHangEntity;
import util.ConnectDB;

public class QuanLyCaTrucDAO {

	CaTrucEntity caTrucEntity;

	public QuanLyCaTrucDAO() {

	}

	public List<CaTrucEntity> duyetDanhSach() {
		List<CaTrucEntity> list = new ArrayList<CaTrucEntity>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statement = null;

		try {
			String query = "SELECT *FROM CaTruc";
			statement = connect.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				String maCT = result.getString(1);
				String tenCT = result.getString(2);
				LocalTime gioBD = result.getTime(3).toLocalTime();
				LocalTime gioKT = result.getTime(4).toLocalTime();

				caTrucEntity = new CaTrucEntity(maCT, tenCT, gioBD, gioKT);
				list.add(caTrucEntity);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closeStatement(statement);
			ConnectDB.closeResultSet(result);
		}
		return list;
	}

	public CaTrucEntity timTheoMa(String maCT) {
		CaTrucEntity caTrucKq = new CaTrucEntity();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "SELECT MaCaTruc, TenCaTruc, GioBatDau, GioKetThuc \r\n" + "FROM CaTruc \r\n"
						+ "WHERE MaCaTruc LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maCT);
				result = statement.executeQuery();
				while (result.next()) {
					String maCTr = result.getString(1);
					String tenCT = result.getString(2);
					LocalTime gioBD = result.getTime(3).toLocalTime();
					LocalTime gioKT = result.getTime(4).toLocalTime();

					caTrucKq = new CaTrucEntity(maCTr, tenCT, gioBD, gioKT);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
				e.printStackTrace();
			} finally {
				ConnectDB.closeConnect(connect);
				ConnectDB.closeResultSet(result);
				ConnectDB.closePreStatement(statement);
			}
		}
		return caTrucKq;
	}

	public CaTrucEntity them(CaTrucEntity caTrucEntity) {
		CaTrucEntity catrucEntity2 = null;
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		PreparedStatement statement = null;
		if (connect != null) {
			try {
				String query = "INSERT INTO CaTruc" + "([TenCaTruc],[GioBatDau],[GioKetThuc])" + "VALUES (?, ?, ?)";
				statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, caTrucEntity.getTenCaTruc());
				statement.setTime(2, Time.valueOf(caTrucEntity.getGioBatDau()));
				statement.setTime(3, Time.valueOf(caTrucEntity.getGioKetThuc()));
				statement.executeUpdate();
				result = statement.getGeneratedKeys();
				while (result.next()) {
					catrucEntity2 = new CaTrucEntity();
					catrucEntity2.setMaCaTruc(result.getString(1));

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

		return catrucEntity2;

	}

	public boolean xoa(String maCaTruc) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "DELETE FROM CaTruc\r\n" + "WHERE MaCaTruc = ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, maCaTruc);
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

	public boolean chinhSua(CaTrucEntity caTrucEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "UPDATE CaTruc \r\n" + "SET TenCaTruc = ?, GioBatDau = ?, GioKetThuc = ?"
						+ "where MaCaTruc LIKE ?";
				statement = connect.prepareStatement(query);
				statement.setString(1, caTrucEntity.getTenCaTruc());
				statement.setTime(2, Time.valueOf(caTrucEntity.getGioBatDau()));
				statement.setTime(3, Time.valueOf(caTrucEntity.getGioKetThuc()));
				statement.setString(4, caTrucEntity.getMaCaTruc());
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

}
