package quang.homework.BT_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import quang.homework.keywords.WebUI;

import java.time.Duration;

public class BaseTest_TestNG {
    public WebDriver driver;

    @BeforeMethod
    public void createBrowser() {
        System.out.println("Start Chrome browser from BaseTest ... ");
        //Khởi dộng với Chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //chờ đợi ngầm định cho từng câu lệnh tìm kiếm driver.findElement()=> 1 case fail : nếu không tìm ra trong 10s thì báo lỗi
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //chờ đợi cả Trang load xong (bao gồm load cả HTML,CSS,JS,...) => Set thời gian nhiều hơn implicitlyWait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @AfterMethod
    public void closeBrowser() {
        WebUI.sleep(2);
        // Reset Implicit Wait (thay đổi thời gian chờ đợi về 0) trong trường hợp muốn 1 đoạn nào trong source không cần chờ đợi
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        System.out.println("Close Chrome browser from BaseTest ... ");
        driver.quit();
    }


}
