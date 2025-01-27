package io.czen.springboot.service;

import io.czen.springboot.entity.StudentEntity;
import io.czen.springboot.model.Student;
import io.czen.springboot.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<StudentEntity> getAllStudents() {
    return studentRepository.findAll();
  }

  public StudentEntity createStudent(Student student) {
    StudentEntity studentEntity =
        StudentEntity.builder().name(student.getName()).email(student.getEmail()).age(student.getAge()).build();
    return studentRepository.save(studentEntity);
  }

  public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
  }

  public StudentEntity getStudentById(Long id) {
    return studentRepository.findById(id).orElse(null);
  }
}
