package quangtester.com.Bai35_FilterDataTable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import quangtester.com.common.Bai30_BaseTest;
import quangtester.com.drivers.DriverManager;
import quangtester.com.keywords.WebUI;

import java.util.ArrayList;
import java.util.List;

import static quangtester.com.keywords.WebUI.sleep;
import static quangtester.com.keywords.WebUI.waitForPageLoaded;

public class CheckDuyetAllDongTrongAllPage extends Bai30_BaseTest {
    /*
         Ý tưởng xử lý :
            - Phải nắm được mặc định hiện bao nhiêu Item trên 1 trang - đặt là itemTotalOnePage
            - Bắt tổng số item thường hiện bên dưới bảng - đặt là itemTotal
            - Lấy itemTotal chia cho itemTotalOnePage để biết là nó phân trang đúng tổng số trang đó chưa (đặt là pageTotal)
            - Lấy xpath nút Next để click chuyển từng trang
            - Dùng vòng lặp FOR chạy từ 1 đến <= pageTotal để duyệt từng trang
            - Mỗi lần duyệt trang sau khi check data như mong muốn trên table rồi thì nhấn nút Next
    */

    //Hàm xử lý duyệt toàn bộ dòng trong 1 Page
    public void checkSearchTableByColumn(int column, String value) {
        waitForPageLoaded();
        sleep(2);
        //Xác định số dòng của table sau khi search
        List<WebElement> row = DriverManager.getDriver().findElements(By.xpath("//table[@id='example']//tbody//tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Số dòng tìm thấy: " + rowTotal);
        //Dùng for để duyệt tất cả dòng trong 1 trang
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = DriverManager.getDriver().findElement(By.xpath("//table[@id='example']//tbody/tr[" + i + "]/td[" + column + "]"));

            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", elementCheck);

            //Value : giá trị User điền
            //" - " : Kết quả trên màn hình
            System.out.print(value + " - ");
            System.out.println(elementCheck.getText());
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }

    }

    @Test
    public void testCheckPaginationOnTable() {
        WebUI.openURL("https://datatables.net/");

        //Giá trị User nhập vào tìm kiếm
        String searchValue = "LonDon";

        //Lấy số item MẶC ĐỊNH hiển thị ở dropdown lọc Show ... entries
        Select select = new Select(WebUI.getWebElement(By.xpath("//select[@name='example_length']")));
        System.out.println(select.getFirstSelectedOption().getText());

        //Lấy tổng số Item trên 1 trang
        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số item / trang: " + itemTotalOnePage);

        //Thực hiện search giá trị User nhập vào
        WebUI.setText(By.xpath("//input[@type='search']"),searchValue);

        //Tạo mảng để chứa toàn bộ item
        String strTotal = WebUI.getTextElement(By.xpath("//div[@id='example_info']"));
        ArrayList<String> list = new ArrayList<String>();

        /*
            - "\\s" => là khoảng trắng
            - split("\\s") => là tách chuỗi theo kí tự khoảng trắng
                VD : Showing 1 to 10 of 57 entries tách ra theo khoảng trắng
                    => 7 phần tử trong mảng
        */

        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }

        System.out.println(list);

        // Do mảng tính từ 0 => get(5) là vị trí số 5 => kết quả lấy được số 57
        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("Tổng số item: " + itemTotal);
        int pageTotal = itemTotal / itemTotalOnePage;
        int sodu = itemTotal % itemTotalOnePage;
        System.out.println("Tổng số nguyên: " + pageTotal);
        System.out.println("Tổng số dư: " + sodu);

         /*
            Nếu trong trường hợp có số dư => phải làm tròn
                VD :
                    - Lấy số 10 ra từ (dropdown lọc Show ... entries)  -> 10 item trên 1 trang
                    - Lấy số 57 ra từ (Showing 1 to 10 of 57 entries) -> 57 item trên 1 trang
                    => Tổng là 6 trang
        */
        if (sodu > 0) {
            pageTotal = pageTotal + 1;
        }

        System.out.println("Tổng số Page: " + pageTotal);

        //Dùng for duyệt tất cả trang
        for (int i = 1; i <= pageTotal; i++) {
            //Gọi lại đoạn kiểm tra data trên 1 trang
            checkSearchTableByColumn(3, searchValue);

            //Nhấn nút Next (số lần nhấn phải nhỏ hơn tổng số trang 1 đơn vị) => Đén trang cuối cùng không nhấn next nữa
                //VD : 5 trang nhấn 4 lần , 4 trang nhấn 3 lần
            if (i < pageTotal) {
                WebUI.clickElement(By.xpath("//a[@id='example_next']"));
            }
        }

    }
}
