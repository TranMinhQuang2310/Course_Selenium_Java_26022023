package quang.homework.WebElementANDWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import quang.homework.common.BaseTest;

public class BaiTapSuDungXpathTuongDoi extends BaseTest {
    @Test
    public void XpathTuongDoi() {
        createDriver();

        //1. Login
        driver.get("https://crm.anhtester.com/admin/authentication");
        sleep(1);

        //1.1 Username
        driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/input")).sendKeys("admin@example.com");

        //1.2 Password
        sleep(1);
        driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/input")).sendKeys("123456");

        //1.3 Click remember me
        sleep(1);
        driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div")).click();

        //1.4 Click login
        sleep(1);
        driver.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/button")).click();

        //2.Run New Customer

        //2.1 Click tab menu Customer
        sleep(1);
        driver.findElement(By.xpath("/html/body/aside/ul/li[3]/a")).click();

        //2.2 Click New Customer
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/a[1]")).click();

        //2.3 Điền Company
        sleep(1);
        driver.findElement(By.xpath
                        ("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[1]/input"))
                .sendKeys("VuThao");

        //2.4 Điền Vat number
        sleep(1);
        driver.findElement(By.xpath
                        ("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[3]/input"))
                .sendKeys("123465");

        //2.5 Điền Phone
        sleep(1);
        driver.findElement(By.xpath
                        ("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[4]/input"))
                .sendKeys("0983892347");

        //2.6 Điền Website
        sleep(1);
        driver.findElement(By.xpath
                        ("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[5]/input"))
                .sendKeys("quangdepzai.com");

        //2.7 add group
        sleep(1);
        driver.findElement(By.xpath
                        ("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[6]/div/div[2]/a"))
                .click();
        //điền add group
        sleep(1);
        driver.findElement(By.xpath
                        ("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[2]/div/div/form/div[1]/div/div/div/input"))
                .sendKeys("abcds");
        //save add group
        sleep(1);
        driver.findElement(By.xpath
                        ("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[2]/div/div/form/div[2]/button[2]"))
                .click();
        //Nhấn vô group
        sleep(2);
        driver.findElement(By.xpath
                        ("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[6]/div/div[1]/button"))
                .click();
        //Nhập giá trị tìm kiếm trong group
        sleep(1);
        driver.findElement(By.xpath
                        ("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[6]/div/div[1]/div/div[1]/input"))
                .sendKeys("abcds");

        //Click vào giá trị vừa tìm kiếm trong group
        sleep(2);
        driver.findElement(By.xpath
                        ("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[6]/div/div[1]/div/div[3]/ul/li/a"))
                .click();

        //Click lại vào group để tắt dropdown
        sleep(2);
        driver.findElement(By.xpath
                        ("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[6]/div/div[1]/button"))
                .click();

        //2.8 Nhấn vô currency
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[7]/div[1]/div/div/button")).click();
        //Nhập giá trị tìm kiếm trong currency
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[7]/div[1]/div/div/div/div[1]/input"))
                .sendKeys("USD");
        //Click vào giá trị vừa tìm kiếm trong currency
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[7]/div[1]/div/div/div/div[2]/ul/li/a"))
                .click();

        //2.9 Nhấn vô Default Language
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[7]/div[2]/div/div/button"))
                .click();
        //Chọn French
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[7]/div[2]/div/div/div/div/ul/li[2]/a"))
                .click();

        //2.10 : Cuộn chuột đến element Label ở cuối để thấy được các element bị che
        JavascriptExecutor jsEnd = (JavascriptExecutor) driver;
        jsEnd.executeScript("arguments[0].scrollIntoView(false)",driver.findElement(By.xpath("//button[@class='btn btn-primary only-save customer-form-submiter']")));

        //2.11 Điền Address
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[8]/textarea"))
                .sendKeys("TD - HCM");

        //2.12 Điền City
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[9]/input"))
                .sendKeys("HCM");

        //2.13 Điền State
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[10]/input"))
                .sendKeys("Khỏe");

        //2.14 Điền Zip Code
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[11]/input"))
                .sendKeys("3287732");

        //2.15 Nhấn vô Country
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[12]/div/button"))
                .click();
        //Nhập giá trị tìm kiếm trong Country
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[12]/div/div/div[1]/input"))
                .sendKeys("VietNam");
        //Click vào giá trị vừa tìm kiếm trong Country
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[1]/div/div/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/div[12]/div/div/div[2]/ul/li/a"))
                .click();

        //2.16 : Nhấn nút Save
        sleep(2);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div[2]/button[2]")).click();

        closeDriver();
    }
}
