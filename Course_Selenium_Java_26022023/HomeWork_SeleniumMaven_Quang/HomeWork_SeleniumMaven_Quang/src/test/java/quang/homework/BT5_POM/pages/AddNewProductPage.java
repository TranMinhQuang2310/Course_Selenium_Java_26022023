package quang.homework.BT5_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import quang.homework.keywords.WebUI;

import java.util.Set;

public class AddNewProductPage {

    //Dùng private để đảm bảo tính đóng gói => Áp dụng tính đóng gói trong OOP
    //Các thuộc tính xác thực
    //Product
    public String PRODUCT_URL = "https://cms.anhtester.com/admin/products/create";
    public String TEXT_ADD_PRODUCT = "Add New Product";

    //Các  Object
    public By CheckHeaderPageProducts = By.xpath("//h5[normalize-space()='" + TEXT_ADD_PRODUCT + "']");
    //1. Product Information
    public By inputProductName = By.xpath("//input[@placeholder='Product Name']");

    public By category = By.xpath("//label[contains(.,'Category *')]/following-sibling::div");
    public By categorySearchbox = By.xpath("//div[@class='bs-searchbox']//input[@aria-controls='bs-select-1']");

    public By brand = By.xpath("//label[contains(.,'Brand')]/following-sibling::div");
    public By brandSearchbox = By.xpath("//div[@class='bs-searchbox']//input[@aria-controls='bs-select-2']");

    public By inputUnit = By.xpath("//input[@name='unit']");

    public By inputWeight = By.xpath("//input[@name='weight']");

    public By inputMinimumPurchaseQty = By.xpath("//input[@name='min_qty']");

    public By inputTags = By.xpath("//span[@class='tagify__input']");

    //-------------------------------------------------------------------------------------

    //2. Product Images
    public By galleryImages = By.xpath("//label[contains(.,'Gallery Images (600x600)')]/following-sibling::div");
    public By inputGalleryImagesSearch = By.xpath("//input[@name='aiz-uploader-search']");
    //Chọn hình đầu tiên
    public By galleryImagesResult = By.xpath("(//div[@class='card card-file aiz-uploader-select'])[1]");
    public By buttonGalleryImages_AddFile = By.xpath("//button[normalize-space()='Add Files']");

    //-------------------------------------------------------------------------------------

    //3. Product Videos
    public By buttonVideoProvider = By.xpath("//select[@id='video_provider']/following-sibling::button");
        //Chọn Vimeo
    public By chooseVideoProvider = By.xpath("//select[@id='video_provider']/following-sibling::div//div[@id='bs-select-3']//li[.='Vimeo']");

    public By inputVideoLink = By.xpath("//input[@name='video_link']");

    //-------------------------------------------------------------------------------------

    //4. Product Variation
    public By buttonActiveColors = By.xpath("//div[@class='col-md-1']//label[@class='aiz-switch aiz-switch-success mb-0']");
    public By buttonColors = By.xpath("//select[@id='colors']/following-sibling::button");
    public By colorsSearchbox = By.xpath("//select[@id='colors']/following-sibling::div//div[@class='bs-searchbox']//input");

    public By buttonAttributes = By.xpath("//select[@id='choice_attributes']/following-sibling::button");
    public By attributesSearchbox = By.xpath("//select[@id='choice_attributes']/following-sibling::div//div[@class='bs-searchbox']//input");

    //-------------------------------------------------------------------------------------

    //5. Product price + stock
    //5.1 Unit price
    public By inputUnitPrice = By.xpath("//input[@name='unit_price']");

    //5.2 Discount Date Range
    public By inputDiscountDate = By.xpath("//input[@name='date_range']");
        //Calendar Left
        //Chọn ngày 28/5/2023 (Sau này không chạy được thì lấy trong khoảng thời gian hiện tại) => Nhớ lấy đúng tr và td
    public By dayOfCalendarLeft = By.xpath("//div[@class='drp-calendar left']//tbody//tr[5]//td[@data-title='r4c1']");
        //Click Open dropdown GIỜ
    public By hourOfCalendarLeft = By.xpath("//div[@class='drp-calendar left']//select[@class='hourselect']");
        //Chọn 7 giờ
    public By chooseHourOfCalendarLeft = By.xpath("//div[@class='drp-calendar left']//select[@class='hourselect']//option[@value='7']");


