import java.io.Serializable;

public class Student implements Serializable {
     private String name;
     private String rollNo;
     private String age;
     private String email;
     private String phoneNumber;

     Student(String name,String rollNo,String age,String email,String phoneNumber){
         this.name=name;
         this.rollNo=rollNo;
         this.age=age;
         this.email=email;
         this.phoneNumber=phoneNumber;
     }

     public String getName(){
         return name;
     }
     public String getRollNo(){
         return rollNo;
     }

     public String getAge(){
         return age;
     }
     public String getEmail(){
         return email;
     }
     public String getPhoneNumber(){
         return phoneNumber;
     }
    public String toString() {
        return "Student(Name: " + name + ", Roll Number: " + rollNo + ", Age: " + age + ", Email: "+ email+"," +
                " Phone: "+ phoneNumber+")";
    }


}
