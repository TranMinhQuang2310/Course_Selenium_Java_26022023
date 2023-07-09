package quangtester.com.Bai34_UploadFile;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import quangtester.com.common.Bai26_BaseTest;
import quangtester.com.common.Bai30_BaseTest;
import quangtester.com.drivers.DriverManager;
import quangtester.com.helpers.SystemHelper;
import quangtester.com.keywords.WebUI;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class HandleUploadFile_UseRobotClass extends Bai26_BaseTest {

    /*
        Ý tưởng:
            - Click button mở form chọn file từ máy tính
            - Copy link file đó vào clipboard(bộ nhớ tạm)
            - Dán giá trị từ clipboard đó (Ctrl + V) vào ô input
            - Nhấn phím Enter
    */
    @Test
    public void testUploadFileWithRobotClass() throws InterruptedException {
        DriverManager.getDriver().get("https://files.fm/");

        WebUI.sleep(2);

        By divFileUpload = By.xpath("//div[@id='uploadifive-file_upload']");

        //Dùng dấu \\ để phân cách folder nếu link trực tiếp trong ổ đĩa máy tính Windows
        String filePath = SystemHelper.getCurrentDir() + "src\\test\\java\\quangtester\\com\\Bai34_UploadFile\\FileUseUpLoad\\tho7mau.jpg";

        //Click button để mở form upload
        DriverManager.getDriver().findElement(divFileUpload).click();
        WebUI.sleep(3);

        // Khởi tạo Robot class
        Robot rb = null; // Mặc định là null
        try {
            rb = new Robot();
        }catch (AWTException e) {
            e.printStackTrace();
        }

        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);

        WebUI.sleep(2);

        //Dán giá trị từ clipboard đó (Ctrl + V) vào ô input => Nhấn ngón tay
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        //Xác nhận Control V trên => Thả ngón tay ra
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        WebUI.sleep(1);

        //Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        WebUI.sleep(4);

        //Kiểm tra đoạn text hiển thị sau khi thêm file thành công
        String statusText = WebUI.getTextElement(By.xpath("//div[@id='upload_stats_text']"));
        Assert.assertTrue(statusText.contains("Selected files 1"),"Fail. Can not upload file");
    }
}
