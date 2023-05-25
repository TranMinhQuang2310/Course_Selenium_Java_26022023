package anhtester.com.tinhkethua;

public class Person extends School {
    public String name;
    public int age;
    public float height;
    public String address;

    //Build hàm xây dựng (constructor)
    //Nhận giá trị từ từ khóa "super" ở lớp con
    public Person(String name, int age, float height , String address) {
        /*
           Giải nghĩa vì sao dùng this :
           VD : this.name = name;
           => this là lấy tên thuộc tính nào đó trong class
           => name ở vế trái lấy từ hàm khai báo ở trên
           => name ở vế phải lấy từ hàm xây dưng vừa khai báo

        */
        this.name = name;
        this.age = age;
        this.height = height;
        this.address = address;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(String name, int age, float height) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void getInfo() {
        System.out.println("Name:" + this.name);
        System.out.println("Age:" + this.age);
        System.out.println("Height:" + this.height);
        System.out.println("Address :" + this.address);
    }

    public static void main(String[] args) {
        // Chạy vào hàm Person thứ 1
        Person ps = new Person("Nga" , 23,35, "HCM");
        ps.getInfo();

        System.out.println("------");

        // Chạy vào hàm Person thứ 2
        Person ps1 = new Person("Nga" , 23, "HCM");
        ps1.getInfo();

        System.out.println("------");

        // Chạy vào hàm Person thứ 3
        Person ps2 = new Person("Nga" , 23, 36);
        ps2.getInfo();

        System.out.println("------");

        //VD2 : Lấy giá trị từ class Cha là class School
        ps.getSchoolName();
    }
}
