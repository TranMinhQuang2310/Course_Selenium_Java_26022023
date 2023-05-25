package quang.homework.JavaOOP_1;

public class ThongTin {
    public static void main(String[] args) {
        NhanVien nv = new NhanVien();
        System.out.println("Tên :" + nv.getName());
        System.out.println("Tuổi :" + nv.getAge());
        System.out.println("Địa chỉ :" + nv.getAddress());
        System.out.println("Tên nghề nghiệp :" + nv.getJobName());
    }
}
