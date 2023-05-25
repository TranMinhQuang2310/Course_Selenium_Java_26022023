package quang.homework.JavaBasic_2;

public class Calculator {
    public void Tong2SoNguyen(int a, int b) {
        System.out.println("Tổng 2 số nguyên là : " + (a+b));
    }
    public void Tich2SoThuc(double c , double d) {
        System.out.println("Tích 2 số thực là : " + (c*d));
    }

    public static void main(String[] args) {
        Calculator cl = new Calculator();

        cl.Tong2SoNguyen(5,10);

        cl.Tich2SoThuc(5,2);
    }


}
