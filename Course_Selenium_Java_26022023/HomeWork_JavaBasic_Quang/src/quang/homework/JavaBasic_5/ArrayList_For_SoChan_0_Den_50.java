package quang.homework.JavaBasic_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayList_For_SoChan_0_Den_50 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < 50; i = i +2 ) {
            arr.add(i);
        }
        System.out.println(arr);
    }

}
