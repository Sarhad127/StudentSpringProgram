package org.example.studentspringprogram;

import org.example.studentspringprogram.Model.Student;
import org.example.studentspringprogram.Repository.StudentRepo;
import org.example.studentspringprogram.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentSpringProgramApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentSpringProgramApplication.class, args);
    }

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student("Linus", "Markant", "Linne99@hotmail.com");
        studentRepo.save(s1);
        Student s2 = new Student("Sam", "Anderson", "Sam@hotmail.com");
        studentRepo.save(s2);
        Student s3 = new Student("Tony", "Madison", "Tony@hotmail.com");
        studentRepo.save(s3);
    }
}
