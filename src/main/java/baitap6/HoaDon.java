package baitap6;

import java.util.Date;

public class HoaDon {
   private String maDonHang;
   private   String maNhanVienBanHang;
   private String maKhachHang;
   private String danhSachMatHang;
   private long tongGia;
   private   Date ngayMua;

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getMaNhanVienBanHang() {
        return maNhanVienBanHang;
    }

    public void setMaNhanVienBanHang(String maNhanVienBanHang) {
        this.maNhanVienBanHang = maNhanVienBanHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getDanhSachMatHang() {
        return danhSachMatHang;
    }

    public void setDanhSachMatHang(String danhSachMatHang) {
        this.danhSachMatHang = danhSachMatHang;
    }

    public long getTongGia() {
        return tongGia;
    }

    public void setTongGia(long tongGia) {
        this.tongGia = tongGia;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public HoaDon(String maDonHang, String maNhanVienBanHang, String maKhachHang,
                  String danhSachMatHang, long tongGia, Date ngayMua) {
        this.maDonHang = maDonHang;
        this.maNhanVienBanHang = maNhanVienBanHang;
        this.maKhachHang = maKhachHang;
        this.danhSachMatHang = danhSachMatHang;
        this.tongGia = tongGia;
        this.ngayMua = ngayMua;
    }
}
