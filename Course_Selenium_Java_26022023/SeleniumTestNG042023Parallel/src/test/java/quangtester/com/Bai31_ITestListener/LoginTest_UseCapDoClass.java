package quangtester.com.Bai31_ITestListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import quangtester.com.common.Bai30_BaseTest;
import quangtester.com.pages.Bai19_Pages_UseLienKetTrang.Bai19_LoginPage_UseLienKetTrang;

//Gọi class TestListener
@Listeners(TestListener.class)
public class LoginTest_UseCapDoClass extends Bai30_BaseTest {
    //LoginTest_Use_DataProvider dùng để khởi tạo class đó và truyền driver vào
    //Khởi tạo đối tượng class
    Bai19_LoginPage_UseLienKetTrang loginPage;


    //Tạo 1 testcase đăng nhập
    @Test
    public void loginTestSuccess() {
        //Khởi tạo đối tượng trang Bai28_LoginPage
        //Truyền driver từ BaseTest
        loginPage = new Bai19_LoginPage_UseLienKetTrang();

        //Gọi hàm "login" từ Bai28_LoginPage để dùng
        loginPage.login("admin@example.com","123456");
    }

    //Tạo 1 testcase đăng nhập nhưng nhập sai tên Email
    @Test
    public void loginTestInvalidEmail() {
        loginPage = new Bai19_LoginPage_UseLienKetTrang();
        loginPage.loginInvalidEmail("admin@example.com12345","123456");
    }
}
