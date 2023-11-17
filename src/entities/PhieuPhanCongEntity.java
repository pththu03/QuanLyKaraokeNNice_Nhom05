package entities;

import java.time.LocalDate;
import java.util.Objects;

public class PhieuPhanCongEntity {
	private String maPhieuPhanCong;
	private String maNhanVien;
	private CaTrucEntity caTruc;
	private LocalDate ngay;

	public PhieuPhanCongEntity() {
		super();
	}

	public PhieuPhanCongEntity(String maPhieuPhanCong, String maNhanVien, CaTrucEntity caTruc, LocalDate ngay) {
		super();
		this.maPhieuPhanCong = maPhieuPhanCong;
		this.maNhanVien = maNhanVien;
		this.caTruc = caTruc;
		this.ngay = ngay;
	}

	public PhieuPhanCongEntity(String maNhanVien, CaTrucEntity caTruc, LocalDate ngay) {
		super();
		this.maNhanVien = maNhanVien;
		this.caTruc = caTruc;
		this.ngay = ngay;
	}

	public String getMaPhieuPhanCong() {
		return maPhieuPhanCong;
	}

	public void setMaPhieuPhanCong(String maPhieuPhanCong) {
		this.maPhieuPhanCong = maPhieuPhanCong;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public CaTrucEntity getCaTruc() {
		return caTruc;
	}

	public void setCaTruc(CaTrucEntity caTruc) {
		this.caTruc = caTruc;
	}

	public LocalDate getNgay() {
		return ngay;
	}

	public void setNgay(LocalDate ngay) {
		this.ngay = ngay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieuPhanCong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		PhieuPhanCongEntity other = (PhieuPhanCongEntity) obj;
		return Objects.equals(maPhieuPhanCong, other.maPhieuPhanCong);
	}

	@Override
	public String toString() {
		return "PhieuPhanCongEntity [maPhieuPhanCong=" + maPhieuPhanCong + ", maNhanVien=" + maNhanVien + ", caTruc="
				+ caTruc + ", ngay=" + ngay + "]";
	}
}
