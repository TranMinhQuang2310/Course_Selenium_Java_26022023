package quangtester.com.Bai30_TakeScreenshot.pages_UseRecordVideo;

import org.openqa.selenium.By;
import org.testng.Assert;
import quangtester.com.keywords.WebUI;

import static quangtester.com.keywords.WebUI.*;

public class CustomerPage {
    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers";
    private By headerPageCustomers = By.xpath("//div[@class='panel-body']//h4[contains(.,'" + PAGE_TEXT + "')]");

    private By Button_Add_New_Customer = By.xpath("//a[normalize-space()='New Customer']");



    public void verifyCustomerPage() {
        Assert.assertEquals(getCurrentURL(),PAGE_URL,"URL chưa đúng trang Customer");
        Assert.assertTrue(WebUI.checkElementExist_UseBy(headerPageCustomers),"Customer Header Page not existing");
        Assert.assertEquals(getTextElement(headerPageCustomers),"Customers Summary","Customer Header Page is not match");
    }

    public void ClickButton_add_Customer() {
        //driver.findElement(Button_Add_New_Customer).click();
        clickElement(Button_Add_New_Customer);
    }

    public void addCustomer() {
        ClickButton_add_Customer();
    }
}
