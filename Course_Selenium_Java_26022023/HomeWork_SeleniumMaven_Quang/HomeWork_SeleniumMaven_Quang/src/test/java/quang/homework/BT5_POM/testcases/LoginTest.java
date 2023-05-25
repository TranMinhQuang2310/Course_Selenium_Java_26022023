package quang.homework.BT5_POM.testcases;

import org.testng.annotations.Test;
import quang.homework.BT5_POM.common.BaseTest_POM;
import quang.homework.BT5_POM.pages.LoginPage;

public class LoginTest extends BaseTest_POM {
    //LoginTest dùng để khởi tạo class đó và truyền driver vào
    //Khởi tạo đối tượng class
    LoginPage loginPage;

    //Tạo 1 testcase đăng nhập
    @Test
    public void loginTestSuccess() {
        //Khởi tạo đối tượng trang LoginPage
        //Truyền driver từ BaseTest
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com","123456");
    }

}
