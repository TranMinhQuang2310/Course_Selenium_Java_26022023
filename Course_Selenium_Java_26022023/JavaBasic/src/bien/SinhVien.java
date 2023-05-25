package bien;

public class SinhVien {

    /*
        BIẾN STATIC :
            - Khi tạo biến phải có từ khóa static đằng trước (đồng bộ với hàm main)
            - Nằm ngoài hàm . Mà trong Class
            - Dùng được nhiều hàm khác nhau
            - Dùng được phạm vi truy cập (public , private ,protected)
            - Có thể gọi tên trực tiếp vào các hàm
            - Có thể gọi biến/hàm thông qua tên class . VD : Sv.name

     */
    //Biến static
    public static String ten = "Quang Tèo";

    //Biến non-static :
    public int tuoi = 10;

    public static void main(String[] args) {

        //VD1 : In ra biến static
        System.out.println(ten);

        //VD2 : In ra biến non-static (phải dùng thông qua tên class mới in được) :
        SinhVien tuoiSV = new SinhVien();
        System.out.println(tuoiSV.tuoi);
    }
}
