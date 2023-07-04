package quangtester.com.testcases.Bai28_ReadFileExcel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import quangtester.com.common.Bai27_BaseTest;
import quangtester.com.helpers.ExcelHelpers;
import quangtester.com.helpers.PropertiesHelper;
import quangtester.com.keywords.WebUI;
import quangtester.com.pages.Bai27_Pages_DataConfig.Bai27_LoginPage;
import quangtester.com.pages.Bai28_Pages_ReadFileExcel.Bai28_LoginPage;

public class Bai28_LoginTest extends Bai27_BaseTest {

    //LoginTest_Use_DataProvider dùng để khởi tạo class đó và truyền driver vào
    //Khởi tạo đối tượng class
    Bai28_LoginPage loginPage;

    //Tạo 1 testcase đăng nhập
    @Test
    public void loginTestSuccess() {
        //Khởi tạo đối tượng trang Bai28_LoginPage
        //Truyền driver từ BaseTest
        loginPage = new Bai28_LoginPage();

        //Kiểm tra trạng thái của Testcase sau khi chạy


        //Gọi hàm để đọc file Excel
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/resources/datatest/CRM.xlsx","Login");


        //Gọi hàm "login" từ Bai28_LoginPage để dùng
        /*
            rownum : 0 => tương đương với dòng thứ 1 trong file Excel
            rownum : 1 => tương đương với dòng thứ 2 trong file Excel
        */
        //Thực hiện tìm dòng trong file Excel
        loginPage.login(excelHelpers.getCellData("EMAIL",1),excelHelpers.getCellData("PASSWORD",1));

        //Thực hiện ghi data vào file => Chạy tới dòng này là passed
        excelHelpers.setCellDataTheoTenCot("Passed",1,"RESULT");


        //Test lưu dữ liệu label Invoice overview vào file data.properties
        PropertiesHelper.setFile("src/test/resources/configs/data.properties");
        PropertiesHelper.setValue("label", WebUI.getTextElement(By.xpath("//span[normalize-space()='Invoice overview']")));

    }

    //Tạo 1 testcase đăng nhập nhưng nhập sai tên Email
    @Test
    public void loginTestInvalidEmail() {
        loginPage = new Bai28_LoginPage();
        loginPage.loginInvalidEmail("admin@example.com123","123456");
    }

}
