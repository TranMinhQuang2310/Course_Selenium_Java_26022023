package vonglapfor;

public class ForCaiTienExample {
    /*
        for (Type var : array) {
            // Khối lệnh được thực thi
        }
    */
    public static void main(String[] args) {
        int arr[] = {12, 23, 44, 56, 78}; // khai báo mảng

        //VD1 : Dùng vòng lặp for cải tiến
//        for(int i : arr) {
//            System.out.println(i);
//        }

        //VD2 : Dùng vòng lặp for đơn giản
        for(int i = 0 ; i < 5 ; i++) {
            System.out.println(arr[i]);
        }

    }
}
