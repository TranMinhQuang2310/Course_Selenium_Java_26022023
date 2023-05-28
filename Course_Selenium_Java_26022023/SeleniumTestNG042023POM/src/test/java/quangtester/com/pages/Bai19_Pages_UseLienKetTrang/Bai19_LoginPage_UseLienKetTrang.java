package quangtester.com.pages.Bai19_Pages_UseLienKetTrang;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import quangtester.com.keywords.WebUI;

public class Bai19_LoginPage_UseLienKetTrang {
    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGETEXT = "Login";

    //Lưu Object của trang Login => Dùng đối tượng By trong Selenium để khai báo tên Object cùng giá trị Locator tương ứng
    private By headerPage = By.xpath("//h1");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By messageErrorEmail = By.xpath("//div[@class='text-center alert alert-danger']");

    /*
        + Hàm xây dựng để truyền vào driver => Hàm xây dựng có tham số gì thì khi khởi tạo class phải có tham số đó
        + LoginPage là 1 hàm nhận giá trị driver để dùng
    */

    private WebDriver driver;
    public Bai19_LoginPage_UseLienKetTrang(WebDriver _driver) {
        driver = _driver;
    }

    //Viết các hàm xử lý cho trang Login
    //1. Kiểm tra header page có phải tên "Login" không
    public void verifyHeaderPage() {
        Assert.assertEquals(driver.findElement(headerPage).getText(),"Login","Failed . Name of Header Page not match");
    }

    //2.Điền email
    public void enterEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    //3. Điền password
    public void enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    //4. Click button Login
    public void clickOnLoginButton() {
        driver.findElement(buttonLogin).click();
    }

    /*
        5 . Kiểm tra khi nhập sai Email or Password thì :
            -   Có hiển thị thông báo không
            -   In ra đoạn text xem có Đúng với từ truyền vào không
    */
    public void verifyErrorMessageDisplay() {
        Assert.assertTrue(driver.findElement(messageErrorEmail).isDisplayed(),"Failed . Error Message no display");
        Assert.assertEquals(driver.findElement(messageErrorEmail).getText(),"Invalid email or password","Failed . Content of the Error massage not match");
    }



    //Hàm xử lý tổng hợp để login
    public Bai19_DashboardPage_UseLienKetTrang login(String email,String password) {
        //1. Open URL
        driver.get(URL);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();

        return new Bai19_DashboardPage_UseLienKetTrang(driver);
    }

    public void loginInvalidEmail(String email,String password) {
        //1. Open URL
        driver.get(URL);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        WebUI.sleep(2);
        clickOnLoginButton();
        //2. Kiểm tra thông báo lỗi khi sai Email
        verifyErrorMessageDisplay();
    }

}
