package anhtester.com.phamvitruycapONE;

public class LearnPublic {
    public static void main(String[] args) {
        //VD1 : gọi hàm pubic trong package ở ClassD
        ClassD d = new ClassD();
        d.showInformation();
        System.out.println(d.address);
    }
}
