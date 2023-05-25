package quangtester.com.Bai8_CheckboxRadioDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import quangtester.com.common.BaseTest;

public class HandleDropdownListStatic extends BaseTest {
    public static void main(String[] args) {
        createDriver();
        //1. Open đường link web url
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        sleep(5);

        //2. Khởi tạo đối tượng select và giá trị là một WebElement của thẻ select trong HTML
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='select-demo']"));
        Select select = new Select(selectElement);
        System.out.println("Giá trị đã chọn :" + select.getFirstSelectedOption().getText());// Lấy giá trị sau khi chọn rồi in ra màn hình

        //2.1 Kiểm tra kiểu của Select có phải multiple không
        System.out.println("Kiểm tra kiểu của Select :" + select.isMultiple());
        //2.2 Kiểm tra số lượng option trong Select
        System.out.println("Kiểm tra số lượng option trong select :" + select.getOptions().size());

        //3.1 Get option với các hàm hỗ trợ của class Select theo text
        select.selectByVisibleText("Wednesday");
        sleep(2);
        System.out.println("Giá trị đã chọn :" + select.getFirstSelectedOption().getText());// Lấy giá trị sau khi chọn rồi in ra màn hình

        //3.2 Get option với các hàm hỗ trợ của class Select theo value (value lấy trong html)
        select.selectByValue("Thursday");
        sleep(2);
        System.out.println("Giá trị đã chọn :" + select.getFirstSelectedOption().getText());// Lấy giá trị sau khi chọn rồi in ra màn hình

        //3.3 Get option với các hàm hỗ trợ của class Select theo vị trí (bắt đầu từ vị trí số 0)
        select.selectByIndex(2); // => vị trí thứ 2 là Monday
        sleep(1);
        System.out.println("Giá trị đã chọn :" + select.getFirstSelectedOption().getText());// Lấy giá trị sau khi chọn rồi in ra màn hình

        sleep(2);
        closeDriver();


    }

}
