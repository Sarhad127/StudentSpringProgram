package org.example.studentspringprogram.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.studentspringprogram.Model.Student;
import org.example.studentspringprogram.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Home page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "all_students";
    }
    //Home page
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "all_students";
    }
    //Return add new student page
    @GetMapping("/students/new")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "add_new_student";
    }
    //Adds the new student
    @PostMapping("/students")
    public String saveStudent(Model model, Student student) {
        studentService.saveStudent(student);
        model.addAttribute("student", student);
        return "redirect:/students";
    }
    //Gets the student to edit
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }
    //Saves the updated student
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, Student student, Model model) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }
    //Delete student from homepage
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id, Model model) {
        studentService.getStudentById(id);
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}


