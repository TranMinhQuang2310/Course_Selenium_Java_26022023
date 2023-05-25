package vonglapfor;

public class ForDonGianExample {
    /*
        for (khoi_tao_bien ; check_dieu_kien ; tang/giam_bien) {
            // Khối lệnh được thực thi
        }
    */

    public static void main(String[] args) {
        //VD1 : In ra màn hình 1 3 5 7 9
        for (int i = 1;i <= 10 ; i = i +2) {
            System.out.println(i);
        }

        //VD2 : In ra màn hình 0 2 4 6 8 10
        for (int i = 0;i <= 10 ; i = i +2) {
            System.out.println(i);
        }
    }
}
