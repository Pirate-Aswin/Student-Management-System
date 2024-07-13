import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        try {
            sms.loadFromFile("students.dat");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Could not load data: " + e.getMessage());
        }

        while (true) {
            displayMethod();
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    Student student = studentData(sc);
                    sms.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter the RollNo to search: ");
                    String rollNo = sc.nextLine().trim();
                    System.out.println(sms.searchStudent(rollNo));
                    break;
                case 3:
                    System.out.println("Enter the RollNumer to Delete: ");
                    String rollNo1 = sc.nextLine().trim();
                    sms.removeStudent(rollNo1);
                    System.out.println("Student Details Removed");
                    break;
                case 4:
                    sms.displayStudent();
                    break;
                case 5 :
                    try {
                        sms.saveToFile("students.dat");
                    } catch (IOException e) {
                        System.out.println("Could not save data: " + e.getMessage());
                    }
                    System.out.println("Exiting.......");
                    return;
            }
        }
    }

    private static void displayMethod(){
        System.out.println("------Student Manasgement System-----");
        System.out.println("--------------------------------------");
        System.out.println("1-> Add Student");
        System.out.println("2-> Search Student");
        System.out.println("3-> Delete Student");
        System.out.println("4-> Display All Student");
        System.out.println("5-> Exit");
    }

    private static Student studentData(Scanner sc){
        String name;
        do {
            System.out.print("Enter the Name: ");
            name = sc.nextLine().trim();
            if(name.isEmpty()){
                System.out.println("Name Cannot be Empty");
            }
        }while(name.isEmpty());

        String rollNo;
        do {
            System.out.print("Enter the RollNumber: ");
            rollNo = sc.nextLine().trim();
            if (rollNo.isEmpty()) {
                System.out.println("Roll Number Cannot be Empty");
            }
        }while(rollNo.isEmpty());

        String age;
        do {
            System.out.print("Enter the Age: ");
            age = sc.nextLine().trim();
            if(age.isEmpty()){
                System.out.println("Age Cannot be Empty");
            }
        }while(age.isEmpty());

        String email;
        do {
            System.out.print("Enter the Email: ");
            email = sc.nextLine().trim();
            if(email.isEmpty()){
                System.out.println("Email Cannot be Empty");
            }
        }while(email.isEmpty());

        String phone;
        do {
            System.out.print("Enter the Phone NNumber: ");
            phone = sc.nextLine().trim();
            if(phone.isEmpty()){
                System.out.println("Phone Number cannot be Empty");
            }
        }while(phone.isEmpty());

        return new Student(name,rollNo,age,email,phone);
    }
}
