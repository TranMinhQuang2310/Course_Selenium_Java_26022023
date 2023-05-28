package quangtester.com.pages.Bai20_Pages_ThucHanh.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import quangtester.com.keywords.WebUI;

public class Bai20_CustomerPage_ThucHanh {
    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers Summary";

    //Các Object thuộc Customer Page
    private By headerPageCustomers = By.xpath("//div[@class='panel-body']//div[@class='mbot15']//h4");
    private By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    private By buttonAddCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//div[@class='_buttons']//a[normalize-space()='Contacts']");

    //Nút search trong tab menu Customer
    private By inputSearch = By.xpath("//div[@id='DataTables_Table_0_filter']//input");
    //Lấy dòng đầu tiên trong bảng
    private By tdCustomerName = By.xpath("//tbody/tr[1]/td[3]/a");

    //Hàm xây dựng
    private WebDriver driver;

    public Bai20_CustomerPage_ThucHanh(WebDriver _driver) {
        driver = _driver;
    }

    //Các hàm xử lý cho chức năng thuộc Customer Page
    public void verifyCustomerPage() {
        //Kiểm tra url có đúng trang Customer chưa
        Assert.assertEquals(driver.getCurrentUrl(),PAGE_URL,"URL chưa đúng trang Customer");
        //Kiểm tra headerPage có tồn tại không
        Assert.assertTrue(WebUI.checkElementExist_UseBy(driver,headerPageCustomers),"Customer Header Page not existing");
        //Kiểm tra headerPage có giống giá trị truyền vào không
        Assert.assertEquals(driver.findElement(headerPageCustomers).getText(),PAGE_TEXT , "Customer Header Page is not match");
    }

    public Bai20_AddNewCustomerPage_ThucHanh clickNewCustomerButton() {
        //Kiểm tra nút Add Customer có tồn tại
        WebUI.waitForElementVisible(driver,buttonAddCustomer,10);
        driver.findElement(buttonAddCustomer).click();

        return new Bai20_AddNewCustomerPage_ThucHanh(driver);
    }

    public void searchCustomer(String companyName) {
        //Chờ trang hiển thị
        WebUI.waitForPageLoaded(driver);
        //Chờ nút search hiển thị
        WebUI.waitForElementVisible(driver,inputSearch,10);
        //Nhập dữ liệu vào ô search
        driver.findElement(inputSearch).sendKeys(companyName);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
    }

    public Bai20_CustomerDetailPage_ThucHanh clickOnFirstRowCustomerName() {
        //Chờ trang hiển thị
        WebUI.waitForPageLoaded(driver);
        //Chờ kết quả hiển thị sau khi tìm kiếm
        WebUI.waitForElementVisible(driver,tdCustomerName,10);
        //Nhấp vào kết quả
        driver.findElement(tdCustomerName).click();

        return new Bai20_CustomerDetailPage_ThucHanh(driver);
    }


}
