package quang.homework.BT5_POM.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import quang.homework.BT5_POM.common.BaseTest_POM;
import quang.homework.BT5_POM.pages.AddNewCategoryPage;
import quang.homework.BT5_POM.pages.DashboardPage;
import quang.homework.BT5_POM.pages.DetailCategoryPage;
import quang.homework.BT5_POM.pages.LoginPage;
import quang.homework.keywords.WebUI;

public class CategoryTest extends BaseTest_POM {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    DetailCategoryPage detailCategoryPage;

    AddNewCategoryPage addNewCategoryPage;

    @Test
    public void testAddNewCategory() {

        String NAME_CATEGORY = "PIZZA";

        loginPage = new LoginPage(driver);
        //Thực hiện đăng nhâp
        dashboardPage = loginPage.login("admin@example.com","123456");
        //Open tab menu Product
        dashboardPage.clickOpenMenuProduct();
        //Kiểm tra trang DashboardPage load được hay chưa và đúng hay chưa
        dashboardPage.verifyPageDashBoard();

        //Click vào tab menu "Category"
        WebUI.sleep(2);
        detailCategoryPage = dashboardPage.clickOpenDetailCategoryPage();

        //Click nút "Add new category"
        addNewCategoryPage = detailCategoryPage.clickAddNewCategory();

        //Chạy hàm addNewCategory để nhập dữ liệu
        addNewCategoryPage.addNewCategory(NAME_CATEGORY);
    }
}
