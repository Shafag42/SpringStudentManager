package com.sys.controller;

import com.sys.dto.StudentDto;
import com.sys.entity.Student;
import com.sys.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model){
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";

    }
    @GetMapping("/students/new")
    public String newStudent(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "new_student";

    }
    @PostMapping("/students")
    public  String saveStudent(@Valid @ModelAttribute("student")StudentDto student,
                               BindingResult result,
                               Model model){
        if (result.hasErrors()){
            model.addAttribute("student", student);
            return "new_student" ;
        }

        studentService.createStudent(student);
        return "redirect:/students";

    }
}

