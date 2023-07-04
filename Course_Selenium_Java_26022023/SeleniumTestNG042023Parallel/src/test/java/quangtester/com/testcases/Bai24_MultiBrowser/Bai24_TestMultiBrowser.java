package quangtester.com.testcases.Bai24_MultiBrowser;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import quangtester.com.common.Bai24_MultiBrowser_BaseTest;

public class Bai24_TestMultiBrowser extends Bai24_MultiBrowser_BaseTest {

    //Đề bài : Run class này bằng file Bai24_MultiBrowser.xml => kết quả là Open bằng MicrosoftEdge

    @Test
    public void testAnhTesterBlog() {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
    }
}
