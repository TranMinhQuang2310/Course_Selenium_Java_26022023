package quang.homework.JavaBasic_5;

import java.util.ArrayList;

public class ArrayList_Danh_Sach_Nhan_Vien {

    //- Tạo hàm riêng để thêm thông tin cơ bản của một nhân viên vào collection đã học phù hợp
    public static ArrayList<NhanVien> infoNV() {
        //Set thông tin vào cho class NhanVien
        NhanVien nv1 = new NhanVien();
        nv1.setMaNV("NV01");
        nv1.setAge(25);

        //Thêm nhân viên vào danh sách class NhanVien
        ArrayList<NhanVien> listemployees = new ArrayList<NhanVien>();
        listemployees.add(nv1);
        return listemployees;
    }

    // - Trong hàm main gọi lại hàm trên để in ra thông tin nhân viên đó với vòng lặp for CƠ BẢN
    public static void main(String[] args) {
        ArrayList<NhanVien> list = infoNV();
        //For cơ bản
        for(int i = 0; i < list.size(); i++) {
            System.out.println("MaNV :" + list.get(i).getMaNV());
            System.out.println("Tuổi :" + list.get(i).getAge());
            System.out.println();
        }
    }







//    public void InfoNV() {
//        String name = "Quang";
//    }
//
//    public static void main(String[] args) {
//        ArrayList_Danh_Sach_Nhan_Vien cl = new ArrayList_Danh_Sach_Nhan_Vien();
//        cl.InfoNV();
//
//        ArrayList<ArrayList_Danh_Sach_Nhan_Vien> list = new ArrayList<>();
//        list.add(cl);
//
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//
//    }
}
