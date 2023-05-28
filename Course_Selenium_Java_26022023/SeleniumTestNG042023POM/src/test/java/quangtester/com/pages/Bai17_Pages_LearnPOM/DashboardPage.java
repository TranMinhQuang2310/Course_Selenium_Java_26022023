package quangtester.com.pages.Bai17_Pages_LearnPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import quangtester.com.keywords.WebUI;

public class DashboardPage {
    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    private String PAGE_URL = "https://crm.anhtester.com/admin/";
    private String PAGE_TEXT = "Dashboard Options";

    //Lưu Object của trang Login => Dùng đối tượng By trong Selenium để khai báo tên Object cùng giá trị Locator tương ứng
    //Các object
    private By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    private By buttonOptionDashboard = By.xpath("//div[@class='screen-options-btn']");//Lấy tên nút "Dashboard Options"
    private By checkboxQuickStatics =
            By.xpath("//div[@id='dashboard-options']//label[normalize-space()='Quick Statistics']");//Lấy tên widget đầu tiên
    private By widgetStatistics = By.xpath("//div[@id='widget-top_stats']");//Lấy Widget của Statistics

    /*
        + Hàm xây dựng để truyền vào driver => Hàm xây dựng có tham số gì thì khi khởi tạo class phải có tham số đó
        + DashboardPage là 1 hàm nhận giá trị driver để dùng
    */
    //Hàm xây dựng
    private WebDriver driver;
    public DashboardPage(WebDriver _driver) {
        driver = _driver;
    }

    //Hàm xử lý
    public void verifyDashboardPage() {
        //Kiểm tra URL có đúng vào trang Dashboard không
        Assert.assertEquals(driver.getCurrentUrl(),PAGE_URL,"URL chưa đúng trang Dashboard");
        //Kiểm tra nút "Dashboard Options" có tồn tại hay không
        Assert.assertTrue(WebUI.checkElementExist_UseBy(driver,buttonOptionDashboard),"Button Dashboard Options not existing");
    }

    //Open tab menu Customers
    public void openCustomerPage() {
        //Dùng Wait for Page loaded (Chờ đợi trang tải xong)
        WebUI.waitForPageLoaded(driver);
        driver.findElement(menuCustomer).click();
    }


    public void clickCheckboxQuickStatistics() {
        //Click nút "Dashboard Options"
        driver.findElement(buttonOptionDashboard).click();
        WebUI.waitForElementVisible(driver,checkboxQuickStatics,2);
        //Click vào widget đầu tiên
        driver.findElement(checkboxQuickStatics).click();
    }

    public void verifyFilterStatistics() {
        //Kiểm tra widget trên đã bị ẩn (not visible)
        Assert.assertTrue(WebUI.verifyElementNotVisible(driver,widgetStatistics,5),"The Widget Statisttics is visible");
        //Click uncheck this widget
        clickCheckboxQuickStatistics();
        //Kiểm tra widget này đang hiển thị (visible)
        Assert.assertTrue(WebUI.verifyElementVisible(driver,widgetStatistics,5),"The Widget Statisttics default not visible"); ;

    }

}
