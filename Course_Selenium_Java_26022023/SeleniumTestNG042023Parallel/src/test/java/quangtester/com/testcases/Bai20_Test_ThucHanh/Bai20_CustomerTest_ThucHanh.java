package quangtester.com.testcases.Bai20_Test_ThucHanh;

import org.testng.annotations.Test;
import quangtester.com.common.Bai26_BaseTest;
import quangtester.com.common.BaseTest;
import quangtester.com.pages.Bai20_Pages_ThucHanh.Customer.Bai20_AddNewCustomerPage_ThucHanh;
import quangtester.com.pages.Bai20_Pages_ThucHanh.Customer.Bai20_CustomerDetailPage_ThucHanh;
import quangtester.com.pages.Bai20_Pages_ThucHanh.Customer.Bai20_CustomerPage_ThucHanh;
import quangtester.com.pages.Bai20_Pages_ThucHanh.Dashboard.Bai20_DashboardPage_ThucHanh;
import quangtester.com.pages.Bai20_Pages_ThucHanh.Login.Bai20_LoginPage_ThucHanh;

public class Bai20_CustomerTest_ThucHanh extends Bai26_BaseTest {
    Bai20_LoginPage_ThucHanh loginPage_thucHanh;
    Bai20_DashboardPage_ThucHanh dashboardPage_thucHanh;
    Bai20_CustomerPage_ThucHanh customerPage_thucHanh;
    Bai20_AddNewCustomerPage_ThucHanh addCustomerPage_thucHanh;
    Bai20_CustomerDetailPage_ThucHanh customerDetailPage_thucHanh;


    @Test
    public void testAddNewCustomer() {

        String COMPANY_NAME = "TGDD";
        String VAT_NAME = "10";
        String NAME_GROUP = "TEST-NAME";

        loginPage_thucHanh = new Bai20_LoginPage_ThucHanh();
        //Thực hiện đăng nhập
        dashboardPage_thucHanh = loginPage_thucHanh.login("admin@example.com","123456");
        //Open Customer Page
        customerPage_thucHanh = dashboardPage_thucHanh.openCustomerPage();

        //Kiểm tra trang Customer Page load được hay chưa và đúng hay chưa
        customerPage_thucHanh.verifyCustomerPage();
        //Click vào button "New Customer"
        addCustomerPage_thucHanh = customerPage_thucHanh.clickNewCustomerButton();

        //Chạy hàm AddDataNewCustomer để nhập dữ liệu
        addCustomerPage_thucHanh.AddDataNewCustomer(COMPANY_NAME,NAME_GROUP);

        //Mở lại trang Customer
        dashboardPage_thucHanh.openCustomerPage();

        //Search giá trị Customer vừa Add vào
        customerPage_thucHanh.searchCustomer(COMPANY_NAME);

        //Click vào kết quả Customer Name dòng đầu tiên sau khi search
        customerDetailPage_thucHanh = customerPage_thucHanh.clickOnFirstRowCustomerName();

        //gọi hàm check danh sách Customer Detail
        customerDetailPage_thucHanh.checkCustomerDetail(COMPANY_NAME,VAT_NAME);


    }
}
