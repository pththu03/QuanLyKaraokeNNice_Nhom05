﻿USE [master]
GO

DROP DATABASE QuanLyKaraokeNNice
GO

CREATE DATABASE QuanLyKaraokeNNice
GO

USE QuanLyKaraokeNNice
GO

-- 1 tao ma tu tang bang nhan vien
CREATE FUNCTION AUTO_ID_NhanVien()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaNhanVien) FROM NhanVien) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaNhanVien, 3) AS INT)) FROM NhanVien
	SET @ID = @ID + 1

	DECLARE @MaNhanVien VARCHAR(7)
	SET @MaNhanVien = 'NV' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaNhanVien
END
GO

-- 2 tao ma tu tang bang khach hang
CREATE FUNCTION AUTO_ID_KhachHang()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaKhachHang) FROM [dbo].[KhachHang]) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaKhachHang, 3) AS INT)) FROM [dbo].[KhachHang]
	SET @ID = @ID + 1

	DECLARE @MaKhachHang VARCHAR(7)
	SET @MaKhachHang = 'KH' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaKhachHang
END
GO

-- 3 tao ma tu tang bang loai phong
CREATE FUNCTION AUTO_ID_LoaiPhong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaLoaiPhong) FROM LoaiPhong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaLoaiPhong, 3) AS INT)) FROM LoaiPhong
	SET @ID = @ID + 1

	DECLARE @MaLoaiPhong VARCHAR(7)
	SET @MaLoaiPhong = 'LP' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaLoaiPhong
END
GO

-- 4 tao ma tu tang bang phong
CREATE FUNCTION AUTO_ID_Phong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaPhong) FROM Phong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaPhong, 3) AS INT)) FROM Phong
	SET @ID = @ID + 1

	DECLARE @MaPhong VARCHAR(7)
	SET @MaPhong = 'P' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaPhong
END
GO

-- 5 tao ma tu tang bang loai dich vu
CREATE FUNCTION AUTO_ID_LoaiDichVu()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaLoaiDichVu) FROM LoaiDichVu) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaLoaiDichVu, 3) AS INT)) FROM LoaiDichVu
	SET @ID = @ID + 1

	DECLARE @MaLoaiDichVu VARCHAR(7)
	SET @MaLoaiDichVu = 'LDV' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaLoaiDichVu
END
GO

-- 6 tao ma tu tang bang dich vu
CREATE FUNCTION AUTO_ID_DichVu()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaDV) FROM DichVu) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaDV, 3) AS INT)) FROM DichVu
	SET @ID = @ID + 1

	DECLARE @MaDV VARCHAR(7)
	SET @MaDV = 'DV' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaDV
END
GO

-- 7 tao ma tu tang bang hoa don 
CREATE FUNCTION AUTO_ID_HoaDon()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaHoaDon) FROM HoaDon) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaHoaDon, 3) AS INT)) FROM HoaDon
	SET @ID = @ID + 1

	DECLARE @MaHoaDon VARCHAR(7)
	SET @MaHoaDon = 'HD' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaHoaDon
END
GO

-- 8 tao ma tu tang bang chi tiet hoa don
CREATE FUNCTION AUTO_ID_ChiTietHoaDon()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaChiTietHoaDon) FROM ChiTietHoaDon) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaChiTietHoaDon, 3) AS INT)) FROM ChiTietHoaDon
	SET @ID = @ID + 1

	DECLARE @MaChiTietHoaDon VARCHAR(7)
	SET @MaChiTietHoaDon = 'CTHD' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaChiTietHoaDon
END
GO 

-- 9 tao ma tu tang bang chi tiet dich vu
CREATE FUNCTION AUTO_ID_ChiTietDatPhong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaChiTietDatPhong) FROM ChiTietDatPhong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaChiTietDatPhong, 3) AS INT)) FROM ChiTietDatPhong
	SET @ID = @ID + 1

	DECLARE @MaChiTietDatPhong VARCHAR(7)
	SET @MaChiTietDatPhong = 'CTDP' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaChiTietDatPhong
END
GO 

