package quangtester.com.helpers;

import java.io.File;

public class SystemHelper {

    // Hàm lấy đường dẫn tuyệt đối của Project
    public static String getCurrentDir() {
        //D:\HocTester-AnhTester-Course\SeleniumJava\Course_Selenium_Java_26022023 + "\"
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }

}
