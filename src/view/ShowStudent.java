package view;

import controller.StudentManager;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class ShowStudent {
    private Scanner scanner = new Scanner(System.in);
    private StudentManager studentManager = new StudentManager();
    private List<Student> students = studentManager.getListStudent();
     public String enterStudentCode(){
         System.out.println("Enter student code: ");
         String studentCode = scanner.nextLine();
         for (Student student : students){
             while (true){
                 if(student.getStudentCode().equals(studentCode)){
                     System.out.println("Duplicate student code, please re-enter :");
                     studentCode = scanner.nextLine();
                 } else if (studentCode.equals(" ")){
                     break;
                 }
                 else {
                     return studentCode;
                 }
             }

         }
         System.out.println("Student code not found: " + studentCode);
         return enterStudentCode();
     }
     public String checkStudentCodeEdit(){
         System.out.println("Enter student code edit: ");
         String nameCode = scanner.nextLine();
         for (int i = 0; i < students.size(); i++) {
             while (true) {
                 if (nameCode.equals(students.get(i).getStudentCode())) {
                     return nameCode;
                 } else if (nameCode.equals(" ")) {
                     break;
                 } else {
                     System.out.println("Please enter student code edit :");
                     nameCode = scanner.nextLine();
                 }
             }
         }
         System.out.println("Not found student code: " + nameCode);
         return checkStudentCodeEdit();
     }
     public String checkStudentCodeDelete(){
         System.out.println("Enter student code edit: ");
         String nameCode = scanner.nextLine();
         for (int i = 0; i < students.size(); i++) {
             while (true){
                 if(nameCode.equals(students.get(i).getStudentCode())){
                     System.out.println("you want to delete : please enter the letter ' Y '");
                     String name = scanner.nextLine();
                     if(name.equals("Y")){
                         return nameCode;
                     } else {
                         break;
                     }
                 } else if(nameCode.equals(" ")){
                     System.out.println("Please enter student code delete :");
                     nameCode = scanner.nextLine();
                 }
             }
         }
         System.out.println("Not found student code: " + nameCode);
         return checkStudentCodeDelete();
     }
     public String enterFullName(){
         try {
             System.out.println("Enter full name: ");
             return scanner.nextLine();
         } catch (Exception e){
             System.out.println("Name incorrect: " + e);
         }
         return enterFullName();
     }
     public int enterAge(){
         try{
             System.out.println("Enter age: ");
             return Integer.parseInt(scanner.nextLine());
         } catch (Exception e){
             System.out.println("Age incorrect: " + e);
         }
         return enterAge();
     }
     public String enterGender(){
         try{
             System.out.println("Enter gender: ");
             return scanner.nextLine();
         } catch (Exception e){
             System.out.println("Gender incorrect: " + e);
         }
         return enterGender();
     }
     public String enterAddress(){
         try {
             System.out.println("Enter address: ");
             return scanner.nextLine();
         } catch (Exception e){
             System.out.println("Address incorrect: " + e);
         }
         return enterAddress();
     }
     public double enterMediumScore(){
         try{
             System.out.println("Enter medium score: ");
             return Double.parseDouble(scanner.nextLine());
         } catch (Exception e){
             System.out.println("Medium score incorrect: ");
         }
         return enterMediumScore();
     }
     public void addStudent(){
         studentManager.add(new Student(enterStudentCode(),enterFullName(),enterAge(),enterGender(),enterAddress(),enterMediumScore()));
     }
     public void editStudent(){
         studentManager.edit(checkStudentCodeEdit(),new Student(enterStudentCode(),enterFullName(),enterAge(),enterGender(),enterAddress(),enterMediumScore()));
     }
     public void deleteStudent(){
         studentManager.delete(checkStudentCodeDelete());
     }
     public void sortStudentUpMedium(){
         studentManager.sort_up_mediumScore();
     }
     public void sortStudentDownMedium(){
         studentManager.sort_down_mediumScore();
     }
     public void displayStudent(){
         studentManager.display();
     }

     public void displayAndAdd(){
         int choice;
         do{
             System.out.println("""
                     Menu:
                     1.Add Student.
                     2.Display Student.
                     3.Back
                     """);
             System.out.println("Enter choice: ");
             choice =  Integer.parseInt(scanner.nextLine());
                 switch (choice){
                     case 1 -> {
                         addStudent();
                     }
                     case 2 ->{
                         studentManager.display();
                     }
                     case 3 -> deleteStudent();

                     default -> System.out.println("Does not exist");
             }
         } while (choice != 3);
     }
     public void showMediumScore() {
         int choice;
         do {
             System.out.println("""
                     Menu:
                     1. Sort Student Medium Score up.
                     2. Sort Student Medium Score down.
                     3. Display Student Medium Score.
                     4. Back
                     """);
             System.out.println("Enter choice: ");
             choice =  Integer.parseInt(scanner.nextLine());
             switch (choice) {
                 case 1 -> sortStudentUpMedium();
                 case 2 -> sortStudentDownMedium();
                 case 3 -> displayStudent();
                 case 4 -> {
                 }
                 default -> System.out.println("Does not exist");
             }
         } while (choice != 4);
     }
     public void showStudentManager(){
         int choice;
         do {
             System.out.println("""
                     -----Student Management Program-----
                     Select function
                     1.Display Student And Add Student.
                     2.Add Student.
                     3.Edit Student.
                     4.Delete Student.
                     5.Sort Student.
                     6.Read File Student.
                     7.Write File Student.
                     8.Display Student.
                     0.Exit.
                     """);
             System.out.println("Enter choice: ");
             choice =  Integer.parseInt(scanner.nextLine());
             switch (choice){
                 case 1 -> displayAndAdd();
                 case 2 -> addStudent();
                 case 3 -> editStudent();
                 case 4 -> deleteStudent();
                 case 5 -> showMediumScore();
                 case 6 -> {
                     studentManager.readFile("src/file/Student.dat");
                 }
                 case 7 ->{
                     studentManager.writeFile(students,"src/file/Student.dat");
                 }
                 case 8 -> displayStudent();

                 case 0 -> System.exit(0);

                 default -> System.out.println("Does not exist");
             }
         } while (choice != 0);
     }
}
