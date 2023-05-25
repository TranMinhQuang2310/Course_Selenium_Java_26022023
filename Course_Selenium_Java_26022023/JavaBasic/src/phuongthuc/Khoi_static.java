package phuongthuc;

public class Khoi_static {
    //In nguyên khối static chạy trước hàm main
    static {
        System.out.println("Khối static : Hello");
    }
    public static void main(String[] args) {
        System.out.println("Main : hello ");
    }
}
