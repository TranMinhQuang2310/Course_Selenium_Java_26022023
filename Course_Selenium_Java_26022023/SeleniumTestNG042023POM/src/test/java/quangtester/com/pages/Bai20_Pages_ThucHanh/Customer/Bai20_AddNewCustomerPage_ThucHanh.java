package quangtester.com.pages.Bai20_Pages_ThucHanh.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import quangtester.com.keywords.WebUI;

//Gọi ra tất cả các hàm có trạng thái static trong class WebUI
import static quangtester.com.keywords.WebUI.*;

public class Bai20_AddNewCustomerPage_ThucHanh extends Bai20_AddCustomerGroupDialog_ThucHanh {

    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients/client";
    private String PAGE_TEXT = "Customer Details";

    //Các Object
    public By tabCustomerDetail = By.xpath("//a[@aria-controls='contact_info']");
    //Company
    public By inputCompany = By.xpath("//input[@id='company']");
    //VAT Number
    public By inputVat = By.id("vat");
    //Phone
    public By inputPhoneNumber = By.id("phonenumber");
    //Website
    public By inputWebsite = By.id("website");

    //Groups
        //Nhấn vô button Add Group
    public By buttonAddGroup = By.xpath("//div[@class='input-group-btn']//a");
    public By dropdownGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div");
    public By inputGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']");


    //Currency
    public By dropdownCurrency = By.xpath("//select[@id='default_currency']/following-sibling::button");
    public By inputCurrency = By.xpath("//select[@id='default_currency']/following-sibling::div//input[@type='search']");

    //Default Language
    public By dropdownDefaultLanguage = By.xpath("//select[@id='default_language']/following-sibling::button");
        //Chọn kết quả đứng thứ 4
    public By chooseLanguage = By.xpath("//select[@id='default_language']/following-sibling::div//div[@id='bs-select-3']//li//a[@id='bs-select-3-3']");

    //Address
    public By inputAddress = By.id("address");
    //City
    public By inputCity = By.id("city");
    //State
    public By inputState = By.id("state");
    //Zip Code
    public By inputZipCode = By.id("zip");

    //Country
    public By dropdownCountry = By.xpath("//label[@for='country']/following-sibling::div");
    public By inputCountry = By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']");

    //Save
    public By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");



    //Hàm xây dựng
    private WebDriver driver;
    public Bai20_AddNewCustomerPage_ThucHanh(WebDriver _driver) {
        //Khi kế thừa từ hàm CHa phải có super => Tuân theo cấu trúc hàm xây dựng của hàm cha (Bai20_CustomerPage_ThucHanh)
        super(_driver);
        //Khởi tạo driver của thằng con (Bai20_AddNewCustomerPage_ThucHanh)
        driver = _driver;
        //Khởi tạo class WebUI để truyền giá trị driver từ bên ngoài vào WebUI
        new WebUI(driver);//Đây là kiểu khởi tạo đối tượng Annonymous trong Java

    }

    //Hàm xử lý

    //Tạo hàm để mở popup add Group
    public Bai20_AddCustomerGroupDialog_ThucHanh AddGroup(String nameGroup) {
        //Nhấn nút add group
        //driver.findElement(buttonAddGroup).click();
        clickElement(buttonAddGroup);
        WebUI.waitForPageLoaded();
        WebUI.sleep(1);

        //Kiểm tra xem có đúng là popup "Add New Customer Group" chưa
        String getTitleGroup = getTextElement(titleGroup);
        System.out.println("Title popup Group là :" + getTitleGroup );
        Assert.assertEquals(getTitleGroup,PAGE_TEXT_GROUP,"Failed . Title Customer Group not match");
        //Điền vào ô inputName
        //driver.findElement(inputName).sendKeys(nameGroup);
        setText(inputName,nameGroup);
        //Nhấn Save
        //driver.findElement(buttonSubmitGroup).click();
        clickElement(buttonSubmitGroup);

        return new Bai20_AddCustomerGroupDialog_ThucHanh(driver);
    }

    //Tạo hàm cho field Group
    public void selectGroup(String nameGroup) {
        //driver.findElement(dropdownGroups).click();
        clickElement(dropdownGroups);
        driver.findElement(inputGroups).sendKeys(nameGroup, Keys.ENTER);
        //driver.findElement(dropdownGroups).click();
        clickElement(dropdownGroups);
    }

    //Tạo hàm cho field Country
    public void selectCountry() {
        //driver.findElement(dropdownCountry).click();
        clickElement(dropdownCountry);
        driver.findElement(inputCountry).sendKeys("VietNam",Keys.ENTER);
    }


    public void AddDataNewCustomer(String COMPANY_NAME,String nameGroup) {
        //Dùng Wait for Page loaded (Chờ đợi trang tải xong)
        WebUI.waitForPageLoaded();
        //driver.findElement(inputCompany).sendKeys(COMPANY_NAME);
        setText(inputCompany,COMPANY_NAME);
        //driver.findElement(inputVat).sendKeys("10");
        setText(inputVat,"10");
        //driver.findElement(inputPhoneNumber).sendKeys("73871278");
        setText(inputPhoneNumber,"73871278");
        //driver.findElement(inputWebsite).sendKeys("avc.com.vn");
        setText(inputWebsite,"avc.com.vn");

        AddGroup(nameGroup);
        WebUI.sleep(2);
        selectGroup(nameGroup);

        //driver.findElement(dropdownCurrency).click();
        clickElement(dropdownCurrency);
        driver.findElement(inputCurrency).sendKeys("USD", Keys.ENTER);

        //driver.findElement(dropdownDefaultLanguage).click();
        clickElement(dropdownDefaultLanguage);
        //driver.findElement(chooseLanguage).click();
        clickElement(chooseLanguage);

        //driver.findElement(inputAddress).sendKeys("Viet Nam");
        setText(inputAddress,"Viet Nam");
        //driver.findElement(inputCity).sendKeys("Can Tho");
        setText(inputCity,"Can Tho");
        //driver.findElement(inputState).sendKeys("Can Tho");
        setText(inputState,"Can Tho");
        //driver.findElement(inputZipCode).sendKeys("92000");
        setText(inputZipCode,"92000");

        selectCountry();

        //driver.findElement(buttonSave).click();
        clickElement(buttonSave);

        WebUI.waitForPageLoaded();

    }

}
