package quangtester.com.Bai7_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import quangtester.com.common.BaseTest;

import java.util.List;

public class ListWebElement extends BaseTest {
    //Gọi 2 hàm createDriver() và closeDriver() từ bên class BaseTest
    public static void main(String[] args) throws InterruptedException {
        createDriver();
        //1. Open đường link web url
        driver.get("https://app.hrsale.com/");
        //2. Click vào nút Super Admin
        driver.findElement(By.xpath("//button[normalize-space()='Super Admin']")).click();
        //3. Click vào nút Login
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        //4. Tạo 1 list webelement
        List<WebElement> listMenu = driver.findElements(By.xpath("//ul[@class='pc-navbar']/li"));
        //5. Vì đây là list nên để tương tác với từng element ở trong list thì chúng ta thường sẽ sử dụng vòng lặp.
            //listMenu.size() là lấy số phần tử trong list
            //get(i) là lấy vị trí phần tử trong list
            //getText() là hàm của WebElement
        //=> Hàm này dùng để in ra toàn bộ các phần tử bên left menu
        for(int i = 0; i < listMenu.size();i++){
            System.out.println(listMenu.get(i).getText());
        }


        Thread.sleep(6000);
        closeDriver();
    }
}
