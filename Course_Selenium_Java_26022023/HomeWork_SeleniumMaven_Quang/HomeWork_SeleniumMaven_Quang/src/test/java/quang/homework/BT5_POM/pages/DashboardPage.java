package quang.homework.BT5_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import quang.homework.keywords.WebUI;

public class DashboardPage {
    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    private String DASHBOARD_URL = "https://cms.anhtester.com/admin";

    //Các object
    private By openProduct = By.xpath("//li[@class='aiz-side-nav-item']//span[normalize-space()='Products']");
    private By add_new_Product = By.xpath("//span[normalize-space()='Add New Product']");
    private By category = By.xpath("//span[normalize-space()='Category']");

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

    //Kiểm tra đã vào màn hình Dashboard chưa
    public void verifyPageDashBoard() {
        //Kiểm tra URL có đúng vào trang Dashboard không
        String checkURL = driver.getCurrentUrl();
        Assert.assertEquals(checkURL,DASHBOARD_URL,"URL chưa đúng trang Dashboard");
        System.out.println("URL hiện tại của Trang là :" + checkURL);
    }

    //Click open tab menu Product
    public void clickOpenMenuProduct() {
        //Dùng Wait for Page loaded (Chờ đợi trang tải xong)
        WebUI.waitForPageLoaded(driver);
        driver.findElement(openProduct).click();
    }


    //Click tab menu "Add New Product"
    public AddNewProductPage clickaddNewProduct() {
        //Dùng Wait for Page loaded (Chờ đợi trang tải xong)
        WebUI.waitForPageLoaded(driver);
        driver.findElement(add_new_Product).click();

        return new AddNewProductPage(driver);
    }

    //Click tab menu "Category"
    public DetailCategoryPage clickOpenDetailCategoryPage() {
        //Dùng Wait for Page loaded (Chờ đợi trang tải xong)
        WebUI.waitForPageLoaded(driver);
        driver.findElement(category).click();

        return new DetailCategoryPage(driver);
    }



}
