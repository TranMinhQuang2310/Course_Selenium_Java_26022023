package quangtester.com.ThucHanh;

import org.openqa.selenium.By;
import quangtester.com.common.BaseTest;

public class HRSale_LayNgayTrongThang extends BaseTest {

    public static void LoginHrSale() {
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

    }

    //Open Field Project
    public static void OpenFieldProject() {
        sleep(2);
        //5. Click vào Project trên left menu
        driver.findElement(By.xpath("//a[@href='https://app.hrsale.com/erp/projects-grid']")).click();
        sleep(1);
        //6. Click vào Add Project
        driver.findElement(By.xpath("//a[normalize-space()='Add Project']")).click();
        sleep(1);
    }

    // Cách lấy ngày trong tháng của field Start Date
    public static void checkMonthName(String monthName , String dayNumber) {
        sleep(2);
        //7. Click vào field Start Date
        driver.findElement(By.xpath("//div[@class='input-group']//input[@placeholder='Start Date']")).click();
        //8. Dùng vòng lặp for
        for(int i = 1; i <= 12 ; i++) {
            //8.1 Bắt xpath của nút qua phải
            driver.findElement(By.xpath("(//div[@class='dtp-date']//div[contains(@class,'right center')])[1]")).click();
            sleep(1);
            //8.2 Bắt xpath tên của tháng
            String getMonthName = driver.findElement(By.xpath
                    ("//div[@class='dtp-date']//div[contains(@class,'dtp-actual-month ')]")).getText();
            if(getMonthName.equals(monthName)) {
                //Click chọn ngày
                driver.findElement(By.xpath("//a[normalize-space()='"+dayNumber+"']")).click();
                break;//Thoát vòng lặp
            }
        }

    }

    public static void main(String[] args) {
        createDriver();

        LoginHrSale();
        OpenFieldProject();
        checkMonthName("FEB","23");

        closeDriver();
    }
}
