package com.example.servingwebcontent.model;

// TẠM THỜI COMMENT MONGODB IMPORTS
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "students")
public class Student {

    @Id
    private String id;

    private String studentId;   // Mã sinh viên
    private String name;
    private int age;
    private String className;
    private String email;

    public Student() {}

    public Student(String studentId, String name, int age, String className, String email) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.className = className;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}