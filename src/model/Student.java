package model;

import java.io.Serializable;

public class Student implements Serializable {
    private String StudentCode;
    private String fullName;
    private int age;
    private String gender;
    private String address;
    private double mediumScore;

    public Student() {
    }

    public Student(String studentCode, String fullName, int age, String gender, String address, double mediumScore) {
        StudentCode = studentCode;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.mediumScore = mediumScore;
    }

    public String getStudentCode() {
        return StudentCode;
    }

    public void setStudentCode(String studentCode) {
        StudentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(double mediumScore) {
        this.mediumScore = mediumScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentCode='" + StudentCode + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", mediumScore=" + mediumScore +
                '}';
    }
}
