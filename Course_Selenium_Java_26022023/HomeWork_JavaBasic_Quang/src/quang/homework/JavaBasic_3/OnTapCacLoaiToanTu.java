package quang.homework.JavaBasic_3;

public class OnTapCacLoaiToanTu {

    /*
           - Tạo hàm truyền tham số int ""n"" và Dùng câu lệnh IF Else để đặt điều kiện cho tham số n truyền vào đó:
                + TH1:  = n
                + TH2:  > n
                + TH3:  < n"
            - Gọi lại hàm này xuống main để truyền giá trị vào hàm kiểm tra
    */
    public static void Test(int n1,int n2) {
        System.out.println((n1 == n2) ? "Đúng" : "Sai");
        System.out.println((n1 > n2) ? "Đúng" : "Sai");
        System.out.println((n1 < n2) ? "Đúng" : "Sai");

    }


    public static void main(String[] args) {
        Test(2,3);
        System.out.println("-------");

        /*
            - Tạo class ôn tập các loại toán tử: quan hệ, logic
            - Tạo ra ít nhất 3 biến lưu giá trị trong class đó
            - Thực hiện các loại toán tử trên các biến trên
        */
        int a = 1;
        int b = 2;
        int c = 3;

        //Toán tử quan hệ
        //1. So sánh bằng
        System.out.println(a == b);
        //2. So sánh khác
        System.out.println(a != b);
        //3. Lớn hơn
        System.out.println(a > b);
        //4. Nhỏ hơn
        System.out.println(a < b);
        //5. Lớn hơn hoặc bằng
        System.out.println(a >= b);
        //6.Nhỏ hơn hoặc bằng
        System.out.println(a <= b);

        System.out.println("------");

        //Toán tử logic
        //1. Toán tử và (AND)
        System.out.println(a > 2 && c > 2);
        //2. Toán tử hoặc (OR)
        System.out.println(a > 2 || c > 2);
        //3. Toán tử XOR
        System.out.println(a > 2 ^ b > 2);
        //4. Toán tử phủ định (NOT)
        System.out.println(!(a > b));



    }
}
