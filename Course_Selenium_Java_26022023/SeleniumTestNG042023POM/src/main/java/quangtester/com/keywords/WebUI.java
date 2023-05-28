package quangtester.com.keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {
    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------------------------------------------------------------------------

    //Áp dụng cho Bài 15 : TestExplicitWait
    public static void waitForElementVisible(WebDriver driver,By by, int seconds_of_timeout) {
        //Khởi tạo ExplicitWait để CHỜ tìm xem đối tượng có visible (vừa tồn tại trong DOM vừa tồn tại trên UI để người dùng thao tác)chưa
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds_of_timeout));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementPresent(WebDriver driver,By by,int seconds_of_timeouts) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds_of_timeouts));

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementClickable(WebDriver driver,By by, int seconds_of_timeouts) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds_of_timeouts));

        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Áp dụng cho Bài 15 : TestFluentWait
    public static void waitForElementVisible_FluentWait (WebDriver driver,By by,int seconds_of_timeouts, int seconds_of_millis ) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds_of_timeouts),Duration.ofMillis(seconds_of_millis));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //----------------------------------------------------------------------------------------------

    //Áp dụng cho Bài 16 :
    public static Boolean checkElementExist_UseBy(WebDriver driver, By by) {
        List<WebElement> listElement = driver.findElements(by);

        if(listElement.size() > 0) {
            System.out.println("Element" + by + " existing .");
            return true;
        }else{
            System.out.println("Element" + by + " NOT exist.");
            return false;
        }
    }

    public static Boolean checkElementExist_UseXpath(WebDriver driver,String xpath) {
        List<WebElement> listElement = driver.findElements(By.xpath(xpath));

        if(listElement.size() > 0) {
            System.out.println("Element" + xpath + " existing .");
            return true;
        }else{
            System.out.println("Element" + xpath + " NOT exist.");
            return false;
        }
    }

     /**
         * Wait for Page loaded (Chờ đợi trang tải xong) (Javascript tải xong)
     */
     public static void waitForPageLoaded(WebDriver driver) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
         JavascriptExecutor js = (JavascriptExecutor) driver;

         //Wait for Javascript to load
         ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
             @Override
             public Boolean apply(WebDriver driver) {
                 return js.executeScript("return document.readyState").toString().equals("complete");
             }
         };

         //Check JS is Ready
         boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

         //Wait Javascript until it is Ready!
         if (!jsReady) {
             System.out.println("Javascript is NOT Ready.");
             //Wait for Javascript to load
             try {
                 wait.until(jsLoad);
             } catch (Throwable error) {
                 error.printStackTrace();
                 Assert.fail("FAILED. Timeout waiting for page load.");
             }
         }
     }

    //----------------------------------------------------------------------------------------------

    //Áp dụng cho Bài 17 :
    //Kiểm tra xác nhận CÓ tồn tại
    public static boolean verifyElementVisible(WebDriver driver,By by,int second) {
         try {
             //Dùng hàm chờ đợi truyền vô xem object có visible(CÓ TỒN TẠI) hay không
             WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(second),Duration.ofMillis(500));
             wait.until(ExpectedConditions.visibilityOfElementLocated(by));
             //Nếu trong thời gian chờ đợi tìm thấy object có visible => trả về true
             return true;
         //=> Nếu quá thời gian chờ đợi mà không tìm thấy object visible sẽ truyền xuống hàm catch báo lỗi => trả về false
         }catch (TimeoutException e) {
             e.printStackTrace();
             return false;
         }
    }

    //Kiểm tra xác nhận KHÔNG tồn tại
    public static boolean verifyElementNotVisible(WebDriver driver,By by ,int second) {
         try{
             //Dùng hàm chờ đợi truyền vô xem object có unvisible(KHÔNG TỒN TẠI) hay không
             WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(second),Duration.ofMillis(500));
             wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
             //Nếu trong thời gian chờ đợi tìm thấy object có unvisible => trả về true
             return true;
             //=> Nếu quá thời gian chờ đợi mà không tìm thấy object unvisible sẽ truyền xuống hàm catch báo lỗi => trả về false
         }catch (TimeoutException e) {
             e.printStackTrace();
             return false;
         }
    }



}
