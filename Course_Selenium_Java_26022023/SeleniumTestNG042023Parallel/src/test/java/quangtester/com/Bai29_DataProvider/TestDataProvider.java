package quangtester.com.Bai29_DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import quangtester.com.Bai29_DataProvider.TestOtherClass.DataLogin;

public class TestDataProvider {

    //dataProviderClass gọi từ class chung để chạy
    @Test(dataProvider = "dataProviderLoginCRM",dataProviderClass = DataLogin.class)
    public void testLoginCRM(String email, String password) {
        System.out.println(email + "-" + password);

        //Mở chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.vn/?hl=vi");
        driver.quit();

    }

    @Test(dataProvider = "dataProviderLoginCMS",dataProviderClass = DataLogin.class)
    public void testLoginCMS(String email, String password, int pin) {
        System.out.println(email + "-" + password + "-" + pin);
    }

}
