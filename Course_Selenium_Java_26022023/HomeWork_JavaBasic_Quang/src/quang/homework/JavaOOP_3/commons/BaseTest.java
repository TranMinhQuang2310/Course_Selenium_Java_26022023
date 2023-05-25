package quang.homework.JavaOOP_3.commons;

public class BaseTest extends Constants {
    public BaseTest(String browser1,boolean report1,boolean headless1) {
        super(browser1,report1,headless1);
    }

    public void createDriver() {
        super.getInfo();
    }

    public void closeDriver() {
        System.out.println("Closed browser: " + browser);
    }

    public static void main(String[] args) {
        BaseTest bs = new BaseTest("Quang", true,false);
        bs.createDriver();
        bs.closeDriver();
    }

}
