package quangtester.com.Bai30_TakeScreenshot.testcases_UseRecordVideo;

import org.testng.annotations.Test;
import quangtester.com.common.Bai26_BaseTest;
import quangtester.com.common.Bai30_BaseTest;
import quangtester.com.helpers.Bai30_VideoRecordHelper;
import quangtester.com.pages.Bai19_Pages_UseLienKetTrang.Bai19_CustomerPage_UseLienKetTrang;
import quangtester.com.pages.Bai19_Pages_UseLienKetTrang.Bai19_DashboardPage_UseLienKetTrang;
import quangtester.com.pages.Bai19_Pages_UseLienKetTrang.Bai19_LoginPage_UseLienKetTrang;

import java.lang.reflect.Method;

public class DashboardTest extends Bai30_BaseTest {
    Bai19_LoginPage_UseLienKetTrang loginPage;
    Bai19_DashboardPage_UseLienKetTrang dashboardPage;
    Bai19_CustomerPage_UseLienKetTrang customersPage;

    @Test
    public void testOpenMenuOnDashboard(Method tenVideoRecord) {

        //Start Record Video
        //Lấy tên class làm tên Video Record
        Bai30_VideoRecordHelper.startRecord(tenVideoRecord.getName());

        //Khởi tạo đối tượng trang Bai28_LoginPage
        //Truyền driver từ BaseTest
        loginPage = new Bai19_LoginPage_UseLienKetTrang();

        //Liên kết trang được xảy ra nhờ hàm login trả về là sự khởi tạo của trang Dashboard
            // => Khởi tạo đối tượng trang Bai28_DashboardPage luôn
        dashboardPage = loginPage.login("admin@example.com","123456");

        //Kiểm tra trang Dashboard đúng
        dashboardPage.verifyDashboardPage();

        //Liên kết trang được xảy ra nhờ hàm login trả về là sự khởi tạo của trang Customer
            // => Khởi tạo đối tượng trang CustomerPage luôn
        //Kiểm tra menu Customers click vào mở được trang
        customersPage = dashboardPage.openCustomerPage();

        //Kiểm tra trang Customer đúng
        customersPage.verifyCustomerPage();

        //Stop Record Video
        Bai30_VideoRecordHelper.stopRecord();

    }

    @Test
    public void testAddCustomer() {
        loginPage = new Bai19_LoginPage_UseLienKetTrang();
        dashboardPage = loginPage.login("admin@example.com","123456");
        customersPage = dashboardPage.openCustomerPage();
        customersPage.addCustomer();
    }

    @Test
    public void testFilterWidgetsOnDashboard() {
        loginPage = new Bai19_LoginPage_UseLienKetTrang();
        dashboardPage = loginPage.login("admin@example.com","123456");
        dashboardPage.verifyDashboardPage();
        //Click vào Widgets đầu tiên => Chạy 1l thì được , nhưng chạy từ lần 2 thì sẽ lỗi do ban đầu bấm là nó tự động hiển thị(visible) rồi
        dashboardPage.verifyFilterStatistics();

    }
}
