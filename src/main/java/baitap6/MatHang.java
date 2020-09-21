package baitap6;

public class MatHang {
    private String maMatHang;
    private String tenHangHoa;
    private long gia;
    private String phanloai;

    public String getMaMatHang() {
        return maMatHang;
    }

    public void setMaMatHang(String maMatHang) {
        this.maMatHang = maMatHang;
    }

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public String getPhanloai() {
        return phanloai;
    }

    public void setPhanloai(String phanloai) {
        this.phanloai = phanloai;
    }

    public MatHang(String maMatHang, String tenHangHoa, long gia, String phanloai) {
        this.maMatHang = maMatHang;
        this.tenHangHoa = tenHangHoa;
        this.gia = gia;
        this.phanloai = phanloai;
    }
}
