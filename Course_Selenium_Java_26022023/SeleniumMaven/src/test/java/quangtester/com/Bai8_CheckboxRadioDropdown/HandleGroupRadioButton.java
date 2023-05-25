package quangtester.com.Bai8_CheckboxRadioDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import quangtester.com.common.BaseTest;

public class HandleGroupRadioButton extends BaseTest {
    public static void main(String[] args) {

        /*
            Cách lấy xpath của radio button khác group
                //h4[normalize-space()='Age Group :']/following-sibling::label[normalize-space()='5 to 15']//input
        */

        createDriver();

        //1. Open đường link web url
        driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");

        //2. Tạo 1 đối tượng element
        WebElement radioGroup = driver.findElement(By.xpath
                ("//h4[normalize-space()='Age Group :']/following-sibling::label[normalize-space()='5 to 15']//input"));

        //3. Click vào 1 radio button
        radioGroup.click();

        //4. Kiểm tra radio mặc định có được tích chọn hay chưa
        System.out.println("Trạng thái Radio Group :" + radioGroup.isSelected());

        System.out.println("-------------");

        //5. Kiểm tra trạng thái 2 radio button còn lại (gộp bước để in ra luôn) :
        WebElement radio0to5 = driver.findElement(By.xpath
                ("//h4[normalize-space()='Age Group :']/following-sibling::label[normalize-space()='0 to 5']//input"));
        WebElement radio15to50 = driver.findElement(By.xpath
                ("//h4[normalize-space()='Age Group :']/following-sibling::label[normalize-space()='15 to 50']//input"));

        System.out.println("Trạng thái Radio 0 to 15 :" + radio0to5.isSelected());
        System.out.println("Trạng thái Radio 15 to 50 :" + radio15to50.isSelected());

        closeDriver();
    }
}
