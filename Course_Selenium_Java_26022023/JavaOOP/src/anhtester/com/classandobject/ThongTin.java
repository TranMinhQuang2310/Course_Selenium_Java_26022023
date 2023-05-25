package anhtester.com.classandobject;

public class ThongTin {
    public static void main(String[] args) {
        NhanVien nv = new NhanVien();
        nv.getAddress();

        nv.setName("Nga");
        System.out.println(nv.getName());
    }
}