-- 10 tao ma tu tang bang chi tiet dich vu
CREATE FUNCTION AUTO_ID_ChiTietDichVu()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaChiTietDichVu) FROM ChiTietDichVu) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaChiTietDichVu, 3) AS INT)) FROM ChiTietDichVu
	SET @ID = @ID + 1

	DECLARE @MaChiTietDichVu VARCHAR(7)
	SET @MaChiTietDichVu = 'CTDV' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaChiTietDichVu
END
GO 

-- 11 tao ma tu tang bang chi tiet dich vu
CREATE FUNCTION AUTO_ID_PhieuDatPhong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaPhieuDatPhong) FROM PhieuDatPhong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaPhieuDatPhong, 3) AS INT)) FROM PhieuDatPhong
	SET @ID = @ID + 1

	DECLARE @MaPhieuDatPhong VARCHAR(7)
	SET @MaPhieuDatPhong = 'PDP' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaPhieuDatPhong
END
GO 

-- 12 tao ma tu tang bang ca truc
CREATE FUNCTION AUTO_ID_CaTruc()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaCaTruc) FROM CaTruc) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaCaTruc, 3) AS INT)) FROM CaTruc
	SET @ID = @ID + 1

	DECLARE @MaCaTruc VARCHAR(7)
	SET @MaCaTruc = 'CT' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaCaTruc
END
GO

-- 13 TAO MA AUTO BANG PHAN CONG
CREATE FUNCTION AUTO_ID_PhieuPhanCong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaPhieuPhanCong) FROM PhieuPhanCong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaPhieuPhanCong, 3) AS INT)) FROM PhieuPhanCong
	SET @ID = @ID + 1

	DECLARE @MaPhieuPhanCong VARCHAR(7)
	SET @MaPhieuPhanCong = 'PPC' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaPhieuPhanCong
END
GO

-- 14 TAO MA AUTO BANG PHIEU CHAM CONG
CREATE FUNCTION AUTO_ID_PhieuChamCong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaPhieuChamCong) FROM PhieuChamCong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaPhieuChamCong, 3) AS INT)) FROM PhieuChamCong
	SET @ID = @ID + 1

	DECLARE @MaPhieuChamCong VARCHAR(7)
	SET @MaPhieuChamCong = 'PCC' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaPhieuChamCong
END
GO

--------------------------------------------------------------------------
--------------------------------------------------------------------------
-- 1
CREATE TABLE NhanVien( 
	MaNhanVien VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_NhanVien(),
	HoTen NVARCHAR(30) NOT NULL,
	SoDienThoai VARCHAR(10) NOT NULL,
	Email VARCHAR(100) NOT NULL,
	CCCD VARCHAR(12) NOT NULL,
	Password VARCHAR(100) NOT NULL,
	NamSinh INT NOT NULL,
	MucLuong MONEY NOT NULL,
	ChucVu NVARCHAR(8) NOT NULL,
	TrangThai NVARCHAR(13) NOT NULL -- Đã nghỉ hoặc đang làm việc
) 
GO

--2 
CREATE TABLE KhachHang(
	MaKhachHang VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_KhachHang(),
	HoTen NVARCHAR(30) NOT NULL,
	SoDienThoai VARCHAR(10) NOT NULL,
	Email VARCHAR(100),
	NamSinh INT NOT NULL,
	SoLanDatPhong INT DEFAULT 0 NOT NULL
)
GO

-- 3
CREATE TABLE LoaiPhong(
	MaLoaiPhong VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_LoaiPhong(),
	TenLoai NVARCHAR(50) NOT NULL
) 
GO

-- 4
CREATE TABLE Phong(
	MaPhong	VARCHAR(7) PRIMARY KEY DEFAULT DBO.AUTO_ID_Phong() NOT NULL,
	SoPhong INT NOT NULL,
	MaLoaiPhong VARCHAR(7) NOT NULL, -- VIP hoặc thường
	TrangThai NVARCHAR(15) NOT NULL, -- Trống, đang sử dụng, phòng chờ
	SucChua int NOT NULL
) 
GO

-- 5
CREATE TABLE LoaiDichVu(
	MaLoaiDichVu VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_LoaiDichVu(),
	TenLoaiDichVu NVARCHAR(50) NOT NULL
) 
GO

