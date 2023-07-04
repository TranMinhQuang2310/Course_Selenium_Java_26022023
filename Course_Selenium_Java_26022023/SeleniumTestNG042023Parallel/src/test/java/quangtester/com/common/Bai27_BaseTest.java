package quangtester.com.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import quangtester.com.Bai31_ITestListener.TestListener;
import quangtester.com.drivers.DriverManager;
import quangtester.com.helpers.PropertiesHelper;

@Listeners(TestListener.class)
public class Bai27_BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    //@Optional("chrome") => mặc định chạy vào Google Chrome nếu không set giá trị bên file Bai24_MultiBrowser.xml
    public static void createDriver(@Optional("chrome") String browser) {
        WebDriver driver = setupDriver(browser);
        PropertiesHelper.loadAllFiles();
        //Set giá trị driver đã được khởi tạo vào ThreadLocal ở class DriverManager
        DriverManager.setDriver(driver);
    }

    public static WebDriver setupDriver(String browserName) {
        WebDriver driver;
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
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver() {

        if(DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }


}
