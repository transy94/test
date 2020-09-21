package baitap6;

public class KhachHang {
    private String maKhacHang;
    private String gioiTinh;
    private int tuoi;

    public String getMaKhacHang() {
        return maKhacHang;
    }

    public void setMaKhacHang(String maKhacHang) {
        this.maKhacHang = maKhacHang;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public KhachHang(String maKhacHang, String gioiTinh, int tuoi) {
        this.maKhacHang = maKhacHang;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
    }
}
