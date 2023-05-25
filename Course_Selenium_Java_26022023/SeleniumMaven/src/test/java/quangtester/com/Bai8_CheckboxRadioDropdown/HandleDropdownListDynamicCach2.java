package quangtester.com.Bai8_CheckboxRadioDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import quangtester.com.common.BaseTest;

public class HandleDropdownListDynamicCach2 extends BaseTest {
    public static void main(String[] args) {
        createDriver();
        //1. Open đường link web url
        driver.get("https://app.hrsale.com/erp/login");

        //2. Điền Email
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("frances.burns");
        sleep(1);

        //3. Điền password
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("frances.burns");
        sleep(1);

        //4. Click nút login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(1);

        //5. Click vào Project trên left menu
        driver.findElement(By.xpath("//a[@href='https://app.hrsale.com/erp/projects-grid']")).click();
        sleep(1);

        //6. Click vào Add Project
        driver.findElement(By.xpath("//a[normalize-space()='Add Project']")).click();
        sleep(1);

        //7. Click vào dropdown Priority
        driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single']//span[normalize-space()='Highest']")).click();
        sleep(1);

        //8.Search giá trị cần tìm
        driver.findElement(By.xpath
                ("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")).sendKeys("Normal");
        sleep(1);

        //9. Click chọn Text đã search (cần chọn)
            //Cách 1 :
        //driver.findElement(By.xpath("//span[@class='select2-results']//li[normalize-space()='Normal']")).click();

            //Cách 2 :
        driver.findElement(By.xpath
                ("//span[@class='select2-results']//li[contains(@class,'select2-results__option select2-results__option--highlighted')]"))
                .click();

        //10.Nếu không muốn click chọn Text đã search ở B9 => Thực hiện nhấn Enter(dùng cho TH lựa chọn 1 giá trị)
//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.ENTER).perform();

        closeDriver();


    }
}
