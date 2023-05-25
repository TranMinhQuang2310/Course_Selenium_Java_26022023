package phuongthuc;

public class Student {
    int rollno;
    String name;
    public static String college = "Bưu Chính Viễn Thông";

    Student(int r, String n) {
        rollno = r;
        name = n;
    }


    void display() {
        System.out.println(rollno + " - " + name + " - " + college);
    }

    static void show() {
        System.out.println(college);
    }


    public static void main(String args[]) {
        Student s1 = new Student(111, "Thông");
        Student s2 = new Student(222, "Minh");


        s1.display();
        s2.display();
    }
}
