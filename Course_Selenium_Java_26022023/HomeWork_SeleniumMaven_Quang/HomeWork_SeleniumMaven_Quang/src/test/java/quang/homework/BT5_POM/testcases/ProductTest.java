package quang.homework.BT5_POM.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import quang.homework.BT5_POM.common.BaseTest_POM;
import quang.homework.BT5_POM.pages.LoginPage;
import quang.homework.BT5_POM.pages.ProductPage;

public class ProductTest extends BaseTest_POM {
    LoginPage loginPage;
    ProductPage productPage;

    //Tạo 1 testcase
    @Test
    public void AddProduct() {
        //Khởi tạo đối tượng trang LoginPage
        //Truyền driver từ BaseTest
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com","123456");

        //Khởi tạo đối tượng trang ProductPage
        //Truyền driver từ BaseTest
        productPage = new ProductPage(driver);
        productPage.addNewProduct();

    }
}
