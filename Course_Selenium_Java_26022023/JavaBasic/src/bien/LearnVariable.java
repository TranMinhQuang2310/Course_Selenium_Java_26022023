package bien;

public class LearnVariable {

    /*
     HÀM XÂY DỰNG (CONSTRUCTOR) : HÀM TRÙNG TÊN VỚI CLASS
      public LearnVariable() {
        }
    */

    //Khai báo biến : DataType varName [ = value] [, varName2] [ = value2]...;
    public void sayHello() {
        int n = 10; //Đây là biến local
        System.out.println("Giá trị của n là " + n);
    }

    /*
        BIẾN TOÀN CỤC (instance) :
            - Nằm ngoài hàm . Mà trong Class
            - Dùng được nhiều hàm khác nhau
            - Dùng được phạm vi truy cập (public , private ,protected)
            - Có thể gọi tên trực tiếp vào các hàm (Trừ hàm "main" hoặc các hàm có trạng thái static)
    */
    static String city = "Nam Định";
    public void sayCity() {

        System.out.println(city);
    }

    public static void main(String[] args) {

        /*
            BIẾN LOCAL :
                - Nằm trong hàm
                - Không dùng phạm vi truy cập (public , private ,protected)
                - Không được gọi sang các hàm khác
        */

        String name = "Quang Tester";
        int age = 24;
        String address = "HCM";


        System.out.println(name);
        System.out.println(age);
        System.out.println(address);

        //VD1 : Khởi tạo biến local và gọi hàm sayHello thông qua 1 cái hàm để in ra kết quả
        LearnVariable bienLocal = new LearnVariable();
        bienLocal.sayHello();

        //VD2 : Khởi tạo biến toàn cục và gọi hàm trực tiep để in ra kết quả
        System.out.println(city);
    }
}
