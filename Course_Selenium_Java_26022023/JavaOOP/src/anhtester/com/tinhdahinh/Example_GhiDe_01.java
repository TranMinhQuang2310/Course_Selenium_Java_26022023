package anhtester.com.tinhdahinh;

class Vehicle {
    void run() {
        System.out.println("Vehicle is running");
    }
}

public class Example_GhiDe_01 extends Vehicle {
    void run() {
        System.out.println("Bike is running safely");
    }

    public static void main(String[] args) {
        // Xuất ra hàm con được kế thừa từ hàm cha
        Example_GhiDe_01 obj = new Example_GhiDe_01();
        obj.run();

        System.out.println("--------------");

        // Xuất ra hàm cha
        Vehicle vh = new Vehicle();
        vh.run();
    }
}
