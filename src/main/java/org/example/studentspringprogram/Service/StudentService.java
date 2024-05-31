package org.example.studentspringprogram.Service;

import org.example.studentspringprogram.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student updateStudent(Student student);
    Student getStudentById(Long id);
    Student deleteStudentById(Long id);
}