        //Calendar Right
        //Chọn ngày 30/6/2023 (Sau này không chạy được thì lấy trong khoảng thời gian hiện tại) => Nhớ lấy đúng tr và td
    public By dayOfCalendarRight = By.xpath("//div[@class='drp-calendar right']//tbody//tr[5]//td[@data-title='r4c5']");
        //Click Open dropdown GIỜ
    public By hourOfCalendarRight = By.xpath("//div[@class='drp-calendar right']//select[@class='hourselect']");
        //Chọn 10h
    public By chooseHourOfCalendarRight = By.xpath("//div[@class='drp-calendar right']//select[@class='hourselect']//option[@value='10']");

        //Nhấn nút Select sau khi chọn ngày xong
    public By buttonSelectCalendar = By.xpath("//button[@class='applyBtn btn btn-sm btn-primary']");

    //5.3 Discount
    public By inputDiscount = By.xpath("//input[@name='discount']");
    public By buttonDiscount = By.xpath("//select[@name='discount_type']/following-sibling::button");
        //Chọn Percent
    public By chooseButtonDiscount = By.xpath("//select[@name='discount_type']/following-sibling::div//div[@id='bs-select-6']//a[@id='bs-select-6-1']");

    //-------------------------------------------------------------------------------------

    //6. Tổng hợp hàm cuộn chuột
        //6.1 Scroll tới label Product Variation
    public By scrollToProductVariation = By.xpath("//h5[normalize-space()='Product Variation']");
        //6.2 Scroll tới label Product Description
    public By scrollToProductDescription = By.xpath("//h5[normalize-space()='Product Description']");
        //6.3 Scroll tới label cuối trang
    public By scrollToEndPage = By.xpath("//p[@class='mb-0']");

    //-------------------------------------------------------------------------------------

    //7. Nhấn nút "Save & Publish"
    public By buttonSaveAndPublish = By.xpath("//button[@value='publish']");




    /*
        + Hàm xây dựng để truyền vào driver => Hàm xây dựng có tham số gì thì khi khởi tạo class phải có tham số đó
    */
    //Hàm xây dựng
    private WebDriver driver;
    public AddNewProductPage(WebDriver _driver) {
        driver = _driver;
    }


    //Kiểm tra đã vào màn hình Add Product chưa
    public void verifyPageProduct() {
        //Kiểm tra URL có đúng vào trang Add Product không
        String check_url = driver.getCurrentUrl();
        Assert.assertEquals(check_url,PRODUCT_URL,"URL chưa đúng trang Add Product");
        System.out.println("URL hiện tại của Trang là :" + check_url);

        //Kiểm tra Header Page có đúng đoạn text "Add New Product"
        String check_text = driver.findElement(CheckHeaderPageProducts).getText();
        Assert.assertEquals(check_text,TEXT_ADD_PRODUCT,"Product Header Page is not match");
        System.out.println("Header Page hiện tại của Trang là :" + check_text);
    }



