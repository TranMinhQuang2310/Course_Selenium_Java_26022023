package anhtester.com.tinhdahinh;

public class Example_napchong_02 {
                        //B .Nạp chồng với thay đổi kiểu dữ liệu của tham số
     //-----------Ví dụ 1 -------------
    /*
        - Đặt tên 2 hàm giống nhau nhưng khác kiểu dữ liệu
    */
     //Hàm thứ nhất
    public int add(int a,int b) {
        return a + b;
    }

    //Hàm thứ hai
    public double add(double a , double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Example_napchong_02 nc2 = new Example_napchong_02();

        //-----------Ví dụ 1 -------------
        /*
            - Tính tổng 2 hàm khai báo ở VD1
        */
        //Tổng hàm thứ nhất
        System.out.println(nc2.add(5,7));

        //Tổng hàm thứ hai => Chuyển từ kiểu double sang int cho mất .0 đằng sau
        System.out.println((int)nc2.add(5,10.0));
    }



}