-- 6
CREATE TABLE DichVu(
	MaDichVu VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_DichVu(),
	TenDichVu NVARCHAR(50) NOT NULL,
	MaLoaiDichVu VARCHAR(7) NOT NULL,
	Gia MONEY NOT NULL
)
GO

-- 7
CREATE TABLE PhieuDatPhong(
	MaPhieuDatPhong VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_PhieuDatPhong(),
	MaKhachHang VARCHAR(7) NOT NULL,
	MaPhong VARCHAR(7) NOT NULL,
	NgayDat DATE NOT NULL
) 
GO

-- 8
CREATE TABLE HoaDon(
	MaHoaDon VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_HoaDon(),
	MaNhanVien VARCHAR(7) NOT NULL,
	MaKhachHang VARCHAR(7) NOT NULL,
	NgayLap DATE NOT NULL,
	GioLap TIME NOT NULL
) 
GO

-- 9
CREATE TABLE ChiTietHoaDon(
	MaChiTietHoaDon VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_ChiTietHoaDon(),
	MaHoaDon VARCHAR(7),
	MaChiTietDatPhong VARCHAR(7) NOT NULL,
	MaChiTietDichVu VARCHAR(7) NOT NULL
) 
GO

-- 10
CREATE TABLE ChiTietDatPhong(
	MaChiTietDatPhong VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_ChiTietDatPhong(),
	MaPhong VARCHAR(7) NOT NULL,
	GioNhanPhong TIME NOT NULL,
	GioTraPhong TIME NOT NULL
) 
GO

-- 11
CREATE TABLE ChiTietDichVu(
	MaChiTietDichVu VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_ChiTietDichVu(),
	MaDichVu VARCHAR(7) NOT NULL,
	SoLuong INT NOT NULL
) 
GO

-- 12
CREATE TABLE CaTruc(
	MaCaTruc VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_CaTruc(),
	TenCaTruc NVARCHAR(10) NOT NULL,
	GioBatDau TIME NOT NULL,
	GioKetThuc TIME NOT NULL
) 
GO

-- 13
CREATE TABLE PhieuPhanCong(
	MaPhieuPhanCong VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_PhieuPhanCong(),
	MaNhanVien VARCHAR(7) NOT NULL,
	MaCaTruc VARCHAR(7) NOT NULL,
	Ngay DATE NOT NULL
) 
GO

-- 14
CREATE TABLE PhieuChamCong(
	MaPhieuChamCong VARCHAR(7) NOT NULL PRIMARY KEY DEFAULT DBO.AUTO_ID_PhieuChamCong(),
	MaPhieuPhanCong VARCHAR(7) NOT NULL,
	TrangThai NVARCHAR(10) NOT NULL
) 
GO

----------------------------------------------------------------
----------------------------------------------------------------

ALTER TABLE ChiTietDatPhong ADD 
FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong)
GO

ALTER TABLE ChiTietDichVu ADD
FOREIGN KEY (MaDichVu) REFERENCES DichVu(MaDichVu)
GO

ALTER TABLE ChiTietHoaDon ADD
FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
FOREIGN KEY (MaChiTietDatPhong) REFERENCES ChiTietDatPhong(MaChiTietDatPhong),
FOREIGN KEY (MaChiTietDichVu) REFERENCES ChiTietDichVu(MaChiTietDichVu)
GO

ALTER TABLE DichVu ADD
FOREIGN KEY (MaLoaiDichVu) REFERENCES LoaiDichVu(MaLoaiDichVu)
GO

ALTER TABLE HoaDon ADD
FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien),
FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang)
GO

ALTER TABLE PhieuChamCong ADD
FOREIGN KEY (MaPhieuPhanCong) REFERENCES PhieuPhanCong(MaPhieuPhanCong)
GO

ALTER TABLE PhieuDatPhong ADD
FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
FOREIGN KEY (MaPhong) REFERENCES Phong(MaPhong)
GO

ALTER TABLE PhieuPhanCong ADD
FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien),
FOREIGN KEY (MaCaTruc) REFERENCES CaTruc(MaCaTruc)
GO

ALTER TABLE Phong ADD
FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong(MaLoaiPhong)
GO

