package com.first.boot.demo.boot_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.boot.demo.boot_demo.converter.StudentConverter;
import com.first.boot.demo.boot_demo.dao.Student;
import com.first.boot.demo.boot_demo.dao.StudentRepository;
import com.first.boot.demo.boot_demo.dto.StudentDTO;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.convertStudent(student);
    }

}
