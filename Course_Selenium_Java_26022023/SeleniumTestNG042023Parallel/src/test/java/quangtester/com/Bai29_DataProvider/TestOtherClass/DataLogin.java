package quangtester.com.Bai29_DataProvider.TestOtherClass;

import org.testng.annotations.DataProvider;
import quangtester.com.helpers.ExcelHelpers;
import quangtester.com.helpers.SystemHelper;

public class DataLogin {

    //1. Gọi DataProvider từ class SystemHelper
    //parallel = true : chạy song song
    //parallel = false : chạy tuần tự (mặc định)
    @DataProvider(name = "dataProviderLoginCRM",parallel = true)
    public Object[][] dataLoginCRM() {
        return new Object[][]{
                //Cấu trúc dòng dữ liệu
                {"admin@example.com", "123456"},
                {"admin2@example.com", "123456"},
                {"admin3@example.com", "123456"}
        };
    }

    @DataProvider(name = "dataProviderLoginCMS",parallel = true)
    public Object[][] dataLoginCMS() {
        return new Object[][]{
                {"admin1@example.com", "123456", 123},
                {"admin2@example.com", "123456", 1234}
        };
    }

    //2. Đọc Excel tất cả các dòng trong một Sheet

    @DataProvider(name = "data_provider_login_excel")
    public Object[][] dataLoginCRMFromExcel() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getExcelData(SystemHelper.getCurrentDir() + "src/test/resources/datatest/CRM.xlsx", "Login");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

    //3. Đọc Excel data với số dòng tuỳ ý sử dụng HashTable
    //startRow : số dòng (Không phải số lượng) BẮT ĐẦU trong file excel - 1
    //endRow : sô dòng (Không phải số lượng) KẾT THÚC trong file excel
    //VD : Run từ dòng 4 đến dòng 5 trong file excel
    @DataProvider(name = "data_provider_login_excel_custom_row")
    public Object[][] dataLoginCRMFromExcelCustomRow() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/datatest/CRM.xlsx", "Login",3,4);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }


}
