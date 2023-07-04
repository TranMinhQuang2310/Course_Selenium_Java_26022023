package quangtester.com.Bai30_TakeScreenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import quangtester.com.common.Bai27_BaseTest;
import quangtester.com.common.Bai30_BaseTest;
import quangtester.com.drivers.DriverManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;


public class TestScreenshot extends Bai30_BaseTest {

    // 1. Take Screenshot khi chạy test case
    @Test
    public void TestHomePage1() {
        DriverManager.getDriver().get("https://anhtester.com");
        Assert.assertEquals(DriverManager.getDriver().getTitle(),"Anh Tester Automation Testing");

        // Chụp màn hình step này lại
        // Tạo tham chiếu của TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        // Gọi hàm capture screenshot - getScreenshotAs để chụp màn hình
        File source = ts.getScreenshotAs(OutputType.FILE);
        // Kiểm tra folder tồn tại. Nếu không thì tạo mới folder
        File theDir = new File("screenshots/");
        if(!theDir.exists()) {
            theDir.mkdir();
        }
        try {
            FileHandler.copy(source,new File("screenshots/testHomepage1.png"));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot success !!");
    }

    // 2. Tự động lấy tên hàm làm tên File
    @Test
    public void TestHomePageNeuCoLoi(Method tenham) {
        DriverManager.getDriver().get("https://anhtester.com/login");
        Assert.assertEquals(DriverManager.getDriver().getTitle(),"Login");

//        // Chụp màn hình step này lại
//        // Tạo tham chiếu của TakesScreenshot
//        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
//        // Gọi hàm capture screenshot - getScreenshotAs để chụp màn hình
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        // Kiểm tra folder tồn tại. Nếu không thì tạo mới folder
//        File theDir = new File("screenshots/");
//        if(!theDir.exists()) {
//            theDir.mkdir();
//        }
//        //Lấy tên của hàm xong gán cho tên File chụp màn hình
//        try {
//            FileHandler.copy(source,new File("screenshots/" + tenham.getName() + ".png"));
//        }catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Screenshot success !!");
    }

        // Chụp ảnh màn hình cho những trường hợp Fail (nhớ là Run @Test số 2) do @AfterMethod chạy sau mỗi @Test
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Step
        // Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        // passed = SUCCESS và failed = FAILURE
        if(result.getStatus() == ITestResult.FAILURE) {
            // Chụp màn hình step này lại
            // Tạo tham chiếu của TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
            // Gọi hàm capture screenshot - getScreenshotAs để chụp màn hình
            File source = ts.getScreenshotAs(OutputType.FILE);
            // Kiểm tra folder tồn tại. Nếu không thì tạo mới folder
            File theDir = new File("screenshots/");
            if(!theDir.exists()) {
                theDir.mkdir();
            }
            //Lấy tên của hàm xong gán cho tên File chụp màn hình
            try {
                FileHandler.copy(source,new File("screenshots/" + result.getName() + ".png"));
                System.out.println("Screenshot success: " + result.getName());
            }catch (IOException e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }

        }
    }

}
