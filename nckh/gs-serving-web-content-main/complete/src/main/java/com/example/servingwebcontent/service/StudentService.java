package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.Student;
import com.example.servingwebcontent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> getStudentByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    public Student createStudent(Student student) {
        if (studentRepository.existsByStudentId(student.getStudentId())) {
            throw new RuntimeException("Student ID already exists");
        }
        return studentRepository.save(student);
    }

    public Student updateStudent(String id, Student studentDetails) {
        return studentRepository.findById(id).map(student -> {
            student.setStudentId(studentDetails.getStudentId());
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setClassName(studentDetails.getClassName());
            student.setAge(studentDetails.getAge());
            return studentRepository.save(student);
        }).orElse(null);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
