package quangtester.com.Bai7_WebDriver;

import org.openqa.selenium.WindowType;
import quangtester.com.common.BaseTest;

public class AdvancedBrowser extends BaseTest {
    public static void main(String[] args) {
        createDriver();

        //1. Open đường link web url
        driver.get("https://anhtester.com/");
        //2. Mở tab mới đồng thời mở link url mới
        driver.switchTo().newWindow(WindowType.TAB);
        sleep(2);
        driver.get("https://www.google.com.vn/?hl=vi");
        sleep(2);

        //3.Mở của sổ mới  đồng thời mở link url mới
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://anhtester.com/blog");
        sleep(2);

        closeDriver();

    }
}