---------------------------------------
---------------------------------------

CREATE TRIGGER ThemHoaDon
ON HoaDon
AFTER INSERT 
AS
	DECLARE @MaKhachHang VARCHAR(7)
	SELECT @MaKhachHang = INSERTED.MaKhachHang FROM INSERTED
	IF NOT EXISTS (SELECT * FROM [dbo].[KhachHang] WHERE MaKhachHang = @MaKhachHang)
		ROLLBACK
	
	UPDATE [dbo].[KhachHang]
	SET SoLanDatPhong = SoLanDatPhong + 1
	WHERE MaKhachHang = @MaKhachHang
GO

CREATE TRIGGER XoaChiTietHoaDon
ON ChiTietHoaDon
AFTER DELETE
AS
	DECLARE @MaChiTietDatPhong VARCHAR(7), @MaChiTietDichVu VARCHAR(7), @MaPhong VARCHAR(7)
	SELECT @MaChiTietDatPhong = DELETED.MaChiTietDatPhong, @MaChiTietDichVu = DELETED.MaChiTietDichVu FROM DELETED
	IF EXISTS (SELECT * FROM ChiTietDatPhong WHERE ChiTietDatPhong.MaChiTietDatPhong = @MaChiTietDatPhong)
		SELECT @MaPhong = MaPhong FROM ChiTietDatPhong WHERE ChiTietDatPhong.MaChiTietDatPhong = @MaChiTietDatPhong
	ELSE
		ROLLBACK
	IF NOT EXISTS (SELECT * FROM ChiTietDichVu WHERE ChiTietDichVu.MaChiTietDichVu = @MaChiTietDichVu)
		ROLLBACK

	UPDATE Phong
	SET TrangThai = N'Trống'
	WHERE MaPhong = @MaPhong
GO

----------------------------------------------------------------------------------------------------------
--____________________________________________INSERT DATA_________________________________________________

INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Phan Thị Huỳnh Thư', '0333411964', 'phanthihthu@gmail.com', '226505948824', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1993, 35000, N'Quản lí', N'Đang làm việc')
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Trần Thị Huyền Trân', '0907293510', 'tranthihuyentran@gmail.com', '222828115276', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1999, 30000, N'Quản lí', N'Đang làm việc')
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Minh Hải', '0389660754', 'nguyenhai2009@gmail.com', '217958221685', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1989, 28000, N'Tiếp tân', N'Đang làm việc')
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Tiến Dũng', '0782566343', 'nguyentdung1110@gmail.com', '211019927954', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2000, 28000, N'Tiếp tân', N'Đang làm việc')
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Phan Thanh Nam', '0936279762', 'thanhnam1210@gmail.com', '219422793198', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2000, 28000, N'Tiếp tân', N'Đã nghỉ')
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Vân', '0984164251', 'nguyenvan@gmail.com', '227794341138', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1999, 28000, N'Tiếp tân', N'Đang làm việc')
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Bùi Tuấn Phú', '0982464251', 'fubui03@gmail.com', '229894341138', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1999, 28000, N'Tiếp tân', N'Đang làm việc')
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Thị Nên Hoài', '0982876251', 'nenhoai@gmail.com', '229894344538', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2000, 29000, N'Tiếp tân', N'Đang làm việc')
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Trần Thị Lệ Giang', '0970876251', 'legiang0301@gmail.com', '229894994538', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2001, 30000, N'Tiếp tân', N'Đang làm việc')
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Văn Công Thành Đạt', '0367306158', 'vancongthanhdata10@gmail.com', '229004994538', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2003, 27000, N'Tiếp tân', N'Đang làm việc')
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Tấn Thái Dương', '0356309561', 'duongnguyen1323@gmail.com', '229004994538', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1998, 31000, N'Tiếp tân', N'Đang làm việc')
GO

select * from NhanVien

INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Dương Hoàng Lan Anh', '0906809981', 'dhlananh2309@gmail.com', 1998)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Hoàng Anh', '0941727338', 'hoanganh54321.oc@gmail.com', 2000)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lý Nhựt Anh', '0915841171', 'Lynhutanh26@gmail.com', 2000)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Nhựt Anh', '0939968135', 'nhutanh123abc@gmail.com', 1999)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Thị Ánh', '0355615214', 'nguyenthianh0514@gmail.com', 2004)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Vũ Thảo Ánh', '0356690717', 'thaoanh.0717@gmail.com', 2004)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Gia Bảo', '0934776810', 'datbao124@gmail.com', 2001)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Huỳnh Thế Bảo', '0374151952', ' nguyenhuynhthebao29@gmail.com', 2001)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Lê Gia Bảo', '0931508027', ' nguyenlegiabao810@gmail.com', 1997)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Trần Chí Bảo', '0337061506', 'baotran.060103@gmail.com', 1998)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Bùi Thanh Bình', '0707102548', 'Thanhbinh14062003@gmail.com', 2000)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Vũ Hòa Bình', '0866625408', 'hoabinh.viprpro63@gmail.com', 2001)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Đinh Nguyên Chung', '0335090607', 'dinhvanchung24042003@gmail.com', 1998)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Thành Cương', '0349424156', ' nguyenthanh8a2@gmail.com', 1999)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Duy Cường', '0836985735', ' Nguyenduycuong712@gmail.com', 1999)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Tấn Đãm', '0834848767', ' Tandam9902@gmail.com', 1999)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Đặng Duy Hồ Điệp', '0344037974', ' diepakpro@gmail.com', 2005)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lê Thiên Định', '0389832067', ' lethiendinh123@gmail.com', 2005)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Văn Đủ', '0886550735', '  nguyenvandu222k4@gmail.com', 2000)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Đặng Mãi Chí Đức ', '0876040304', '  duc1211depv@gmail.com', 2002)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Võ Huỳnh Đức ', '0964335169', '  ducfazi14@gmail.com', 1999)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lê Minh Thư', '0384573214', 'leminhthu@gmail.com', 1999)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Trịnh Khang Ninh', '0384573453', 'khangninh@gmail.com', 1989)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Tống Anh Quân', '0388973214', 'nguyenanhquan@gmail.com', 1999)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Trần Đức Vũ', '0385732141', 'tranducvu@gmail.com', 1979)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Thành Nghiêm', '0384532564', 'thanhnghiem@gmail.com', 2000)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Vòng Vĩnh Lợi', '0384589653', 'vvloi@gmail.com', 1985)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Tiến Hoàng', '0384892314', 'nthoang@gmail.com', 1994)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lê Bá Hậu', '0384598371', 'lebahau@gmail.com', 1992)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Thanh Hiền', '0381242314', 'thanhhien@gmail.com', 2000)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lê Hữu Duy', '0373127573', 'lehuuduy@gmail.com', 1991)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Thanh Tuyền', '0309650214', 'nguyenthanhtien@gmail.com', 1995)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Trần Huỳnh Bắc', '0984643251', 'huynhbac05@gmail.com', 2005)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Phan Huỳnh Tuấn', '0976643251', 'phtuan01@gmail.com', 2001)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Trương Trần Quốc Quân', '0970973251', 'ttquocquan@gmail.com', 2003)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lê Minh Đại', '0982535251', 'leminhdai003@gmail.com', 2003)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Đặng Trần Đan Vũ', '0809633251', 'vuxinhdep@gmail.com', 2000)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Thị Thanh Ngân', '0954363251', 'thanhngan99@gmail.com', 1999)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lê Thị Phương Xa', '0908782212', 'lethiphuongxa@gmail.com', 1993)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Ngọc Hạ', '0809638764', 'nguyenngocha0402@gmail.com', 2002)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Triệu Gia Bảo', '0996538754', 'trieugiabao0903@gmail.com', 2003)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Hàng Tuyết My', '0977238753', 'mymy0899@gmail.com', 1999)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Đinh Trần Anh Quân', '0977238876', 'daicaquan02@gmail.com', 2002)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Đình Đan Phi', '0883389234', 'nguyendinhdanfi@gmail.com', 1990)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Thị Trúc Uyên', '0988238594', 'uyenuyencongchua@gmail.com', 1989)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Phùng Thị Kim Trúc', '0992138284', 'ptktruc97@gmail.com', 1997)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Phan Như Uyên', '0903058232', 'phannhuuyen95@gmail.com', 1995)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Nhật Khánh', '0965338221', 'nguyennhatkhanh@gmail.com', 1998)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Bá Nha', '0969938253', 'banha010394@gmail.com', 1993)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Trần Thanh Sang', '0847898234', 'tranthanhsang93@gmail.com', 1993)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lê Văn Rôn', '0882498254', 'levanron02@gmail.com', 1992)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Lưu Anh Thư', '0987898874', 'nguyenluuanhthu@gmail.com', 2001)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Phan Huy Phong', '0993898874', 'huyphong@gmail.com', 2001)
GO

