package anhtester.com.classandobject;

public class NhanVien {
        /*
            Mẹo : Để sinh ra hàm get mà không cần gõ
                Bôi đen các biến vừa khai báo -> Click chuột phải -> Generater -> Getter -> Đè shift chọn All -> Ok
        */
    public int age;
    public String name;
    public String address;
    public String jobName;


    public int getAge() {
        return age;
    }

    public String getName() {
        return name + " - " + SinhVien.getNameSV() ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getJobName() {
        return jobName;
    }

    public static void main(String[] args) {

    }

}
