package quangtester.com.testcases.Bai19_Test_UseLienKetTrang;

import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.pages.Bai19_Pages_UseLienKetTrang.Bai19_LoginPage_UseLienKetTrang;

public class Bai19_LoginTest_UseLienKetTrang extends BaseTest {
    //LoginTest dùng để khởi tạo class đó và truyền driver vào
    //Khởi tạo đối tượng class
    Bai19_LoginPage_UseLienKetTrang loginPage;

    //Tạo 1 testcase đăng nhập
    @Test
    public void loginTestSuccess() {
        //Khởi tạo đối tượng trang LoginPage
        //Truyền driver từ BaseTest
        loginPage = new Bai19_LoginPage_UseLienKetTrang(driver);

        //Gọi hàm "login" từ LoginPage để dùng
        loginPage.login("admin@example.com","123456");
    }

    //Tạo 1 testcase đăng nhập nhưng nhập sai tên Email
    @Test
    public void loginTestInvalidEmail() {
        loginPage = new Bai19_LoginPage_UseLienKetTrang(driver);
        loginPage.loginInvalidEmail("admin@example.com123","123456");
    }
}
