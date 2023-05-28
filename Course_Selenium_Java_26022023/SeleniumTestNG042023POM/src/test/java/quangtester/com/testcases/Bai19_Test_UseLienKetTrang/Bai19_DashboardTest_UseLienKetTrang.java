package quangtester.com.testcases.Bai19_Test_UseLienKetTrang;

import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.pages.Bai19_Pages_UseLienKetTrang.Bai19_CustomerPage_UseLienKetTrang;
import quangtester.com.pages.Bai19_Pages_UseLienKetTrang.Bai19_DashboardPage_UseLienKetTrang;
import quangtester.com.pages.Bai19_Pages_UseLienKetTrang.Bai19_LoginPage_UseLienKetTrang;

public class Bai19_DashboardTest_UseLienKetTrang extends BaseTest {
    Bai19_LoginPage_UseLienKetTrang loginPage;
    Bai19_DashboardPage_UseLienKetTrang dashboardPage;
    Bai19_CustomerPage_UseLienKetTrang customersPage;

    @Test
    public void testOpenMenuOnDashboard() {
        //Khởi tạo đối tượng trang LoginPage
        //Truyền driver từ BaseTest
        loginPage = new Bai19_LoginPage_UseLienKetTrang(driver);

        //Liên kết trang được xảy ra nhờ hàm login trả về là sự khởi tạo của trang Dashboard
            // => Khởi tạo đối tượng trang DashboardPage luôn
        dashboardPage = loginPage.login("admin@example.com","123456");

        //Kiểm tra trang Dashboard đúng
        dashboardPage.verifyDashboardPage();

        //Liên kết trang được xảy ra nhờ hàm login trả về là sự khởi tạo của trang Customer
            // => Khởi tạo đối tượng trang CustomerPage luôn
        //Kiểm tra menu Customers click vào mở được trang
        customersPage = dashboardPage.openCustomerPage();

        //Kiểm tra trang Customer đúng
        customersPage.verifyCustomerPage();

    }

    @Test
    public void testAddCustomer() {
        loginPage = new Bai19_LoginPage_UseLienKetTrang(driver);
        dashboardPage = loginPage.login("admin@example.com","123456");
        customersPage = dashboardPage.openCustomerPage();
        customersPage.addCustomer();
    }

    @Test
    public void testFilterWidgetsOnDashboard() {
        loginPage = new Bai19_LoginPage_UseLienKetTrang(driver);
        dashboardPage = loginPage.login("admin@example.com","123456");
        dashboardPage.verifyDashboardPage();
        //Click vào Widgets đầu tiên => Chạy 1l thì được , nhưng chạy từ lần 2 thì sẽ lỗi do ban đầu bấm là nó tự động hiển thị(visible) rồi
        dashboardPage.verifyFilterStatistics();

    }
}
