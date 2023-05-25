package anhtester.com.tinhdonggoi;

public class Student {

    //Biến thể hiện giá trị thông tin của sinh viên
    private String mssv;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String password;
    private String phone;
    private String address;
    private final String schoolName = "Đại học Văn Lang";//khi gắn từ khóa final vào thì không thể tạo hàm set thêm nữa


    //GET values
    public String getSchoolName() {
        return schoolName;
    }
    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    //SET values
    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Ví dụ giới hạn độ tuổi không được quá 100 => nếu quá 100 sẽ xuất câu thông báo
    public void setAge(int age) {
        System.out.println((age > 100) ? "Tuổi không được quá 100" : (this.age = age));
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Ví dụ nếu độ dài của password bé hơn 6 => xuất câu thông báo
    public void setPassword(String password) {
        if(password.length() < 6) {
            System.out.println("Lỗi. Password phải từ 6 kí tự trở lên");
        }else if(password.length() > 16) {
            System.out.println("Lỗi. Password không được vượt quá 16 kí tự");
        }else{
            this.password = password;
        }

    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
