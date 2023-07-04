package quangtester.com.Bai30_TakeScreenshot.testcases_UseRecordVideo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import quangtester.com.common.Bai26_BaseTest;
import quangtester.com.common.Bai30_BaseTest;
import quangtester.com.helpers.Bai30_VideoRecordHelper;
import quangtester.com.pages.Bai19_Pages_UseLienKetTrang.Bai19_LoginPage_UseLienKetTrang;
import quangtester.com.utils.LogUtils;

public class LoginTest extends Bai30_BaseTest {
    //LoginTest_Use_DataProvider dùng để khởi tạo class đó và truyền driver vào
    //Khởi tạo đối tượng class
    Bai19_LoginPage_UseLienKetTrang loginPage;

    //Thực hiện Record toàn bộ @Test trong 1 class => Nhớ chạy toàn bộ class chứ KHÔNG chạy từng @Test
    @BeforeClass
    public void StartRecordClass() {
        Bai30_VideoRecordHelper.startRecord("LoginTest_UseCapDoClass");
    }

    @AfterClass
    public void StopRecordClass() {
        Bai30_VideoRecordHelper.stopRecord();
    }


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
        loginPage.loginInvalidEmail("admin@example.com123","123456");
    }
}
