package com.example.servingwebcontent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "students")
public class Student {
    @Id
    private String id;
    
    private String studentId;        // Mã sinh viên (unique)
    private String name;
    private String email;
    private String className;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors
    public Student() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Student(String studentId, String name, String email, String className, Integer age) {
        this();
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.className = className;
        this.age = age;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", className='" + className + '\'' +
                ", age=" + age +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
