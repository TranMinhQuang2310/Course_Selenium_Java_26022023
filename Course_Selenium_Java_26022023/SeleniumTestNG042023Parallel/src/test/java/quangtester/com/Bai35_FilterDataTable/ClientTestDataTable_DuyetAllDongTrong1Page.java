package quangtester.com.Bai35_FilterDataTable;

import org.testng.annotations.Test;
import quangtester.com.common.Bai30_BaseTest;

public class ClientTestDataTable_DuyetAllDongTrong1Page extends Bai30_BaseTest {

    ClientPage_DuyetAllDongTrong1Page clientPage;

    @Test
    public void ClientTestDataTable() {
        clientPage = new ClientPage_DuyetAllDongTrong1Page();
        clientPage.loginRiseCRM();
        clientPage.openClientPage();
        clientPage.checkSearchTableByColumn(4,"VIP");
    }
}
