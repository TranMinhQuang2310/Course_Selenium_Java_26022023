package quangtester.com.Bai33_ExtentReport;

import com.aventstack.extentreports.Status;
import lombok.extern.java.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import quangtester.com.helpers.Bai30_CaptureHelper;
import quangtester.com.helpers.PropertiesHelper;
import quangtester.com.reports.ExtentReportManager;
import quangtester.com.reports.ExtentTestManager;
import quangtester.com.utils.LogUtils;

public class Bai33_TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext arg0) {
        //Gọi hàm loadAllFiles
        PropertiesHelper.loadAllFiles();

    }

    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("Kết thúc test :" + result.getName());

        //Kết thúc và thực thi Extents Report
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("Running Test Case :" + result.getName());

        //Bắt đầu ghi 1 TCs mới vào Extent Report
        ExtentTestManager.saveToReport(getTestName(result),getTestDescription(result));

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("Đây là test case  " + result.getName() + " chạy thành công");

        //Extent Report
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " chạy thành công.");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("Đây là test case " + result.getName() + " thất bại");
        //Screenshot ngay lập tức khi chạy fail
        Bai30_CaptureHelper.captureScreenshot(result.getName());
        //Ghi ra chi tiết lỗi
        LogUtils.error("Chi tiết lỗi :" + (result.getThrowable().toString()));

        //Extent Report
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " thất bại.");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.info("Đây là test case " + result.getName() + " bị bỏ qua");
        //Ghi ra chi tiết lỗi
        LogUtils.info("Chi tiết lỗi :" + (result.getThrowable().toString()));

        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LogUtils.info("Đây là test case  " + result.getName() + " bị FAIL nhưng có phần SUCCESS ");
        //Ghi ra chi tiết lỗi
        LogUtils.info("Chi tiết lỗi :" + (result.getThrowable().toString()));

    }








}
