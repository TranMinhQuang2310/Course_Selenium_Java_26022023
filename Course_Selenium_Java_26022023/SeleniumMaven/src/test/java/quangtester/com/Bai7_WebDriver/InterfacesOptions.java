package quangtester.com.Bai7_WebDriver;

import org.openqa.selenium.Cookie;
import quangtester.com.common.BaseTest;

import java.util.Set;

public class InterfacesOptions extends BaseTest {
    public static void main(String[] args) {
        createDriver();

        driver.get("https://anhtester.com/");
        //Add a new cookie (trường hợp chưa có cookie)
        Cookie newCookie = new Cookie("customName", "847378363427");//name + value ở đây đang nhập đại
        driver.manage().addCookie(newCookie);

        //Th1 : Get theo name
        System.out.println(driver.manage().getCookieNamed("customName"));

        //TH2 : Get all cookies
        Set<Cookie> cookies = driver.manage().getCookies();

        System.out.println(cookies.toString());

//        // Delete a cookie by name
//        driver.manage().deleteCookieNamed("CookieName");
//
//        // Delete all cookies
//        driver.manage().deleteAllCookies();

        closeDriver();
    }

}
