package quangtester.com.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    //Khởi tạo browser
    public static void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    //Đóng browser
    public static void closeDriver() {
        sleep(2);
        driver.quit();
    }

    //Cách khai báo hàm sleep để không bị gạch đỏ
    public static void sleep(double seconds) {
            try {
                Thread.sleep((long) (1000 * seconds)); // set thời gian thay vì hay để 1000 thì thành 1s
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
