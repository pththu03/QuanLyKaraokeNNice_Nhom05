package entities;

import java.time.LocalDate;
import java.util.Objects;

public class PhieuPhanCongEntity {
	private String maPhieuPhanCong;
	private NhanVienEntity nhanVien;
	private CaTrucEntity caTruc;
	private LocalDate ngay;

	public PhieuPhanCongEntity() {
		super();
	}

	public String getMaPhieuPhanCong() {
		return maPhieuPhanCong;
	}

	public void setMaPhieuPhanCong(String maPhieuPhanCong) {
		this.maPhieuPhanCong = maPhieuPhanCong;
	}

	public NhanVienEntity getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVienEntity nhanVien) {
		this.nhanVien = nhanVien;
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
	public String toString() {
		return "PhieuPhanCongEntity [maPhieuPhanCong=" + maPhieuPhanCong + ", nhanVien=" + nhanVien + ", caTruc="
				+ caTruc + ", ngay=" + ngay + "]";
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
		if (getClass() != obj.getClass())
			return false;
		PhieuPhanCongEntity other = (PhieuPhanCongEntity) obj;
		return Objects.equals(maPhieuPhanCong, other.maPhieuPhanCong);
	}

	public PhieuPhanCongEntity(String maPhieuPhanCong, NhanVienEntity nhanVien, CaTrucEntity caTruc, LocalDate ngay) {
		super();
		this.maPhieuPhanCong = maPhieuPhanCong;
		this.nhanVien = nhanVien;
		this.caTruc = caTruc;
		this.ngay = ngay;
	}

	public PhieuPhanCongEntity(NhanVienEntity nhanVien, CaTrucEntity caTruc, LocalDate ngay) {
		super();
		this.nhanVien = nhanVien;
		this.caTruc = caTruc;
		this.ngay = ngay;
	}

	public PhieuPhanCongEntity(String maPhieuPhanCong, NhanVienEntity nhanVien, CaTrucEntity caTruc) {
		super();
		this.maPhieuPhanCong = maPhieuPhanCong;
		this.nhanVien = nhanVien;
		this.caTruc = caTruc;
	}
}