    //Hàm xử lý tổng hợp
    public void addNewProduct(String NAME_PRODUCT) {
        verifyPageProduct();
        WebUI.waitForPageLoaded(driver);

        //1. Product Information
        driver.findElement(inputProductName).sendKeys(NAME_PRODUCT);

        driver.findElement(category).click();
        driver.findElement(categorySearchbox).sendKeys("Hoai 1", Keys.ENTER);

        driver.findElement(brand).click();
        driver.findElement(brandSearchbox).sendKeys("Select Brand", Keys.ENTER);

        driver.findElement(inputUnit).sendKeys("abc");

        driver.findElement(inputWeight).clear();
        WebUI.sleep(1);
        driver.findElement(inputWeight).sendKeys("150");

        driver.findElement(inputMinimumPurchaseQty).clear();
        WebUI.sleep(1);
        driver.findElement(inputMinimumPurchaseQty).sendKeys("222");

        WebUI.sleep(1);
        driver.findElement(inputTags).click();
        driver.findElement(inputTags).sendKeys("1111",Keys.ENTER);

        //6. Cuộn chuột đến element Label Product Variation để thấy được các element bị che
        JavascriptExecutor jsEnd = (JavascriptExecutor) driver;
        jsEnd.executeScript("arguments[0].scrollIntoView(false)",driver.findElement(scrollToProductVariation));
        WebUI.sleep(2);


        //2. Product Images
        WebUI.sleep(1);
        driver.findElement(galleryImages).click();
        WebUI.sleep(1);
        driver.findElement(inputGalleryImagesSearch).sendKeys("Cosy");
        //Chọn hình đầu tiên
        WebUI.sleep(3);
        WebUI.waitForPageLoaded(driver);
        driver.findElement(galleryImagesResult).click();
        //Nhấn Add file
        WebUI.sleep(1);
        driver.findElement(buttonGalleryImages_AddFile).click();

        //3. Product Videos
        WebUI.sleep(1);
        driver.findElement(buttonVideoProvider).click();
            //Chọn Vimeo
        driver.findElement(chooseVideoProvider).click();

        driver.findElement(inputVideoLink).sendKeys("abc.com.vn");

        //4. Product Variation
        // 4.1 Colors
            //Nhấn nút active color
        driver.findElement(buttonActiveColors).click();
        WebUI.sleep(2);
            //Nhấn dropdown
        driver.findElement(buttonColors).click();
            //Nhập dữ liệu vào thanh tìm kiếm
        driver.findElement(colorsSearchbox).sendKeys("Aqua",Keys.ENTER);
            //Nhấn lại dropdown để tắt
        driver.findElement(buttonColors).click();

        //4.2 Attributes
            //Nhấn dropdown
        driver.findElement(buttonAttributes).click();
            //Nhập dữ liệu vào thanh tìm kiếm
        driver.findElement(attributesSearchbox).sendKeys("Size",Keys.ENTER);
            //Nhấn lại dropdown để tắt
        driver.findElement(buttonAttributes).click();

        //5. Product price + stock

        //Cuộn chuột đến element Label Product Description để thấy được các element bị che
        JavascriptExecutor jsEnd1 = (JavascriptExecutor) driver;
        jsEnd1.executeScript("arguments[0].scrollIntoView(false)",driver.findElement(scrollToProductDescription));
        WebUI.sleep(2);

        //5.1 Unit price
        driver.findElement(inputUnitPrice).clear();
        WebUI.sleep(1);
        driver.findElement(inputUnitPrice).sendKeys("100");

        //5.2 Discount Date Range
            //Click vào ô input để mở calendar
        driver.findElement(inputDiscountDate).click();

            //Calendar Left
            //Chọn ngày 28/5/2023 (Sau này không chạy được thì lấy trong khoảng thời gian hiện tại) => Nhớ lấy đúng tr và td
        driver.findElement(dayOfCalendarLeft).click();
            //Click Open dropdown GIỜ
        driver.findElement(hourOfCalendarLeft).click();
            //Chọn 7 giờ
        driver.findElement(chooseHourOfCalendarLeft).click();
        WebUI.sleep(2);

            //Calendar Right
            //Chọn ngày 30/6/2023 (Sau này không chạy được thì lấy trong khoảng thời gian hiện tại) => Nhớ lấy đúng tr và td
        driver.findElement(dayOfCalendarRight).click();
            //Click Open dropdown GIỜ
        driver.findElement(hourOfCalendarRight).click();
            //Chọn 10h
        driver.findElement(chooseHourOfCalendarRight).click();
        WebUI.sleep(2);

            //Nhấn nút Select sau khi chọn ngày xong
        driver.findElement(buttonSelectCalendar).click();
        WebUI.sleep(2);

        //5.3 Discount
        driver.findElement(inputDiscount).clear();
        driver.findElement(inputDiscount).sendKeys("50");

        driver.findElement(buttonDiscount).click();
            //Chọn Percent
        driver.findElement(chooseButtonDiscount).click();
        WebUI.sleep(2);

        //6. Cuộn chuột đến element Label cuối trang
        JavascriptExecutor jsEnd2 = (JavascriptExecutor) driver;
        jsEnd2.executeScript("arguments[0].scrollIntoView(false)",driver.findElement(scrollToEndPage));
        WebUI.sleep(2);


        //7. Nhấn nút "Save & Publish"
        driver.findElement(buttonSaveAndPublish).click();
        WebUI.sleep(3);



    }

}
