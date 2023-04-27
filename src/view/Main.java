package view;

import controller.StudentManager;
import model.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
      ShowStudent student = new ShowStudent();
      student.showStudentManager();
    }
}