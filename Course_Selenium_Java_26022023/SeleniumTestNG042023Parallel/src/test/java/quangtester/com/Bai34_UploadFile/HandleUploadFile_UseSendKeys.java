package quangtester.com.Bai34_UploadFile;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import quangtester.com.common.Bai26_BaseTest;
import quangtester.com.common.Bai30_BaseTest;
import quangtester.com.common.BaseTest;
import quangtester.com.drivers.DriverManager;
import quangtester.com.helpers.SystemHelper;
import quangtester.com.keywords.WebUI;

public class HandleUploadFile_UseSendKeys extends Bai30_BaseTest {

    /*
        - Điều kiện tiên quyết: phải là thẻ "input" và có type là "file" => type = khác thì dùng Robot class
        - File PATH phải tính từ thư mục ổ đĩa máy tính cho đến file name chấm đuôi file chính xác
        - Dùng dấu \\ để phân cách folder nếu link trực tiếp trong ổ đĩa máy tính Windows
        - Suggest: nên mang file vào cùng project để file PATH nó ổn định cho nhiều máy
    */

    @Test
    public void testUploadFileWithSendKeys() throws InterruptedException {
        DriverManager.getDriver().get("https://cgi-lib.berkeley.edu/ex/fup.html");

        Thread.sleep(2000);

        By inputFileUpload = By.xpath("//input[@name='upfile']");

        DriverManager.getDriver().findElement(inputFileUpload).sendKeys
                (SystemHelper.getCurrentDir() + "src/test/java/quangtester/com/Bai34_UploadFile/FileUseUpLoad/acc clone.txt");


        Thread.sleep(3000);
    }
}
