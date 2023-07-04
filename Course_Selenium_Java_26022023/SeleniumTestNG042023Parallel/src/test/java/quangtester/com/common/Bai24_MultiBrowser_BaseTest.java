package quangtester.com.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import quangtester.com.Bai31_ITestListener.TestListener;

@Listeners(TestListener.class)
public class Bai24_MultiBrowser_BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    //@Optional("chrome") => mặc định chạy vào Google Chrome nếu không set giá trị bên file Bai24_MultiBrowser.xml
    public static void createDriver(@Optional("chrome") String browser) {
        setupDriver(browser);
    }

    public static WebDriver setupDriver(String browserName) {
        //Dùng trim() để cắt 2 đầu
        //Dùng toLowerCase() để chuyển kiểu chữ về kiểu bình thường
        switch (browserName.trim().toLowerCase()) {
            case "chrome" :
                driver = initChromeDriver();
                break;
            case "firefox" :
                driver = initFirefoxDriver();
                break;
            case "edge" :
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser :" + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;

    }

    private static WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); //Reset timeout
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(driver != null) {
            driver.quit();
        }
    }


}
