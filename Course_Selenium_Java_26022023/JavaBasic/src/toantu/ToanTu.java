package toantu;

public class ToanTu {
    public static void main(String[] args) {
        int a = 40;
        int b = 20;

        //VD1 : Toán tử số học
        System.out.println(a+b);

        //VD2 : Toán tử bit
        System.out.println(a ^ b);

        //VD3 : Toán tử quan hệ (dùng so sánh)
        System.out.println(a == b);

        //VD4 : Toán tử logic (dùng để ghép)
        System.out.println((a > 30) || (b < 10));

        //VD5: Toán tử gán
        String name,address,city; //Tất cả những biến này đều mang cùng kiểu dữ liệu là String
        name = address = city = "HCM";
        System.out.println(name + address + city);


    }
}
