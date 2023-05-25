package quang.homework.JavaBasic_1;

public class SinhVien {

    //Khai báo 3 loại biến (local, instance, static) gọi lại in ra ở 3 hàm trong class sau đó gọi nó ở hàm main

    //1 . Biến local
    public void InfoSV_Local() {
        String name = "Quang";
        System.out.println("Tên của SV là : " + name);
    }

    //2. Biến instance
    private String diachi = "TPHCM";
    public void InfoSV_instance() {
        System.out.println("Địa chỉ của SV là :" + diachi);
    }

    //3 Biến static
    public static String sdt  = "012334";
    public void InfoSV_static() {
        System.out.println("SDT của SV là :" + sdt);
    }


    public static void main(String[] args) {
        SinhVien sv = new SinhVien();

        //Gọi hàm local
        sv.InfoSV_Local();

        //Gọi hàm instance
        sv.InfoSV_instance();

        //Gọi hàm static
        sv.InfoSV_static();

    }
}
