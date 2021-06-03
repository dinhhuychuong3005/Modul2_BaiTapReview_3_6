public class test {
    public static void main(String[] args) {
        Validate validate = new Validate();
        System.out.println(validate.validateEmail("chuong.dinh@gmail.com"));
      ManageStudent manageStudent = new ManageStudent();
        Student student = new Student("C0321K1","Chương",5,"nam","namdinh","chuong.dinh@gmail.com",7.5f);
        Student student2 = new Student("C0321K1","Chương ",5,"nam","namdinh","chuong.dinh@gmail.com",7.5f);
//        manageStudent.getStudents().add(student);
//        manageStudent.getStudents().add(student2);
////        manageStudent.add(new Student("C0321K2","Phong",7,"nam","namdinh","chuong.dinh@gmail.com",7.5f));
//////        manageStudent.add(new Student("C0321K3","Chiến",9,"nam","namdinh","chuong.dinh@gmail.com",7.5f));
//        manageStudent.searchName();
        manageStudent.inputId();
    }


}
