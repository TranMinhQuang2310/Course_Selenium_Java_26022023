package dieukien_if_else;

public class LearnDieuKien_IF_ELSE_IF {
    public static void main(String[] args) {
        //VD1 : Kiểu double
        double DTB = 7.5;

        if(DTB > 8) {
            System.out.println("Xuất sắc");
        }else if(DTB == 8) {
            System.out.println("Giỏi");
        }else if(DTB < 8 && DTB >= 7) {
            System.out.println("Khá");
        }else if(DTB <  7 && DTB >= 5) {
            System.out.println("Trung Bình");
        } else {
            System.out.println("Yếu");
        }

        //VD2 : Kiểu string
        String message = "Lấy từ website";
        if(message == "Please fill value") {
            System.out.println("Chưa điền email");
        }else if(message == "Please fill include in @..") {
            System.out.println("format email chưa đúng");
        }else {
            System.out.println("Điền email thành công");
        }
    }
}
