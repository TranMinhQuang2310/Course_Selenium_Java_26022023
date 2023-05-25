package quang.homework.JavaOOP_3.commons;

public class Constants {
    public static String browser;
    public static boolean report;
    public static boolean headless;

    public Constants(String browser,boolean report,boolean headless){
        this.browser = browser;
        this.report = report;
        this.headless = headless;
    }

    public void getInfo() {
        System.out.println("browser :" + this.browser);
        System.out.println("report :" + this.report);
        System.out.println("headless :" + this.headless);

    }


}
