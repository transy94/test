import java.util.*;


public class SinhVien {

    String ten;
    String diachi;
    int GPA;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

    public SinhVien(String ten, String diachi, int GPA) {
        this.ten = ten;
        this.diachi = diachi;
        this.GPA = GPA;

    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "ten='" + ten + '\'' +
                ", diachi='" + diachi + '\'' +
                ", GPA=" + GPA +
                '}';
    }

    public static void main(String[] args) {
        List<SinhVien> list = new ArrayList<SinhVien>();
        list.add(new SinhVien("sy1","hn1",2));
        list.add(new SinhVien("sy2","hn2",7));
        list.add(new SinhVien("sy3","hn3",6));
        list.add(new SinhVien("sy4","hn4",5));
        list.add(new SinhVien("sy5","hn5",4));
        list.add(new SinhVien("sy6","hn6",3));
        list.add(new SinhVien("sy7","hn7",8));
        list.add(new SinhVien("sy8","hn8",9));
        Collections.sort(list, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return  o1.getGPA()- o2.getGPA();
            }
        });
        System.out.println(list);
//    list.stream().limit(4).forEach(s-> System.out.println(s));
    list.stream().filter(p-> p.getGPA()>5).forEach(s-> System.out.println(s));



    }
}
