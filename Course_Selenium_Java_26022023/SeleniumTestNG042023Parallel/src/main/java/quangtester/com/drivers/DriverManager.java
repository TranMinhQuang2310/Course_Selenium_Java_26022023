package quangtester.com.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    /*
        getDriver(): lấy giá trị driver theo luồng (máy nó tự hiểu luồng nào cho session nào)
        setDriver(): set giá trị cho driver theo luồng
        quit(): xoá phiên session driver của luồng hiện tại (xoá session là việc cả thread chứa driver đó)
    */


    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static void quit() {
        DriverManager.driver.get().quit();// Tắt browser hiện tại
        driver.remove();//remove thread chứa driver đó
    }

}
