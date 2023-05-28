package quang.homework.BT5_POM.testcases;

import org.testng.annotations.Test;
import quang.homework.BT5_POM.common.BaseTest_POM;
import quang.homework.BT5_POM.pages.DashboardPage;
import quang.homework.BT5_POM.pages.LoginPage;

public class DashboardTest extends BaseTest_POM {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    //Tạo 1 testcase
    @Test
    public void AddProduct() {
        //Khởi tạo đối tượng trang LoginPage
        //Truyền driver từ BaseTest
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com","123456");

        //Khởi tạo đối tượng trang DashboardPage
        //Truyền driver từ BaseTest
        dashboardPage = new DashboardPage(driver);


    }
}
