package phuongthuc;

public class Counter1 {
    //Đếm số không sử dụng biến static
    int count = 0 ; // Lấy bộ nhớ khi khởi tạo class

    Counter1() {
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        //Khởi tạo class 3 lần
        Counter1 c1 = new Counter1(); //count = 1
        Counter1 c2 = new Counter1(); //count = 1
        Counter1 c3 = new Counter1(); //count = 1


    }
}
