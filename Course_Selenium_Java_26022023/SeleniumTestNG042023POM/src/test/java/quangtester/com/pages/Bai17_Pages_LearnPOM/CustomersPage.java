package quangtester.com.pages.Bai17_Pages_LearnPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import quangtester.com.keywords.WebUI;
//Gọi ra tất cả các hàm có trạng thái static trong class WebUI
import static quangtester.com.keywords.WebUI.*;

public class CustomersPage {
    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers";
    private By headerPageCustomers = By.xpath("//div[@class='panel-body']//h4[contains(.,'" + PAGE_TEXT + "')]");

    //Hàm xây dựng
    private WebDriver driver;
    public CustomersPage(WebDriver _driver) {
        driver = _driver;
        //Khởi tạo class WebUI để truyền giá trị driver từ bên ngoài vào WebUI
        new WebUI(driver);//Đây là kiểu khởi tạo đối tượng Annonymous trong Java
    }

    public void verifyCustomerPage() {
        Assert.assertEquals(getCurrentURL(),PAGE_URL,"URL chưa đúng trang Customer");
        Assert.assertTrue(WebUI.checkElementExist_UseBy(headerPageCustomers),"Customer Header Page not existing");
        Assert.assertEquals(getTextElement(headerPageCustomers),"Customers Summary","Customer Header Page is not match");
    }
}
