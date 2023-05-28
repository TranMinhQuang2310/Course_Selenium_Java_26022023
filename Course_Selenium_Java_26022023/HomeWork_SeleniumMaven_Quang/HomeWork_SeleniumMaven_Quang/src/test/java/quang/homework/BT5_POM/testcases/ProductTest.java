package quang.homework.BT5_POM.testcases;

import org.testng.annotations.Test;
import quang.homework.BT5_POM.common.BaseTest_POM;
import quang.homework.BT5_POM.pages.AddNewProductPage;
import quang.homework.BT5_POM.pages.DashboardPage;
import quang.homework.BT5_POM.pages.LoginPage;

public class ProductTest extends BaseTest_POM {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AddNewProductPage addNewProductPage;
    @Test
    public void testAddNewProduct() {

        String NAME_PRODUCT = "CAKE12345";

        loginPage = new LoginPage(driver);
        //Thực hiện đăng nhâp
        dashboardPage = loginPage.login("admin@example.com","123456");
        //Open tab menu Product
        dashboardPage.clickOpenMenuProduct();
        //Kiểm tra trang DashboardPage load được hay chưa và đúng hay chưa
        dashboardPage.verifyPageDashBoard();

        //Nhấn tab menu "Add New Product"
        addNewProductPage = dashboardPage.clickaddNewProduct();
        //Chạy hàm addNewProduct để nhập dữ liệu
        addNewProductPage.addNewProduct(NAME_PRODUCT);
    }
}
