package anhtester.com.phamvitruycapTWO;

import anhtester.com.phamvitruycapONE.ClassB;

public class LearnProtectedTWO {
    public static void main(String[] args) {
        ClassB b = new ClassB();

        // b. không ra là do => không hiển thị thành phần ở ClassB (do khác package)
    }
}
