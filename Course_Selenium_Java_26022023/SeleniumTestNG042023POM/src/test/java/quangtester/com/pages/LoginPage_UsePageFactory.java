package quangtester.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import quangtester.com.keywords.WebUI;

import java.util.List;

public class LoginPage_UsePageFactory {

        private String URL = "https://crm.anhtester.com/admin/authentication";
        private String PAGETEXT = "Login";

        // Khai báo object - là đối tượng WebElement

        //1. Khai báo Email :
        /*
            Cách 1 :
                //@FindBy(xpath = "//input[@id='email']")
                //private WebElement inputEmail;
        */


        /*
             Cách 2 :
                Dùng @FindAll để tìm kiếm 2 đối tượng web element giống nhau (theo điều kiện HOẶC) :
                        => Nghĩa là nếu không tìm được đối tượng đầu tiên , thì nó mới tìm kiếm đối tượng tiếp theo
        */

        @FindAll({ @FindBy(id = "email") , @FindBy(xpath = "//input[@type='email']") })
        private WebElement inputEmail;

        /*
             Cách 3 :
                Dùng How
                        @FindAll({@FindBy(how = How.ID,using = "email"), @FindBy(xpath = "//input[@type='email']") })
                        private WebElement inputEmail;

        */

        @FindBy(xpath = "//input[@id='password']")
        private WebElement inputPassword;

        @FindBy(xpath = "//button[normalize-space()='Login']")
        private WebElement buttonLogin;

        @FindBy(xpath = "//h1")
        private WebElement headerPage;

        //Dùng FindBys lấy danh sách toàn bộ menu trong thanh left menu
        @FindBys(@FindBy(xpath = "//aside[@id='menu']/ul/li"))
        private List<WebElement> menu;

        //Khai báo hàm xây dựng
        private WebDriver driver;
        public LoginPage_UsePageFactory(WebDriver _driver) {
                driver = _driver;
                //Gọi hàm initElements của class PageFactory để khởi tạo các WebElement trên
                //=> Khởi tạo 1 element này với đường truyền là driver đồng thời khởi tạo trên chính class này
                PageFactory.initElements(driver,this);
        }

        //Viết các hàm xử lý cho trang Login

        public void clickOnMenuByName(String menuName) {
                By menu = By.xpath("//span[normalize-space()='" + menuName + "']");
                driver.findElement(menu).click();
        }

        public void enterEmail(String email) {
                inputEmail.sendKeys(email);
        }
        public void enterPassword(String password) {
                inputPassword.sendKeys(password);
        }

        public void clickOnLoginButton() {
               buttonLogin.click();
        }



        //Viết hàm xử lý tổng hợp
        public void login(String email , String password) {
                driver.get(URL);

                //Cách 1 :
                        //inputEmail.sendKeys(email);
                        //inputPassword.sendKeys(password);
                        //buttonLogin.click();

                //Cách 2 :
                enterEmail(email);
                enterPassword(password);
                clickOnLoginButton();
                WebUI.sleep(3);

                //Kiểm tra @FindBys => lấy danh sách toàn bộ menu trong thanh left menu
                for(int i = 0; i < menu.size();i++) {
                        System.out.println("Lấy danh sách toàn bộ menu trong thanh left menu :" + menu.get(i).getText());
                }

        }

}
