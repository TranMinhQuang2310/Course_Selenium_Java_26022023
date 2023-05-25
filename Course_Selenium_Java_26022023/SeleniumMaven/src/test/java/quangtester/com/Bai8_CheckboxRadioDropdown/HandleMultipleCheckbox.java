package quangtester.com.Bai8_CheckboxRadioDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import quangtester.com.common.BaseTest;

import java.util.List;

public class HandleMultipleCheckbox extends BaseTest {
    public static void main(String[] args) {
        /*
            Có 4 cách thông dụng để lấy xpatch của 4 checkbox :
                //div[normalize-space()='Multiple Checkbox Demo']//following-sibling::div//input[@type='checkbox']
                //label[contains(normalize-space(),'Option')]//input
                //input[@class='cb1-element']
                (//label[contains(normalize-space(),'Option')])[1] => lấy theo vị trí
        */

        createDriver();

        //1. Open đường link web url
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");

        sleep(1);

        //2. Tạo 1 danh sách đối tượng element để xác định được tổng số checkbox => dùng để giới hạn vòng lặp for
        List<WebElement> listCheckbox = driver.findElements(By.xpath
                ("//div[normalize-space()='Multiple Checkbox Demo']//following-sibling::div//input[@type='checkbox']"));

        //3. Kiểm tra List này chứa được bao nhiêu element
        System.out.println("Kích thước List :" + listCheckbox.size());

        //4. Click vào 4 ô checkbox
        for(int i = 1; i <= listCheckbox.size() ; i++) {
            sleep(1);
            driver.findElement(By.xpath("//label[normalize-space()='Option " + i + "']")).click();
        }

        //5. Kiểm tra 4 ô checkbox đã được click hay chưa
        for(int i = 1; i <= listCheckbox.size() ; i++) {
            sleep(1);
            boolean isSelected = driver.findElement(By.xpath(
                    "//label[normalize-space()='Option " + i + "']//input")).isSelected();
            System.out.println("Trạng thái checkbox :" + isSelected);
        }

        closeDriver();

    }
}
