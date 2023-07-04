package quangtester.com.testcases.Bai24_MultiBrowser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Bai24_TestParameters_CapDoTest {
    /*
       Đề bài 1 : Khai báo 2 parameter(tham số) từ file .xml (Bai24_SuitesTestParameters_CapDoTest.xml)
    sau đó truyền vào hàm Cong2So để in ra kết quả là : 15
    */
    @Test
    @Parameters({"number1","number2"})
    public void Cong2So(int num1,int num2) {
        System.out.println("Tổng 2 số ở Đề bài 1 là :" + (num1 + num2));
    }

    /*
       Đề bài 2 : Khai báo :
            - 1 parameter(tham số) từ file .xml (Bai24_SuitesTestParameters_CapDoTest.xml)
            - 1 tham số mặc định
    sau đó truyền vào hàm Tich2So để in ra kết quả là : 12
    */
    @Test
    @Parameters({"number3","number4"})
    public void Tich2So(int num3, @Optional("4") int num4) {
        System.out.println("Tích 2 số ở Đề bài 2 là :" + (num3 * num4));
    }

}
