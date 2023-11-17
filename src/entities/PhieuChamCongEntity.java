package entities;

import java.util.Objects;

public class PhieuChamCongEntity {
	private String maPhieuChamCong;
	private PhieuPhanCongEntity phieuPhanCong;
	private boolean trangThai;

	public PhieuChamCongEntity() {
		super();
	}

	public PhieuChamCongEntity(String maPhieuChamCong, PhieuPhanCongEntity phieuPhanCong, boolean trangThai) {
		super();
		this.maPhieuChamCong = maPhieuChamCong;
		this.phieuPhanCong = phieuPhanCong;
		this.trangThai = trangThai;
	}

	public PhieuChamCongEntity(PhieuPhanCongEntity phieuPhanCong, boolean trangThai) {
		super();
		this.phieuPhanCong = phieuPhanCong;
		this.trangThai = trangThai;
	}

	public String getMaPhieuChamCong() {
		return maPhieuChamCong;
	}

	public void setMaPhieuChamCong(String maPhieuChamCong) {
		this.maPhieuChamCong = maPhieuChamCong;
	}

	public PhieuPhanCongEntity getPhieuPhanCong() {
		return phieuPhanCong;
	}

	public void setPhieuPhanCong(PhieuPhanCongEntity phieuPhanCong) {
		this.phieuPhanCong = phieuPhanCong;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieuChamCong);
	}

	public double tinhLuong() {
		double tienLuong = 0;

		return tienLuong;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		PhieuChamCongEntity other = (PhieuChamCongEntity) obj;
		return Objects.equals(maPhieuChamCong, other.maPhieuChamCong);
	}

	@Override
	public String toString() {
		return "PhieuChamCongEntity [maPhieuChamCong=" + maPhieuChamCong + ", phieuPhanCong=" + phieuPhanCong
				+ ", trangThai=" + trangThai + "]";
	}
}
