package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.NhanVienEntity;
import util.ConnectDB;

public class QuanLyNhanVienDAO {
	public QuanLyNhanVienDAO() {

	}

	public List<NhanVienEntity> duyetDanhSach() {
		List<NhanVienEntity> listNhanVien = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statemant = null;

		if (connect != null) {
			try {
				String query = "SELECT * FROM NhanVien";
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
}
