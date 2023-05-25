package learncollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LearnArrayList {
    public static void main(String[] args) {
        /*
            ArrayList : là một collection có thứ tự (đôi khi còn được gọi là một chuỗi). List có thể chứa các phần tử
            trùng lặp
        */

        /*
            VD1 :
            - Xuất các giá trị được add vào ArrayList
            - Set giá trị mới cho phần tử ở vị trí thứ 1(bắt đầu từ 0)
            - Tìm kiếm giá trị "Project" -> trả về tue/false

        */
        //B1 : Khai báo và khởi tạo đối tượng ArrayList
        List<String> listMenu = new ArrayList<String>();//Cách 1
        //List<String> listMenu = new ArrayList<String>();//Cách 1

        //B2 : Thêm phần tử vào bộ ArrayList
        listMenu.add("Home");
        listMenu.add("Client");
        listMenu.add("Project");
        listMenu.add("Task");
        listMenu.add("Selenium");

        //B3 : Tính độ dài của ArrayList - dùng hàm size()
        System.out.println("Độ dài của ArrayList :" + listMenu.size());

        //B4: Xóa 1 phần tử => xóa phần tử selenium
        listMenu.remove(4);//Xóa selenium ở vị trí số 4

        //B5 : Set giá trị mới cho phần tử ở vị trí thứ 1(bắt đầu từ 0)
        listMenu.set(1 , "QuangDepZai");

        //B6 : Lấy giá trị phần tử - Dùng for , foreach ,interator

        //6.1 Dùng for
        for (int i = 0; i < listMenu.size(); i++) {
            System.out.println(listMenu.get(i));
        }
        System.out.println("================");

        //6.2 Dùng foreach(trong c# gọi là foreach, trong java là hàm for này)
        for (String obj : listMenu) {
            System.out.print(obj + ", ");
        }
        System.out.println("");
        System.out.println("================");

        /*
            6.3 Dùng interator
            => hàm hasNext() kiểm tra phần tử kế tiếp còn không , không còn thì dừng
        */
        Iterator<String> interator = listMenu.iterator();
        while (interator.hasNext()) {
            System.out.println(interator.next() + ", ");
        }

        System.out.println("");
        System.out.println("================");
        //B7 : Tìm kiếm giá trị Project -> Trả về true / false
        System.out.println(listMenu.contains("Project"));

        /*
            VD2 : Copy phần tử từ List 1 sang List 2
            - List 1 : listMenu => lấy từ trên VD1
            - List 2 : tempMenu
        */
        //B1 : Khai báo và khởi tạo đối tượng ArrayList
        ArrayList<String> tempMenu = new ArrayList<String>();

        //B2 : truyền listMenu vào tempMenu
        tempMenu.addAll(listMenu);

        System.out.println("");
        System.out.println("---------");

        //B3 Dùng foreach(trong c# gọi là foreach, trong java là hàm for này)
        for(String obj : tempMenu) {
            System.out.print(obj + ", ");
        }
    }
}
