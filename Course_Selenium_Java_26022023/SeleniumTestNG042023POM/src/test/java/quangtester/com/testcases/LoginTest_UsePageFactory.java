package quangtester.com.testcases;

import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.pages.LoginPage_UsePageFactory;

public class LoginTest_UsePageFactory extends BaseTest {
    LoginPage_UsePageFactory loginByFactory ;

    @Test
    public void testLoginSuccess() {
        loginByFactory = new LoginPage_UsePageFactory(driver);
        loginByFactory.login("admin@example.com","123456");

    }

}
