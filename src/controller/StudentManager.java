package controller;

import model.CRUD;
import model.Student;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManager implements CRUD<Student> {
    private ReadWriteFile<Student> studentFile = ReadWriteFile.getINSTANCE();
    public List<Student> students;

    public StudentManager() {
        students = new ArrayList<Student>();
        students.add(new Student("01","Trần Hồng Quân",25,"Male","Thái Nguyên",4.5));
        students.add(new Student("02","Trần Xuân Mạnh",24,"Male","Nam Định",3.5));
        students.add(new Student("03","Nguyễn Huy Hoàng",27,"Male","Thái Bình",2.5));
        students.add(new Student("04","Trương Đình Hoàng",30,"Male","Đak lak",5.5));
        students.add(new Student("05","Phùng Quang Hiếu",29,"Male","Hà Nội",1.5));
    }

    @Override
    public void add(Student list) {
        students.add(list);
    }

    @Override
    public void display() {
        for (Student s: students
             ) {
            System.out.println(s);
        }
    }

    @Override
    public void edit(String studentCode, Student list) {
        for (int i = 0; i < students.size(); i++) {
            if(studentCode.equals(students.get(i).getStudentCode())){
                students.set(i,list);
            }
        }
    }

    @Override
    public void delete(String studentCode) {
        for (int i = 0; i < students.size(); i++) {
           if(studentCode.equals(students.get(i).getStudentCode())){
               students.remove(i);
           }

        }
    }
    public List<Student> getListStudent() {
        return students;
    }
    public void writeFile(List<Student> student,String path){
        studentFile.writeData(student,path);
    }
    public void readFile(String path){
        studentFile.readData(path);
    }
    public void sort_up_mediumScore(){
        Collections.sort(students, new Comparator<Student>(){
            @Override
            public int compare(Student student1,Student student2){
                return (int)(student1.getMediumScore() - student2.getMediumScore());
            }
        });
    }
    public void sort_down_mediumScore(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o2.getMediumScore() - o1.getMediumScore());
            }
        });
    }
}
