package anhtester.com.tinhkethua;

public class Student extends Person {

    String universityName;

    //Nếu bên class Cha có hàm xây dựng thì class Con cũng phải build 1 hàm xây dựng
    public Student(String name2, int age2 , float height2 , String address2, String universityName) {
        super(name2,age2,height2,address2); //Truyền ngược tham số về class Cha

        this.universityName = universityName;
    }

    public void getInfoChild() {
        super.getInfo();//getInfo này của class cha là Person thông qua từ khóa super
        System.out.println("University Name :" + this.universityName);
    }

    public static void main(String[] args) {
        Student std = new Student("Quang",18,58, "HN" , "Đại học Văn Lang");
        std.getInfoChild();

        //VD2 : Lấy giá trị từ class Ông Nội là class School
        std.getSchoolName();


    }
}
