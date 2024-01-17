package com.sys.service;

import com.sys.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto>getAllStudents();

    void createStudent(StudentDto student);

    StudentDto getStudentById(Long studentId);

    void updateStudent(StudentDto studentDto);
}
