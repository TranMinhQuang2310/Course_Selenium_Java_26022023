package quangtester.com.pages.Bai20_Pages_ThucHanh.Customer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import quangtester.com.keywords.WebUI;

//Gọi ra tất cả các hàm có trạng thái static trong class WebUI
import static quangtester.com.keywords.WebUI.*;

public class Bai20_CustomerDetailPage_ThucHanh extends Bai20_AddNewCustomerPage_ThucHanh {

    //Object trong trang Customer Detail
    /*
        - Do đã kế thừa từ hàm Cha (Bai20_AddNewCustomerPage_ThucHanh) => Không phải khai báo lại
        - Lỡ có thay đổi chỉ cần sửa 1 nơi => Bai20_AddNewCustomerPage_ThucHanh
    */



    //Check danh sách Customer Detail
    public void checkCustomerDetail(String customerName,String vatName) {
        //Lấy inputCompany từ hàm (Bai20_AddNewCustomerPage_ThucHanh)
        //String getCompanyNameInDetail = driver.findElement(inputCompany).getAttribute("value");
        String getCompanyNameInDetail = getAttributeElement(inputCompany,"value");
        System.out.println("Name trong ô input của field Company sau khi Lưu là :" + getCompanyNameInDetail);
        //Kiểm tra xem name trong ô inputCompany sau khi Lưu có đúng với dữ liệu nhập vào không
        Assert.assertEquals(getCompanyNameInDetail,customerName,"Failed . Customer Name not match");

        //Lấy inputVat từ hàm (Bai20_AddNewCustomerPage_ThucHanh)
        //String getVatInDetail = driver.findElement(inputVat).getAttribute("value");
        String getVatInDetail = getAttributeElement(inputVat,"value");
        System.out.println("VAT trong ô input của field VAT sau khi Lưu là : " + getVatInDetail);
        //Kiểm tra xem name trong ô inputVAT sau khi Lưu có đúng với dữ liệu nhập vào không
        Assert.assertEquals(getVatInDetail,vatName,"Failed . VAT Name not match");


    }
}
