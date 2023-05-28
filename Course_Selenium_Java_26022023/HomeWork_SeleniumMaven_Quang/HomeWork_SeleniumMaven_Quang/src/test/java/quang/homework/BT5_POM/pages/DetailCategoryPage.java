package quang.homework.BT5_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import quang.homework.keywords.WebUI;

public class DetailCategoryPage {
    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    private String CATEGORY_URL = "https://cms.anhtester.com/admin/categories";
    private String CATEGORY_TEXT = "All categories";

    //Các  Object
    public By buttonAddNewProject = By.xpath("//span[normalize-space()='Add New category']");
    public By inputSearch = By.xpath("//input[@id='search']");

     /*
        + Hàm xây dựng để truyền vào driver => Hàm xây dựng có tham số gì thì khi khởi tạo class phải có tham số đó
    */
    private WebDriver driver;
    public DetailCategoryPage(WebDriver _driver) {
        driver = _driver;
    }

    //Kiểm tra đã vào màn hình Category chưa
    public void verifyPageCategory() {
        //Kiểm tra URL có đúng vào trang Category không
        String check_url = driver.getCurrentUrl();
        Assert.assertEquals(check_url,CATEGORY_URL,"URL chưa đúng trang Category");
        System.out.println("URL hiện tại của Trang là :" + check_url);
    }

    public AddNewCategoryPage clickAddNewCategory() {
        //Dùng Wait for Page loaded (Chờ đợi trang tải xong)
        WebUI.waitForPageLoaded(driver);
        driver.findElement(buttonAddNewProject).click();

        return new AddNewCategoryPage(driver);
    }
}
