package quangtester.com.Bai6_WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginCMS {
    public static void main(String[] args) throws InterruptedException {

        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Login CMS
        driver.get("https://demo.activeitzone.com/ecommerce/login"); // Mở đường link

        //Bắt WebElement Email (object) => Dùng Cách 1

        /*
            - findElement : tìm 1 element
            - findElements : tìm nhiều element
        */
        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys("admin@example.com");

        /*
        Vừa nhập xong là xóa ô email luôn
            inputEmail.clear();
        */

        //1. Bắt WebElement Password (object) => Dùng Cách 2
        driver.findElement(By.id("password")).sendKeys("123456");

        //2. Dùng hàm isSelected kiểm tra xem ô Remember đã chọn hay chưa
        WebElement checkboxRemember1 = driver.findElement(By.id("remember"));
        System.out.println("Đã chọn :" + checkboxRemember1.isSelected());

        //2.1 Cho click vào ô checkbox : Remember me
        driver.findElement(By.xpath("//span[normalize-space()='Remember Me']")).click();
        Thread.sleep(1000);

        //2.2 Sau khi click vào ô checkbox : Remember me thì dùng hàm isSelected kiểm tra xem ô Remember đã chọn hay chưa
        WebElement checkboxRemember2 = driver.findElement(By.id("remember"));
        System.out.println("Đã chọn :" + checkboxRemember2.isSelected());

        System.out.println("---------------");

        //4. Dùng hàm getCssValue - Kiểm tra mã màu của thanh Login
        WebElement buttonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        System.out.println(buttonLogin.getCssValue("background-color")); //Trả về mã màu rgba

        System.out.println("---------------");

        //5. Dùng hàm getText để lấy tiêu đề h1 - Welcome to Active eCommerce CMS
        WebElement tieude = driver.findElement(By.xpath("//h1[normalize-space()='Welcome to Active eCommerce CMS']"));
        System.out.println("Tên tiêu đề là :" +tieude.getText());

        System.out.println("---------------");

        //6. Dùng hàm getAttribute() để lấy name và class của ô username
        System.out.println("name của ô Email :" + inputEmail.getAttribute("name"));
        System.out.println("class của ô Email :" + inputEmail.getAttribute("class"));

        System.out.println("---------------");

        //7. Dùng hàm getSize() để kiểm tra chiều dài và chiều rộng của thanh Login(width, height)
        Dimension dimensions = buttonLogin.getSize();
        System.out.println("Height : " + dimensions.height + " Width :" + dimensions.width);

        System.out.println("---------------");

        //8. Dùng hàm getLocation() để lấy tọa độ của thanh Login(x, y)
        Point points = buttonLogin.getLocation();
        System.out.println("Tọa độ X :" + points.x + " Tọa độ Y : " + points.y);

        System.out.println("---------------");

        //9. Dùng hàm isDisplayed để kiểm tra trạng thái 1 object(nút copy) có hiển thị hay chưa
        WebElement buttonCopy = driver.findElement(By.xpath("//button[normalize-space()='Copy']"));
        System.out.println("Trạng thái nút copy: " + buttonCopy.isDisplayed());

        //9.1 Nếu trạng thái nút copy là true => Click vào nút Đăng nhập
        if(buttonCopy.isDisplayed() == true){
            //Click vào nút Đăng nhập => Dùng Cách 2
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        }




        //Set tốc độ khi vào trang CMS
        Thread.sleep(1000);

        //Tắt browser
        driver.quit();

    }
}
