package learncollection;

import java.util.HashMap;
import java.util.Map;

public class LearnMap {
        /*
            - Map : Là một collection không thể chứa key trùng lặp => Nếu cố tình trùng thì chỉ nhận key cuối cùng
            - new TreeMap() sẽ sắp xếp các phần tử dự vào key của chúng
        */
    public static void main(String[] args) {
        //B1 : Khai báo và khởi tạo đối tượng hashMap
        Map<String, String> hashMap = new HashMap<String , String>();

        //B2 : Đặt key và value
        hashMap.put("Window" , "2000");
        hashMap.put("Window" , "XP");
        hashMap.put("Language2", "Java");
        hashMap.put("Language1", ".Net");

        System.out.println("Các phần tử của Map");
        System.out.println("\t" +hashMap);

        System.out.println("");
        System.out.println("--------");
        //B3 : Lấy giá trị từ key "Window" là XP
        System.out.println(hashMap.get("Window"));
    }
}
