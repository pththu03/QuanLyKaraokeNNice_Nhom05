package entities;

import java.util.List;
import java.util.Objects;

public class PhieuDatPhongEntity {
	private String maPhieuDatPhong;
	private String maKhachHang;
	private List<PhongEntity> listPhong;

	public PhieuDatPhongEntity() {
		super();
	}

	public PhieuDatPhongEntity(String maPhieuDatPhong, String maKhachHang, List<PhongEntity> listPhong) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
		this.maKhachHang = maKhachHang;
		this.listPhong = listPhong;
	}

	public PhieuDatPhongEntity(String maKhachHang, List<PhongEntity> listPhong) {
		super();
		this.maKhachHang = maKhachHang;
		this.listPhong = listPhong;
	}

	public String getMaPhieuDatPhong() {
		return maPhieuDatPhong;
	}

	public void setMaPhieuDatPhong(String maPhieuDatPhong) {
		this.maPhieuDatPhong = maPhieuDatPhong;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public List<PhongEntity> getListPhong() {
		return listPhong;
	}

	public void setListPhong(List<PhongEntity> listPhong) {
		this.listPhong = listPhong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieuDatPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		PhieuDatPhongEntity other = (PhieuDatPhongEntity) obj;
		return Objects.equals(maPhieuDatPhong, other.maPhieuDatPhong);
	}

	@Override
	public String toString() {
		return "PhieuDatPhongEntity [maPhieuDatPhong=" + maPhieuDatPhong + ", maKhachHang=" + maKhachHang
				+ ", listPhong=" + listPhong + "]";
	}

}
