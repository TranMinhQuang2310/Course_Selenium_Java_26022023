package anhtester.com.phamvitruycapTWO;

import anhtester.com.phamvitruycapONE.ClassD;

public class LearnPublicTWO {
    public static void main(String[] args) {
        //VD1 : gọi hàm pubic ngoài package ở ClassD
        ClassD d = new ClassD();
        d.showInformation();
        System.out.println(d.address);
    }
}
