package phuongthuc;

public class LearnMethod {
    /*
        - PHẠM VI TRUY CẬP : <modifier> : private , public ,protected
        - Kiểu dữ liệu trả về của Hàm :
            + Không trả về : void
            + Trả về : String , int , boolean, ... => phải dùng return

    */

    //VD1 : Hàm KHÔNG TRẢ VỀ
    public void showInfo() {
        System.out.println("Quang Dep Chai");
    }

    /*
        VD2 : Hàm TRẢ VỀ :
            - Phải có từ khóa return
            - Cho phép return 1 biến . Nhưng Biến phải có cùng kiểu dữ liệu với method

    */

    private static String getName() {
        String name = "Quang Hoc Gioi";
        return name;
    }

    private static int getAge() {
        int age = 20;
        return age;
    }

    //VD3 : Dùng hàm KHÔNG TRẢ VỀ để gọi hàm và truyền giá trị vào hàm
    protected  void displayInfo(String address , int age) {
        System.out.println(address);
        System.out.println(age);
    }
    //Gọi hàm main phải có static hoặc thông qua class
    public static void main(String[] args) {
        LearnMethod obj = new LearnMethod();// Tạo đối tượng thay mặt cho class để gọi lại tất cả các hàm trong class
        obj.showInfo();//Thông qua class

        //Phải có static
        System.out.println(getName());
        System.out.println(getAge() + 10);

        obj.displayInfo("ThuDuc",18);

        //VD4 :In hàm show từ bên class Student.java
        Student.show();
    }
}
