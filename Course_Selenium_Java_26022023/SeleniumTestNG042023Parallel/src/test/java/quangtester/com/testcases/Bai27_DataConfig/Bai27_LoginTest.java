package quangtester.com.testcases.Bai27_DataConfig;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import quangtester.com.common.Bai27_BaseTest;
import quangtester.com.helpers.PropertiesHelper;
import quangtester.com.keywords.WebUI;
import quangtester.com.pages.Bai27_Pages_DataConfig.Bai27_LoginPage;

public class Bai27_LoginTest extends Bai27_BaseTest {

    //LoginTest_Use_DataProvider dùng để khởi tạo class đó và truyền driver vào
    //Khởi tạo đối tượng class
    Bai27_LoginPage loginPage;

    //Tạo 1 testcase đăng nhập
    @Test
    public void loginTestSuccess() {
        //Khởi tạo đối tượng trang Bai28_LoginPage
        //Truyền driver từ BaseTest
        loginPage = new Bai27_LoginPage();

        //Gọi hàm "login" từ Bai28_LoginPage để dùng
        loginPage.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));

        //Test lưu dữ liệu label Invoice overview vào file data.properties
        PropertiesHelper.setFile("src/test/resources/configs/data.properties");
        PropertiesHelper.setValue("label", WebUI.getTextElement(By.xpath("//span[normalize-space()='Invoice overview']")));

    }

    //Tạo 1 testcase đăng nhập nhưng nhập sai tên Email
    @Test
    public void loginTestInvalidEmail() {
        loginPage = new Bai27_LoginPage();
        loginPage.loginInvalidEmail("admin@example.com123","123456");
    }

}
