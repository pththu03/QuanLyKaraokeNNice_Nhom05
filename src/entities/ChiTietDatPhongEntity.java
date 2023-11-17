package entities;

import java.time.LocalTime;
import java.util.Objects;

public class ChiTietDatPhongEntity {
	private String maChiTietDatPhong;
	private PhongEntity phong;
	private LocalTime gioNhanPhong;
	private LocalTime gioTraPhong;

	public ChiTietDatPhongEntity() {
		super();
	}

	public ChiTietDatPhongEntity(String maChiTietDatPhong, PhongEntity phong, LocalTime gioNhanPhong,
			LocalTime gioTraPhong) {
		super();
		this.maChiTietDatPhong = maChiTietDatPhong;
		this.phong = phong;
		this.gioNhanPhong = gioNhanPhong;
		this.gioTraPhong = gioTraPhong;
	}

	public ChiTietDatPhongEntity(PhongEntity phong, LocalTime gioNhanPhong, LocalTime gioTraPhong) {
		super();
		this.phong = phong;
		this.gioNhanPhong = gioNhanPhong;
		this.gioTraPhong = gioTraPhong;
	}

	public String getMaChiTietDatPhong() {
		return maChiTietDatPhong;
	}

	public void setMaChiTietDatPhong(String maChiTietDatPhong) {
		this.maChiTietDatPhong = maChiTietDatPhong;
	}

	public PhongEntity getPhong() {
		return phong;
	}

	public void setPhong(PhongEntity phong) {
		this.phong = phong;
	}

	public LocalTime getGioNhanPhong() {
		return gioNhanPhong;
	}

	public void setGioNhanPhong(LocalTime gioNhanPhong) {
		this.gioNhanPhong = gioNhanPhong;
	}

	public LocalTime getGioTraPhong() {
		return gioTraPhong;
	}

	public void setGioTraPhong(LocalTime gioTraPhong) {
		this.gioTraPhong = gioTraPhong;
	}

	public double tinhTienHat() {
		double tienHat = 0;
		return tienHat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maChiTietDatPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		ChiTietDatPhongEntity other = (ChiTietDatPhongEntity) obj;
		return Objects.equals(maChiTietDatPhong, other.maChiTietDatPhong);
	}

	@Override
	public String toString() {
		return "ChiTietDatPhongEntity [maChiTietDatPhong=" + maChiTietDatPhong + ", phong=" + phong + ", gioNhanPhong="
				+ gioNhanPhong + ", gioTraPhong=" + gioTraPhong + "]";
	}

}
