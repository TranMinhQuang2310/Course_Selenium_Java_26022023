package quangtester.com.pages.Bai20_Pages_ThucHanh.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Bai20_AddCustomerGroupDialog_ThucHanh {

    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    public String PAGE_TEXT_GROUP = "Add New Customer Group";

    //Các Object
    public By titleGroup = By.xpath("//span[@class='add-title']");
    public By inputName = By.xpath("//input[@id='name']");
    public By buttonSubmitGroup = By.xpath("//button[@group='submit']");

    //Hàm xây dựng
    private WebDriver driver;
    public Bai20_AddCustomerGroupDialog_ThucHanh(WebDriver _driver) {
        driver = _driver;
    }

}
