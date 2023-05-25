package learncollection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LearnSet {
    public static void main(String[] args) {

        /*
            - Set : Là một collection không thể chứa 2 giá trị trùng lặp => Nếu cố tình lưu 2 giá trị giống nhau thì
            chỉ hiển thị 1 giá trị
            - new TreeSet() sẽ sắp xếp các phần tử
        */

        //B1 : Khai báo và khởi tạo đối tượng set
        Set<String> set = new HashSet<String>();

        //B2 : Thêm phần tử vào bộ Set
        set.add("Java");
        set.add("C++");
        set.add("PHP");
        set.add("Java");

        //set.remove("PHP");

        //B3 : Lấy giá trị phần tử - Dùng foreach ,interator

        //3.1 Dùng interator
        Iterator<String> interator = set.iterator();
        while (interator.hasNext()) {
            System.out.print(interator.next() + ", ");
        }

        System.out.println("");
        System.out.println("================");

        //3.2 Dùng foreach
        for(String obj : set) {
            System.out.print(obj + ", ");
        }

    }
}
