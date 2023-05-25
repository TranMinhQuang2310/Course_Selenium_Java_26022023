package quang.homework.BT_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import quang.homework.keywords.WebUI;

public class BT1_2_3 extends BaseTest_TestNG {
    //Login CMS
    @BeforeMethod
    public void loginCMS() {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//label[@class='aiz-checkbox']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

    }

    @Test(priority = 1)
    public void addCategory() {
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        WebUI.sleep(2);
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();

        //Lấy hàm sleep từ class WebUI
        WebUI.sleep(2);
        //Field Name
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test Category");
        WebUI.sleep(2);

        //Parent Category
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div")).click();
        WebUI.sleep(2);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).
                sendKeys("product101",Keys.ENTER);
        WebUI.sleep(2);

        //Ordering Number
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("123");
        WebUI.sleep(2);

        //Type
        driver.findElement(By.xpath("//label[normalize-space()='Type']/following-sibling::div//button")).click();
        WebUI.sleep(2);
        driver.findElement(By.xpath("//ul[@class='dropdown-menu inner show']//a[@id='bs-select-2-1']")).click();
        WebUI.sleep(2);

        //Banner 200x200
        driver.findElement(By.xpath("//label[normalize-space()='Banner (200x200)']/following-sibling::div")).click();
//        WebUI.sleep(8);
//        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("Group");
//        WebUI.sleep(4);
//        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys(" 25936");
        WebUI.sleep(6);
        driver.findElement(By.xpath("//img[@class='img-fit']")).click();
        WebUI.sleep(4);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        WebUI.sleep(4);

        //Meta Title
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Abc");
        WebUI.sleep(4);

        // Cuộn chuột đến element Label ở cuối để thấy được các element bị che
        JavascriptExecutor jsEnd = (JavascriptExecutor) driver;
        jsEnd.executeScript("arguments[0].scrollIntoView(false)",driver.findElement(By.xpath("//p[normalize-space()='© Active eCommerce CMS v7.1.0']")));

        //Meta Description
        driver.findElement(By.xpath("//label[normalize-space()='Meta description']/following-sibling::div//textarea")).sendKeys("ABC");
        WebUI.sleep(2);

        //Filtering Attributes
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div//button")).click();
        WebUI.sleep(2);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Size",Keys.ENTER);
        WebUI.sleep(2);
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div//button")).click();
        WebUI.sleep(2);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        WebUI.sleep(4);

        //Nhập dữ liệu vào ô search để tìm category vừa tạo
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Test Category",Keys.ENTER);
        WebUI.sleep(2);

        //Get cái Text của item đầu tiên cột Name dưới Table sau khi search xem đúng không
        String categoryItem = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();

        //Cách 1 : Dùng if-else
//        if(categoryItem.contains("Test Category")) {
//            System.out.println("Done");
//        }else {
//            System.out.println("Not Done");
//        }

        //Cách 2 : Dùng assert
        System.out.println("Lấy được Item :" + categoryItem);
        Assert.assertEquals(categoryItem,"Test Category");
        WebUI.sleep(2);



    }


}
