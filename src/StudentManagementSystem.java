import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;

    StudentManagementSystem(){
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(String rollNo){
        students.removeIf(student -> student.getRollNo().equals(rollNo));
    }
    public Student searchStudent(String rollNo){
        for(Student student:students){
            if(student.getRollNo().equals(rollNo)){
                return student;
            }
        }
        return null;
    }
    public void displayStudent(){
        for(Student student: students){
            System.out.println(student);
        }
    }
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        }
    }
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with an empty list.");
        }
    }
}
