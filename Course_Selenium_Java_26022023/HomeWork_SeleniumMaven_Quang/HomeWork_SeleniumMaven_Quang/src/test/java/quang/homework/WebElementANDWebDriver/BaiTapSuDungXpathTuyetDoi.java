package quang.homework.WebElementANDWebDriver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import quang.homework.common.BaseTest;

public class BaiTapSuDungXpathTuyetDoi extends BaseTest {

    //2.11 Cách lấy ngày trong tháng của field Start Date
    public void checkMonthNameStartDate(String monthName,String dayNumber) {
        // Nhấn vô Start Date
        sleep(1);
        driver.findElement(By.xpath("//div[@app-field-wrapper='start_date']//div[@class='input-group date']")).click();
        //VD : Chọn ngày 23/07/2023
        //Dùng vòng lặp for
        for(int i = 1; i <= 12 ; i++) {
            //Bắt xpath của nút qua phải
            sleep(1);
            driver.findElement(By.xpath("//div[@class='xdsoft_datepicker active']//button[@class='xdsoft_next']")).click();
            //Bắt xpath tên của tháng
            sleep(1);
            String getMonthName = driver.findElement(By.xpath("//div[@class='xdsoft_label xdsoft_month']"))
                    .getText();
            if(getMonthName.equals(monthName)) {
                //Click chọn ngày
                driver.findElement(By.xpath("//div[@class='xdsoft_calendar']//tbody//tr//td//div[normalize-space()='"+dayNumber+"']")).click();
                break;
            }
        }
    }
    @Test
    public void XpathTuyetDoi() {
        createDriver();

        //1. Login
        driver.get("https://crm.anhtester.com/admin/authentication");
        sleep(1);

        //1.1 Username
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");

        //1.2 Password
        sleep(1);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");

        //1.3 Click remember me
        sleep(1);
        driver.findElement(By.xpath("//label[normalize-space()='Remember me']")).click();

        //1.4 Click login
        sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //2.Run New Project

        //2.1 Click tab menu Project
        sleep(1);
        driver.findElement(By.xpath("//ul[@id='side-menu']//following-sibling::li[@class='menu-item-projects']")).click();

        //2.2 Click New Project
        sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='New Project']")).click();

        //2.3 Điền Project Name
        sleep(1);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test Create Project");

        //2.4 Nhấn vô Customer
        sleep(1);
        driver.findElement(By.xpath
                ("//div[@class='form-group']//div[@class='dropdown bootstrap-select ajax-search bs3']")).click();
        //Nhập giá trị tìm kiếm trong customer
        sleep(1);
        driver.findElement(By.xpath("(//div[@class='bs-searchbox']//input[@placeholder='Type to search...'])[1]"))
                .sendKeys("testQA");
        //Click vào giá trị vừa tìm kiếm trong Customer
        sleep(1);
        driver.findElement(By.xpath("//div[@id='bs-select-6']//ul[@role='presentation']")).click();

        //2.5 Bỏ tích checkbox calculate
        sleep(1);
        driver.findElement(By.xpath("//div[@class='checkbox checkbox-success']//input[@id='progress_from_tasks']")).click();
        //Di chuyển thanh ngang qua tới 26% => Đang hỏi a An
        sleep(1);
//        driver.findElement(By.xpath("//span[@tabindex='0' and @style='left: 26%;']")).click();

        //2.6 Nhấn vô Billing Type
        sleep(1);
        driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select bs3']//button[@title='Project Hours']")).click();
        //Chọn Fixed Rate
        sleep(1);
        driver.findElement(By.xpath("//a[@id='bs-select-1-1']")).click();

        //2.7 Nhấn vô Status
        sleep(1);
        driver.findElement(By.xpath("//div[@class='dropdown bootstrap-select bs3']//button[@title='In Progress']")).click();
        //Chọn Finished
        sleep(1);
        driver.findElement(By.xpath("//a[@id='bs-select-2-4']")).click();

        //2.8 Nhập số vô Total Rate
        sleep(1);
        driver.findElement(By.xpath("//input[@id='project_cost']")).sendKeys("5");

        //2.9 Nhập số vô Estimated Hours
        sleep(1);
        driver.findElement(By.xpath("//input[@id='estimated_hours']")).sendKeys("100");

        //2.10 Nhấn vô Members
        sleep(1);
        driver.findElement(By.xpath("//button[@data-id='project_members[]']")).click();
        //Nhập dữ liệu vào ô search Members
        sleep(1);
        driver.findElement(By.xpath("//div[@class='bs-searchbox']//input[@aria-controls='bs-select-3']"))
                .sendKeys("Anh Tester");
        //Click vào giá trị vừa tìm kiếm trong Members
        sleep(1);
        driver.findElement(By.xpath("//div[@id='bs-select-3']//ul[@role='presentation']")).click();
        //Nhấn vô thanh Members 1 lần nữa để tắt thanh lựa chọn
        sleep(2);
        driver.findElement(By.xpath("//button[@data-id='project_members[]']")).click();


        checkMonthNameStartDate("July","23");
        closeDriver();
    }

}
