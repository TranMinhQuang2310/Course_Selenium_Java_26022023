package quang.homework.JavaBasic_1;

public class ThongTin {
    //Khai báo các biến static để gọi lại ở class SinhVien và in ra thông tin
    public static void main(String[] args) {
        SinhVien sv = new SinhVien();
        System.out.println("In số điện thoại từ class SinhVien : " + sv.sdt);
    }
}
