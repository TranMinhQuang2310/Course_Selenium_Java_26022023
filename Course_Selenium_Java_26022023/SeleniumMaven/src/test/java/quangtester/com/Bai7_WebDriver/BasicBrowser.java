package quangtester.com.Bai7_WebDriver;

import org.openqa.selenium.By;
import quangtester.com.common.BaseTest;

public class BasicBrowser extends BaseTest {
    public static void main(String[] args) {
        createDriver();
        //1. Open đường link web url
        driver.navigate().to("https://anhtester.com/");
        sleep(2);

        driver.findElement(By.id("btn-login")).click();
        sleep(1);
//        //2. Điều hướng về lịch sử trang trước đó
//        driver.navigate().back();
//
//        sleep(2);
//        //3.Làm mới trang hiện tại
//        driver.navigate().refresh();
//
//        sleep(2);
//        //4 . Điều hướng đến trang sau
//        driver.navigate().forward();

        //5. Lấy title của trang web và in ra
        System.out.println(driver.getTitle());
        sleep(2);

        //6. Lấy đường link url và in ra
        System.out.println(driver.getCurrentUrl());

        //7. Lấy source code và in ra
        System.out.println(driver.getPageSource());

        closeDriver();
    }
}
