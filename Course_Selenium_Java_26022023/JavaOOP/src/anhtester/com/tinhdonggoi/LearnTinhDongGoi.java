package anhtester.com.tinhdonggoi;

public class LearnTinhDongGoi {
    public static void main(String[] args) {
        Student std = new Student();
        System.out.println(std.getSchoolName());

        //Set thông tin vào cho class Student
        std.setMssv("SV01");
        std.setName("Quang");
        // Ví dụ giới hạn độ tuổi không được quá 100 => nếu quá 100 sẽ xuất câu thông báo
        std.setAge(101);
        std.setGender("Nam");
        std.setPhone("0123");

        //Ví dụ nếu độ dài của password bé hơn 6 => xuất câu thông báo
        std.setPassword("SeleniumJavaAnhTester");

        //Get thông tin ra từ class Student
        System.out.println(std.getMssv());
        System.out.println(std.getName());
        System.out.println(std.getAge());
        System.out.println(std.getGender());
        System.out.println(std.getPhone());
        System.out.println(std.getPassword());
    }
}
