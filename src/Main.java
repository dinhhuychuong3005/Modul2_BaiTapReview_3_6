import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManageStudent manageStudent = new ManageStudent();
        StudentFile studentFile = new StudentFile();
        while (true) {
            System.out.println("=========Menu=========");
            System.out.println("1.Hiển thị danh sách sinh viên");
            System.out.println("2.Thêm sinh viên");
            System.out.println("3.Tìm kiếm sinh viên theo ID");
            System.out.println("4.Xóa sinh viên theo id:");
            System.out.println("5.Sửa thông tin sinh viên theo mã sinh viên");
            System.out.println("6.Sắp xếp sinh viên");
            System.out.println("7.Exit");
            System.out.println("Nhập lựa chọn của bạn:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    try {
                        System.out.println(manageStudent.print(studentFile.readFile("abc.csv")));
                    } catch (Exception e) {
                        System.out.println("Chưa có dữ liệu");
                    }
                    break;

                }
                case 2: {
                    manageStudent.add();
                    System.out.println("Danh sách sinh viên sau khi thêm:");
                    System.out.println(manageStudent.print(manageStudent.getStudents()));
                    break;
                }
                case 3: {
                    System.out.println("a.Tìm kiếm theo tên sinh viên");
                    System.out.println("b.Tìm kiếm theo khoảng tuổi sinh viên");
                    System.out.println("c.Tìm kiếm theo mã sinh viên");
                    System.out.println("d.Tìm kiếm theo khoảng điểm sinh viên");
                    scanner.nextLine();
                    String line = scanner.nextLine();
                    switch (line) {
                        case "a": {
                            manageStudent.searchName();
                            break;
                        }
                        case "b": {
                            manageStudent.searchAge();
                            break;
                        }
                        case "c": {
                            System.out.println("Nhập vào mã sinh viên cần tìm");
                            String id = scanner.nextLine();
                            if (manageStudent.checkId(id) == -1) {
                                System.out.println("Id không tồn tại là:");
                            } else {
                                System.out.println(manageStudent.getStudents().get(manageStudent.checkId(id)));
                            }
                            break;
                        }
                        case "d": {
                            manageStudent.searchGpa();
                            break;
                        }
                        default:
                            System.out.println("Nhập lại");
                            break;
                    }
                    break;
                }
                case 4: {
                    manageStudent.removeId();
                    System.out.println(manageStudent.print(manageStudent.getStudents()));
                    break;
                }
                case 5: {
                    manageStudent.editId();
                    break;
                }
                case 6: {
                    System.out.println("1.Sắp xếp sinh viên theo tên");
                    System.out.println("2.Sắp xếp sinh viên theo điểm(nếu cùng điểm thì sắp xếp theo tên)");
                    int i = scanner.nextInt();
                    switch (i) {
                        case 1: {
                            manageStudent.sortName();
                            System.out.println("sau khi sắp xếp");
                            System.out.println(manageStudent.print(manageStudent.getStudents()));
                            try {
                                studentFile.writeFile("abc.csv", manageStudent.getStudents());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 2: {
                            manageStudent.sortGpa();
                            System.out.println("sau khi sắp xếp");
                            System.out.println(manageStudent.print(manageStudent.getStudents()));
                            try {
                                studentFile.writeFile("abc.csv", manageStudent.getStudents());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                    }
                    break;
                }
                case 7: {
                    System.exit(0);
                }
                default:
                    System.out.println("nhập lại");
                    break;
            }
        }
    }
}

