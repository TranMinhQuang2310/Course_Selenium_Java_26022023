package switchcase;

public class SwitchExampleNOTBreak {
    public static void main(String[] args) {
        //Trường hợp không dùng break , sau khi thực thi case có giá trị phù hợp => chạy từ case đó đến cuối
        int number = 20;
        switch (number) {
            case 10:
                System.out.println("10");
            case 20:
                System.out.println("20");
            case 30:
                System.out.println("30");
            default:
                System.out.println("Not in 10, 20 or 30");
        }
    }
}
