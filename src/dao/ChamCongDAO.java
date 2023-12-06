package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import entities.PhieuChamCongEntity;
import util.ConnectDB;

public class ChamCongDAO {
	PhieuChamCongEntity phieuChamCongEntity;
	private PhanCongDAO phanCongDAO = new PhanCongDAO();

	public ChamCongDAO() {

	}

	public List<PhieuChamCongEntity> duyetDanhSach() {
		List<PhieuChamCongEntity> listPhieuChamCong = new ArrayList<PhieuChamCongEntity>();
		Connection connect = ConnectDB.getConnect();
		ResultSet result = null;
		Statement statement = null;

		try {
			String query = "SELECT *FROM PhieuChamCong";
			statement = connect.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				String maPhieuChamCong = result.getString(1);
				String maPhieuPhanCong = result.getString(2);
				boolean trangThai = false;
				if (result.getString(3).equals("Vắng")) {
					trangThai = true;
				}

				PhieuChamCongEntity phieuChamCongEntity = new PhieuChamCongEntity(maPhieuChamCong,
						phanCongDAO.timTheoMa(maPhieuPhanCong), trangThai);
				listPhieuChamCong.add(phieuChamCongEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnect(connect);
			ConnectDB.closeStatement(statement);
			ConnectDB.closeResultSet(result);
		}

		return listPhieuChamCong;
	}

	public boolean themPhieuChamCong(PhieuChamCongEntity phieuChamCongEntity) {
		Connection connect = ConnectDB.getConnect();
		PreparedStatement statement = null;

		if (connect != null) {
			try {
				String query = "INSERT PhieuChamCong ([MaPhieuPhanCong], [TrangThai])\r\n" + "VALUES (?, ?)";
				String trangThai = "Không vắng";
				if (phieuChamCongEntity.isTrangThai()) {
					trangThai = "Vắng";
				}
				statement = connect.prepareStatement(query);
				statement.setString(1, phieuChamCongEntity.getPhieuPhanCong().getMaPhieuPhanCong());
				statement.setString(2, trangThai);
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
