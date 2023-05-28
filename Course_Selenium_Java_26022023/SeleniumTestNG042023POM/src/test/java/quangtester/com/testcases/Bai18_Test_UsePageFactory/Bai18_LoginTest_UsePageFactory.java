package quangtester.com.testcases.Bai18_Test_UsePageFactory;

import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.pages.Bai18_Pages_UsePageFactory.Bai18_LoginPage_UsePageFactory;

public class Bai18_LoginTest_UsePageFactory extends BaseTest {
    Bai18_LoginPage_UsePageFactory loginByFactory ;

    @Test
    public void testLoginSuccess() {
        loginByFactory = new Bai18_LoginPage_UsePageFactory(driver);
        loginByFactory.login("admin@example.com","123456");

    }

}
