import java.io.Serializable;
import java.time.LocalDate;

public class Student extends Person implements Serializable {
    private String id;
    private String email;
    private float gpa;
    public Student(int i, String value, String s, String value1, String s1, String value2, String s2, String value3){}


    public Student(String id,String name, int age, String gender, String address,  String email, float gpa) {
        super(name, age, gender, address);
        this.id = id;
        this.email = email;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                " ,name=" + getName() +
                " ,age=" + getAge() +
                " ,gender=" + getGender() +
                ", address=" + getAddress() +
                ", email='" + email + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
