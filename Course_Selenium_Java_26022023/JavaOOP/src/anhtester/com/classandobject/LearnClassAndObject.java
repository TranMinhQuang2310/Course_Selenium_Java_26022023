package anhtester.com.classandobject;

public class LearnClassAndObject {
    String name = "Hoa";
    int age = 30;

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public void Cong2So(int a, int b) {
        System.out.println("Cộng 2 số :" + (a + b));
    }

    public static void main(String[] args) {
        /*
            1. Tạo đối tượng trong java bằng từ khóa new
            VD1 : Gọi các thành phần của class thông qua đối tượng cụ thể
        */
        LearnClassAndObject ten = new LearnClassAndObject();
        ten.getName();
        ten.Cong2So(8,2);

        LearnClassAndObject tuoi = new LearnClassAndObject();
        tuoi.getAge();
        tuoi.Cong2So(5,10);

        System.out.println("------------");

        /*
            2.
            VD2 : Gọi thành phần của 1 lớp từ lớp SinhVien không thông qua đối tượng
            => Bắt buộc những thành phần trong lớp phải có trạng thái static

        */
        System.out.println(SinhVien.getNameSV());

        /*
            3   . Dùng đối tượng Annonymous
            VD3 : Gọi thành phần của 1 lớp theo kiểu Annoymous(vô danh)
        */
        new LearnClassAndObject().getAge();
    }
}
