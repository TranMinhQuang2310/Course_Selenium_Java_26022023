package quang.homework.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void closeDriver() {
        sleep(2);
        driver.quit();
    }

    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (1000*seconds));
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
