package quangtester.com.Bai6_WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckElementEnable {
    public static void main(String[] args) throws InterruptedException {
        /*
            Đăng nhập vào trang : https://www.dofactory.com/html/button/disabled
                => sau đó check nút click me có Enable(bật hay tắt)
                => Dùng hàm isEnabled
        */

        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //chờ đợi ngầm để tìm kiếm element , nếu không tìm ra thì báo lỗi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://www.dofactory.com/html/button/disabled
        driver.get("https://www.dofactory.com/html/button/disabled");

        //Kiểm tra nút "Click me" có Enable(bật hay tắt)
        WebElement buttonClickMe = driver.findElement(By.xpath("//button[text()='Click Me']"));
        System.out.println("Nút Click Me :" + buttonClickMe.isEnabled());

        //Kiểm tra nút "Try it live" có Enable(bật hay tắt)
            //[1] là vị trí xpath
        WebElement buttonTry = driver.findElement(By.xpath("(//button[normalize-space()='Try it live'])[1]"));
        System.out.println("Nút Try it live :" + buttonTry.isEnabled());


        Thread.sleep(1000);

        //Tắt browser
        driver.quit();
    }
}
