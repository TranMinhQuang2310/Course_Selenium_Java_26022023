package phuongthuc;

public class Counter2 {
        //Đếm số sử dụng biến static
        static int count = 0 ;//Lấy bộ nhớ khi khởi tạo class
    Counter2() {
        count++;
        System.out.println(count);
    }
    public static void main(String[] args) {
        Counter2 c1 = new Counter2(); //count = 1
        Counter2 c2 = new Counter2(); //count = count + 1 = 2
        Counter2 c3 = new Counter2(); //count = count + 1 = 3
    }
}
