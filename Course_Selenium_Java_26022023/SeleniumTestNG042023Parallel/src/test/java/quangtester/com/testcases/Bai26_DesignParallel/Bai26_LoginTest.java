package quangtester.com.testcases.Bai26_DesignParallel;

import org.testng.annotations.Test;
import quangtester.com.common.Bai26_BaseTest;
import quangtester.com.common.BaseTest;
import quangtester.com.drivers.DriverManager;
import quangtester.com.pages.Bai17_Pages_LearnPOM.LoginPage;

public class Bai26_LoginTest extends Bai26_BaseTest {

    //LoginTest_Use_DataProvider dùng để khởi tạo class đó và truyền driver vào
    //Khởi tạo đối tượng class
    LoginPage loginPage;

    //Tạo 1 testcase đăng nhập
    @Test
    public void loginTestSuccess() {
        //Khởi tạo đối tượng trang Bai28_LoginPage
        //Truyền driver từ BaseTest
        loginPage = new LoginPage();

        //Gọi hàm "login" từ Bai28_LoginPage để dùng
        loginPage.login("admin@example.com","123456");
    }

    //Tạo 1 testcase đăng nhập nhưng nhập sai tên Email
    @Test
    public void loginTestInvalidEmail() {
        loginPage = new LoginPage();
        loginPage.loginInvalidEmail("admin@example.com123","123456");
    }

}
