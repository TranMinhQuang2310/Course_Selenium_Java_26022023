package quangtester.com.Bai30_TakeScreenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import quangtester.com.common.Bai30_BaseTest;
import quangtester.com.drivers.DriverManager;
import quangtester.com.helpers.Bai30_CaptureHelper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class Screenshot_DungHamRieng extends Bai30_BaseTest {
    // 1. Take Screenshot khi chạy test case
    @Test
    public void TestHomePage1() {
        DriverManager.getDriver().get("https://anhtester.com");
        Assert.assertEquals(DriverManager.getDriver().getTitle(),"Anh Tester Automation Testing");

    }

    // 2. Tự động lấy tên hàm làm tên File
    @Test
    public void TestHomePageNeuCoLoi(Method tenham) {
        DriverManager.getDriver().get("https://anhtester.com/login");
        Assert.assertEquals(DriverManager.getDriver().getTitle(),"Login");

    }

    // Chụp ảnh màn hình cho những trường hợp Fail (nhớ là Run @Test số 2) do @AfterMethod chạy sau mỗi @Test
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Step
        // Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        // passed = SUCCESS và failed = FAILURE
        if(result.getStatus() == ITestResult.FAILURE) {

            Bai30_CaptureHelper.captureScreenshot(result.getName());

        }
    }
}
