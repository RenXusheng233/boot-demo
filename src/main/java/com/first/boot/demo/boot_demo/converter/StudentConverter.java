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
}
