package quang.homework.BT5_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import quang.homework.keywords.WebUI;

public class AddNewCategoryPage {
    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    private String ADD_CATEGORY_URL = "https://cms.anhtester.com/admin/categories/create";
    private String ADD_CATEGORY_TEXT = "Category Information";

    //Các object
    private By CheckHeaderPageAddNewCategory = By.xpath("//h5[normalize-space()='Category Information']");

    //Field Name
    private By inputName = By.xpath("//input[@id='name']");

    //Parent Category
    private By buttonParentCategory = By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div");
    private By buttonParentCategory_searchbox = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");

    //Ordering Number
    private By inputOrderingNumber = By.xpath("//input[@id='order_level']");

    //Type
    private By buttonType = By.xpath("//label[normalize-space()='Type']/following-sibling::div//button");
        //Chọn Digital
    private By chooseType = By.xpath("//ul[@class='dropdown-menu inner show']//a[@id='bs-select-2-1']");

    //Banner 200x200
    private By buttonBanner = By.xpath("//label[normalize-space()='Banner (200x200)']/following-sibling::div");
        //Click vào ô input Search
    private  By inputSearch = By.xpath("//div[@class='aiz-uploader-search text-right']//input");
        //Chọn hình đầu tiên
    private  By resultdBanner = By.xpath("(//div[@class='aiz-file-box-wrap'])[1]");
        //Nhấn nút Add file
    private By buttonAddFile = By.xpath("//button[normalize-space()='Add Files']");

    //Meta Title
    private By inputMetaTitle = By.xpath("//input[@name='meta_title']");

    //Meta Description
    private By textareaMetaDescription = By.xpath("//label[normalize-space()='Meta description']/following-sibling::div//textarea");

    //Filtering Attributes
    private By buttonFilteringAttributes = By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div//button");
    private By buttonFilteringAttributes_searchbox = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");

    //Scroll chuột xuống cuối trang
    private By scrollEndPage = By.xpath("//p[normalize-space()='© Active eCommerce CMS v7.1.0']");

    //Button Save
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");



    /*
        + Hàm xây dựng để truyền vào driver => Hàm xây dựng có tham số gì thì khi khởi tạo class phải có tham số đó
    */
    private WebDriver driver;
    public AddNewCategoryPage(WebDriver _driver) {
        driver = _driver;
    }

    //Kiểm tra đã vào màn hình Add Category chưa
    public void verifyPageAddNewCategory() {
        //Kiểm tra URL có đúng vào trang Add Category không
        String checkUrl = driver.getCurrentUrl();
        Assert.assertEquals(checkUrl,ADD_CATEGORY_URL,"URL chưa đúng trang Add Category");
        System.out.println("URL hiện tại của trang là :" + checkUrl);

        //Kiểm tra Header Page có đúng đoạn text "Category Information"
        String check_text = driver.findElement(CheckHeaderPageAddNewCategory).getText();
        Assert.assertEquals(check_text,ADD_CATEGORY_TEXT,"Product Header Page is not match");
        System.out.println("Header Page hiện tại của Trang là :" + check_text);
    }

    //Hàm xử lý tổng hợp
    public void addNewCategory(String NAME_CATEGORY) {
        verifyPageAddNewCategory();
        WebUI.waitForPageLoaded(driver);

        //Field Name
        driver.findElement(inputName).sendKeys(NAME_CATEGORY);

        //Parent Category
        WebUI.sleep(2);
        driver.findElement(buttonParentCategory).click();
            //Nhập dữ liệu vào ô searchbox
        driver.findElement(buttonParentCategory_searchbox).sendKeys("ĐỒNG HỒ", Keys.ENTER);

        //Ordering Number
        WebUI.sleep(2);
        driver.findElement(inputOrderingNumber).sendKeys("333");

        //Type
        WebUI.sleep(2);
        driver.findElement(buttonType).click();
            //Chọn Digital
        driver.findElement(chooseType).click();

        //Banner 200x200
        WebUI.sleep(2);
        driver.findElement(buttonBanner).click();
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(3);
            //Nhập dữ liệu vào ô input Search
        driver.findElement(inputSearch).sendKeys("quatet");
            //Check cả trong DOM và UI chờ đợi hình đầu tiên đến khi sẵn sàng hiển thị để có thể thao tác được
        WebUI.waitForElementVisible(driver,resultdBanner,5);
            //Chọn hình đầu tiên
        driver.findElement(resultdBanner).click();
            //Nhấn nút Add file
        driver.findElement(buttonAddFile).click();

        //Meta Title
        WebUI.sleep(2);
        driver.findElement(inputMetaTitle).sendKeys("abc");

        // Cuộn chuột đến element Label ở cuối để thấy được các element bị che
        JavascriptExecutor jsEnd = (JavascriptExecutor) driver;
        jsEnd.executeScript("arguments[0].scrollIntoView(false)",driver.findElement(scrollEndPage));

        //Meta Description
        WebUI.sleep(2);
        driver.findElement(textareaMetaDescription).sendKeys("aaaaaaaaaa");

        //Filtering Attributes
        WebUI.sleep(2);
        driver.findElement(buttonFilteringAttributes).click();
            //Nhập dữ liệu vào ô search box
        driver.findElement(buttonFilteringAttributes_searchbox).sendKeys("Size",Keys.ENTER);
        driver.findElement(buttonFilteringAttributes).click();
        WebUI.sleep(2);

        //Button Save
        driver.findElement(buttonSave).click();
    }
}
