package quangtester.com.Bai8_CheckboxRadioDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import quangtester.com.common.BaseTest;

public class HandleCheckbox extends BaseTest {
    public static void main(String[] args) {
        createDriver();

        //1. Open đường link web url
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");

        //2. Tạo 1 đối tượng element
        WebElement checkboxOne = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        //3. Kiểm tra checkbox mặc định có được tích chọn hay chưa
        boolean checkboxStatusBefore = checkboxOne.isSelected();

        //4.In ra kết quả
        System.out.println("Trạng thái checkbox trước khi click :" + checkboxStatusBefore);

        //5. Trường hợp checkbox chưa được click => click vào check box
        if (checkboxStatusBefore == false) {
            checkboxOne.click();
        }

        sleep(1);
        //6. Kiểm tra sau khi click vào check box thì có chuyển trạng thái từ false sang true chưa
        boolean checkboxStatusAfter = checkboxOne.isSelected();

        //7.In ra kết quả
        System.out.println("Trạng thái checkbox sau khi click :" +checkboxStatusAfter);

        sleep(1);
        //8. Kiểm tra xem message thông báo có hiển thị hay không
        WebElement message = driver.findElement(By.xpath("//div[@id='txtAge']"));
        System.out.println("Trạng thái message :" + message.isDisplayed());
        System.out.println("Hiển thị message :" + message.getText());// Chỉ dùng getText khi thẻ html có text

        closeDriver();
    }
}