INSERT INTO [dbo].[LoaiPhong] (TenLoai) VALUES (N'Thường')
INSERT INTO [dbo].[LoaiPhong] (TenLoai) VALUES (N'VIP')
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (101, 'LP001', N'Trống', 10)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (102, 'LP001', N'Trống', 20)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (103, 'LP001', N'Trống', 10)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (104, 'LP001', N'Trống', 10)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (105, 'LP001', N'Trống', 20)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (201, 'LP002', N'Trống', 10)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (202, 'LP002', N'Trống', 10)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (203, 'LP002', N'Trống', 20)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (204, 'LP002', N'Trống', 10)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (205, 'LP002', N'Trống', 20)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (206, 'LP002', N'Trống', 20)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (207, 'LP002', N'Trống', 20)
GO

INSERT INTO [dbo].[LoaiDichVu] ([TenLoaiDichVu]) VALUES (N'Nước uống')
INSERT INTO [dbo].[LoaiDichVu] ([TenLoaiDichVu]) VALUES (N'Món chính')
INSERT INTO [dbo].[LoaiDichVu] ([TenLoaiDichVu]) VALUES (N'Tráng miệng')
INSERT INTO [dbo].[LoaiDichVu] ([TenLoaiDichVu]) VALUES (N'Khai vị')
GO

INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Nước ép trái cây', 'LDV001', 35000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Nước khoáng', 'LDV001', 20000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Coca-Cola', 'LDV001', 25000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Pepsi', 'LDV001', 25000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Sữa tươi', 'LDV001', 30000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Bia Tiger', 'LDV001', 50000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Bia Heineken', 'LDV001', 25000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Rượu vang đỏ', 'LDV001', 25000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Rượu vang trắng', 'LDV001', 100000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Cocktail Mojito', 'LDV001', 70000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Cocktail Margarita', 'LDV001', 70000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Trà đá', 'LDV001', 20000)

INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Bánh kem', 'LDV003', 100000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Chè thập cẩm', 'LDV003', 40000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Trái cây theo mùa', 'LDV003', 80000)

INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Mực chiên giòn', 'LDV002', 100000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Cơm chiên hải sản', 'LDV002', 120000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Lẩu thái', 'LDV002', 250000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Gà nước BBQ', 'LDV002', 150000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Cá hồi áp chảo', 'LDV002', 180000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Bò xào lá lốt', 'LDV002', 180000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Tôm sốt me', 'LDV002', 160000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Tôm rim mặn ngọt', 'LDV002', 120000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Gà rang muối', 'LDV002', 150000)

INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Bánh tráng nướng', 'LDV004', 50000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Gỏi cuốn', 'LDV004', 50000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Nem rán', 'LDV004', 55000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Chả giò', 'LDV004', 55000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Khoai tây chiên', 'LDV004', 45000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Salad rau củ', 'LDV004', 40000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Soup cua', 'LDV004', 60000)

--INSERT INTO [dbo].DichVu  ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Tiệc sinh nhật', N'Tiệc', 2000000)
--INSERT INTO [dbo].DichVu  ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Tiệc họp mặt gia đình, bạn bè', N'Tiệc', 2000000)
--INSERT INTO [dbo].DichVu  ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Tiệc công ty', N'Tiệc', 3000000)
--INSERT INTO [dbo].DichVu  ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Tiệc cầu hôn', N'Tiệc', 3000000)
GO


SELECT * FROM NhanVien
WHERE SoDienThoai = '0333411964' AND Password = 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f' AND TrangThai = N'Đang làm việc'