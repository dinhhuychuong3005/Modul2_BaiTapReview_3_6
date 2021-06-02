import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFile {
    void writeFile(String path, List<Student> studentList) throws IOException {
        FileWriter fr = new FileWriter(path);
        BufferedWriter bf = new BufferedWriter(fr);
        String str = "id, name, age, gender, address, email, Gpa \n";
        for (int i = 0; i < studentList.size(); i++) {
            str += studentList.get(i).getId() + "," + studentList.get(i).getName() + "," + studentList.get(i).getAge() + "," +
                    studentList.get(i).getGender() + "," + studentList.get(i).getAddress() + "," + studentList.get(i).getEmail() + "," +
                    studentList.get(i).getGpa() + "\n";
        }
        bf.write(str);
        bf.close();
        fr.close();
    }

    List<Student> readFile(String path) throws IOException {
        List<Student> students = new ArrayList<>();
        FileReader fw = new FileReader(path);
        BufferedReader bw = new BufferedReader(fw);;
        String content = bw.readLine();
        while ((content = bw.readLine()) != null) {
            String[] values = content.split(",");
            students.add(new Student(Integer.parseInt(values[0]),values[1],values[2],values[3],values[4],values[5],values[6],values[7]));
        }
        return students;
    }
}
