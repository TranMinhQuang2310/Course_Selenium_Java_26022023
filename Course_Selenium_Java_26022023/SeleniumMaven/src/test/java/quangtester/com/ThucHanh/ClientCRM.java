package quangtester.com.ThucHanh;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import quangtester.com.common.BaseTest;

import javax.swing.*;

public class ClientCRM extends BaseTest {

    //Login to CRM system
    public static void loginCRM() {
        driver.get("https://rise.fairsketch.com/signin");
        //B1: Clear 2 ô email và password
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        sleep(1);
        //B2 : Sau khi clear thì điền giá trị vào
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@demo.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("riseDemo");
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
    }

    //Open Client Page
    public static void openClientPage() {
        sleep(2);
        //B3 : Click vào tab menu Clients bên left menu
        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        sleep(2);
        //B4 : Click vào tab Client
        driver.findElement(By.xpath("//div[@id='page-content']//a[normalize-space()='Clients']")).click();
        sleep(1);

    }

    //Enter data on Add Client Diaglog
    public static void EnterDataAddClient(String clientName) {
        sleep(2);
        //B5 : Click nút Add client
        driver.findElement(By.xpath("//a[normalize-space()='Add client']")).click();
        sleep(2);
        driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys(clientName);

        //B6 : Điền vào ô Dropdown xong sau đó nhấn enter
        sleep(2);
        driver.findElement(By.xpath("//div[@id='s2id_created_by']")).click();
        sleep(2);
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Sara Ann");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //B7 : Điền vào các ô còn lại bằng cách dùng id thay vì xpath
        driver.findElement(By.id("address")).sendKeys("ThuDuc");
        driver.findElement(By.id("city")).sendKeys("TPHCM");
        driver.findElement(By.id("state")).sendKeys("23213");
        driver.findElement(By.id("zip")).sendKeys("81000");
        driver.findElement(By.id("country")).sendKeys("Viet Nam");
        driver.findElement(By.id("phone")).sendKeys("32431232");
        driver.findElement(By.id("website")).sendKeys("https://rise.fairsketch.com/clients");

        //B8 : Cuộn chuột đến element Label ở cuối để thấy được các element bị che
        JavascriptExecutor jsEnd = (JavascriptExecutor) driver;
        jsEnd.executeScript("arguments[0].scrollIntoView(false)",driver.findElement(By.xpath("//label[normalize-space()='Disable online payment']")));

        driver.findElement(By.id("vat_number")).sendKeys("0");

        //B9 : Điền vào ô Dropdown Client groups xong nhấn Enter
        driver.findElement(By.xpath("//div[@id='s2id_group_ids']")).click();
        sleep(2);
        driver.findElement(By.xpath("//div[@id='s2id_group_ids']//input")).sendKeys("VIP",Keys.ENTER);

        //B10. Click vào nút Save
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

    }

    // Search Client Afer Added
    public static void checkClientAfterAdded(String clientName) {
        sleep(2);
        driver.findElement(By.xpath("//div[@id='client-table_filter']//input")).sendKeys(clientName);
        sleep(2);
        String clientNameInTable = driver.findElement(By.xpath
                ("//table[@id='client-table']//tbody//tr[1]//td[2]")).getText();
        System.out.println(clientNameInTable);

    }


    public static void main(String[] args) {
        createDriver();

        loginCRM();
        openClientPage();
        EnterDataAddClient("Quang Teo");
        checkClientAfterAdded("Quang Teo");

        closeDriver();
    }
}
