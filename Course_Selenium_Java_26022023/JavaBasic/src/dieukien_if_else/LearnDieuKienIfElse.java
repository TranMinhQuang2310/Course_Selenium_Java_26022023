package dieukien_if_else;

public class LearnDieuKienIfElse {
    public static void main(String[] args) {
        int age = 30;
        String name = "Selenium";

        //VD1 : 1 điều kiện
        if(age > 30) {
            System.out.println("Tuổi lớn hơn 30");
        }else {
            System.out.println("Tuổi bé hơn hoặc bằng 30");
        }

        //VD2 : Kết hợp nhiều điều kiện
        //equal : giúp kiểm tra so sánh bằng (áp dụng khi so sánh với kiểu String)
        if(age > 10 && name.equals("Selenium")) {
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
    }
}
