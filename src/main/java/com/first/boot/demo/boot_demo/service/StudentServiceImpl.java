package com.first.boot.demo.boot_demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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

    @Override
    public Long addNewStudent(StudentDTO studentDTO) {
        List<Student> studenList = studentRepository.findByEmail(studentDTO.getEmail());
        if (!CollectionUtils.isEmpty(studenList)) {
            throw new IllegalStateException("Email: " + studentDTO.getEmail() + " is already in use.");
        }
        Student student = studentRepository.save(StudentConverter.convertStudentDTO(studentDTO));
        return student.getId();
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id: " + id + " doesn't exist!"));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDTO updateStudentById(long id, String name, String email) {
        Student studentInDB = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id: " + id + " doesn't exist!"));

        if (StringUtils.hasLength(name) && !studentInDB.getName().equals(name)) {
            studentInDB.setName(name);
        }

        if (StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)) {
            studentInDB.setEmail(email);
        }

        Student student = studentRepository.save(studentInDB);
        return StudentConverter.convertStudent(student);
    }

}
