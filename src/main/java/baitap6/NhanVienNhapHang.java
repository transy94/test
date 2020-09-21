package baitap6;

import java.util.Date;

public class NhanVienNhapHang {
    private String maNhanVien;
    private String gioiTinh;
    private Date ngayLamViec;
    private int thamNien;

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
        return ngayLamViec;
    }

    public void setNgayLamViec(Date ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public int getThamNien() {
        return thamNien;
    }

    public void setThamNien(int thamNien) {
        this.thamNien = thamNien;
    }

    public NhanVienNhapHang(String maNhanVien, String gioiTinh, Date ngayLamViec, int thamNien) {
        this.maNhanVien = maNhanVien;
        this.gioiTinh = gioiTinh;
        this.ngayLamViec = ngayLamViec;
        this.thamNien = thamNien;
    }
}
