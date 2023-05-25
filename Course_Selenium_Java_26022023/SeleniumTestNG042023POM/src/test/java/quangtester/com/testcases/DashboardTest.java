package quangtester.com.testcases;

import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.pages.CustomersPage;
import quangtester.com.pages.DashboardPage;
import quangtester.com.pages.LoginPage;
import org.openqa.selenium.By;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    @Test
    public void testOpenMenuOnDashboard() {
        //Khởi tạo đối tượng trang LoginPage
        //Truyền driver từ BaseTest
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com","123456");

        //Viết vội cho nội dung lấy total (thật ra phải tạo dashboard page sau đó để hàm này trong đó)
        //By total = By.xpath("(//div[@id='widget-top_stats']//div[@class='top_stats_wrapper'])[2]");
        //System.out.println(driver.findElement(total).getText());

        //Khởi tạo đối tượng trang DashboardPage
        //Truyền driver từ BaseTest
        dashboardPage = new DashboardPage(driver);
        //Kiểm tra trang Dashboard đúng
        dashboardPage.verifyDashboardPage();
        //Kiểm tra menu Customers click vào mở được trang
        dashboardPage.openCustomerPage();

        //Khởi tạo đối tượng trang CustomerPage
        //Truyền driver từ BaseTest
        customersPage = new CustomersPage(driver);
        //Kiểm tra trang Customer đúng
        customersPage.verifyCustomerPage();

    }

    @Test
    public void testFilterWidgetsOnDashboard() {
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com","123456");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
        //Click vào Widgets đầu tiên => Chạy 1l thì được , nhưng chạy từ lần 2 thì sẽ lỗi do ban đầu bấm là nó tự động hiển thị(visible) rồi
        dashboardPage.verifyFilterStatistics();

    }
}
