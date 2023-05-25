package quangtester.com.Bai8_CheckboxRadioDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import quangtester.com.common.BaseTest;

public class HandleRadioButton extends BaseTest {
    public static void main(String[] args) {
        createDriver();

        //1. Open đường link web url
        driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");

        //2. Tạo 1 đối tượng element
        WebElement radioButton = driver.findElement(By.xpath
                ("//div[normalize-space()='Radio Button Demo']//following-sibling::div//label[normalize-space()='Male']/input"));

        //3. Kiểm tra radio mặc định có được tích chọn hay chưa
        boolean radioBefore = radioButton.isSelected();

        //4 In ra kết quả
        System.out.println("Trạng thái Radio trước khi click :" + radioBefore);

        sleep(1);
        //5. Trường hợp radio chưa được click => click vào radio
        if(radioBefore == false) {
            radioButton.click();
        }

        //6. Kiểm tra sau khi click vào radio thì có chuyển trạng thái từ false sang true chưa
        boolean radioAfter = radioButton.isSelected();

        //7. In ra kết quả
        System.out.println("Trạng thái Radio sau khi click :" + radioAfter);

        //8. Kiểm tra xem message thông báo có hiển thị hay không
        WebElement message = driver.findElement(By.xpath("//button[@id='buttoncheck']"));
        System.out.println("Trạng thái message :" + message.isDisplayed());
        System.out.println("Hiển thị message :" +message.getText());//Chỉ dùng getText khi thẻ html có text

        closeDriver();
    }
}
