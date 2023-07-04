package quangtester.com.testcases.Bai24_MultiBrowser;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Bai24_TestParameters_CapDoSuites {
    /*
       Đề bài 1 :
        - Khai báo 2 parameter(tham số) từ file .xml (Bai24_SuitesTestParameters_CapDoTest.xml)
    sau đó truyền vào hàm Cong2So
        - Để hàm <parameter name="message" value="QuangDepZai"></parameter> ở ngoài test trong file .xml
        - Tạo ra 3 file test trong file .xml
        => Kết quả là ở hàm test nào cũng in ra được kết quả : QuangDepZai
    */

    @Test
    @Parameters({"number1","number2"})
    public void Cong2So(int num1,int num2) {
        System.out.println("Tổng 2 số ở đề bài 1 là :" + (num1 + num2));
    }

    @Test
    @Parameters({"message"})
    public void Notification(String mess) {
        System.out.println("Thông báo là :" + mess);
    }


}
