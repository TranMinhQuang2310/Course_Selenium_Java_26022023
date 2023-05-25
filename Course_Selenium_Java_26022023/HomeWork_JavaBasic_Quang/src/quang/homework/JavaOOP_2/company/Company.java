package quang.homework.JavaOOP_2.company;

import quang.homework.JavaOOP_2.person.Person;

public class Company extends Person {
    public static void main(String[] args) {
        Company cp = new Company();
        System.out.println(cp.getName());
        System.out.println(cp.getAge());
        System.out.println(cp.getGender());
    }
}
