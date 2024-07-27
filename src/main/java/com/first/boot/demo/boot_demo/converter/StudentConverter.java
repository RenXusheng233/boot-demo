package com.first.boot.demo.boot_demo.converter;

import com.first.boot.demo.boot_demo.dao.Student;
import com.first.boot.demo.boot_demo.dto.StudentDTO;

public class StudentConverter {
    public static StudentDTO convertStudent(Student student) {
        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());

        return studentDTO;
    }

    public static Student convertStudentDTO(StudentDTO studentDTO) {
        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());

        return student;
    }
}
