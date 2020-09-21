package baitap6;

import java.util.Date;

public class NhanVienBanHang {
    private String maNhanVien;
    private String gioiTinh;
    private Date NgayLamViec;
    private String caDangKi;

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgayLamViec() {
        return NgayLamViec;
    }

    public void setNgayLamViec(Date ngayLamViec) {
        NgayLamViec = ngayLamViec;
    }

    public String getCaDangKi() {
        return caDangKi;
    }

    public void setCaDangKi(String caDangKi) {
        this.caDangKi = caDangKi;
    }

    public NhanVienBanHang(String maNhanVien, String gioiTinh, Date ngayLamViec, String caDangKi) {
        this.maNhanVien = maNhanVien;
        this.gioiTinh = gioiTinh;
        NgayLamViec = ngayLamViec;
        this.caDangKi = caDangKi;
    }
}
