package quang.homework.BT5_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Data nội bộ
    private String URL = "https://cms.anhtester.com/login";
    private String HEADER_TEXT = "Welcome to Active eCommerce CMS";

    //Lưu Object của trang Login => Dùng đối tượng By trong Selenium để khai báo tên Object cùng giá trị Locator tương ứng
    //Các object
        //1. Đăng nhập
    private By header_text = By.xpath("//h1[normalize-space()='Welcome to Active eCommerce CMS']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonRemember_me = By.xpath("//span[@class='aiz-square-check']");
    private By verify_remember_me = By.id("remember");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");


    /*
        + Hàm xây dựng để truyền vào driver => Hàm xây dựng có tham số gì thì khi khởi tạo class phải có tham số đó
        + DashboardPage là 1 hàm nhận giá trị driver để dùng
    */
    //Hàm xây dựng
    private WebDriver driver;
    public LoginPage(WebDriver _driver) {
        driver = _driver;
    }

    //Viết các hàm xử lý cho trang Login
        //1.Đăng nhập
    //1.1 Kiểm tra header text có phải tên "Welcome to Active eCommerce CMS" không
    public void verifyHeaderText() {
        String verify_headerText = driver.findElement(header_text).getText();
        System.out.println("Tên của Header Text là :" + verify_headerText);
        Assert.assertEquals(verify_headerText,HEADER_TEXT,"Failed . Name of Header Text not match");
    }

    //1.2 Điền email
    public void enterEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    //1.3 Điền password
    public void enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    //1.4 Click vào remember me
    public void clickRemember_me() {
        driver.findElement(buttonRemember_me).click();
    }
    //1.5 Sau khi click thì kiểm tra ô clickRemember_me đã được chọn hay chưa
    public void verifyclickRemember_me() {
        WebElement verify_clickRemember_me = driver.findElement(verify_remember_me);
        System.out.println("Trạng thái ô Remember Me :" + verify_clickRemember_me.isSelected());
    }

    //1.6 Click button Login
    public void clickOnLoginButton() {
        driver.findElement(buttonLogin).click();
    }

    //Hàm xử lý tổng hợp
        //1. Login
    public void login(String email,String passeword) {
        driver.get(URL);//Open URL
        verifyHeaderText();
        enterEmail(email);
        enterPassword(passeword);
        clickRemember_me();
        verifyclickRemember_me();
        clickOnLoginButton();
    }

}
