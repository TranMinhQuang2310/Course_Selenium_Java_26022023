package quangtester.com.Bai29_DataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestDataProvider_Use_SwitchCase {
    @DataProvider (name = "CheckData-Provider")
    public Object[][] dpMethod(Method m) {
        switch (m.getName()) {
            case "Sum" :
                return new Object[][] {{2, 3 , 5}, {5, 7, 12}};
            case "Diff" :
                return new Object[][] {{2, 3, -1}, {5, 7, -2}};
        }
        return null;
    }

    @Test(dataProvider = "CheckData-Provider")
    public void Sum(int a,int b,int result) {
        int sum = a + b;
        //Cộng 2 số lại sau đó so sánh với số cuối cùng xem có bằng nhau không
        Assert.assertEquals(result,sum);
        System.out.println("Kết quả phép cộng :" + result);
    }

    @Test(dataProvider = "CheckData-Provider")
    public void Diff(int a, int b, int result) {
        int diff = a - b;
        //Trừ 2 số sau đó so sánh với số cuối cùng xem có bằng nhau không
        Assert.assertEquals(result, diff);
        System.out.println("Kết quả phép trừ :" + diff);

    }
}
