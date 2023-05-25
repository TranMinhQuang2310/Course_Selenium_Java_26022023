package array;

public class MangNacDanh {
    public static void main(String[] args) {
        //khai báo mảng nặc danh - Không đầy đủ thông tin mảng (độ dài cụ thể , không cần nạp theo vị trí cụ thể , ...)
        String menu[] = {"Súp cua" , "Hủ tiếu" , "Bánh mì"};

        //Duyệt mảng nặc danh
        for(String name : menu) {
            System.out.println(name);
        }
    }
}
