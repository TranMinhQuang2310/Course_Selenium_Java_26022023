package anhtester.com.phamvitruycapONE;

import anhtester.com.phamvitruycapONE.package_child.ClassC;

public class LearnProtected extends ClassC {
    public static void main(String[] args) {
        //VD1 : Gọi hàm msg() từ bên CLassB
        ClassB b = new ClassB();

        b.msg();
        System.out.println(b.data);

        System.out.println("-------");

        //VD2 : Gọi hàm protected ngoài package - thông qua kế thừa ClassC
        LearnProtected prt = new LearnProtected();
        prt.showInfo();



    }
}
