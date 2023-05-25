package anhtester.com.classandobject;

public class SinhVien {
    static String name = "Quang";
     static int age = 30;

    public static String getNameSV() {
        return name;
    }

    public static int getAgeSV() {
        return age;
    }

    public static void main(String[] args) {
        SinhVien sv = new SinhVien();
        sv.getNameSV();
    }
}
