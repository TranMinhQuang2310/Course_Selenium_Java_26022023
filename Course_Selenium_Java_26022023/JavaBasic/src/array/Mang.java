package array;

public class Mang {
    /*
        datatype <tên mảng>[] = new datatype[size];
    */
    public static void main(String[] args) {
        /*
            VD1 : Duyệt phần tử trong mảng theo datatype là int
        */
        //B1 : Khai báo và khởi tạo mảng
        int mang1[] = new int[3];
        //B2 : Gán giá trị cho phần tử trong mảng
        mang1[0] = 4;//Gán giá trị 4 cho vị trí thứ 0 trong mảng
        mang1[1] = 6;//Gán giá trị 6 cho vị trí thứ 1 trong mảng
        mang1[2] = 10;//Gán giá trị 10 cho vị trí thứ 2 trong mảng

        System.out.println("Xuất giá trị đuợc gán ở vị trí thứ 0 trong mảng :" + mang1[1]);

         /*
            B3 : Duyệt phần tử trong mảng
             => Dùng vòng lặp for đơn giản hoặc for cải tiến
        */

        for(int i : mang1) {
            System.out.println(i);
        }

        //------------------------------------------------------------------------------------

        /*
            VD2 : Duyệt phần tử trong mảng theo datatype là String
        */
        //B1 : Khai báo và khởi tạo mảng
        String arr[] = new String[10];
        //B2 : Nạp giá trị CHUỖI vào mảng
        for(int i = 0 ; i < arr.length ; i++) { // Cho chạy từ vị trí 0 đến vị trí 10
            arr[i] = "quang tèo"; //Nạp vào vị trí thứ 0 giá trị "quang tèo"
        }
        //B3 : Xuất giá trị đuợc gán ở vị trí thứ 3 trong mảng
        System.out.println(arr[1]);

    }
}
