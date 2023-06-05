package quangtester.com.Bai24_MultiBrowser;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Bai24_TestParameters_CapDoTestAndSuites {
    /*
       Đề bài 1 :
       - Khai báo 2 parameter(tham số) từ file .xml (Bai24_SuitesTestParameters_CapDoTest.xml)
    sau đó truyền vào hàm Cong2So để in ra kết quả
        - Trong file .xml :
            + Vừa để  2 parameter(tham số) ở trong suites và trong test luôn
      ===> Kết quả là : 15 . Do TestNG ưu tiên cho các Tham số được xác định ở cấp thử nghiệm (Test) hơn các tham số
      được đặt ở cấp bộ (Suite).
    */
    @Test
    @Parameters({"number1","number2"})
    public void Cong2So(int num1,int num2) {
        System.out.println("Tổng 2 số ở Đề bài 1 là :" + (num1 + num2));
    }
}
