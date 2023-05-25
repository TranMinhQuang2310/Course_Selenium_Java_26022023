package array;

public class TruyenMangVaoPhuongThuc {
    //VD1 : Tìm giá trị nhỏ nhất trong mảng
    static void min(int arr[]) {
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println(min);
    }
    public static void main(String[] args) {
        int a[] = {33, 3, 4, 5};
        min(a);// truyền mảng tới phương thức
    }
}
