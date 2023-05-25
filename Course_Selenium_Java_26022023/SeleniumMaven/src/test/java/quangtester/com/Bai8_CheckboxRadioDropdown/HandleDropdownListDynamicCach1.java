package quangtester.com.Bai8_CheckboxRadioDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import quangtester.com.common.BaseTest;

public class HandleDropdownListDynamicCach1 extends BaseTest {
    public static void main(String[] args) {
        createDriver();
        //1. Open đường link web url
        driver.get("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
        sleep(2);

        //2. Click vào dropdown Category
        driver.findElement(By.xpath("//span[normalize-space()='Select a Category']")).click();
        sleep(2);

        //3. Search giá trị cần tìm
        /*
            Trong trường hợp không muốn phải nhập xong rồi mới chọn giá trị từ B4 đến B5 thì có thể ENTER luôn vào hàm này
            driver.findElement(By.xpath
                ("//span[normalize-space()='Select a Category']/parent::a/following-sibling::div//input"))
                        .sendKeys("Travel",Keys.ENTER);
        */
        driver.findElement(By.xpath
                ("//span[normalize-space()='Select a Category']/parent::a/following-sibling::div//input"))
                        .sendKeys("Travel");
        sleep(2);



        //4. Click chọn Text đã search (cần chọn)
        /*
            Mẹo cách để lấy được xpath : //li[@class='active-result highlighted'
                B1 : Xổ thanh category và Inspect(F12) ngay thanh tìm kiếm
                B2 : Trong đoạn html xổ đoạn : <ul class='chosen-result' ra trước
                B3 : Nhập từ khóa : Travel vào thanh tìm kiếm
                B4 : Nhấp vô active-result highlighted trên đoạn html để lấy xpath
        */

        //driver.findElement(By.xpath("//li[@class='active-result highlighted']")).click();
        sleep(1);

        //5. Nếu không muốn click chọn Text đã search ở B4 => Thực hiện nhấn Enter(dùng cho TH lựa chọn 1 giá trị)
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        closeDriver();
    }
}
