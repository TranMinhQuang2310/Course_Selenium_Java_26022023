package quangtester.com.Bai29_DataProvider.UseInPOM;

import org.testng.annotations.Test;
import quangtester.com.Bai29_DataProvider.TestOtherClass.DataLogin;
import quangtester.com.common.Bai26_BaseTest;
import quangtester.com.pages.Bai17_Pages_LearnPOM.LoginPage;

import java.util.Hashtable;

public class LoginTest_Use_DataProvider extends Bai26_BaseTest {

    //LoginTest_Use_DataProvider dùng để khởi tạo class đó và truyền driver vào
    //Khởi tạo đối tượng class
    LoginPage_Use_DataProvider loginPage;

    //Tạo 1 testcase đăng nhập

    //1. Chạy DataProvider từ class SystemHelper
    @Test(dataProvider = "dataProviderLoginCRM",dataProviderClass = DataLogin.class)
    public void loginTestSuccess(String email,String password) {
        loginPage = new LoginPage_Use_DataProvider();
        loginPage.login(email,password);
    }

    //2. Đọc Excel tất cả các dòng trong một Sheet
    /*
         Cách cấu hình file Excel để Run file
         VD trong file excel có 3 cột 3 dòng :
            EMAIL	                PASSWORD	RESULT
            admin@example.com	    123456
            admin123@example.com	123456

         B1: Chuyển dòng 2 và 3 ở cột Password về kiểu String bằng cách thêm dấu nháy trước 123456
         B2 : Xóa 1 vài cột và 1 vài hàng trống trong file excel
         B3 : Thêm 1 dấu nháy (hoặc dấu cách) ở cột Result
    */
    //
    @Test(dataProvider = "data_provider_login_excel",dataProviderClass = DataLogin.class)
    public void loginTestFormDataProviderReadExcel(String email,String password,String result) {
        loginPage = new LoginPage_Use_DataProvider();
        loginPage.login(email,password);
    }

    //3. Đọc Excel data với số dòng tuỳ ý sử dụng HashTable
    @Test(dataProvider = "data_provider_login_excel_custom_row",dataProviderClass = DataLogin.class)
    public void loginTestFormDataProviderReadExcelCustomRow(Hashtable< String, String > data) {
        loginPage = new LoginPage_Use_DataProvider();
        loginPage.login(data.get("EMAIL"),data.get("PASSWORD"));
    }


}
