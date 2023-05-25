package anhtester.com.tinhdahinh;

public class Example_napchong_01 {
                    //A. Nạp chồng với thay đổi số lượng tham số

    //-----------Ví dụ 1 -------------
    /*
        - Đặt tên 2 hàm giống nhau nhưng khác số lượng tham số
    */
    //Hàm thứ nhất
    public void tinhTong(int a,int b) {
        System.out.println(a+b);
    }

    //Hàm thứ hai
    public void tinhTong(int a,int b ,int c) {
        System.out.println(a+b+c);
    }

    //-----------Ví dụ 2 -------------
    /*
        VD2 : Tạo ra 2 hàm tên login
    */
    public void login(String username , String password) {
        System.out.println("Set Text: " + username);
        System.out.println("Set Text: " + password);
        System.out.println("Click login button");
    }

    public void login(String username , String password , String validateMessage) {
        System.out.println("Set Text :" + username);
        System.out.println("Set Text: " + password);
        System.out.println("Click login button");
        System.out.println("Verify message: " +validateMessage);
    }


    public static void main(String[] args) {
        Example_napchong_01 nc = new Example_napchong_01();
        //-----------Ví dụ 1 -------------
        /*
            - Tính tổng 2 hàm khai báo ở VD1
        */
        //Tổng hàm thứ nhất
        nc.tinhTong(1,2);

        //Tổng hàm thứ hai
        nc.tinhTong(1,2,3);

        System.out.println("-------------");

        //-----------Ví dụ 2 -------------
        /*
            - Gọi 1 hàm nhập giá trị đúng : admin / 123456 => gọi hàm 1
            - Gọi 1 hàm nhập giá trị password sai : admin / 12345678 => gọi hàm 2 để in ra câu thông báo
        */

        nc.login("admin" , "123456");
        System.out.println("-------------");
        nc.login("admin" , "12345678" , "Sai Username or Password");


    }
}
