package quang.homework.BT5_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import quang.homework.keywords.WebUI;

public class ProductPage {
    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Data nội bộ
    //Product
    private String PRODUCT_URL = "https://cms.anhtester.com/admin/products/create";
    private String TEXT_ADD_PRODUCT = "Add New Product";
    private By openProduct = By.xpath("//li[@class='aiz-side-nav-item']//span[normalize-space()='Products']");
    private By add_new_Product = By.xpath("//span[normalize-space()='Add New Product']");
    private By CheckHeaderPageProducts = By.xpath("//h5[normalize-space()='" + TEXT_ADD_PRODUCT + "']");
        //1. Product Information
    private By product_name = By.xpath("//input[@placeholder='Product Name']");

    private By category = By.xpath("//label[contains(.,'Category *')]/following-sibling::div");
    private By category_searchbox = By.xpath("//div[@class='bs-searchbox']//input[@aria-controls='bs-select-1']");

    private By brand = By.xpath("//label[contains(.,'Brand')]/following-sibling::div");
    private By brand_searchbox = By.xpath("//div[@class='bs-searchbox']//input[@aria-controls='bs-select-2']");

    private By weight = By.xpath("//input[@name='weight']");

    public By minimum_Purchase_Qty = By.xpath("//input[@name='min_qty']");

    public By tags = By.xpath("//span[@class='tagify__input']");

        //2. Product Images
    public By gallery_Images = By.xpath("//label[contains(.,'Gallery Images (600x600)')]/following-sibling::div");
    public By gallery_Images_search = By.xpath("//input[@name='aiz-uploader-search']");
    //Chọn hình đầu tiên
    public By gallery_Images_result = By.xpath("(//div[@class='card card-file aiz-uploader-select'])[1]");
    public By gallery_Images_AddFile = By.xpath("//button[normalize-space()='Add Files']");





    /*
        + Hàm xây dựng để truyền vào driver => Hàm xây dựng có tham số gì thì khi khởi tạo class phải có tham số đó
        + DashboardPage là 1 hàm nhận giá trị driver để dùng
    */
    //Hàm xây dựng
    private WebDriver driver;
    public ProductPage(WebDriver _driver) {
        driver = _driver;
    }

    //Hàm xử lý
    //Click open tab menu Product
    public void clickOpenMenuProduct() {
        //Dùng Wait for Page loaded (Chờ đợi trang tải xong)
        WebUI.waitForPageLoaded(driver);
        driver.findElement(openProduct).click();
    }

    //Click add new product
    public void clickaddProduct() {
        //Dùng Wait for Page loaded (Chờ đợi trang tải xong)
        WebUI.waitForPageLoaded(driver);
        driver.findElement(add_new_Product).click();
    }

    //Kiểm tra đã vào màn hình Add Product chưa
    public void verifyPageProduct() {
        //Kiểm tra URL có đúng vào trang Add Product không
        String check_url = driver.getCurrentUrl();
        Assert.assertEquals(check_url,PRODUCT_URL,"URL chưa đúng trang Add Product");
        System.out.println("URL hiện tại của Trang là :" + check_url);

        //Kiểm tra Header Page có đúng đoạn text "Add New Product"
        String check_text = driver.findElement(CheckHeaderPageProducts).getText();
        Assert.assertEquals(check_text,"Add New Product","Product Header Page is not match");
        System.out.println("Header Page hiện tại của Trang là :" + check_text);
    }

    //Nhập field
        //1. Product Information
    public void filed_product_name(String nhapProductName) {
        //Dùng Wait for Page loaded (Chờ đợi trang tải xong)
        WebUI.waitForPageLoaded(driver);
        driver.findElement(product_name).sendKeys(nhapProductName);

    }

    public void field_category(String nhapCategory) {
        driver.findElement(category).click();
        WebUI.sleep(1);
        driver.findElement(category_searchbox).sendKeys(nhapCategory, Keys.ENTER);

    }

    public void field_brand(String nhapBrand) {
        driver.findElement(brand).click();
        WebUI.sleep(1);
        driver.findElement(brand_searchbox).sendKeys(nhapBrand, Keys.ENTER);

    }

    public void field_weight(String nhapWeight) {
        driver.findElement(weight).clear();
        WebUI.sleep(1);
        driver.findElement(weight).sendKeys(nhapWeight);
    }

    public void field_minimum_Purchase_Qty(String nhapMinimum_Purchase_Qty) {
        driver.findElement(minimum_Purchase_Qty).clear();
        WebUI.sleep(1);
        driver.findElement(minimum_Purchase_Qty).sendKeys(nhapMinimum_Purchase_Qty);
    }

    public void field_tags(String nhapTags) {
        WebUI.sleep(1);
        driver.findElement(tags).click();
        driver.findElement(tags).sendKeys(nhapTags,Keys.ENTER);
    }

        //2. Product Images
    public void field_gallery_Images() {
        WebUI.sleep(1);
        driver.findElement(gallery_Images).click();
    }

    public void click_gallery_Images_search(String nhapGallery_Images_search) {
        WebUI.sleep(1);
        driver.findElement(gallery_Images_search).sendKeys(nhapGallery_Images_search);
    }
    //Chọn hình đầu tiên
    public void click_gallery_Images_result() {
        WebUI.sleep(3);
        driver.findElement(gallery_Images_result).click();
    }
    //Nhấn Add file
    public void click_gallery_Images_AddFile() {
        WebUI.sleep(1);
        driver.findElement(gallery_Images_AddFile).click();
    }

    //Hàm xử lý tổng hợp
    public void addNewProduct() {
        clickOpenMenuProduct();
        clickaddProduct();
        verifyPageProduct();

        //1. Product Information
        filed_product_name("Anh");
        field_category("Hoai 1");
        field_brand("Select Brand");
        field_weight("150");
        field_minimum_Purchase_Qty("222");
        field_tags("1111");

        //2. Product Images
        field_gallery_Images();
        click_gallery_Images_search("Cosy");
        click_gallery_Images_result();
        click_gallery_Images_AddFile();

    }
}
