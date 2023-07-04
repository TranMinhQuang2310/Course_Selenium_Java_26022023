package quangtester.com.pages.Bai27_Pages_DataConfig;

import org.openqa.selenium.By;
import org.testng.Assert;
import quangtester.com.keywords.WebUI;

import static quangtester.com.keywords.WebUI.getCurrentURL;
import static quangtester.com.keywords.WebUI.getTextElement;

public class Bai27_CustomersPage {
    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers";
    private By headerPageCustomers = By.xpath("//div[@class='panel-body']//h4[contains(.,'" + PAGE_TEXT + "')]");


    public void verifyCustomerPage() {
        Assert.assertEquals(getCurrentURL(),PAGE_URL,"URL chưa đúng trang Customer");
        Assert.assertTrue(WebUI.checkElementExist_UseBy(headerPageCustomers),"Customer Header Page not existing");
        Assert.assertEquals(getTextElement(headerPageCustomers),"Customers Summary","Customer Header Page is not match");
    }
}
