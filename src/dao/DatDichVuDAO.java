package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.DichVuEntity;
import util.ConnectDB;

public class DatDichVuDAO {
	public DatDichVuDAO() {

	}

	public List<DichVuEntity> timDichVu() {
		List<DichVuEntity> listDichVu = new ArrayList<>();
		Connection connect = ConnectDB.getConnect();
		Statement statement = null;
		ResultSet result = null;

		if (connect != null) {
			try {
				String query = "";

				statement = connect.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listDichVu;
	}
}
