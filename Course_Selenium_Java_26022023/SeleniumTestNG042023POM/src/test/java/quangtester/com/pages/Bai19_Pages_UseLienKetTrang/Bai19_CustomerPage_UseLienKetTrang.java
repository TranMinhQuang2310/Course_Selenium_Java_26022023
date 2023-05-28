package quangtester.com.pages.Bai19_Pages_UseLienKetTrang;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import quangtester.com.keywords.WebUI;

public class Bai19_CustomerPage_UseLienKetTrang {
    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers";
    private By headerPageCustomers = By.xpath("//div[@class='panel-body']//h4[contains(.,'" + PAGE_TEXT + "')]");

    private By Button_Add_New_Customer = By.xpath("//a[normalize-space()='New Customer']");

    //Hàm xây dựng
    private WebDriver driver;
    public Bai19_CustomerPage_UseLienKetTrang(WebDriver _driver) {
        driver = _driver;
    }

    public void verifyCustomerPage() {
        Assert.assertEquals(driver.getCurrentUrl(),PAGE_URL,"URL chưa đúng trang Customer");
        Assert.assertTrue(WebUI.checkElementExist_UseBy(driver,headerPageCustomers),"Customer Header Page not existing");
        Assert.assertEquals(driver.findElement(headerPageCustomers).getText(),"Customers Report","Customer Header Page is not match");
    }

    public void ClickButton_add_Customer() {
        driver.findElement(Button_Add_New_Customer).click();
    }

    public void addCustomer() {
        ClickButton_add_Customer();
    }
}
