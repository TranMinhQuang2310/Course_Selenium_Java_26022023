package quangtester.com.Bai5_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginEcommerce {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //chờ đợi ngầm để tìm kiếm element , nếu không tìm ra thì báo lỗi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang eCommerce
        driver.get("https://demo.activeitzone.com/ecommerce/login");

        //Set tốc độ khi vào trang eCommerce
        Thread.sleep(1000);

        //1. Điền Email - Tìm locators theo ID với By.id() => tự động điền dữ liệu vào ô Email
        driver.findElement(By.id("email")).sendKeys("admin@example.com");

        //2. Điền Password - tìm locators theo Name với By.name() => tự động điền dữ liệu vào ô Password
        driver.findElement(By.name("password")).sendKeys("123456");

        //3 Click link Forgot Password với By.linkText() => tự động click vào action "forgot password"
        //driver.findElement(By.linkText("Forgot password ?")).click();

        //4. Click link Registration với By.partialLinkText() => tự động click vào action "forgot password" mà không cần
        // ghi đầy đủ chữ forgot password
        driver.findElement(By.partialLinkText("Forgot")).click();

        //5. Tìm toàn bộ thẻ a trong html với By.tagName() => Tìm kiếm đồng loạt nhiều elements với đường dẫn locators đó
        //driver.findElements(By.tagName(a));

        //6. Tìm action thông qua với By.classname
        //driver.findElement(By.className("form-control mt-3 form-control-lg"));

        Thread.sleep(2000);
        //Tắt browser
        driver.quit();
    }
}
