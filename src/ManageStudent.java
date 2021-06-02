import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ManageStudent {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Student> students;
    StudentFile studentFile = new StudentFile();
    Validate validate = new Validate();

    public ManageStudent() {
        try {
            this.students = studentFile.readFile("abc.csv");
        } catch (IOException e) {
            this.students = new ArrayList<>();
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void add() {
        String id = inputId();
        String name = inputName();
        int age = inputBirthday();
        String gender = inputGender();
        String address = inputAddress();
        String email = inputEmail();
        float gpa = inputGpa();
        students.add(new Student(id, name, age, gender, address, email, gpa));
        try {
            studentFile.writeFile("abc.csv", students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String print(List<Student> arr) {
        String str = "";
        for (Student st : arr) {
            str += st.toString() + "\n";
        }
        return str;
    }

    public String inputId() {
        String id;
        do {
            System.out.println("Nhập vào mã sinh viên:");
            id = scanner.nextLine();
            if ((!validate.validateId(id)) || (checkId(id) != -1)) {
                System.out.println("Vui lòng nhập lại mã theo định dạng ( Cxxxx[G|H|I|K]x )");
            }
        } while ((!validate.validateId(id)) || (checkId(id) != -1));
        return id;
    }

    public String inputName() {
        String name;
        System.out.println("Nhập vào tên:");
        do {
            name = scanner.nextLine();
            if (!validate.validateName(name)) {
                System.out.println("Vui lòng nhập vào tên không bao gồm kí tự đặc biệt và số");
            }
        } while (!validate.validateName(name));
        return name;
    }

    public int inputBirthday() {
        int age = validate.getValidDate();
        return age;
    }

    public String inputGender() {
        while (true) {
            System.out.println("Nhập giới tính 1 or 2 (1 = nam,2 = nữ)");
            String gender = scanner.nextLine();
            switch (gender) {
                case "1": {
                    return "Nam";
                }
                case "2": {
                    return "Nữ";
                }
            }
        }
    }

    public String inputAddress() {
        System.out.println("Nhập địa chỉ sinh viên:");
        String address = scanner.nextLine();
        return address;
    }

    public String inputEmail() {
        String email;
        System.out.println("Nhập email");
        do {
            email = scanner.nextLine();
            if (!validate.validateEmail(email)) {
                System.out.println("Nhập lại email theo định dạng tên.họ@codegym.vn");
            }
        } while (!validate.validateEmail(email));
        return email;
    }

    private float inputGpa() {
        System.out.print("Input student gpa: ");
        while (true) {
            try {
                float gpa = Float.parseFloat((scanner.nextLine()));
                if (gpa < 0.0 && gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student age again: ");
            }
        }
    }

    public int checkId(String id) {

        for (int i = 0; i < students.size(); i++) {
            if (id.equals(students.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public void removeId() {
        System.out.println("Nhập vào id sinh viên cần xóa");
        String id = scanner.nextLine();
        if (checkId(id) == -1) {
            System.out.println("Id không tồn tại!");
        } else {
            students.remove(checkId(id));
            try {
                studentFile.writeFile("abc.csv", this.students);
                System.out.println("Xoá thành công!");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void editId() {
        System.out.println("Nhập vào id sinh viên cần sửa");
        String id = scanner.nextLine();
        if (checkId(id) == -1) {
            System.out.println("Id không tồn tại!");
        } else {
            System.out.println("Nhập các thông tin cần sửa");
            String name = inputName();
            int age = inputBirthday();
            String gender = inputGender();
            String address = inputAddress();
            String email = inputEmail();
            float gpa = inputGpa();
            students.add(new Student(id, name, age, gender, address, email, gpa));
            try {
                studentFile.writeFile("abc.csv", this.students);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void searchName() {
        System.out.println("Nhập vào tên cần tìm");
        String name = scanner.nextLine();
        boolean check = false;
        ArrayList<Student> arrayList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (name.equals(students.get(i).getName())) {
                arrayList.add(students.get(i));
                check = true;
            }
        }
        if (check == true){
            System.out.println("Thông tin sinh viên cần tìm là");
            print(arrayList);
        }else {
            System.out.println("Không có sinh viên này");
        }
    }


    public void searchAge() {
        List<Student> arr = new ArrayList<>();
        System.out.println("Nhập vào khoảng tuổi cần tìm");
        System.out.println("Từ tuổi:");
        int minAge = scanner.nextInt();
        System.out.println("Đến tuổi");
        int maxAge = scanner.nextInt();
        boolean check = false;
        for (int i = 0; i < students.size(); i++) {
            if (minAge <= students.get(i).getAge() && students.get(i).getAge() <= maxAge) {
                arr.add(students.get(i));
                check = true;
            }
        }
        if (check == true){
            System.out.println("Sinh viên cần tìm là");
            print(arr);
        }else {
            System.out.println("Không có sinh viên trong độ tuổi này");
        }
    }
}

