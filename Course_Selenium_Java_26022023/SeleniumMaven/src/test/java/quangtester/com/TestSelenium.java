package quangtester.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestSelenium {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang anhtester.com
        driver.get("https://anhtester.com/");

        //Set tốc độ khi vào trang anhtester.com
        Thread.sleep(2000);

        //Click Website Testing
        driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']")).click();

        //Set tốc độ khi vào trang Website Testing
        Thread.sleep(2000);

        //Click khóa học Cucumber TestNG Basic to Advanced
        driver.findElement(By.xpath("//h2[@class='card__title']//a[normalize-space()='Cucumber TestNG " +
                "Basic to Advanced']")).click();

        //Set tốc độ khi vào từng trang
        Thread.sleep(1000);

        // Xuất đoạn mô tả trong khóa học
        String description = driver.findElement(By.xpath("Xin chào các bạn. Khóa học Cucumber TestNG này " +
                "nhằm hướng dẫn nâng cao cho những bạn đã học khoá Selenium Java để viết code theo ngôn ngữ Gherkin đi " +
                "từng bước từ cơ bản đến nâng cao.")).getText();

        System.out.println(description);


        //Tắt browser
        driver.quit();
    }

}
